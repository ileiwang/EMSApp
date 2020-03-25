package cc.ileiwang.emsapp.dao.provider;

import static cc.ileiwang.emsapp.util.common.EMSAppConstants.SCORETABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import cc.ileiwang.emsapp.domain.Score;

/**
 * @author Lei Wang
 * @email 3970111@gmail.com
 * @blog www.ileiwang.cc
 * @version 2018年4月1日 上午10:47:50
 */
public class ScoreDynaSqlProvider {

	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(SCORETABLE);
				if (params.get("score") != null) {
					Score score = (Score) params.get("score");
					if (score.getStudent() != null && score.getStudent().getId() != 0) {
						WHERE("student_id LIKE CONCAT ('%',#{score.student.id},'%') ");
					}
					if (score.getCourse() != null && score.getCourse().getId() != 0) {
						WHERE("course_id LIKE CONCAT ('%',#{score.course.id},'%') ");
					}
					if (score.getScore()!=-1) {
						WHERE("score LIKE CONCAT ('%',#{score.score},'%') ");
					}
				}
			}
		}.toString();

		return sql;
	}

	// 动态查询总数量
	public String countScore(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM(SCORETABLE);
				if (params.get("score") != null) {
					Score score = (Score) params.get("score");
					if (score.getStudent() != null && score.getStudent().getId() != 0) {
						WHERE("student_id LIKE CONCAT ('%',#{score.student.id},'%') ");
					}
				}
			}
		}.toString();
	}

	// 动态插入
	public String insertScore(Score score) {

		return new SQL() {
			{
				INSERT_INTO(SCORETABLE);
				if (score.getScore() != 0) {
					VALUES("score", "#{score}");
				}
				if (score.getCourse() != null && score.getCourse().getId() != 0) {
					VALUES("course_id", "#{course.id}");
				}
				if (score.getStudent() != null && score.getStudent().getId() != 0) {
					VALUES("student_id", "#{student.id}");
				}
			}
		}.toString();
	}

	// 动态更新
	public String updateScore(Score score) {

		return new SQL() {
			{
				UPDATE(SCORETABLE);
				if (score.getScore() != 0) {
					SET("score = #{score}");
				}
				if (score.getCourse() != null && score.getCourse().getId() != 0) {
					SET("course_id = #{course.id}");
				}
				if (score.getStudent() != null && score.getStudent().getId() != 0) {
					SET("student_id = #{student.id}");
				}
				WHERE("id = #{id} ");
			}
		}.toString();
	}
}
