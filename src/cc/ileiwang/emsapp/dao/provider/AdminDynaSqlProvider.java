package cc.ileiwang.emsapp.dao.provider;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import cc.ileiwang.emsapp.domain.*;
import static cc.ileiwang.emsapp.util.common.EMSAppConstants.ADMINTABLE;

/**
 * @author Lei Wang
 * @email 3970111@gmail.com
 * @blog www.ileiwang.cc
 * @version 2018年4月1日 上午10:45:09
 */
public class AdminDynaSqlProvider {

	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(ADMINTABLE);
				if (params.get("admin") != null) {
					Admin admin = (Admin) params.get("admin");
					if (admin.getName() != null && !admin.getName().equals("")) {
						WHERE("name LIKE CONCAT ('%',#{admin.name},'%') ");
					}
				}
			}
		}.toString();
		return sql;
	}

	// 动态查询数量
	public String countAdmin(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM(ADMINTABLE);
				if (params.get("admin") != null) {
					Admin admin = (Admin) params.get("admin");
					if (admin.getName() != null && !admin.getName().equals("")) {
						WHERE("name LIKE CONCAT ('%',#{admin.name},'%') ");
					}
				}
			}
		}.toString();
	}

	// 动态插入
	public String insertAdmin(Admin admin) {

		return new SQL() {
			{
				INSERT_INTO(ADMINTABLE);
				if (admin.getNum() != null && !admin.getNum().equals("")) {
					VALUES("num", "#{num}");
				}
				if (admin.getName() != null && !admin.getName().equals("")) {
					VALUES("name", "#{name}");
				}
				if (admin.getBirthday() != null) {
					VALUES("birthday", "#{birthday}");
				}
				if (admin.getIdcard() != null && !admin.getIdcard().equals("")) {
					VALUES("idcard", "#{idcard}");
				}
				if (admin.getSex() != null && !admin.getSex().equals("")) {
					VALUES("sex", "#{sex}");
				}
				if (admin.getPassword() != null && !admin.getPassword().equals("")) {
					VALUES("password", "#{password}");
				}
				if (admin.getTel() != null && !admin.getTel().equals("")) {
					VALUES("tel", "#{tel}");
				}
				if (admin.getQq() != null && !admin.getQq().equals("")) {
					VALUES("qq", "#{qq}");
				}
				if (admin.getEmail() != null && !admin.getEmail().equals("")) {
					VALUES("email", "#{email}");
				}
				if (admin.getAddress() != null && !admin.getAddress().equals("")) {
					VALUES("address", "#{address}");
				}
			}
		}.toString();
	}

	// 动态更新
	public String updateAdmin(Admin admin) {
		return new SQL() {
			{
				UPDATE(ADMINTABLE);
				if (admin.getNum() != null && !admin.getNum().equals("")) {
					SET("num = #{num}");
				}
				if (admin.getName() != null && !admin.getName().equals("")) {
					SET("name = #{name}");
				}
				if (admin.getBirthday() != null) {
					SET("birthday = #{birthday}");
				}
				if (admin.getIdcard() != null && !admin.getIdcard().equals("")) {
					SET("idcard = #{idcard}");
				}
				if (admin.getSex() != null && !admin.getSex().equals("")) {
					SET("sex = #{sex}");
				}
				if (admin.getPassword() != null && !admin.getPassword().equals("")) {
					SET("password = #{password}");
				}
				if (admin.getTel() != null && !admin.getTel().equals("")) {
					SET("tel = #{tel}");
				}
				if (admin.getQq() != null && !admin.getQq().equals("")) {
					SET("qq = #{qq}");
				}
				if (admin.getEmail() != null && !admin.getEmail().equals("")) {
					SET("email = #{email}");
				}
				if (admin.getAddress() != null && !admin.getAddress().equals("")) {
					SET("address = #{address}");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
}
