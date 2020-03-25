package cc.ileiwang.emsapp.service;

import java.util.List;
//import java.util.Map;
import java.util.Map;


import cc.ileiwang.emsapp.domain.*;
/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018��4��1�� ����10:37:42
*/
public interface EMSAppService {
	
	
	//*******************************************Admin����****************************************
	
	//������
	public List<Admin> findAdmin(Admin admin);
	public List<Admin> findAllAdmin();
	//������
	public Admin selectAdminById(int id);
	public Admin selectAdminByNum(String num);
	//���
	public void addAdmin(Admin admin);
	//�޸�
	public void modifyAdmin(Admin admin);
	//ɾ��
	public void deleteAdminById(int id);
	public void deleteAdminByNum(String num);
	public void deleteAdminByName(String name);
		
	
	
	
	//********************************************Clazz����****************************************
	
	//������
	public List<Clazz> findClazz(Clazz clazz);
	public List<Clazz> findAllClazz();
	public List<Clazz> selectClazzByMajorId(int major_id);
	public List<Clazz> selectClazzByCollegeId(int college_id);
	//������
	public Clazz selectClazzById(int id);
	public Clazz selectClazzByNum(String num);
	//���
	public void addClazz(Clazz clazz);
	//�޸�
	public void modifyClazz(Clazz clazz);
	//ɾ��
	public void deleteClazzById(int id);
	public void deleteClazzByNum(String num);
	
	
	
	
	
	//****************************************College����******************************************
	
	//������
	public List<College> findCollege(College college);
	public List<College> findAllCollege();
	//������
	public College selectCollegeById(int id);
	public College selectCollegeByNum(String num);
	//���
	public void addCollege(College college);
	//�޸�
	public void modifyCollege(College college);
	//ɾ��
	public void deleteCollegeById(int id);
	public void deleteCollegeByNum(String num);
	
	
	
	
	
	//**************************************Course����*********************************************
	
	//������
	public List<Course> findCourse(Course course);
	public List<Course> findAllCourse();
	public List<Course> selectCourseByTeacherId(int teacher_id);
	public List<Course> selectCourseByStudentId(int student_id);
	public List<Course> selectCourseByMajorId(int major_id);
	public List<Course> selectCourseByCollegeId(int college_id);
	public List<Course> selectCourseByMajorAndStudentUnChoosen(int major_id,int student_id);
	//������
	public Course selectCourseById(int id);
	public Course selectCourseByNum(String num);
	//���
	public void addCourse(Course course);
	//�޸�
	public void modifyCourse(Course course);
	//ɾ��
	public void deleteCourseById(int id);
	public void deleteCourseByNum(String num);
	//ѡ��
	public void chooseCourse(Integer student_id,Integer course_id);
	//��ѡ
	public void unchooseCourse(Integer student_id,Integer course_id);
	
	//�γ�ѡ��������Ϣ
	public List<Map<String,Object>> courseInfo();
	
	//�γ�ѡ�������б�
	public List<Student> courseStudentList(Integer course_id);
	
	//ѧ��ѡ������ͳ��
	public List<Map<String,Object>>courseCountByStudent();
	
	//ѡ��3�ż����Ͽγ̵�ѧ��
	public List<Map<String,Object>> courseCountOverThree();
	
	//ͳ��ѡ������Ϊ30�˼����ϵĿγ�
	public List<Course> selectCourseByStudentCountMoreThanThirty();
		
	//ͳ��ѡ������Ϊ30�����µĿγ�
	public List<Course> selectCourseByStudentCountLessThanThirty();
	
	
	
	//****************************************Major����*******************************************
	
	//������
	public List<Major> findMajor(Major major);
	public List<Major> findAllMajor();
	public List<Major> selectMajorByCollegeId(int college_id);
	//������
	public Major selectMajorById(int id);
	public Major selectMajorByNum(String num);
	//���
	public void addMajor(Major major);
	//�޸�
	public void modifyMajor(Major major);
	//ɾ��
	public void deleteMajorById(int id);
	public void deleteMajorByNum(String num);
	
	
	
	
	
