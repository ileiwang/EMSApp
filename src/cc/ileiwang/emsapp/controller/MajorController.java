package cc.ileiwang.emsapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cc.ileiwang.emsapp.domain.College;
import cc.ileiwang.emsapp.domain.Major;
import cc.ileiwang.emsapp.service.EMSAppService;

/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018年4月1日 上午10:51:43
*/
@Controller
public class MajorController {
	// 自动注入eMSAppService
	@Autowired
	@Qualifier("eMSAppService")
	private EMSAppService eMSAppService;
	
	// 添加专业
	@RequestMapping(value = "/major/addMajor")
	public ModelAndView addMajor(String flag,Integer college_id,@ModelAttribute Major major, ModelAndView mv) {
		if (flag.equals("1")) {
			List<College> colleges = eMSAppService.findAllCollege();
			mv.addObject("colleges", colleges);
			mv.setViewName("major/showAddMajor");
		} else {
			
			College college  = new College();
			college.setId(college_id);
			major.setCollege(college);
			eMSAppService.addMajor(major);
			mv.setViewName("redirect:/major/showAllMajor");
		}
		return mv;
	}
	
	
	// 查看所有专业
	@RequestMapping(value = "/major/showAllMajor")
	public ModelAndView showAllMajor(ModelAndView mv, HttpSession session) {
		List<Major> majors = eMSAppService.findAllMajor();

		if (session.getAttribute("admin") != null) {
			mv.addObject("majors", majors);
			mv.setViewName("major/allMajor");

		} else {
			mv.setViewName("redirect:/main");
		}

		return mv;
	}
	
	// 删除专业
	@RequestMapping(value = "/major/deleteMajor")
	public ModelAndView deleteMajor(ModelAndView mv, int id, HttpSession session) {
		if (session.getAttribute("college") != null) {
			eMSAppService.deleteMajorById(id);
			mv.setViewName("redirect:/major/showAllMajor");
		} else {
			mv.setViewName("redirect:/main");
		}

		return mv;
	}

	// 更新专业
	@RequestMapping(value = "/major/updateMajor")
	public ModelAndView updateMajor(String flag, @ModelAttribute Major major,Integer college_id, ModelAndView mv) {
		if (flag.equals("1")) {
			Major target = eMSAppService.selectMajorById(major.getId());
			List<College> colleges = eMSAppService.findAllCollege();
			mv.addObject("major", target);
			mv.addObject("colleges", colleges);
			mv.setViewName("major/showUpdateMajor");
		} else {
			College college  = new College();
			college.setId(college_id);
			major.setCollege(college);
			eMSAppService.modifyMajor(major);
			mv.setViewName("redirect:/major/showAllMajor");
		}
		return mv;
	}
	
	
	
	// 选择专业
	@RequestMapping(value = "/major/selectMajor")
	public String selectMajor(String flag, Integer college_id,@ModelAttribute Major major,Model model) {
		if (flag.equals("1")) {

			List<College> colleges = eMSAppService.findAllCollege();
			model.addAttribute("colleges", colleges);
			return "major/showSelectMajor";
		} 
		else 
		{
			College college = new College();
			college.setId(college_id);
			major.setCollege(college);
			List<Major> majors = eMSAppService.findMajor(major);
			model.addAttribute("majors", majors);
			return "major/allMajor";
		}
	}
	
	// 按学院查询
	@RequestMapping(value = "/major/selectMajorByCollege")
	public String selectMajor(Integer college_id ,Model model) {
			List<Major> majors = eMSAppService.selectMajorByCollegeId(college_id);
			model.addAttribute("majors", majors);
			return "major/allMajor";
	}
}
