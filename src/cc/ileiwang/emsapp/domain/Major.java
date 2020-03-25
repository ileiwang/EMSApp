package cc.ileiwang.emsapp.domain;

import java.io.Serializable;
import java.util.List;

/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018年3月30日 下午4:20:17
*/
public class Major implements Serializable{
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getClazznum() {
		return clazznum;
	}
	public void setClazznum(int clazznum) {
		this.clazznum = clazznum;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public List<Clazz> getClazzs() {
		return clazzs;
	}
	public void setClazzs(List<Clazz> clazzs) {
		this.clazzs = clazzs;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Major(int id, String num, String name, int clazznum, College college, List<Clazz> clazzs, List<Course> courses,
			List<Teacher> teachers) {
		super();
		this.id = id;
		this.num = num;
		this.name = name;
		this.clazznum = clazznum;
		this.college = college;
		this.clazzs = clazzs;
		this.courses = courses;
		this.teachers = teachers;
	}
	public Major() {
		super();
	}
	private int id;//id
	private String num;//专业号
	private String name;//专业名称
	private int clazznum;//班级数
	private College college;//所属学院
	private List <Clazz> clazzs;//所有班级：专业和班级是一对多的关系
	private List <Course> courses;//所开课程：专业和课程是一对多的关系
	private List <Teacher> teachers;//所有教师：专业和教师是一对多的关系
}
