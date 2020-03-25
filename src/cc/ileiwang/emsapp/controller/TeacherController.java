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
import cc.ileiwang.emsapp.domain.Teacher;
import cc.ileiwang.emsapp.service.EMSAppService;

/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018年4月1日 上午10:52:34
*/
@Controller
public class TeacherController {
	
	// 自动注入eMSAppService
	@Autowired
	@Qualifier("eMSAppService")
	private EMSAppService eMSAppService;
	
	// 查看所有教师
	@RequestMapping(value = "/teacher/showAllTeacher")
	public ModelAndView showAllTeacher(ModelAndView mv, HttpSession session) {
		List<Teacher> teachers = eMSAppService.findAllTeacher();

		if (session.getAttribute("admin") != null) {
			mv.addObject("teachers", teachers);
			mv.setViewName("teacher/allTeacher");
		} else {
			mv.setViewName("redirect:/main");
		}

		return mv;
	}
	
	// 添加教师
	@RequestMapping(value = "/teacher/addTeacher")
	public ModelAndView addTeacher(String flag, Integer major_id, @ModelAttribute Teacher teacher, ModelAndView mv) {
		if (flag.equals("1")) {
			List<Major> majors = eMSAppService.findAllMajor();
			mv.addObject("majors", majors);
			mv.setViewName("teacher/showAddTeacher");
		} else {
			this.genericAssociation(major_id, teacher);
			eMSAppService.addTeacher(teacher);
			mv.setViewName("redirect:/teacher/showAllTeacher");
		}
		return mv;
	}
	// 关联教师和专业
	private void genericAssociation(Integer major_id, Teacher teacher) {
		if (major_id != null) {
			Major major = new Major();
			major.setId(major_id);
			teacher.setMajor(major);
		}
	}
	
	// 删除教师
	@RequestMapping(value = "/teacher/deleteTeacher")
	public ModelAndView deleteTeacher(ModelAndView mv, int id, HttpSession session) {
		if (session.getAttribute("admin") != null) {
			eMSAppService.deleteTeacherById(id);
			mv.setViewName("redirect:/teacher/showAllTeacher");
		} else {
			mv.setViewName("redirect:/main");
		}

		return mv;
	}

	// 更新教师
	@RequestMapping(value = "/teacher/updateTeacher")
	public ModelAndView updateTeacher(String flag, Integer major_id, @ModelAttribute Teacher teacher, ModelAndView mv) {
		if (flag.equals("1")) {
			Teacher target = eMSAppService.selectTeacherById(teacher.getId());
			List<Major> majors = eMSAppService.findAllMajor();
			mv.addObject("teacher", target);
			mv.addObject("majors", majors);
			mv.setViewName("teacher/showUpdateTeacher");
		} else {
			this.genericAssociation(major_id, teacher);
			eMSAppService.modifyTeacher(teacher);
			mv.setViewName("redirect:/teacher/showAllTeacher");
		}
		return mv;
	}
	
	// 选择教师
	@RequestMapping(value = "/teacher/selectTeacher")
	public String selectTeacher(String flag, @ModelAttribute Teacher teacher, Integer major_id,Model model) {
		if (flag.equals("1")) {
			List<Major> majors = eMSAppService.findAllMajor();
			model.addAttribute("majors", majors);
			return "teacher/showSelectTeacher";
		} else {
			this.genericAssociation(major_id, teacher);
			List<Teacher> teachers = eMSAppService.findTeacher(teacher);

			model.addAttribute("teachers", teachers);
			return "teacher/allTeacher";
		}
	}
	
	//按学院选择教师
	@RequestMapping(value = "/teacher/selectTeacherByCollege")
	public String selectTeacher(String flag , Integer college_id,Model model) {
		if (flag.equals("1")) {
			List<College> colleges = eMSAppService.findAllCollege();
			model.addAttribute("colleges", colleges);
			return "teacher/showSelectByCollege";
		} else {
			//this.genericAssociation(major_id, teacher);
			List<Teacher> teachers = eMSAppService.selectTeacherByCollegeId(college_id);
			model.addAttribute("teachers", teachers);
			return "teacher/allTeacher";
		}
	}

}
