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
import cc.ileiwang.emsapp.service.EMSAppService;

/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018��11��8�� ����10:50:53
*/
@Controller
public class CollegeController {
	// �Զ�ע��eMSAppService
	@Autowired
	@Qualifier("eMSAppService")
	private EMSAppService eMSAppService;
	
	
	// ���ѧԺ
	@RequestMapping(value = "/college/addCollege")
	public ModelAndView addCollege(String flag,@ModelAttribute College college, ModelAndView mv) {
		if (flag.equals("1")) {
			mv.setViewName("college/showAddCollege");
		} else {
			eMSAppService.addCollege(college);
			mv.setViewName("redirect:/college/showAllCollege");
		}
		return mv;
	}
	
	
	// �鿴����ѧԺ
	@RequestMapping(value = "/college/showAllCollege")
	public ModelAndView showAllCollege(ModelAndView mv, HttpSession session) {
		List<College> colleges = eMSAppService.findAllCollege();

		if (session.getAttribute("admin") != null) {
			mv.addObject("colleges", colleges);

			mv.setViewName("college/allCollege");

		} else {
			mv.setViewName("redirect:/main");
		}

		return mv;
	}
	
	// ɾ��ѧԺ
	@RequestMapping(value = "/college/deleteCollege")
	public ModelAndView deleteCollege(ModelAndView mv, int id, HttpSession session) {
		if (session.getAttribute("admin") != null) {
			eMSAppService.deleteCollegeById(id);
			mv.setViewName("redirect:/college/showAllCollege");
		} else {
			mv.setViewName("redirect:/main");
		}

		return mv;
	}

	// ����ѧԺ
	@RequestMapping(value = "/college/updateCollege")
	public ModelAndView updateCollege(String flag, @ModelAttribute College college,ModelAndView mv) {
		if (flag.equals("1")) {
			College target = eMSAppService.selectCollegeById(college.getId());
			mv.addObject("college", target);
			mv.setViewName("college/showUpdateCollege");
		} else {
			eMSAppService.modifyCollege(college);
			mv.setViewName("redirect:/college/showAllCollege");
		}
		return mv;
	}
	
	
	
	// ѡ��ѧԺ
	@RequestMapping(value = "/college/selectCollege")
	public String selectCollege(String flag,@ModelAttribute College college,Model model) {
		if (flag.equals("1")) {
			return "college/showSelectCollege";
		} 
		else 
		{
			List<College> colleges = eMSAppService.findCollege(college);
			model.addAttribute("colleges", colleges);
			return "college/allCollege";
		}
	}
}
