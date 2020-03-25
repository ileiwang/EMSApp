package cc.ileiwang.emsapp.domain;

import java.io.Serializable;
import java.util.Date;

/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018年3月30日 下午1:28:58
*/
public class Notice implements Serializable{
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Notice(int id, String title, String content, Date createdate, Admin admin) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createdate = createdate;
		this.admin = admin;
	}
	public Notice() {
		super();
	}
	private int id;//id
	private String title;//标题
	private String content;//内容
	private Date createdate;//时间
	private Admin admin;//发布者
}
