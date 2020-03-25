package cc.ileiwang.emsapp.service;

import java.util.List;
//import java.util.Map;
import java.util.Map;


import cc.ileiwang.emsapp.domain.*;
/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018年4月1日 上午10:37:42
*/
public interface EMSAppService {
	
	
	//*******************************************Admin操作****************************************
	
	//批查找
	public List<Admin> findAdmin(Admin admin);
	public List<Admin> findAllAdmin();
	//单查找
	public Admin selectAdminById(int id);
	public Admin selectAdminByNum(String num);
	//添加
	public void addAdmin(Admin admin);
	//修改
	public void modifyAdmin(Admin admin);
	//删除
	public void deleteAdminById(int id);
	public void deleteAdminByNum(String num);
	public void deleteAdminByName(String name);
		
	
	
	
	//********************************************Clazz操作****************************************
	
	//批查找
	public List<Clazz> findClazz(Clazz clazz);
	public List<Clazz> findAllClazz();
	public List<Clazz> selectClazzByMajorId(int major_id);
	public List<Clazz> selectClazzByCollegeId(int college_id);
	//单查找
	public Clazz selectClazzById(int id);
	public Clazz selectClazzByNum(String num);
	//添加
	public void addClazz(Clazz clazz);
	//修改
	public void modifyClazz(Clazz clazz);
	//删除
	public void deleteClazzById(int id);
	public void deleteClazzByNum(String num);
	
	
	
	
	
	//****************************************College操作******************************************
	
	//批查找
	public List<College> findCollege(College college);
	public List<College> findAllCollege();
	//单查找
	public College selectCollegeById(int id);
	public College selectCollegeByNum(String num);
	//添加
	public void addCollege(College college);
	//修改
	public void modifyCollege(College college);
	//删除
	public void deleteCollegeById(int id);
	public void deleteCollegeByNum(String num);
	
	
	
	
	
	//**************************************Course操作*********************************************
	
	//批查找
	public List<Course> findCourse(Course course);
	public List<Course> findAllCourse();
	public List<Course> selectCourseByTeacherId(int teacher_id);
	public List<Course> selectCourseByStudentId(int student_id);
	public List<Course> selectCourseByMajorId(int major_id);
	public List<Course> selectCourseByCollegeId(int college_id);
	public List<Course> selectCourseByMajorAndStudentUnChoosen(int major_id,int student_id);
	//单查找
	public Course selectCourseById(int id);
	public Course selectCourseByNum(String num);
	//添加
	public void addCourse(Course course);
	//修改
	public void modifyCourse(Course course);
	//删除
	public void deleteCourseById(int id);
	public void deleteCourseByNum(String num);
	//选课
	public void chooseCourse(Integer student_id,Integer course_id);
	//退选
	public void unchooseCourse(Integer student_id,Integer course_id);
	
	//课程选课人数信息
	public List<Map<String,Object>> courseInfo();
	
	//课程选课人数列表
	public List<Student> courseStudentList(Integer course_id);
	
	//学生选课数量统计
	public List<Map<String,Object>>courseCountByStudent();
	
	//选修3门及以上课程的学生
	public List<Map<String,Object>> courseCountOverThree();
	
	//统计选课人数为30人及以上的课程
	public List<Course> selectCourseByStudentCountMoreThanThirty();
		
	//统计选课人数为30人以下的课程
	public List<Course> selectCourseByStudentCountLessThanThirty();
	
	
	
	//****************************************Major操作*******************************************
	
	//批查找
	public List<Major> findMajor(Major major);
	public List<Major> findAllMajor();
	public List<Major> selectMajorByCollegeId(int college_id);
	//单查找
	public Major selectMajorById(int id);
	public Major selectMajorByNum(String num);
	//添加
	public void addMajor(Major major);
	//修改
	public void modifyMajor(Major major);
	//删除
	public void deleteMajorById(int id);
	public void deleteMajorByNum(String num);
	
	
	
	
	
	//****************************************Notice操作******************************************
	
