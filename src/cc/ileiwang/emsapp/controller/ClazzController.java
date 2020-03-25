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

import cc.ileiwang.emsapp.domain.Clazz;
import cc.ileiwang.emsapp.domain.College;
import cc.ileiwang.emsapp.domain.Major;
import cc.ileiwang.emsapp.service.EMSAppService;

/**
 * @author Lei Wang
 * @email 3970111@gmail.com
 * @blog www.ileiwang.cc
 * @version 2018��4��1�� ����10:50:41
 */
@Controller
public class ClazzController {
	// �Զ�ע��eMSAppService
	@Autowired
	@Qualifier("eMSAppService")
	private EMSAppService eMSAppService;

	// ��Ӱ༶
	@RequestMapping(value = "/clazz/addClazz")
	public ModelAndView addClazz(String flag, Integer major_id, @ModelAttribute Clazz clazz, ModelAndView mv) {
		if (flag.equals("1")) {
			List<Major> majors = eMSAppService.findAllMajor();
			mv.addObject("majors", majors);
			mv.setViewName("clazz/showAddClazz");
		} else {

			Major major = new Major();
			major.setId(major_id);
			System.out.println(major_id);
			clazz.setMajor(major);
			eMSAppService.addClazz(clazz);
			mv.setViewName("redirect:/clazz/showAllClazz");
		}
		return mv;
	}

	// �鿴���а༶
	@RequestMapping(value = "/clazz/showAllClazz")
	public ModelAndView showAllClazz(ModelAndView mv, HttpSession session) {
		List<Clazz> clazzs = eMSAppService.findAllClazz();

		if (session.getAttribute("admin") != null) {
			mv.addObject("clazzs", clazzs);
			mv.setViewName("clazz/allClazz");

		} else {
			mv.setViewName("redirect:/main");
		}

		return mv;
	}

	// ɾ���༶
	@RequestMapping(value = "/clazz/deleteClazz")
	public ModelAndView deleteClazz(ModelAndView mv, int id, HttpSession session) {
		if (session.getAttribute("major") != null) {
			eMSAppService.deleteClazzById(id);
			mv.setViewName("redirect:/clazz/showAllClazz");
		} else {
			mv.setViewName("redirect:/main");
		}

		return mv;
	}

	// ���°༶
	@RequestMapping(value = "/clazz/updateClazz")
	public ModelAndView updateClazz(String flag, @ModelAttribute Clazz clazz, Integer major_id, ModelAndView mv) {
		if (flag.equals("1")) {
			Clazz target = eMSAppService.selectClazzById(clazz.getId());
			List<Major> majors = eMSAppService.findAllMajor();
			mv.addObject("clazz", target);
			mv.addObject("majors", majors);
			mv.setViewName("clazz/showUpdateClazz");
		} else {
			Major major = new Major();
			major.setId(major_id);
			clazz.setMajor(major);
			eMSAppService.modifyClazz(clazz);
			mv.setViewName("redirect:/clazz/showAllClazz");
		}
		return mv;
	}

	// ��ѯ�༶
	@RequestMapping(value = "/clazz/selectClazz")
	public String selectClazz(String flag, Integer major_id, @ModelAttribute Clazz clazz, Model model) {
		if (flag.equals("1")) {
			List<Major> majors = eMSAppService.findAllMajor();
			model.addAttribute("majors", majors);
			return "clazz/showSelectClazz";
		} else {
			Major major = new Major();
			major.setId(major_id);
			clazz.setMajor(major);
			List<Clazz> clazzs = eMSAppService.findClazz(clazz);
			model.addAttribute("clazzs", clazzs);
			return "clazz/allClazz";
		}
	}
	
	// ��ѧԺ��ѯ�༶
	@RequestMapping(value = "/clazz/selectClazzByCollege")
	public String selectClazzByCollege(String flag, Integer college_id, Model model) {
		if (flag.equals("1")) {
			List<College> colleges = eMSAppService.findAllCollege();
			model.addAttribute("colleges", colleges);
			return "clazz/showSelectCollege";
		} else {
			List<Clazz> clazzs = eMSAppService.selectClazzByCollegeId(college_id);
			model.addAttribute("clazzs", clazzs);
			return "clazz/allClazz";
		}
	}
	
	// ��רҵ��ѯ�༶
	@RequestMapping(value = "/clazz/selectClazzByMajor")
	public String selectClazzByMajor(Integer major_id, Model model) {

			List<Clazz> clazzs = eMSAppService.selectClazzByMajorId(major_id);
			model.addAttribute("clazzs", clazzs);
			return "clazz/allClazz";
	}
}
