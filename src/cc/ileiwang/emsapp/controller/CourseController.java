package cc.ileiwang.emsapp.controller;

import java.util.List;
import java.util.Map;

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
import cc.ileiwang.emsapp.domain.Course;
import cc.ileiwang.emsapp.domain.Major;
import cc.ileiwang.emsapp.domain.Student;
import cc.ileiwang.emsapp.domain.Teacher;
import cc.ileiwang.emsapp.service.EMSAppService;

/**
 * @author Lei Wang
 * @email 3970111@gmail.com
 * @blog www.ileiwang.cc
 * @version 2018年4月1日 上午10:51:10
 */
@Controller
public class CourseController {
	// 自动注入eMSAppService
	@Autowired
	@Qualifier("eMSAppService")
	private EMSAppService eMSAppService;

	// 添加课程
	@RequestMapping(value = "/course/addCourse")
	public ModelAndView addCourse(String flag, Integer major_id, Integer teacher_id, @ModelAttribute Course course,
			ModelAndView mv) {
		if (flag.equals("1")) {

			List<Major> majors = eMSAppService.findAllMajor();
			mv.addObject("majors", majors);
			List<Teacher> teachers = eMSAppService.findAllTeacher();
			mv.addObject("teachers", teachers);
			mv.setViewName("course/showAddCourse");
		} else {
			this.genericAssociation(major_id, teacher_id, course);
			eMSAppService.addCourse(course);
			mv.setViewName("redirect:/course/showAllCourse");
		}
		return mv;
	}

	// 关联课程和专业、教师
	private void genericAssociation(Integer major_id, Integer teacher_id, Course course) {

		if (course == null) {
			course = new Course();
		}

		if (major_id != null) {

			Major major = new Major();
			major.setId(major_id);
			course.setMajor(major);

		}
		if (teacher_id != null) {
			Teacher teacher = new Teacher();
			teacher.setId(teacher_id);
			course.setTeacher(teacher);
		}

	}

	// 查看所有课程
	@RequestMapping(value = "/course/showAllCourse")
	public ModelAndView showAllCourse(ModelAndView mv, HttpSession session) {
		List<Course> courses = eMSAppService.findAllCourse();

		if (session.getAttribute("admin") != null) {
			mv.addObject("courses", courses);

			mv.setViewName("course/allCourse");

		} else {
			mv.setViewName("redirect:/main");
		}

		return mv;
	}

	// 删除课程
	@RequestMapping(value = "/course/deleteCourse")
	public ModelAndView deleteCourse(ModelAndView mv, int id, HttpSession session) {
		if (session.getAttribute("admin") != null) {
			eMSAppService.deleteCourseById(id);
			mv.setViewName("redirect:/course/showAllCourse");
		} else {
			mv.setViewName("redirect:/main");
		}

		return mv;
	}

	// 更新课程
	@RequestMapping(value = "/course/updateCourse")
	public ModelAndView updateCourse(String flag, Integer major_id, Integer teacher_id, @ModelAttribute Course course,
			ModelAndView mv) {
		if (flag.equals("1")) {
			Course target = eMSAppService.selectCourseById(course.getId());

			mv.addObject("course", target);
			List<Major> majors = eMSAppService.findAllMajor();
			mv.addObject("majors", majors);
			List<Teacher> teachers = eMSAppService.findAllTeacher();
			mv.addObject("teachers", teachers);
			mv.setViewName("course/showUpdateCourse");
		} else {
			this.genericAssociation(major_id, teacher_id, course);
			eMSAppService.modifyCourse(course);
			mv.setViewName("redirect:/course/showAllCourse");
		}
		return mv;
	}

	// 选择课程
	@RequestMapping(value = "/course/selectCourse")
	public String selectCourse(String flag, @ModelAttribute Course course, Integer major_id, Integer teacher_id,
			Model model) {
		if (flag.equals("1")) {
			List<Major> majors = eMSAppService.findAllMajor();
			model.addAttribute("majors", majors);
			List<Teacher> teachers = eMSAppService.findAllTeacher();
			model.addAttribute("teachers", teachers);
			System.out.println("Good");
			return "course/showSelectCourse";
		} else {
			this.genericAssociation(major_id, teacher_id, course);
			List<Course> courses = eMSAppService.findCourse(course);
			model.addAttribute("courses", courses);
			return "course/allCourse";
		}
	}
	