	//批查找
	public List<Notice> findNotice(Notice notice);
	public List<Notice> findAllNotice();
	public List<Notice> findNoticeByAdminId(int admin_id);
	//单查找
	public Notice selectNoticeById(int id);
	public Notice selectNoticeByTitle(String title);
	//添加
	public void addNotice(Notice notice);
	//修改
	public void modifyNotice(Notice notice);
	//删除
	public void deleteNoticeById(int id);
	public void deleteNoticeByTitle(String title);
	
	
	
	
	
	//******************************************Score操作*****************************************
	
	//批查找
	public List<Score> findScore(Score score);
	public List<Score> findAllScore();
	public List<Score> selectScoreByStudentId(int student_id);
	public List<Score> selectScoreByCourseId(int course_id);
	public List<Score> selectFailScoreByStudentId(int student_id);
	public List<Score> selectPassScoreByStudentId(int student_id);
	public Map<String,Object> selectAvgScoreByStudentId(int student_id);
	public List<Score> selectMaxScoreByStudentId(int student_id);
	public List<Score> selectMinScoreByStudentId(int student_id);
	public Map<String,Object> selectGetCreditByStudentId(int student_id);
	//单查找
	public Score selectScoreById(int id);
	//添加
	public void addScore(Score score);
	//修改
	public void modifyScore(Score score);
	//删除
	public void deleteScoreById(int id);
	public void deleteScoreByStudentId(int student_id);
	
	//某课程最高分信息
	public List<Map<String,Object>> selectMaxScoreInfoByCourseId(int course_id);
	
	//某课程最低分信息
	public List<Map<String,Object>> selectMinScoreInfoByCourseId(int course_id);
	
	//某课程平均分
	public Map<String,Object> selectAvgScoreByCourseId(int course_id);
	
	//某课程大于平均分人数
	public Map<String,Object> selectUpAvgScoreCountByCourseId(int course_id);
	
	//某课程小于平均分人数
	public Map<String,Object> selectDownAvgScoreCountByCourseId(int course_id);
	
	//某课程通过人数
	public Map<String,Object> selectPassCountByCourseId(int course_id);
	
	//某课程挂科人数
	public Map<String,Object> selectFailCountByCourseId(int course_id);
	
	
	
	//**************************************Student操作********************************************
	
	//批查找
	public List<Student> findStudent(Student student);
	public List<Student> findAllStudent();
	public List<Student> selectStudentByClazzId(int clazz_id);
	public List<Student> selectStudentByCourseId(int course_id);
	public List<Student> selectStudentByCollegeId(int college_id);
	public List<Student> selectStudentByMajorId(int major_id);
	//选择选修某课程未添加成绩的学生
	public List<Student> selectStudentByCourseIdWithNoScore(int course_id);
	
	//平均分位于起始区间的学生
	public List<Student> avgScoreBetweenAnd(int start,int end);
	
	
	//单查找
	public Student selectStudentById(int id);
	public Student selectStudentByNum(String num);
	//添加
	public void addStudent(Student student);
	//修改
	public void modifyStudent(Student student);
	//删除
	public void deleteStudentById(int id);
	public void deleteStudentByNum(String num);
	public void deleteByClazzId(int clazz_id);
	public void deleteByCourseId(int course_id);
	
	
	
	//*******************************************Teacher操作**************************************
	
	//批查找
	public List<Teacher> findTeacher(Teacher teacher);
	public List<Teacher> findAllTeacher();
	public List<Teacher> selectTeacherByMajorId(int major_id);
	public List<Teacher> selectTeacherByCollegeId(int college_id);
	//单查找
	public Teacher selectTeacherById(int id);
	public Teacher selectTeacherByNum(String num);
	//添加
	public void addTeacher(Teacher teacher);
	//修改
	public void modifyTeacher(Teacher teacher);
	//删除
	public void deleteTeacherById(int id);
	public void deleteTeacherByNum(String num);
	
	
	
	//*********************************************Login操作**************************************
	
	public Student studentlogin(String num,String password);
	public Teacher teacherlogin(String num,String password);
	public Admin adminlogin(String num,String password);
	
	
	
	//***********************************************账号操作**************************************
	
	public void changepasswd(int student_id,String password);
	
	public String findpasswd(String num,String name,String tel);
}
