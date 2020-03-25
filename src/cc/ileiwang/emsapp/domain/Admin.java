package cc.ileiwang.emsapp.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;


/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018年3月30日 下午1:28:37
*/
public class Admin implements Serializable{
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Notice> getNotices() {
		return notices;
	}
	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Admin(int id, String num, String name, Date birthday, String idcard, String sex, String password, String tel,
			String qq, String email, String address, List<Notice> notices) {
		super();
		this.id = id;
		this.num = num;
		this.name = name;
		this.birthday = birthday;
		this.idcard = idcard;
		this.sex = sex;
		this.password = password;
		this.tel = tel;
		this.qq = qq;
		this.email = email;
		this.address = address;
		this.notices = notices;
	}
	public Admin() {
		super();
	}
	private int id;//id
	private String num;//管理员号
	private String name;//姓名
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;//生日
	private String idcard;//身份证
	private String sex;//性别
	private String password;//密码
	private String tel;//电话
	private String qq;//QQ
	private String email;//邮箱
	private String address;//联系方式
	private List<Notice> notices;//通告
}
