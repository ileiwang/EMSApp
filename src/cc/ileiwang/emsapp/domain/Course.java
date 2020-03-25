package cc.ileiwang.emsapp.domain;

import java.io.Serializable;
import java.util.List;

/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018年3月30日 下午4:40:54
*/
public class Course implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getCoursetime() {
		return coursetime;
	}
	public void setCoursetime(int coursetime) {
		this.coursetime = coursetime;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Course(int id, String num, int day, int coursetime, int start, int last, int credit, String place, String name,
			Major major, Teacher teacher, List<Student> students) {
		super();
		this.id = id;
		this.num = num;
		this.day = day;
		this.coursetime = coursetime;
		this.start = start;
		this.last = last;
		this.credit = credit;
		this.place = place;
		this.name = name;
		this.major = major;
		this.teacher = teacher;
		this.students = students;
	}

	public Course() {
		super();
	}

	private int id;//id
	private String num;//课程号
	private int day;//周次
	private int coursetime;//节次
	private int start;//开课周次
	private int last;//持续周次
	private int credit;//学分
	private String place;//授课地点
	private String name;//课程名称
	private Major major;//所属专业：课程与专业是一对一的关系
	private Teacher teacher;//授课教师：课程和教师是一对一的关系
	private List <Student> students;//选课学生：课程和学生是一对多的关系
}
