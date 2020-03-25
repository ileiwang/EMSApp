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

import cc.ileiwang.emsapp.domain.*;
import cc.ileiwang.emsapp.service.EMSAppService;

/**
 * @author Lei Wang
 * @email 3970111@gmail.com
 * @blog www.ileiwang.cc
 * @version 2018年4月1日 上午10:52:22
 */
@Controller
public class StudentController {

	// 自动注入eMSAppService
	@Autowired
	@Qualifier("eMSAppService")
	private EMSAppService eMSAppService;

	// 添加学生
	@RequestMapping(value = "/student/addStudent")
	public ModelAndView addStudent(String flag, Integer clazz_id, @ModelAttribute Student student, ModelAndView mv) {
		if (flag.equals("1")) {
			List<Clazz> clazzs = eMSAppService.findAllClazz();
			mv.addObject("clazzs", clazzs);
			mv.setViewName("student/showAddStudent");
		} else {
			this.genericAssociation(clazz_id, student);
			eMSAppService.addStudent(student);
			mv.setViewName("redirect:/student/showAllStudent");
		}
		return mv;
	}

	// 查看所有学生
	@RequestMapping(value = "/student/showAllStudent")
	public ModelAndView showAllStudent(ModelAndView mv, HttpSession session) {
		List<Student> students = eMSAppService.findAllStudent();

		if (session.getAttribute("admin") != null) {
			mv.addObject("students", students);
			mv.setViewName("student/allstu");
		} else {
			mv.setViewName("redirect:/main");
		}

		return mv;
	}

	// 删除学生
	@RequestMapping(value = "/student/deleteStudent")
	public ModelAndView deleteStudent(ModelAndView mv, int id, HttpSession session) {
		if (session.getAttribute("admin") != null) {
			eMSAppService.deleteStudentById(id);
			mv.setViewName("redirect:/student/showAllStudent");
		} else {
			mv.setViewName("redirect:/main");
		}

		return mv;
	}

	// 更新学生
	@RequestMapping(value = "/student/updateStudent")
	public ModelAndView updateStudent(String flag, Integer clazz_id, @ModelAttribute Student student, ModelAndView mv) {
		if (flag.equals("1")) {
			Student target = eMSAppService.selectStudentById(student.getId());
			List<Clazz> clazzs = eMSAppService.findAllClazz();
			mv.addObject("student", target);
			mv.addObject("clazzs", clazzs);
			mv.setViewName("student/showUpdateStudent");
		} else {
			this.genericAssociation(clazz_id, student);
			eMSAppService.modifyStudent(student);
			mv.setViewName("redirect:/student/showAllStudent");
		}
		return mv;
	}

	// 关联学生和班级
	private void genericAssociation(Integer clazz_id, Student student) {
		if (clazz_id != null) {
			Clazz clazz = new Clazz();
			clazz.setId(clazz_id);
			student.setClazz(clazz);
		}
	}

	// 选择学生
	@RequestMapping(value = "/student/selectStudent")
	public String selectStudent(String flag, @ModelAttribute Student student, Integer clazz_id, Model model) {
		if (flag.equals("1")) {
			List<Clazz> clazzs = eMSAppService.findAllClazz();
			model.addAttribute("clazzs", clazzs);
			return "student/showSelectStudent";
		} else {
			this.genericAssociation(clazz_id, student);
			List<Student> students = eMSAppService.findStudent(student);

			model.addAttribute("students", students);
			return "student/allstu";
		}
	}
	
	// 按学院选择学生
	@RequestMapping(value = "/student/selectStudentByCollege")
	public String selectStudentByCollege(String flag, Integer college_id, Model model) {
		if (flag.equals("1")) {
			List<College> colleges = eMSAppService.findAllCollege();
			model.addAttribute("colleges", colleges);
			return "student/showSelectByCollege";
		} else {
			//this.genericAssociation(clazz_id, student);
			List<Student> students = eMSAppService.selectStudentByCollegeId(college_id);
			model.addAttribute("students", students);
			return "student/allstu";
		}
	}
	
	// 按专业选择学生
	@RequestMapping(value = "/student/selectStudentByMajor")
	public String selectStudentByMajor(String flag, Integer major_id, Model model) {
		if (flag.equals("1")) {
			List<Major> majors = eMSAppService.findAllMajor();
			model.addAttribute("majors", majors);
			return "student/showSelectByMajor";
		} else {
			//this.genericAssociation(clazz_id, student);
			List<Student> students = eMSAppService.selectStudentByMajorId(major_id);
			model.addAttribute("students", students);
			return "student/allstu";
		}
	}
	
	// 按班级选择学生
	@RequestMapping(value = "/student/selectStudentByClazzId")
	public String selectStudentByClazz(Integer clazz_id, Model model) {
			List<Student> students = eMSAppService.selectStudentByClazzId(clazz_id);
			model.addAttribute("students", students);
			return "student/allstu";
	}

	// 显示学生列表
	@RequestMapping(value = "/student/studentListByCourse")
	public ModelAndView studentListByCourse(ModelAndView mv, int course_id, HttpSession session) {

		List<Student> students = eMSAppService.selectStudentByCourseId(course_id);
		mv.addObject("students", students);
		mv.setViewName("student/showStudentListByCourse");
		return mv;
	}

	// 先选择课程
	@RequestMapping(value = "/student/studentList")
	public ModelAndView studentList(ModelAndView mv, HttpSession session) {
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		List<Course> courses = eMSAppService.selectCourseByTeacherId(teacher.getId());
		mv.addObject("courses", courses);
		mv.setViewName("student/showStudentListChooseCourse");
		return mv;
	}
	

	@RequestMapping(value = "/student/avgScoreBetweenAnd")
	public ModelAndView avgScoreBetweenAnd(int start,int end,ModelAndView mv, HttpSession session) {
		List<Student> students = eMSAppService.avgScoreBetweenAnd(start,end);
		mv.addObject("students", students);
		mv.setViewName("student/allstu");
		return mv;
	}
}
