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
 * @version 2018��4��1�� ����10:38:14
 */

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("eMSAppService")
public class EMSAppServiceImpl implements EMSAppService {

	
	//*******************************************����ע��******************************************
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

	// **********************************************Admin����************************************
	// ������
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

	// ������
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

	// ���
	@Override
	public void addAdmin(Admin admin) {
		adminDao.save(admin);
	}

	// �޸�
	@Override
	public void modifyAdmin(Admin admin) {
		adminDao.update(admin);
	}

	// ɾ��
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

	// *******************************************Clazz����***************************************

	// ������
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

	// ������
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

	// ���
	@Override
	public void addClazz(Clazz clazz) {
		clazzDao.save(clazz);
	}

	// �޸�
	@Override
	public void modifyClazz(Clazz clazz) {
		clazzDao.update(clazz);
	}

	// ɾ��
	@Override
	public void deleteClazzById(int id) {
		clazzDao.deleteById(id);
	}

	@Override
	public void deleteClazzByNum(String num) {
		clazzDao.deleteByNum(num);
	}

	// ********************************************College����*************************************
	// ������
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

	// ������
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
	// ���
	public void addCollege(College college) {
		collegeDao.save(college);
	}

	@Override
	// �޸�
	public void modifyCollege(College college) {
		collegeDao.update(college);
	}

	@Override
	// ɾ��
	public void deleteCollegeById(int id) {
		collegeDao.deleteById(id);
	}

	@Override
	public void deleteCollegeByNum(String num) {
		collegeDao.deleteByNum(num);
	}

	// *******************************************Course����**************************************
	// ������
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

	// ������
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

	// ���
	@Override
	public void addCourse(Course course) {
		courseDao.save(course);
	}

	// �޸�
	@Override
	public void modifyCourse(Course course) {
		courseDao.update(course);
	}

	// ɾ��
	@Override
	public void deleteCourseById(int id) {
		courseDao.deleteById(id);
	}

	@Override
	public void deleteCourseByNum(String num) {
		courseDao.deleteByNum(num);
	}

	// ѡ��
	@Override
	public void chooseCourse(Integer student_id, Integer course_id) {
		courseDao.chooseCourse(student_id, course_id);
	}

	// �˿�
	@Override
	public void unchooseCourse(Integer student_id, Integer course_id) {
		courseDao.unchooseCourse(student_id, course_id);
	}

	//ÿ���γ�ѡ������
	public List<Map<String, Object>> courseInfo() {
		return courseDao.courseInfo();
	}

	//ĳ�γ�ѡ��ѧ���б�
	public List<Student> courseStudentList(Integer course_id) {
		return courseDao.courseStudentList(course_id);
	}
	
	//ѧ��ѡ������ͳ��
	public List<Map<String,Object>>courseCountByStudent(){
		return courseDao.courseCountByStudent();
	}
	
	//ѡ��3�ż����Ͽγ̵�ѧ��
	public List<Map<String,Object>> courseCountOverThree(){
		return courseDao.courseCountOverThree();
	}
	
	//ͳ��ѡ������Ϊ30�˼����ϵĿγ�
	public List<Course> selectCourseByStudentCountMoreThanThirty(){
		return courseDao.selectCourseByStudentCountMoreThanThirty();
	}
		
	//ͳ��ѡ������Ϊ30�����µĿγ�
	public List<Course> selectCourseByStudentCountLessThanThirty(){
		return courseDao.selectCourseByStudentCountLessThanThirty();
	}
	
	

	// ******************************************Major����****************************************

	// ������
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

	// ������
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

	// ���
	@Override
	public void addMajor(Major major) {
		majorDao.save(major);
	}

	// �޸�
	@Override
	public void modifyMajor(Major major) {
		majorDao.update(major);
	}

	// ɾ��
	@Override
	public void deleteMajorById(int id) {
		majorDao.deleteById(id);
	}

	@Override
	public void deleteMajorByNum(String num) {
		majorDao.deleteByNum(num);
	}

	// ****************************************Notice����******************************************
	// ������
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

	// ������
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

	// ���
	@Override
	public void addNotice(Notice notice) {
		noticeDao.save(notice);
	}

	// �޸�
	@Override
	public void modifyNotice(Notice notice) {
		noticeDao.update(notice);
	}

	// ɾ��
	@Override
	public void deleteNoticeById(int id) {
		noticeDao.deleteById(id);
	}

	@Override
	public void deleteNoticeByTitle(String title) {
		noticeDao.deleteByTitle(title);
	}

	// ******************************************Score����*********************************************
	// ģ������
	@Transactional(readOnly = true)
	@Override
	public List<Score> findScore(Score score) {
		Map<String, Object> params = new HashMap<>();
		params.put("score", score);
		// int recordCount = scoreDao.count(params);
		List<Score> scores = scoreDao.selectByParam(params);
		return scores;

	}

	// ����ȫ��
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

	// �ҿƳɼ�
	@Transactional(readOnly = true)
	@Override
	public List<Score> selectFailScoreByStudentId(int student_id) {
		return scoreDao.selectFailByStudentId(student_id);
	}

	// ͨ���ɼ�
	@Transactional(readOnly = true)
	@Override
	public List<Score> selectPassScoreByStudentId(int student_id) {
		return scoreDao.selectPassByStudentId(student_id);
	}

	// ƽ���ɼ�
	@Transactional(readOnly = true)
	@Override
	public Map<String, Object> selectAvgScoreByStudentId(int student_id) {
		return scoreDao.selectAvgByStudentId(student_id);
	}

