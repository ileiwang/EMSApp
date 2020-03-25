package cc.ileiwang.emsapp.dao.provider;

import static cc.ileiwang.emsapp.util.common.EMSAppConstants.COLLEGETABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import cc.ileiwang.emsapp.domain.College;

/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018��4��1�� ����10:46:09
*/
public class CollegeDynaSqlProvider {
	// ��ҳ��̬��ѯ
	public String selectWhitParam(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(COLLEGETABLE);
				if (params.get("college") != null) {
					College college = (College) params.get("college");
					if (college.getName() != null && !college.getName().equals("")) {
						WHERE("name LIKE CONCAT ('%',#{college.name},'%') ");
					}
					if (college.getNum() != null && !college.getNum().equals("")) {
						WHERE("num LIKE CONCAT ('%',#{college.num},'%') ");
					}
				}
			}
		}.toString();

		return sql;
	}

	// ��̬��ѯ������
	public String countCollege(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM(COLLEGETABLE);
				if (params.get("college") != null) {
					College college = (College) params.get("college");
					if (college.getName() != null && !college.getName().equals("")) {
						WHERE("name LIKE CONCAT ('%',#{college.name},'%') ");
					}
				}
			}
		}.toString();
	}

	// ��̬����
	public String insertCollege(College college) {

		return new SQL() {
			{
				INSERT_INTO(COLLEGETABLE);
				if (college.getNum() != null && !college.getNum().equals("")) {
					VALUES("num", "#{num}");
				}
				if (college.getName() != null && !college.getName().equals("")) {
					VALUES("name", "#{name}");
				}
			}
		}.toString();
	}

	// ��̬����
	public String updateCollege(College college) {

		return new SQL() {
			{
				UPDATE(COLLEGETABLE);
				if (college.getNum() != null && !college.getNum().equals("")) {
					SET("num = #{num}");
				}
				if (college.getName() != null && !college.getName().equals("")) {
					SET("name = #{name}");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
}
