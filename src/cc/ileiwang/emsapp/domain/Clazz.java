package cc.ileiwang.emsapp.domain;

import java.io.Serializable;
import java.util.List;

/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018��3��30�� ����4:22:12
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
	private String num;//�༶��
	private int stunum;//ѧ����
	private String name;//����
	private Major major;//����רҵ���༶��רҵ��һ��һ�Ĺ�ϵ
	private List<Student> students;//����ѧ�����༶��ѧ����һ�Զ�Ĺ�ϵ
}