	// ��߳ɼ�
	@Transactional(readOnly = true)
	@Override
	public List<Score> selectMaxScoreByStudentId(int student_id) {
		return scoreDao.selectMaxByStudentId(student_id);
	}

	// ��ͳɼ�
	@Transactional(readOnly = true)
	@Override
	public List<Score> selectMinScoreByStudentId(int student_id) {
		return scoreDao.selectMinByStudentId(student_id);
	}

	// �ѻ�ѧ��
	@Transactional(readOnly = true)
	@Override
	public Map<String, Object> selectGetCreditByStudentId(int student_id) {
		return scoreDao.selectGetCreditByStudentId(student_id);
	}

	// ������
	@Transactional(readOnly = true)
	@Override
	public Score selectScoreById(int id) {
		return scoreDao.selectById(id);

	}

	// ���
	@Override
	public void addScore(Score score) {
		scoreDao.save(score);
	}

	// �޸�
	@Override
	public void modifyScore(Score score) {
		scoreDao.update(score);
	}

	// ɾ��
	@Override
	public void deleteScoreById(int id) {
		scoreDao.deleteById(id);
	}

	@Override
	public void deleteScoreByStudentId(int student_id) {
		scoreDao.deleteByStudentId(student_id);
	}

	// ĳ�γ���߷���Ϣ
	@Override
	public List<Map<String,Object>> selectMaxScoreInfoByCourseId(int course_id) {
		return scoreDao.selectMaxScoreInfoByCourseId(course_id);
	}

	// ĳ�γ���ͷ���Ϣ
	@Override
	public List<Map<String,Object>> selectMinScoreInfoByCourseId(int course_id) {
		return scoreDao.selectMinScoreInfoByCourseId(course_id);
	}

	// ĳ�γ�ƽ����
	@Override
	public Map<String, Object> selectAvgScoreByCourseId(int course_id) {
		return scoreDao.selectAvgScoreByCourseId(course_id);
	}

	// ĳ�γ̴���ƽ��������
	@Override
	public Map<String, Object> selectUpAvgScoreCountByCourseId(int course_id) {
		return scoreDao.selectUpAvgScoreCountByCourseId(course_id);

	}

	// ĳ�γ�С��ƽ��������
	@Override
	public Map<String, Object> selectDownAvgScoreCountByCourseId(int course_id) {
		return scoreDao.selectDownAvgScoreCountByCourseId(course_id);
	}

	// ĳ�γ�ͨ������
	@Override
	public Map<String, Object> selectPassCountByCourseId(int course_id) {
		return scoreDao.selectPassCountByCourseId(course_id);

	}

	// ĳ�γ̹ҿ�����
	@Override
	public Map<String, Object> selectFailCountByCourseId(int course_id) {
		return scoreDao.selectFailCountByCourseId(course_id);

	}

	// ************************************************Student����**************************************

	// ������
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

	// ������
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

	// ���
	@Override
	public void addStudent(Student student) {
		studentDao.save(student);
	}

	// �޸�
	@Override
	public void modifyStudent(Student student) {
		studentDao.update(student);
	}

	// ɾ��
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

	// ****************************************Teacher����**********************************************
	// ģ������
	@Transactional(readOnly = true)
	@Override
	public List<Teacher> findTeacher(Teacher teacher) {
		Map<String, Object> params = new HashMap<>();
		params.put("teacher", teacher);
		// int recordCount = teacherDao.count(params);
		List<Teacher> teachers = teacherDao.selectByParam(params);
		return teachers;
	}

	// ����ȫ��
	@Transactional(readOnly = true)
	@Override
	public List<Teacher> findAllTeacher() {
		return teacherDao.selectAll();
	}

	// ��רҵ��Ų���
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

	// ��ID����
	@Transactional(readOnly = true)
	@Override
	public Teacher selectTeacherById(int id) {
		return teacherDao.selectById(id);
	}

	// ����ʦ�Ų���
	@Transactional(readOnly = true)
	@Override
	public Teacher selectTeacherByNum(String num) {
		return teacherDao.selectByNum(num);
	}

	// ��ӽ�ʦ
	@Override
	public void addTeacher(Teacher teacher) {
		teacherDao.save(teacher);
	}

	// �޸Ľ�ʦ
	@Override
	public void modifyTeacher(Teacher teacher) {
		teacherDao.update(teacher);
	}

	// ��IDɾ����ʦ
	@Override
	public void deleteTeacherById(int id) {
		teacherDao.deleteById(id);
	}

	// ����ʦ��ɾ����ʦ
	@Override
	public void deleteTeacherByNum(String num) {
		teacherDao.deleteByNum(num);
	}

	// ********************************************Login����********************************************

	// ѧ����¼
	@Transactional(readOnly = true)
	@Override
	public Student studentlogin(String num, String password) {
		return studentDao.selectByNumAndPassword(num, password);
	}

	// ��ʦ��¼
	@Transactional(readOnly = true)
	@Override
	public Teacher teacherlogin(String num, String password) {
		return teacherDao.selectByNumAndPassword(num, password);
	}

	// ����Ա��¼
	@Transactional(readOnly = true)
	@Override
	public Admin adminlogin(String num, String password) {
		return adminDao.selectByNumAndPassword(num, password);
	}

	// �޸�����
	public void changepasswd(int student_id, String password) {
		studentDao.changepasswd(student_id, password);
	}

	// �һ�����
	public String findpasswd(String num, String name, String tel) {
		return studentDao.findpasswd(num, name, tel);
	}
}