	//****************************************Notice����******************************************
	
	//������
	public List<Notice> findNotice(Notice notice);
	public List<Notice> findAllNotice();
	public List<Notice> findNoticeByAdminId(int admin_id);
	//������
	public Notice selectNoticeById(int id);
	public Notice selectNoticeByTitle(String title);
	//���
	public void addNotice(Notice notice);
	//�޸�
	public void modifyNotice(Notice notice);
	//ɾ��
	public void deleteNoticeById(int id);
	public void deleteNoticeByTitle(String title);
	
	
	
	
	
	//******************************************Score����*****************************************
	
	//������
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
	//������
	public Score selectScoreById(int id);
	//���
	public void addScore(Score score);
	//�޸�
	public void modifyScore(Score score);
	//ɾ��
	public void deleteScoreById(int id);
	public void deleteScoreByStudentId(int student_id);
	
	//ĳ�γ���߷���Ϣ
	public List<Map<String,Object>> selectMaxScoreInfoByCourseId(int course_id);
	
	//ĳ�γ���ͷ���Ϣ
	public List<Map<String,Object>> selectMinScoreInfoByCourseId(int course_id);
	
	//ĳ�γ�ƽ����
	public Map<String,Object> selectAvgScoreByCourseId(int course_id);
	
	//ĳ�γ̴���ƽ��������
	public Map<String,Object> selectUpAvgScoreCountByCourseId(int course_id);
	
	//ĳ�γ�С��ƽ��������
	public Map<String,Object> selectDownAvgScoreCountByCourseId(int course_id);
	
	//ĳ�γ�ͨ������
	public Map<String,Object> selectPassCountByCourseId(int course_id);
	
	//ĳ�γ̹ҿ�����
	public Map<String,Object> selectFailCountByCourseId(int course_id);
	
	
	
	//**************************************Student����********************************************
	
	//������
	public List<Student> findStudent(Student student);
	public List<Student> findAllStudent();
	public List<Student> selectStudentByClazzId(int clazz_id);
	public List<Student> selectStudentByCourseId(int course_id);
	public List<Student> selectStudentByCollegeId(int college_id);
	public List<Student> selectStudentByMajorId(int major_id);
	//ѡ��ѡ��ĳ�γ�δ��ӳɼ���ѧ��
	public List<Student> selectStudentByCourseIdWithNoScore(int course_id);
	
	//ƽ����λ����ʼ�����ѧ��
	public List<Student> avgScoreBetweenAnd(int start,int end);
	
	
	//������
	public Student selectStudentById(int id);
	public Student selectStudentByNum(String num);
	//���
	public void addStudent(Student student);
	//�޸�
	public void modifyStudent(Student student);
	//ɾ��
	public void deleteStudentById(int id);
	public void deleteStudentByNum(String num);
	public void deleteByClazzId(int clazz_id);
	public void deleteByCourseId(int course_id);
	
	
	
	//*******************************************Teacher����**************************************
	
	//������
	public List<Teacher> findTeacher(Teacher teacher);
	public List<Teacher> findAllTeacher();
	public List<Teacher> selectTeacherByMajorId(int major_id);
	public List<Teacher> selectTeacherByCollegeId(int college_id);
	//������
	public Teacher selectTeacherById(int id);
	public Teacher selectTeacherByNum(String num);
	//���
	public void addTeacher(Teacher teacher);
	//�޸�
	public void modifyTeacher(Teacher teacher);
	//ɾ��
	public void deleteTeacherById(int id);
	public void deleteTeacherByNum(String num);
	
	
	
	//*********************************************Login����**************************************
	
	public Student studentlogin(String num,String password);
	public Teacher teacherlogin(String num,String password);
	public Admin adminlogin(String num,String password);
	
	
	
	//***********************************************�˺Ų���**************************************
	
	public void changepasswd(int student_id,String password);
	
	public String findpasswd(String num,String name,String tel);
}
