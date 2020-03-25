package cc.ileiwang.emsapp.domain;

import java.io.Serializable;
import java.util.List;

/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018年3月30日 下午4:26:19
*/
public class College implements Serializable{
	
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
	public List<Major> getMajors() {
		return majors;
	}
	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public College(int id, String num, String name, List<Major> majors) {
		super();
		this.id = id;
		this.num = num;
		this.name = name;
		this.majors = majors;
	}
	public College() {
		super();
	}
	int id;//id
	String num;//学院号
	String name;//名称
	List<Major> majors;//所有专业;
}
