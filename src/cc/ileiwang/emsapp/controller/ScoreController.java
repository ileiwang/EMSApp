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

import cc.ileiwang.emsapp.domain.Course;
import cc.ileiwang.emsapp.domain.Student;
import cc.ileiwang.emsapp.domain.Teacher;
import cc.ileiwang.emsapp.domain.Score;
import cc.ileiwang.emsapp.service.EMSAppService;

/**
 * @author Lei Wang
 * @email 3970111@gmail.com
 * @blog www.ileiwang.cc
 * @version 2018年4月1日 上午10:52:07
 */
@Controller
public class ScoreController {
	// 自动注入eMSAppService
	@Autowired
	@Qualifier("eMSAppService")
	private EMSAppService eMSAppService;

	// *********************************************************************************************
	// 学生查看个人所有成绩
	@RequestMapping(value = "/score/selectScore")
	public String selectScore(@ModelAttribute Score score, Model model, HttpSession session) {
		if (session.getAttribute("student") != null) {
			Student student = (Student) session.getAttribute("student");

			List<Score> scores = eMSAppService.selectScoreByStudentId(student.getId());
			model.addAttribute("scores", scores);

		}
		return "score/allScore";
	}

	// 学生查看个人平均成绩
	@RequestMapping(value = "/score/showAvgScore")
	public String showAvgScore(Model model, HttpSession session) {
		if (session.getAttribute("student") != null) {
			Student student = (Student) session.getAttribute("student");

			Map<String, Object> avgscore = eMSAppService.selectAvgScoreByStudentId(student.getId());
			model.addAttribute("avgscore", avgscore);

		}
		return "score/scoreInfo";
	}

	// 学生查看个人已获学分
	@RequestMapping(value = "/score/showGetCredit")
	public String showGetCredit(@ModelAttribute Score score, Model model, HttpSession session) {
		if (session.getAttribute("student") != null) {
			Student student = (Student) session.getAttribute("student");

			Map<String, Object> getcredit = eMSAppService.selectGetCreditByStudentId(student.getId());
			model.addAttribute("getcredit", getcredit);
		}
		return "score/scoreInfo";
	}

	// 学生查看个人挂科成绩
	@RequestMapping(value = "/score/showFailScore")
	public String showFailScore(@ModelAttribute Score score, Model model, HttpSession session) {
		if (session.getAttribute("student") != null) {
			Student student = (Student) session.getAttribute("student");

			List<Score> scores = eMSAppService.selectFailScoreByStudentId(student.getId());
			model.addAttribute("scores", scores);

		}
		return "score/allScore";
	}

	// 学生查看个人通过成绩
	@RequestMapping(value = "/score/showPassScore")
	public String showPassScore(@ModelAttribute Score score, Model model, HttpSession session) {
		if (session.getAttribute("student") != null) {
			Student student = (Student) session.getAttribute("student");

			List<Score> scores = eMSAppService.selectPassScoreByStudentId(student.getId());
			model.addAttribute("scores", scores);

		}
		return "score/allScore";
	}

	// 学生查看个人最高分
	@RequestMapping(value = "/score/showMaxScore")
	public String showMaxScore(@ModelAttribute Score score, Model model, HttpSession session) {
		if (session.getAttribute("student") != null) {
			Student student = (Student) session.getAttribute("student");

			List<Score> scores = eMSAppService.selectMaxScoreByStudentId(student.getId());
			model.addAttribute("scores", scores);

		}
		return "score/allScore";
	}

	// 学生查看个人最低分
	@RequestMapping(value = "/score/showMinScore")
	public String showMinScore(@ModelAttribute Score score, Model model, HttpSession session) {
		if (session.getAttribute("student") != null) {
			Student student = (Student) session.getAttribute("student");

			List<Score> scores = eMSAppService.selectMinScoreByStudentId(student.getId());
			model.addAttribute("scores", scores);

		}
		return "score/allScore";
	}
	// ***********************************************************************************************

	// 管理员查看所有成绩
	@RequestMapping(value = "/score/showAllScore")
	public ModelAndView showAllCourse(ModelAndView mv, HttpSession session) {
		List<Score> scores = eMSAppService.findAllScore();

		if (session.getAttribute("admin") != null) {
			mv.addObject("scores", scores);

			mv.setViewName("score/allScore");

		} else {
			mv.setViewName("redirect:/main");
		}

		return mv;
	}

	// 管理员添加成绩
	@RequestMapping(value = "/score/addScore")
	public ModelAndView addScore(String flag, Integer student_id, Integer course_id, @ModelAttribute Score score,
			ModelAndView mv) {
		if (flag.equals("1")) {

			List<Student> students = eMSAppService.findAllStudent();
			mv.addObject("students", students);
			List<Course> courses = eMSAppService.findAllCourse();
			mv.addObject("courses", courses);
			mv.setViewName("score/showAddScore");
		} else {

			this.genericAssociation(student_id, course_id, score);
			eMSAppService.addScore(score);
			mv.setViewName("redirect:/score/showAllScore");
		}
		return mv;
	}

	// 显示教师添加成绩界面--课程选择界面
	@RequestMapping(value = "/score/teacherAddScore")
	public ModelAndView teacherAddScore(ModelAndView mv, HttpSession session) {
		// List<Student> students = eMSAppService.findAllStudent();
		// mv.addObject("students", students);
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		List<Course> courses = eMSAppService.selectCourseByTeacherId(teacher.getId());
		mv.addObject("courses", courses);
		mv.setViewName("score/showTeacherAddScore");
		return mv;
	}

