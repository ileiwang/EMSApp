package cc.ileiwang.emsapp.dao.provider;

import static cc.ileiwang.emsapp.util.common.EMSAppConstants.MAJORTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import cc.ileiwang.emsapp.domain.Major;

/**
 * @author Lei Wang
 * @email 3970111@gmail.com
 * @blog www.ileiwang.cc
 * @version 2018年4月1日 上午10:47:08
 */
public class MajorDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(MAJORTABLE);
				if (params.get("major") != null) {
					Major major = (Major) params.get("major");
					if (major.getName() != null && !major.getName().equals("")) {
						WHERE("name LIKE CONCAT ('%',#{major.name},'%') ");
					}
					if (major.getNum() != null && !major.getNum().equals("")) {
						WHERE("num LIKE CONCAT ('%',#{major.num},'%') ");
					}
					if (major.getClazznum() !=0) {
						WHERE("clazznum LIKE CONCAT ('%',#{major.clazznum},'%') ");
					}
					if (major.getCollege() != null && major.getCollege().getId()!=0) {
						WHERE("college_id LIKE CONCAT ('%',#{major.college.id},'%') ");
					}
				}
			}
		}.toString();

		return sql;
	}

	// 动态查询总数量
	public String countMajor(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM(MAJORTABLE);
				if (params.get("major") != null) {
					Major major = (Major) params.get("major");
					if (major.getName() != null && !major.getName().equals("")) {
						WHERE("name LIKE CONCAT ('%',#{major.name},'%') ");
					}
				}
			}
		}.toString();
	}

	// 动态插入
	public String insertMajor(Major major) {

		return new SQL() {
			{
				INSERT_INTO(MAJORTABLE);
				if (major.getNum() != null && !major.getNum().equals("")) {
					VALUES("num", "#{num}");
				}
				if (major.getName() != null && !major.getName().equals("")) {
					VALUES("name", "#{name}");
				}
				if (major.getClazznum() != 0) {
					VALUES("clazznum", "#{clazznum}");
				}
				if (major.getCollege() != null && major.getCollege().getId() != 0) {
					VALUES("college_id", "#{college.id}");
				}
			}
		}.toString();
	}

	// 动态更新
	public String updateMajor(Major major) {

		return new SQL() {
			{
				UPDATE(MAJORTABLE);
				if (major.getNum() != null && !major.getNum().equals("")) {
					SET("num = #{num}");
				}
				if (major.getName() != null && !major.getName().equals("")) {
					SET("name = #{name}");
				}
				if (major.getClazznum() != 0) {
					SET("clazznum = #{clazznum}");
				}
				if (major.getCollege() != null && major.getCollege().getId() != 0) {
					SET("college_id = #{college.id}");
				}
				WHERE("id = #{id} ");
			}
		}.toString();
	}
}
