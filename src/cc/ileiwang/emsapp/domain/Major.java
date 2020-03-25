package cc.ileiwang.emsapp.domain;

import java.io.Serializable;
import java.util.List;

/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018��3��30�� ����4:20:17
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
	private String num;//רҵ��
	private String name;//רҵ����
	private int clazznum;//�༶��
	private College college;//����ѧԺ
	private List <Clazz> clazzs;//���а༶��רҵ�Ͱ༶��һ�Զ�Ĺ�ϵ
	private List <Course> courses;//�����γ̣�רҵ�Ϳγ���һ�Զ�Ĺ�ϵ
	private List <Teacher> teachers;//���н�ʦ��רҵ�ͽ�ʦ��һ�Զ�Ĺ�ϵ
}
