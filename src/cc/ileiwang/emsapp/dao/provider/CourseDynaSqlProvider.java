package cc.ileiwang.emsapp.dao.provider;

import static cc.ileiwang.emsapp.util.common.EMSAppConstants.COURSETABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import cc.ileiwang.emsapp.domain.Course;

/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018年4月1日 上午10:46:26
*/
public class CourseDynaSqlProvider {
	
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(COURSETABLE);
				if (params.get("course") != null) {
					Course course = (Course) params.get("course");
					if (course.getName() != null && !course.getName().equals("")) {
						WHERE("name LIKE CONCAT ('%',#{course.name},'%') ");
					}
					if (course.getNum() != null && !course.getNum().equals("")) {
						WHERE("num LIKE CONCAT ('%',#{course.num},'%') ");
					}
					if (course.getDay() != 0) {
						WHERE("day LIKE CONCAT ('%',#{course.day},'%') ");
					}
					if (course.getCoursetime() != 0) {
						WHERE("coursetime LIKE CONCAT ('%',#{course.coursetime},'%') ");
					}
					if (course.getStart() != 0) {
						WHERE("start LIKE CONCAT ('%',#{course.start},'%') ");
					}
					
					if (course.getLast()!=0) {
						WHERE("last LIKE CONCAT ('%',#{course.last},'%') ");
					}
					if (course.getCredit()!=0) {
						WHERE("credit LIKE CONCAT ('%',#{course.credit},'%') ");
					}
					if (course.getPlace() != null && !course.getPlace().equals("")) {
						WHERE("place LIKE CONCAT ('%',#{course.place},'%') ");
					}
					if (course.getMajor() != null && course.getMajor().getId()!=0) {
						WHERE("major_id LIKE CONCAT ('%',#{course.major.id},'%') ");
					}
					if (course.getTeacher() != null && course.getTeacher().getId()!=0) {
						WHERE("teacher_id LIKE CONCAT ('%',#{course.teacher.id},'%') ");
					}
					
				}
			}
		}.toString();

		return sql;
	}

	// 动态查询总数量
	public String countCourse(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM(COURSETABLE);
				if (params.get("course") != null) {
					Course course = (Course) params.get("course");
					if (course.getName() != null && !course.getName().equals("")) {
						WHERE("name LIKE CONCAT ('%',#{course.name},'%') ");
					}
				}
			}
		}.toString();
	}

	// 动态插入
	public String insertCourse(Course course) {

		return new SQL() {
			{
				INSERT_INTO(COURSETABLE);
				if (course.getNum() != null && !course.getNum().equals("")) {
					VALUES("num", "#{num}");
				}
				if (course.getDay() != 0) {
					VALUES("day", "#{day}");
				}
				if (course.getCoursetime()!=0) {
					VALUES("coursetime", "#{coursetime}");
				}
				if (course.getStart()!=0) {
					VALUES("start", "#{start}");
				}
				if (course.getLast() != 0) {
					VALUES("last", "#{last}");
				}
				if (course.getCredit() != 0) {
					VALUES("credit", "#{credit}");
				}
				if (course.getPlace() != null && !course.getPlace().equals("")) {
					VALUES("place", "#{place}");
				}
				if (course.getName() != null && !course.getName().equals("")) {
					VALUES("name", "#{name}");
				}
				if (course.getMajor() != null && course.getMajor().getId()!=0) {
					VALUES("major_id", "#{major.id}");
				}
				if (course.getTeacher() != null && course.getTeacher().getId()!=0) {
					VALUES("teacher_id", "#{teacher.id}");
				}
			}
		}.toString();
	}

	// 动态更新
	public String updateCourse(Course course) {

		return new SQL() {
			{
				UPDATE(COURSETABLE);
				if (course.getNum() != null && !course.getNum().equals("")) {
					SET("num = #{num}");
				}
				if (course.getDay() != 0) {
					SET("day = #{day}");
				}
				if (course.getCoursetime()!=0) {
					SET("coursetime = #{coursetime}");
				}
				if (course.getStart()!=0) {
					SET("start = #{start}");
				}
				if (course.getLast() != 0) {
					SET("last = #{last}");
				}
				if (course.getCredit() != 0) {
					SET("credit = #{credit}");
				}
				if (course.getPlace() != null && !course.getPlace().equals("")) {
					SET("place = #{place}");
				}
				if (course.getName() != null && !course.getName().equals("")) {
					SET("name = #{name}");
				}
				if (course.getMajor() != null && course.getMajor().getId()!=0) {
					SET("major_id = #{major.id}");
				}
				if (course.getTeacher() != null && course.getTeacher().getId()!=0) {
					SET("teacher_id = #{teacher.id}");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}
}
