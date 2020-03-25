package cc.ileiwang.emsapp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cc.ileiwang.emsapp.dao.*;
import cc.ileiwang.emsapp.domain.*;
import cc.ileiwang.emsapp.service.EMSAppService;

/**
 * @author Lei Wang
 * @email 3970111@gmail.com
 * @blog www.ileiwang.cc
 * @version 2018年4月1日 上午10:38:14
 */

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("eMSAppService")
public class EMSAppServiceImpl implements EMSAppService {

	
	//*******************************************依赖注入******************************************
	@Autowired
	private AdminDAO adminDao;

	@Autowired
	private ClazzDAO clazzDao;

	@Autowired
	private CollegeDAO collegeDao;

	@Autowired
	private CourseDAO courseDao;

	@Autowired
	private MajorDAO majorDao;

	@Autowired
	private NoticeDAO noticeDao;

	@Autowired
	private ScoreDAO scoreDao;

	@Autowired
	private StudentDAO studentDao;

	@Autowired
	private TeacherDAO teacherDao;

	// **********************************************Admin操作************************************
	// 批查找
	@Transactional(readOnly = true)
	@Override
	public List<Admin> findAdmin(Admin admin) {

		Map<String, Object> params = new HashMap<>();
		params.put("admin", admin);
		// int recordCount = adminDao.count(params);
		List<Admin> admins = adminDao.selectByParam(params);
		return admins;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Admin> findAllAdmin() {
		return adminDao.selectAll();
	}

	// 单查找
	@Transactional(readOnly = true)
	@Override
	public Admin selectAdminById(int id) {
		return adminDao.selectById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Admin selectAdminByNum(String num) {
		return adminDao.selectByNum(num);
	}

	// 添加
	@Override
	public void addAdmin(Admin admin) {
		adminDao.save(admin);
	}

	// 修改
	@Override
	public void modifyAdmin(Admin admin) {
		adminDao.update(admin);
	}

	// 删除
	@Override
	public void deleteAdminById(int id) {
		adminDao.deleteById(id);
	}

	@Override
	public void deleteAdminByNum(String num) {
		adminDao.deleteByNum(num);
	}

	@Override
	public void deleteAdminByName(String name) {
		adminDao.deleteByName(name);
	}

	// *******************************************Clazz操作***************************************

	// 批查找
	@Transactional(readOnly = true)
	@Override
	public List<Clazz> findClazz(Clazz clazz) {

		Map<String, Object> params = new HashMap<>();
		params.put("clazz", clazz);
		// int recordCount = clazzDao.count(params);
		List<Clazz> clazzs = clazzDao.selectByParam(params);
		return clazzs;

	}

	@Transactional(readOnly = true)
	@Override
	public List<Clazz> findAllClazz() {
		return clazzDao.selectAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Clazz> selectClazzByMajorId(int major_id) {
		return clazzDao.selectByMajorId(major_id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Clazz> selectClazzByCollegeId(int college_id){
		return clazzDao.selectByCollegeId(college_id);
	}

	// 单查找
	@Transactional(readOnly = true)
	@Override
	public Clazz selectClazzById(int id) {
		return clazzDao.selectById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Clazz selectClazzByNum(String num) {
		return clazzDao.selectByNum(num);
	}

	// 添加
	@Override
	public void addClazz(Clazz clazz) {
		clazzDao.save(clazz);
	}

	// 修改
	@Override
	public void modifyClazz(Clazz clazz) {
		clazzDao.update(clazz);
	}

	// 删除
	@Override
	public void deleteClazzById(int id) {
		clazzDao.deleteById(id);
	}

	@Override
	public void deleteClazzByNum(String num) {
		clazzDao.deleteByNum(num);
	}

	// ********************************************College操作*************************************
	// 批查找
	@Transactional(readOnly = true)
	@Override
	public List<College> findCollege(College college) {
		Map<String, Object> params = new HashMap<>();
		params.put("college", college);
		// int recordCount = collegeDao.count(params);
		List<College> colleges = collegeDao.selectByParam(params);
		return colleges;
	}

	@Transactional(readOnly = true)
	@Override
	public List<College> findAllCollege() {
		return collegeDao.selectAll();
	}

	// 单查找
	@Transactional(readOnly = true)
	@Override
	public College selectCollegeById(int id) {
		return collegeDao.selectById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public College selectCollegeByNum(String num) {
		return collegeDao.selectByNum(num);
	}

	@Override
	// 添加
	public void addCollege(College college) {
		collegeDao.save(college);
	}

	@Override
	// 修改
	public void modifyCollege(College college) {
		collegeDao.update(college);
	}

	@Override
	// 删除
	public void deleteCollegeById(int id) {
		collegeDao.deleteById(id);
	}

	@Override
	public void deleteCollegeByNum(String num) {
		collegeDao.deleteByNum(num);
	}

	// *******************************************Course操作**************************************
	// 批查找
	@Transactional(readOnly = true)
	@Override
	public List<Course> findCourse(Course course) {
		Map<String, Object> params = new HashMap<>();
		params.put("course", course);
		// int recordCount = courseDao.count(params);
		List<Course> courses = courseDao.selectByParam(params);
		return courses;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Course> findAllCourse() {
		return courseDao.selectAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Course> selectCourseByTeacherId(int teacher_id) {
		return courseDao.selectByTeacherId(teacher_id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Course> selectCourseByStudentId(int student_id) {
		return courseDao.selectByStudentId(student_id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Course> selectCourseByMajorId(int major_id) {
		return courseDao.selectByMajorId(major_id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Course> selectCourseByCollegeId(int college_id) {
		return courseDao.selectByCollegeId(college_id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Course> selectCourseByMajorAndStudentUnChoosen(int major_id, int student_id) {
		return courseDao.selectByMajorAndStudentUnChoosen(major_id, student_id);
	}

	// 单查找
	@Transactional(readOnly = true)
	@Override
	public Course selectCourseById(int id) {
		return courseDao.selectById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Course selectCourseByNum(String num) {
		return courseDao.selectByNum(num);
	}

	// 添加
	@Override
	public void addCourse(Course course) {
		courseDao.save(course);
	}

	// 修改
	@Override
	public void modifyCourse(Course course) {
		courseDao.update(course);
	}

	// 删除
	@Override
	public void deleteCourseById(int id) {
		courseDao.deleteById(id);
	}

	@Override
	public void deleteCourseByNum(String num) {
		courseDao.deleteByNum(num);
	}

	// 选课
	@Override
	public void chooseCourse(Integer student_id, Integer course_id) {
		courseDao.chooseCourse(student_id, course_id);
	}

	// 退课
	@Override
	public void unchooseCourse(Integer student_id, Integer course_id) {
		courseDao.unchooseCourse(student_id, course_id);
	}

	//每个课程选课人数
	public List<Map<String, Object>> courseInfo() {
		return courseDao.courseInfo();
	}

	//某课程选课学生列表
	public List<Student> courseStudentList(Integer course_id) {
		return courseDao.courseStudentList(course_id);
	}
	
	//学生选课数量统计
	public List<Map<String,Object>>courseCountByStudent(){
		return courseDao.courseCountByStudent();
	}
	
	//选修3门及以上课程的学生
	public List<Map<String,Object>> courseCountOverThree(){
		return courseDao.courseCountOverThree();
	}
	
	//统计选课人数为30人及以上的课程
	public List<Course> selectCourseByStudentCountMoreThanThirty(){
		return courseDao.selectCourseByStudentCountMoreThanThirty();
	}
		
	//统计选课人数为30人以下的课程
	public List<Course> selectCourseByStudentCountLessThanThirty(){
		return courseDao.selectCourseByStudentCountLessThanThirty();
	}
	
	

	// ******************************************Major操作****************************************

	// 批查找
	@Transactional(readOnly = true)
	@Override
	public List<Major> findMajor(Major major) {
		Map<String, Object> params = new HashMap<>();
		params.put("major", major);
		// int recordCount = majorDao.count(params);
		List<Major> majors = majorDao.selectByParam(params);
		return majors;

	}

	@Transactional(readOnly = true)
	@Override
	public List<Major> findAllMajor() {
		return majorDao.selectAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Major> selectMajorByCollegeId(int college_id) {
		return majorDao.selectByCollegeId(college_id);
	}

	// 单查找
	@Transactional(readOnly = true)
	@Override
	public Major selectMajorById(int id) {
		return majorDao.selectById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Major selectMajorByNum(String num) {
		return majorDao.selectByNum(num);
	}

	// 添加
	@Override
	public void addMajor(Major major) {
		majorDao.save(major);
	}

	// 修改
	@Override
	public void modifyMajor(Major major) {
		majorDao.update(major);
	}

	// 删除
	@Override
	public void deleteMajorById(int id) {
		majorDao.deleteById(id);
	}

	@Override
	public void deleteMajorByNum(String num) {
		majorDao.deleteByNum(num);
	}

	// ****************************************Notice操作******************************************
	// 批查找
	@Transactional(readOnly = true)
	@Override
	public List<Notice> findNotice(Notice notice) {
		Map<String, Object> params = new HashMap<>();
		params.put("notice", notice);
		// int recordCount = noticeDao.count(params);
		List<Notice> notices = noticeDao.selectByParam(params);
		return notices;

	}

	@Transactional(readOnly = true)
	@Override
	public List<Notice> findAllNotice() {
		return noticeDao.selectAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Notice> findNoticeByAdminId(int admin_id) {
		return noticeDao.selectByAdminId(admin_id);
	}

	// 单查找
	@Transactional(readOnly = true)
	@Override
	public Notice selectNoticeById(int id) {
		return noticeDao.selectById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Notice selectNoticeByTitle(String title) {
		return noticeDao.selectByTitle(title);
	}

	// 添加
	@Override
	public void addNotice(Notice notice) {
		noticeDao.save(notice);
	}

	// 修改
	@Override
	public void modifyNotice(Notice notice) {
		noticeDao.update(notice);
	}

	// 删除
	@Override
	public void deleteNoticeById(int id) {
		noticeDao.deleteById(id);
	}

	@Override
	public void deleteNoticeByTitle(String title) {
		noticeDao.deleteByTitle(title);
	}

	// ******************************************Score操作*********************************************
	// 模糊查找
	@Transactional(readOnly = true)
	@Override
	public List<Score> findScore(Score score) {
		Map<String, Object> params = new HashMap<>();
		params.put("score", score);
		// int recordCount = scoreDao.count(params);
		List<Score> scores = scoreDao.selectByParam(params);
		return scores;

	}

	// 查找全部
	@Transactional(readOnly = true)
	@Override
	public List<Score> findAllScore() {
		return scoreDao.selectAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Score> selectScoreByStudentId(int student_id) {
		return scoreDao.selectByStudentId(student_id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Score> selectScoreByCourseId(int course_id) {
		return scoreDao.selectByCourseId(course_id);
	}

	// 挂科成绩
	@Transactional(readOnly = true)
	@Override
	public List<Score> selectFailScoreByStudentId(int student_id) {
		return scoreDao.selectFailByStudentId(student_id);
	}

	// 通过成绩
	@Transactional(readOnly = true)
	@Override
	public List<Score> selectPassScoreByStudentId(int student_id) {
		return scoreDao.selectPassByStudentId(student_id);
	}

	// 平均成绩
	@Transactional(readOnly = true)
	@Override
	public Map<String, Object> selectAvgScoreByStudentId(int student_id) {
		return scoreDao.selectAvgByStudentId(student_id);
	}

	// 最高成绩
	@Transactional(readOnly = true)
	@Override
	public List<Score> selectMaxScoreByStudentId(int student_id) {
		return scoreDao.selectMaxByStudentId(student_id);
	}

	// 最低成绩
	@Transactional(readOnly = true)
	@Override
	public List<Score> selectMinScoreByStudentId(int student_id) {
		return scoreDao.selectMinByStudentId(student_id);
	}

	// 已获学分
	@Transactional(readOnly = true)
	@Override
	public Map<String, Object> selectGetCreditByStudentId(int student_id) {
		return scoreDao.selectGetCreditByStudentId(student_id);
	}

	// 单查找
	@Transactional(readOnly = true)
	@Override
	public Score selectScoreById(int id) {
		return scoreDao.selectById(id);

	}

	// 添加
	@Override
	public void addScore(Score score) {
		scoreDao.save(score);
	}

	// 修改
	@Override
	public void modifyScore(Score score) {
		scoreDao.update(score);
	}

	// 删除
	@Override
	public void deleteScoreById(int id) {
		scoreDao.deleteById(id);
	}

	@Override
	public void deleteScoreByStudentId(int student_id) {
		scoreDao.deleteByStudentId(student_id);
	}

	// 某课程最高分信息
	@Override
	public List<Map<String,Object>> selectMaxScoreInfoByCourseId(int course_id) {
		return scoreDao.selectMaxScoreInfoByCourseId(course_id);
	}

	// 某课程最低分信息
	@Override
	public List<Map<String,Object>> selectMinScoreInfoByCourseId(int course_id) {
		return scoreDao.selectMinScoreInfoByCourseId(course_id);
	}

	// 某课程平均分
	@Override
	public Map<String, Object> selectAvgScoreByCourseId(int course_id) {
		return scoreDao.selectAvgScoreByCourseId(course_id);
	}

	// 某课程大于平均分人数
	@Override
	public Map<String, Object> selectUpAvgScoreCountByCourseId(int course_id) {
		return scoreDao.selectUpAvgScoreCountByCourseId(course_id);

	}

	// 某课程小于平均分人数
	@Override
	public Map<String, Object> selectDownAvgScoreCountByCourseId(int course_id) {
		return scoreDao.selectDownAvgScoreCountByCourseId(course_id);
	}

	// 某课程通过人数
	@Override
	public Map<String, Object> selectPassCountByCourseId(int course_id) {
		return scoreDao.selectPassCountByCourseId(course_id);

	}

	// 某课程挂科人数
	@Override
	public Map<String, Object> selectFailCountByCourseId(int course_id) {
		return scoreDao.selectFailCountByCourseId(course_id);

	}

	// ************************************************Student操作**************************************

	// 批查找
	@Transactional(readOnly = true)
	@Override
	public List<Student> findStudent(Student student) {
		Map<String, Object> params = new HashMap<>();
		params.put("student", student);
		// int recordCount = studentDao.count(params);
		List<Student> students = studentDao.selectByParam(params);
		return students;

	}

	@Transactional(readOnly = true)
	@Override
	public List<Student> findAllStudent() {
		return studentDao.selectAllStudent();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Student> selectStudentByClazzId(int clazz_id) {
		return studentDao.selectByClazzId(clazz_id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Student> selectStudentByCourseId(int course_id) {
		return studentDao.selectByCourseId(course_id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Student> selectStudentByCollegeId(int college_id){
		return studentDao.selectByCollegeId(college_id);
	}
	
	
	@Transactional(readOnly = true)
	@Override
	public List<Student> selectStudentByMajorId(int major_id){
		return studentDao.selectByMajorId(major_id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Student> selectStudentByCourseIdWithNoScore(int course_id) {
		return studentDao.selectByByCourseIdWithNoScore(course_id);
	}
	
	
	@Transactional(readOnly = true)
	@Override
	public List<Student> avgScoreBetweenAnd(int start,int end){
		return studentDao.avgScoreBetweenAnd(start,end);
	}

	// 单查找
	@Transactional(readOnly = true)
	@Override
	public Student selectStudentById(int id) {
		return studentDao.selectById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Student selectStudentByNum(String num) {
		return studentDao.selectByNum(num);
	}

	// 添加
	@Override
	public void addStudent(Student student) {
		studentDao.save(student);
	}

	// 修改
	@Override
	public void modifyStudent(Student student) {
		studentDao.update(student);
	}

	// 删除
	@Override
	public void deleteStudentById(int id) {
		studentDao.deleteById(id);
	}

	@Override
	public void deleteStudentByNum(String num) {
		studentDao.deleteByNum(num);
	}

	@Override
	public void deleteByClazzId(int clazz_id) {
		studentDao.deleteByClazzId(clazz_id);
	}

	@Override
	public void deleteByCourseId(int course_id) {
		studentDao.deleteByCourseId(course_id);
	}

	// ****************************************Teacher操作**********************************************
	// 模糊查找
	@Transactional(readOnly = true)
	@Override
	public List<Teacher> findTeacher(Teacher teacher) {
		Map<String, Object> params = new HashMap<>();
		params.put("teacher", teacher);
		// int recordCount = teacherDao.count(params);
		List<Teacher> teachers = teacherDao.selectByParam(params);
		return teachers;
	}

	// 查找全部
	@Transactional(readOnly = true)
	@Override
	public List<Teacher> findAllTeacher() {
		return teacherDao.selectAll();
	}

	// 按专业编号查找
	@Transactional(readOnly = true)
	@Override
	public List<Teacher> selectTeacherByMajorId(int major_id) {
		return teacherDao.selectByMajorId(major_id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Teacher> selectTeacherByCollegeId(int college_id){
		return teacherDao.selectByCollegeId(college_id);
	}

	// 按ID查找
	@Transactional(readOnly = true)
	@Override
	public Teacher selectTeacherById(int id) {
		return teacherDao.selectById(id);
	}

	// 按教师号查找
	@Transactional(readOnly = true)
	@Override
	public Teacher selectTeacherByNum(String num) {
		return teacherDao.selectByNum(num);
	}

	// 添加教师
	@Override
	public void addTeacher(Teacher teacher) {
		teacherDao.save(teacher);
	}

	// 修改教师
	@Override
	public void modifyTeacher(Teacher teacher) {
		teacherDao.update(teacher);
	}

	// 按ID删除教师
	@Override
	public void deleteTeacherById(int id) {
		teacherDao.deleteById(id);
	}

	// 按教师号删除教师
	@Override
	public void deleteTeacherByNum(String num) {
		teacherDao.deleteByNum(num);
	}

	// ********************************************Login操作********************************************

	// 学生登录
	@Transactional(readOnly = true)
	@Override
	public Student studentlogin(String num, String password) {
		return studentDao.selectByNumAndPassword(num, password);
	}

	// 教师登录
	@Transactional(readOnly = true)
	@Override
	public Teacher teacherlogin(String num, String password) {
		return teacherDao.selectByNumAndPassword(num, password);
	}

	// 管理员登录
	@Transactional(readOnly = true)
	@Override
	public Admin adminlogin(String num, String password) {
		return adminDao.selectByNumAndPassword(num, password);
	}

	// 修改密码
	public void changepasswd(int student_id, String password) {
		studentDao.changepasswd(student_id, password);
	}

	// 找回密码
	public String findpasswd(String num, String name, String tel) {
		return studentDao.findpasswd(num, name, tel);
	}
}
