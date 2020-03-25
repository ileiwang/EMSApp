package cc.ileiwang.emsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cc.ileiwang.emsapp.domain.Admin;
import cc.ileiwang.emsapp.service.EMSAppService;

/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018年4月1日 上午10:49:51
*/
@Controller
public class AdminController {
	// 自动注入eMSAppService
	@Autowired
	@Qualifier("eMSAppService")
	private EMSAppService eMSAppService;
	
	// 学生管理
	@RequestMapping(value = "/studentmgmt")
	public ModelAndView studentmgmt(ModelAndView mv) {
		mv.setViewName("admin/studentmgmt");
		return mv;
	}

	// 教师管理
	@RequestMapping(value = "/teachermgmt")
	public ModelAndView teachermgmt(ModelAndView mv) {
		mv.setViewName("admin/teachermgmt");
		return mv;
	}

	// 课程管理
	@RequestMapping(value = "/coursemgmt")
	public ModelAndView coursemgmt(ModelAndView mv) {
		mv.setViewName("admin/coursemgmt");
		return mv;
	}

	// 公告管理
	@RequestMapping(value = "/noticemgmt")
	public ModelAndView noticemgmt(ModelAndView mv) {
		mv.setViewName("admin/noticemgmt");
		return mv;
	}

	// 学院管理
	@RequestMapping(value = "/collegemgmt")
	public ModelAndView collegemgmt(ModelAndView mv) {
		mv.setViewName("admin/collegemgmt");
		return mv;
	}

	// 专业管理
	@RequestMapping(value = "/majormgmt")
	public ModelAndView majormgmt(ModelAndView mv) {
		mv.setViewName("admin/majormgmt");
		return mv;
	}

	// 班级管理
	@RequestMapping(value = "/clazzmgmt")
	public ModelAndView clazzmgmt(ModelAndView mv) {
		mv.setViewName("admin/clazzmgmt");
		return mv;
	}
	
	// 成绩管理
	@RequestMapping(value = "/scoremgmt")
	public ModelAndView scoremgmt(ModelAndView mv) {
		mv.setViewName("admin/scoremgmt");
		return mv;
	}
	

	
	
	
	
	
	
	
	// 选择管理员
	@RequestMapping(value = "/admin/selectAdmin")
	public String selectAdmin(@ModelAttribute Admin admin, Model model) {
		List<Admin> admins = eMSAppService.findAdmin(admin);
		model.addAttribute("admins", admins);
		return "admin/allAdmin";

	}
	
	
	//添加管理员
	@RequestMapping(value = "/admin/addAdmin")
	public ModelAndView addAdmin(String flag, @ModelAttribute Admin admin, ModelAndView mv) {
		if (flag.equals("1")) {
			mv.setViewName("admin/addAdmin");
		} else {
			eMSAppService.addAdmin(admin);
			mv.setViewName("redirect:main");
		}
		return mv;

	}


	// 更新管理员
	@RequestMapping(value = "/admin/updateAdmin")
	public ModelAndView updateAdmin(String flag, @ModelAttribute Admin admin, ModelAndView mv) {
		if (flag.equals("1")) {
			Admin target = eMSAppService.selectAdminById(admin.getId());
			mv.addObject("admin", target);
			mv.setViewName("admin/showUpdateAdmin");
		} else {
			eMSAppService.modifyAdmin(admin);
			mv.setViewName("redirect:/admin/selectAdmin");
		}
		return mv;
	}
}