	@RequestMapping(value = "/course/selectCourseByCollege")
	public String selectCourseByCollege(String flag,Integer college_id,Model model) {
		if (flag.equals("1")) {
			List<College> colleges = eMSAppService.findAllCollege();
			model.addAttribute("colleges", colleges);
			return "course/showSelectCourseByCollege";
		} else {
			List<Course> courses = eMSAppService.selectCourseByCollegeId(college_id);
			model.addAttribute("courses", courses);
			return "course/allCourse";
		}
	}
	
	// 选择课程
	@RequestMapping(value = "/course/selectCourseByTeacher")
	public String selectCourseByTeacher(Integer id,
			Model model) {

			List<Course> courses = eMSAppService.selectCourseByTeacherId(id);
			model.addAttribute("courses", courses);
			return "course/allCourse";
	}
	
	

	// 选择课程
	@RequestMapping(value = "/course/chooseCourse")
	public ModelAndView chooseCourse(String flag, Integer student_id, Integer course_id, ModelAndView mv,
			HttpSession session) {
		if (flag.equals("1")) {
			// 当前登录学生
			if (session.getAttribute("student") != null) {
				Student student = (Student) session.getAttribute("student");
				Clazz clazz = student.getClazz();
				Major major = clazz.getMajor();

				List<Course> courses = eMSAppService.selectCourseByMajorAndStudentUnChoosen(major.getId(),
						student.getId());

				mv.addObject("student", student);

				mv.addObject("courses", courses);

				mv.setViewName("course/showChooseCourse");
			} else {
				mv.setViewName("redirect:/main");
			}

		} else {
			System.out.println(student_id);
			System.out.println(course_id);
			eMSAppService.chooseCourse(student_id, course_id);

			mv.setViewName("redirect:/course/chooseCourse?flag=1");
		}
		return mv;
	}

	// 选择课程
	@RequestMapping(value = "/course/unchooseCourse")
	public ModelAndView unchooseCourse(Integer student_id, Integer course_id, ModelAndView mv) {
		eMSAppService.unchooseCourse(student_id, course_id);
		mv.setViewName("redirect:/course/courseTable");
		return mv;
	}

	// 课程表
	@RequestMapping(value = "/course/courseTable")
	public ModelAndView courseTable(ModelAndView mv, HttpSession session) {
		if (session.getAttribute("student") != null) {
			Student student = (Student) session.getAttribute("student");
			List<Course> courses = eMSAppService.selectCourseByStudentId(student.getId());
			mv.addObject("courses", courses);
			mv.setViewName("course/allCourse");
		}
		return mv;
	}

	// 选课人数统计
	@RequestMapping(value = "/course/courseInfo")
	public ModelAndView courseInfo(ModelAndView mv, HttpSession session) {
		if (session.getAttribute("admin") != null) {
			List<Map<String, Object>> courseinfo = eMSAppService.courseInfo();
			List<Map<String, Object>> coursecount = eMSAppService.courseCountByStudent();
			List<Map<String, Object>> overthree = eMSAppService.courseCountOverThree();
			List<Course> morethan = eMSAppService.selectCourseByStudentCountMoreThanThirty();
			List<Course> lessthan = eMSAppService.selectCourseByStudentCountLessThanThirty();
			mv.addObject("courseinfo", courseinfo);
			mv.addObject("coursecount", coursecount);
			mv.addObject("overthree", overthree);
			mv.addObject("morethan", morethan);
			mv.addObject("lessthan", lessthan);
			mv.setViewName("course/courseInfo");
		}
		return mv;
	}

	//选修某课程的学生列表

	@RequestMapping(value = "/course/courseStudentList")
	public ModelAndView studentList(ModelAndView mv, Integer course_id, HttpSession session) {
		if (session.getAttribute("admin") != null) {

			List<Student> students = eMSAppService.courseStudentList(course_id);
			mv.addObject("students", students);
			mv.setViewName("course/studentList");
		}
		return mv;
	}
	
	//某学生的选课列表
	@RequestMapping(value = "/course/courseListByStudent")
	public ModelAndView courseListByStudent(ModelAndView mv, int student_id) {
		List<Course> courses = eMSAppService.selectCourseByStudentId(student_id);
		mv.addObject("courses", courses);
		mv.setViewName("course/allCourse");
		return mv;
	}

}
