package cc.ileiwang.emsapp.domain;

import java.io.Serializable;
import java.util.List;

/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018年3月30日 下午4:22:12
*/
public class Clazz implements Serializable {
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
	public int getStunum() {
		return stunum;
	}
	public void setStunum(int stunum) {
		this.stunum = stunum;
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
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Clazz(int id, String num, int stunum, String name, Major major, List<Student> students) {
		super();
		this.id = id;
		this.num = num;
		this.stunum = stunum;
		this.name = name;
		this.major = major;
		this.students = students;
	}
	public Clazz() {
		super();
	}
	private int id;//id
	private String num;//班级号
	private int stunum;//学生数
	private String name;//名称
	private Major major;//所属专业：班级和专业是一对一的关系
	private List<Student> students;//所有学生：班级和学生是一对多的关系
}