	// 根据课程添加成绩

	@RequestMapping(value = "/score/teacherAddScoreByCourse")
	public ModelAndView teacherAddScoreByCourse(String flag, int course_id, @ModelAttribute Score score,
			Integer student_id, ModelAndView mv) {

		if (flag.equals("1")) {
			Course course = eMSAppService.selectCourseById(course_id);
			// 选择全部选课的学生
			// List<Student> students = eMSAppService.selectStudentByCourseId(course_id);
			// 选择选该课并且没有条件成绩的学生
			List<Student> students = eMSAppService.selectStudentByCourseIdWithNoScore(course_id);
			mv.addObject("course", course);
			mv.addObject("students", students);
			mv.setViewName("score/showTeacherAddScoreByCourse");
		} else {
			this.genericAssociation(student_id, course_id, score);
			eMSAppService.addScore(score);
			mv.setViewName("redirect:/score/teacherAddScore");
		}
		return mv;
	}

	// 关联分数和学生、课程
	private void genericAssociation(Integer student_id, Integer course_id, Score score) {

		if (score == null) {
			score = new Score();
		}
		if (student_id != null) {

			Student student = new Student();
			student.setId(student_id);
			score.setStudent(student);
		}
		if (course_id != null) {
			Course course = new Course();
			course.setId(course_id);
			score.setCourse(course);
		}
	}

	// 管理员删除成绩
	@RequestMapping(value = "/score/deleteScore")
	public ModelAndView deleteScore(ModelAndView mv, int id, HttpSession session) {
		if (session.getAttribute("admin") != null) {
			eMSAppService.deleteScoreById(id);
			mv.setViewName("redirect:/score/showAllScore");
		} else {
			mv.setViewName("redirect:/main");
		}

		return mv;
	}

	// 管理员更新成绩
	@RequestMapping(value = "/score/updateScore")
	public ModelAndView updateScore(String flag, Integer student_id, Integer course_id, @ModelAttribute Score score,
			ModelAndView mv) {
		if (flag.equals("1")) {
			Score target = eMSAppService.selectScoreById(score.getId());

			mv.addObject("score", target);
			List<Student> students = eMSAppService.findAllStudent();
			mv.addObject("students", students);
			List<Course> courses = eMSAppService.findAllCourse();
			mv.addObject("courses", courses);
			mv.setViewName("score/showUpdateScore");
		} else {
			this.genericAssociation(student_id, course_id, score);
			eMSAppService.modifyScore(score);
			mv.setViewName("redirect:/score/showAllScore");
		}
		return mv;
	}

	
	
	//教师查看课程统计--进入课程选择界面
	@RequestMapping(value = "/score/scoreStatistics")
	public ModelAndView scoreStatistics(ModelAndView mv,HttpSession session) {
		
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		List<Course> courses = eMSAppService.selectCourseByTeacherId(teacher.getId());
		mv.addObject("courses", courses);
		mv.setViewName("score/showChooseCourse");
		return mv;
	}
	
	//教师查看成绩列表--进入课程选择界面
	@RequestMapping(value = "/score/scoreList")
	public ModelAndView scoreList(ModelAndView mv,HttpSession session) {
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		List<Course> courses = eMSAppService.selectCourseByTeacherId(teacher.getId());
		mv.addObject("courses", courses);
		mv.setViewName("score/showChooseCourse2");
		return mv;
	}
	
	@RequestMapping(value = "/score/scoreListByCourse")
	public ModelAndView scoreListByCourse(int course_id,ModelAndView mv,HttpSession session) {	
		List<Score> scores = eMSAppService.selectScoreByCourseId(course_id);
		mv.addObject("scores", scores);
		mv.setViewName("score/allScore");
		return mv;
	}
	
	
	//教师查看统计信息
	@RequestMapping(value = "/score/scoreStatisticsByCourse")
	public ModelAndView scoreStatisticsByCourse(int course_id,ModelAndView mv) {
		
		
		List<Map<String,Object>> maxscoreinfo = eMSAppService.selectMaxScoreInfoByCourseId(course_id);
		mv.addObject("maxscoreinfo", maxscoreinfo);
		
		List<Map<String,Object>> minscoreinfo = eMSAppService.selectMinScoreInfoByCourseId(course_id);
		mv.addObject("minscoreinfo", minscoreinfo);
		
		Map<String,Object> avgscore = eMSAppService.selectAvgScoreByCourseId(course_id);
		mv.addObject("avgscore", avgscore);
		
		Map<String,Object> upavgscorecount = eMSAppService.selectUpAvgScoreCountByCourseId(course_id);
		mv.addObject("upavgscorecount", upavgscorecount);
		
		Map<String,Object> downavgscorecount = eMSAppService.selectDownAvgScoreCountByCourseId(course_id);
		mv.addObject("downavgscorecount", downavgscorecount);
		
		
		Map<String,Object> passcount = eMSAppService.selectPassCountByCourseId(course_id);
		mv.addObject("passcount", passcount);
		
		Map<String,Object> failcount = eMSAppService.selectFailCountByCourseId(course_id);
		mv.addObject("failcount", failcount);
		
		
		mv.setViewName("score/showScoreStatistics");
		return mv;
	}
	
	
	//输入起始分数页面
	@RequestMapping(value = "/score/chooseBetweenAnd")
	public ModelAndView chooseBeteenAnd(ModelAndView mv, HttpSession session) {
		mv.setViewName("score/showBetweenAnd");
		return mv;
	}
}
