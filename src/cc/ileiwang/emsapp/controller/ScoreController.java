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
 * @version 2018��4��1�� ����10:52:07
 */
@Controller
public class ScoreController {
	// �Զ�ע��eMSAppService
	@Autowired
	@Qualifier("eMSAppService")
	private EMSAppService eMSAppService;

	// *********************************************************************************************
	// ѧ���鿴�������гɼ�
	@RequestMapping(value = "/score/selectScore")
	public String selectScore(@ModelAttribute Score score, Model model, HttpSession session) {
		if (session.getAttribute("student") != null) {
			Student student = (Student) session.getAttribute("student");

			List<Score> scores = eMSAppService.selectScoreByStudentId(student.getId());
			model.addAttribute("scores", scores);

		}
		return "score/allScore";
	}

	// ѧ���鿴����ƽ���ɼ�
	@RequestMapping(value = "/score/showAvgScore")
	public String showAvgScore(Model model, HttpSession session) {
		if (session.getAttribute("student") != null) {
			Student student = (Student) session.getAttribute("student");

			Map<String, Object> avgscore = eMSAppService.selectAvgScoreByStudentId(student.getId());
			model.addAttribute("avgscore", avgscore);

		}
		return "score/scoreInfo";
	}

	// ѧ���鿴�����ѻ�ѧ��
	@RequestMapping(value = "/score/showGetCredit")
	public String showGetCredit(@ModelAttribute Score score, Model model, HttpSession session) {
		if (session.getAttribute("student") != null) {
			Student student = (Student) session.getAttribute("student");

			Map<String, Object> getcredit = eMSAppService.selectGetCreditByStudentId(student.getId());
			model.addAttribute("getcredit", getcredit);
		}
		return "score/scoreInfo";
	}

	// ѧ���鿴���˹ҿƳɼ�
	@RequestMapping(value = "/score/showFailScore")
	public String showFailScore(@ModelAttribute Score score, Model model, HttpSession session) {
		if (session.getAttribute("student") != null) {
			Student student = (Student) session.getAttribute("student");

			List<Score> scores = eMSAppService.selectFailScoreByStudentId(student.getId());
			model.addAttribute("scores", scores);

		}
		return "score/allScore";
	}

	// ѧ���鿴����ͨ���ɼ�
	@RequestMapping(value = "/score/showPassScore")
	public String showPassScore(@ModelAttribute Score score, Model model, HttpSession session) {
		if (session.getAttribute("student") != null) {
			Student student = (Student) session.getAttribute("student");

			List<Score> scores = eMSAppService.selectPassScoreByStudentId(student.getId());
			model.addAttribute("scores", scores);

		}
		return "score/allScore";
	}

	// ѧ���鿴������߷�
	@RequestMapping(value = "/score/showMaxScore")
	public String showMaxScore(@ModelAttribute Score score, Model model, HttpSession session) {
		if (session.getAttribute("student") != null) {
			Student student = (Student) session.getAttribute("student");

			List<Score> scores = eMSAppService.selectMaxScoreByStudentId(student.getId());
			model.addAttribute("scores", scores);

		}
		return "score/allScore";
	}

	// ѧ���鿴������ͷ�
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

	// ����Ա�鿴���гɼ�
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

	// ����Ա��ӳɼ�
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

	// ��ʾ��ʦ��ӳɼ�����--�γ�ѡ�����
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

	// ���ݿγ���ӳɼ�

	@RequestMapping(value = "/score/teacherAddScoreByCourse")
	public ModelAndView teacherAddScoreByCourse(String flag, int course_id, @ModelAttribute Score score,
			Integer student_id, ModelAndView mv) {

		if (flag.equals("1")) {
			Course course = eMSAppService.selectCourseById(course_id);
			// ѡ��ȫ��ѡ�ε�ѧ��
			// List<Student> students = eMSAppService.selectStudentByCourseId(course_id);
			// ѡ��ѡ�ÿβ���û�������ɼ���ѧ��
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

	// ����������ѧ�����γ�
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

	// ����Աɾ���ɼ�
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

	// ����Ա���³ɼ�
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

	
	
	//��ʦ�鿴�γ�ͳ��--����γ�ѡ�����
	@RequestMapping(value = "/score/scoreStatistics")
	public ModelAndView scoreStatistics(ModelAndView mv,HttpSession session) {
		
		Teacher teacher = (Teacher) session.getAttribute("teacher");
		List<Course> courses = eMSAppService.selectCourseByTeacherId(teacher.getId());
		mv.addObject("courses", courses);
		mv.setViewName("score/showChooseCourse");
		return mv;
	}
	
	//��ʦ�鿴�ɼ��б�--����γ�ѡ�����
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
	
	
	//��ʦ�鿴ͳ����Ϣ
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
	
	
	//������ʼ����ҳ��
	@RequestMapping(value = "/score/chooseBetweenAnd")
	public ModelAndView chooseBeteenAnd(ModelAndView mv, HttpSession session) {
		mv.setViewName("score/showBetweenAnd");
		return mv;
	}
}
