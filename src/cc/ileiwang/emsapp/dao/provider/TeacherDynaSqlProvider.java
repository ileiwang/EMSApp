package cc.ileiwang.emsapp.dao.provider;

import static cc.ileiwang.emsapp.util.common.EMSAppConstants.TEACHERTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import cc.ileiwang.emsapp.domain.Teacher;

/**
 * @author Lei Wang
 * @email 3970111@gmail.com
 * @blog www.ileiwang.cc
 * @version 2018年4月1日 上午10:48:27
 */
public class TeacherDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(TEACHERTABLE);
				if (params.get("teacher") != null) {
					Teacher teacher = (Teacher) params.get("teacher");
					if (teacher.getName() != null && !teacher.getName().equals("")) {
						WHERE(" name LIKE CONCAT ('%',#{teacher.name},'%') ");
					}
					if (teacher.getNum() != null && !teacher.getNum().equals("")) {
						WHERE(" num LIKE CONCAT ('%',#{teacher.num},'%') ");
					}
					if (teacher.getBirthday() != null && !teacher.getBirthday().equals("")) {
						WHERE(" birthday LIKE CONCAT ('%',#{teacher.birthday},'%') ");
					}
					if (teacher.getIdcard() != null && !teacher.getIdcard().equals("")) {
						WHERE(" idcard LIKE CONCAT ('%',#{teacher.idcard},'%') ");
					}
					if (teacher.getSex() != null && !teacher.getSex().equals("")) {
						WHERE(" sex LIKE CONCAT ('%',#{teacher.sex},'%') ");
					}
					if (teacher.getMajor() != null && teacher.getMajor().getId()!=0) {
						WHERE(" major_id LIKE CONCAT ('%',#{teacher.major.id},'%') ");
					}
					
					if (teacher.getTel() != null && !teacher.getTel().equals("")) {
						WHERE(" tel LIKE CONCAT ('%',#{teacher.tel},'%') ");
					}
					if (teacher.getQq() != null && !teacher.getQq().equals("")) {
						WHERE(" qq LIKE CONCAT ('%',#{teacher.qq},'%') ");
					}
					if (teacher.getEmail() != null && !teacher.getEmail().equals("")) {
						WHERE(" email LIKE CONCAT ('%',#{teacher.email},'%') ");
					}
					if (teacher.getAddress() != null && !teacher.getAddress().equals("")) {
						WHERE(" address LIKE CONCAT ('%',#{teacher.address},'%') ");
					}
				}
			}
		}.toString();
		
		return sql;
	}

	// 动态查询总数量
	public String countTeacher(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM(TEACHERTABLE);
				if (params.get("teacher") != null) {
					Teacher teacher = (Teacher) params.get("teacher");
					if (teacher.getName() != null && !teacher.getName().equals("")) {
						WHERE(" name LIKE CONCAT ('%',#{teacher.name},'%') ");
					}
				}
			}
		}.toString();
	}

	// 动态插入
	public String insertTeacher(Teacher teacher) {

		return new SQL() {
			{
				INSERT_INTO(TEACHERTABLE);
				if (teacher.getNum() != null && !teacher.getNum().equals("")) {
					VALUES("num", "#{num}");
				}
				if (teacher.getName() != null && !teacher.getName().equals("")) {
					VALUES("name", "#{name}");
				}
				if (teacher.getBirthday() != null) {
					VALUES("birthday", "#{birthday}");
				}
				if (teacher.getIdcard() != null && !teacher.getIdcard().equals("")) {
					VALUES("idcard", "#{idcard}");
				}
				if (teacher.getSex() != null && !teacher.getSex().equals("")) {
					VALUES("sex", "#{sex}");
				}
				if (teacher.getPassword() != null && !teacher.getPassword().equals("")) {
					VALUES("password", "#{password}");
				}
				if (teacher.getTel() != null && !teacher.getTel().equals("")) {
					VALUES("tel", "#{tel}");
				}
				if (teacher.getQq() != null && !teacher.getQq().equals("")) {
					VALUES("qq", "#{qq}");
				}
				if (teacher.getEmail() != null && !teacher.getEmail().equals("")) {
					VALUES("email", "#{email}");
				}
				if (teacher.getAddress() != null && !teacher.getAddress().equals("")) {
					VALUES("address", "#{address}");
				}
				if (teacher.getMajor() != null && teacher.getMajor().getId() != 0) {
					VALUES("major_id", "#{major.id}");
				}
			}
		}.toString();
	}

	// 动态更新
	public String updateTeacher(Teacher teacher) {

		return new SQL() {
			{
				UPDATE(TEACHERTABLE);
				if (teacher.getNum() != null && !teacher.getNum().equals("")) {
					SET("num = #{num}");
				}
				if (teacher.getName() != null && !teacher.getName().equals("")) {
					SET("name = #{name}");
				}
				if (teacher.getBirthday() != null) {
					SET("birthday = #{birthday}");
				}
				if (teacher.getIdcard() != null && !teacher.getIdcard().equals("")) {
					SET("idcard = #{idcard}");
				}
				if (teacher.getSex() != null && !teacher.getSex().equals("")) {
					SET("sex = #{sex}");
				}
				if (teacher.getPassword() != null && !teacher.getPassword().equals("")) {
					SET("password = #{password}");
				}
				if (teacher.getTel() != null && !teacher.getTel().equals("")) {
					SET("tel = #{tel}");
				}
				if (teacher.getQq() != null && !teacher.getQq().equals("")) {
					SET("qq = #{qq}");
				}
				if (teacher.getEmail() != null && !teacher.getEmail().equals("")) {
					SET("email = #{email}");
				}
				if (teacher.getAddress() != null && !teacher.getAddress().equals("")) {
					SET("address = #{address}");
				}
				if (teacher.getMajor() != null && teacher.getMajor().getId() != 0) {
					SET("major_id = #{major.id}");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
}
