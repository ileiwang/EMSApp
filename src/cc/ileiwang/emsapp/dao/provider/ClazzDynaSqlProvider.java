package cc.ileiwang.emsapp.dao.provider;

import static cc.ileiwang.emsapp.util.common.EMSAppConstants.CLAZZTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import cc.ileiwang.emsapp.domain.Clazz;

/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018年4月1日 上午10:45:51
*/
public class ClazzDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(CLAZZTABLE);
				if (params.get("clazz") != null) {
					Clazz clazz = (Clazz) params.get("clazz");
					if (clazz.getName() != null && !clazz.getName().equals("")) {
						WHERE("name LIKE CONCAT ('%',#{clazz.name},'%') ");
					}
					if (clazz.getNum() != null && !clazz.getNum().equals("")) {
						WHERE("num LIKE CONCAT ('%',#{clazz.num},'%') ");
					}
					if (clazz.getStunum() != 0) {
						WHERE("stunum LIKE CONCAT ('%',#{clazz.stunum},'%') ");
					}
					if (clazz.getMajor() != null && clazz.getMajor().getId()!=0) {
						WHERE("major_id LIKE CONCAT ('%',#{clazz.major.id},'%') ");
					}
				}
			}
		}.toString();

		return sql;
	}

	// 动态查询总数量
	public String countClazz(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM(CLAZZTABLE);
				if (params.get("clazz") != null) {
					Clazz clazz = (Clazz) params.get("clazz");
					if (clazz.getName() != null && !clazz.getName().equals("")) {
						WHERE("name LIKE CONCAT ('%',#{clazz.name},'%') ");
					}
					if (clazz.getNum() != null && !clazz.getNum().equals("")) {
						WHERE("num LIKE CONCAT ('%',#{clazz.num},'%') ");
					}
					if (clazz.getStunum() != 0) {
						WHERE("stunum LIKE CONCAT ('%',#{clazz.stunum},'%') ");
					}
					if (clazz.getMajor() != null && clazz.getMajor().getId()!=0) {
						WHERE("major_id LIKE CONCAT ('%',#{clazz.major.id},'%') ");
					}
					
				}
			}
		}.toString();
	}

	// 动态插入
	public String insertClazz(Clazz clazz) {

		return new SQL() {
			{
				INSERT_INTO(CLAZZTABLE);
				if (clazz.getNum() != null && !clazz.getNum().equals("")) {
					VALUES("num","#{num}");
				}
				if (clazz.getStunum() != 0) {
					VALUES("stunum","#{stunum}");
				}
				if (clazz.getName() != null&& !clazz.getName().equals("")) {
					VALUES("name","#{name}");
				}
				if (clazz.getMajor() != null && clazz.getMajor().getId()!=0) {
					VALUES("major_id","#{major.id}");
				}
			}
		}.toString();
	}

	// 动态更新
	public String updateClazz(Clazz clazz) {

		return new SQL() {
			{
				UPDATE(CLAZZTABLE);
				if (clazz.getNum() != null && !clazz.getNum().equals("")) {
					SET("num = #{num}");
				}
				if (clazz.getStunum() != 0) {
					SET("stunum = #{stunum}");
				}
				if (clazz.getName() != null&& !clazz.getName().equals("")) {
					SET("name = #{name}");
				}
				if (clazz.getMajor() != null && clazz.getMajor().getId()!=0) {
					SET("major_id = #{major.id}");
				}
				WHERE("id = #{id} ");
			}
		}.toString();
	}
}
