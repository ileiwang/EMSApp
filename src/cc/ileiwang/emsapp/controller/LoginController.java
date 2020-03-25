package cc.ileiwang.emsapp.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cc.ileiwang.emsapp.domain.Admin;
import cc.ileiwang.emsapp.domain.Student;
import cc.ileiwang.emsapp.domain.Teacher;
import cc.ileiwang.emsapp.service.EMSAppService;
import cc.ileiwang.emsapp.util.common.EMSAppConstants;

/**
 * @author Lei Wang
 * @email ileiwang@live.com
 * @blog www.ileiwang.cc
 * @version 2018年11月15日 上午8:36:55
 */
@Controller
public class LoginController {
	@Autowired
	@Qualifier("eMSAppService")
	private EMSAppService eMSAppService;

	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam("num") String num, @RequestParam("password") String password,
			@RequestParam("type") String type, HttpSession session, ModelAndView mv) {
		// 管理员
		if (type.equals("admin")) {

			Admin admin = eMSAppService.adminlogin(num, password);
			if (admin != null) {
				session.setAttribute(EMSAppConstants.USER_SESSION, admin);
				session.setAttribute(EMSAppConstants.ADMIN_SESSION, admin);
				mv.setViewName("redirect:/main");
			} else {
				mv.addObject("message", "登录名或密码错误!请重新输入");
				mv.setViewName("forward:/loginForm");
			}

		}

		// 教师
		else if (type.equals("teacher")) {

			Teacher teacher = eMSAppService.teacherlogin(num, password);
			if (teacher != null) {
				session.setAttribute(EMSAppConstants.USER_SESSION, teacher);
				session.setAttribute(EMSAppConstants.TEACHER_SESSION, teacher);
				mv.setViewName("redirect:/main");// 客户端跳转
			} else {
				mv.addObject("message", "登录名或密码错误!请重新输入");
				mv.setViewName("forward:/loginForm");// 服务器跳转
			}

		}

		// 学生
		else {
			Student student = eMSAppService.studentlogin(num, password);
			if (student != null) {
				session.setAttribute(EMSAppConstants.USER_SESSION, student);
				session.setAttribute(EMSAppConstants.STUDENT_SESSION, student);
				mv.setViewName("redirect:/main");
			} else {
				mv.addObject("message", "登录名或密码错误!请重新输入");
				mv.setViewName("forward:/loginForm");
			}
		}
		return mv;

	}

	// 退出
	@RequestMapping(value = "/logoff")
	public ModelAndView logoff(HttpSession session, ModelAndView mv) {
		session.invalidate();
		mv.setViewName("redirect:/loginForm");
		return mv;
	}

	// 关于
	@RequestMapping(value = "/about")
	public String about() {
		return "about/about";
	}
	
	
	// 修改密码
	@RequestMapping(value = "/changepasswd")
	public ModelAndView changepasswd(String flag, @Param("oldpasswd") String oldpasswd,
			@Param("newpasswd1") String newpasswd1, @Param("newpasswd2") String newpasswd2, ModelAndView mv,
			HttpSession session) {
		if (flag.equals("1")) {
			mv.setViewName("student/changepasswd");
		} else {
			if (newpasswd1.equals(newpasswd2)) {
				Student student = (Student) session.getAttribute(EMSAppConstants.STUDENT_SESSION);
				if (student.getPassword().equals(oldpasswd)) {
					eMSAppService.changepasswd(student.getId(), newpasswd1);
					session.invalidate();
					mv.setViewName("loginForm");
				}
			}

		}
		return mv;
	}

	// 忘记密码
	@RequestMapping(value = "/forgetpasswd")
	public ModelAndView forgetpasswd(ModelAndView mv) {
		mv.setViewName("forgetpasswd");
		return mv;
	}

	// 查找密码
	@RequestMapping(value = "/findpasswd")
	public ModelAndView findpasswd(@RequestParam("name") String name, @RequestParam("num") String num,
			@RequestParam("tel") String tel, ModelAndView mv) {
		String password = eMSAppService.findpasswd(num, name, tel);
		if (password == null) {
			String error = "输入信息有误，请重新输入";
			mv.addObject("error", error);
		} else {
			mv.addObject("password", password);
		}
		mv.setViewName("passwd");
		return mv;
	}
	
	
	// 注册
	@RequestMapping(value = "/register")
	public ModelAndView register(String flag, @ModelAttribute Student student, ModelAndView mv,
			@Param("password1") String password1, @Param("password2") String password2, HttpSession session) {
		if (flag.equals("1")) {
			mv.setViewName("/register");
		} else {
			if (password1.equals(password2)) {
				student.setPassword(password1);
				System.out.println(student.getName());
				System.out.println(student.getTel());
				System.out.println(student.getNum());
				System.out.println(student.getEmail());
				System.out.println(student.getPassword());
				eMSAppService.addStudent(student);
				session.setAttribute(EMSAppConstants.STUDENT_SESSION, student);
				mv.setViewName("/loginForm");
			} else {
				mv.setViewName("/register?flag=1");
			}
		}
		return mv;
	}
}
