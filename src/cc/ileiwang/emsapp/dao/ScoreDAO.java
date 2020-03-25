package cc.ileiwang.emsapp.dao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.InsertProvider;
//import org.apache.ibatis.annotations.Update;
//import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.annotations.Delete;
//import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
//import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.One;
//import org.apache.ibatis.annotations.Many;

import cc.ileiwang.emsapp.domain.*;
import cc.ileiwang.emsapp.dao.provider.*;

import static cc.ileiwang.emsapp.util.common.EMSAppConstants.*;
/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018年10月11日 上午10:43:25
*/
public interface ScoreDAO {
	
	@SelectProvider(type=ScoreDynaSqlProvider.class,method="selectWhitParam")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "score", property = "score"),
		@Result(column = "course_id", property = "course", 
			one = @One(select = "cc.ileiwang.emsapp.dao.CourseDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "student_id", property = "student", 
			one = @One(select = "cc.ileiwang.emsapp.dao.StudentDAO.selectById", 
			fetchType = FetchType.EAGER))
	})
	List<Score> selectByParam(Map<String, Object> params);
	
	@SelectProvider(type=ScoreDynaSqlProvider.class,method="countScore")
	int count(Map<String, Object> params);

	@SelectProvider(type=ScoreDynaSqlProvider.class,method="insertScore")
	void save(Score score);
	
	@SelectProvider(type=ScoreDynaSqlProvider.class,method="updateScore")
	void update(Score score);
	
	@Select("select * from "+SCORETABLE)
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "score", property = "score"),
		@Result(column = "course_id", property = "course", 
			one = @One(select = "cc.ileiwang.emsapp.dao.CourseDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "student_id", property = "student", 
			one = @One(select = "cc.ileiwang.emsapp.dao.StudentDAO.selectById", 
			fetchType = FetchType.EAGER))
	})
	List<Score> selectAll();
	
	@Select("select * from "+SCORETABLE+" where id = #{id}")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "score", property = "score"),
		@Result(column = "course_id", property = "course", 
			one = @One(select = "cc.ileiwang.emsapp.dao.CourseDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "student_id", property = "student", 
			one = @One(select = "cc.ileiwang.emsapp.dao.StudentDAO.selectById", 
			fetchType = FetchType.EAGER))
	})
	Score selectById(int id);
	
	
	//学生成绩列表
	@Select("select * from "+SCORETABLE+" where student_id = #{student_id}")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "score", property = "score"),
		@Result(column = "course_id", property = "course", 
			one = @One(select = "cc.ileiwang.emsapp.dao.CourseDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "student_id", property = "student", 
			one = @One(select = "cc.ileiwang.emsapp.dao.StudentDAO.selectById", 
			fetchType = FetchType.EAGER))
	})
	List<Score> selectByStudentId(int student_id);
	
	//课程成绩列表
	@Select("select * from "+SCORETABLE+" where course_id = #{course_id}")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "score", property = "score"),
		@Result(column = "course_id", property = "course", 
			one = @One(select = "cc.ileiwang.emsapp.dao.CourseDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "student_id", property = "student", 
			one = @One(select = "cc.ileiwang.emsapp.dao.StudentDAO.selectById", 
			fetchType = FetchType.EAGER))
	})
	List<Score> selectByCourseId(int course_id);
	
	@Delete("delete from "+SCORETABLE+" where id = #{id} ")
	void deleteById(int id);
	
	@Delete("delete from "+SCORETABLE+" where student_id = #{student_id} ")
	void deleteByStudentId(int student_id);
	
	
	//某学生平均成绩
	@Select("select AVG(score) as avgscore from "+SCORETABLE+" where student_id=#{id}")
	Map<String,Object> selectAvgByStudentId(int id);
	
	//某学生已获学分
	@Select("select SUM(credit) as getcredit from "+COURSETABLE+" "
			+ "where course.id in(select score.course_id FROM score WHERE score.student_id = #{id} AND score.score >=60)")
	Map<String,Object> selectGetCreditByStudentId(int id);
	
	//某学生最高分
	@Select("select * from "+SCORETABLE+" where student_id = #{student_id} and score=(select MAX(score) from score where student_id=#{student_id})")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "score", property = "score"),
		@Result(column = "course_id", property = "course", 
			one = @One(select = "cc.ileiwang.emsapp.dao.CourseDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "student_id", property = "student", 
			one = @One(select = "cc.ileiwang.emsapp.dao.StudentDAO.selectById", 
			fetchType = FetchType.EAGER))
	})
	List<Score> selectMaxByStudentId(int student_id);
	
	//某学生最低分
	@Select("select * from "+SCORETABLE+" where student_id = #{student_id} "
			+ "and score=(select MIN(score) from score where student_id=#{student_id})")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "score", property = "score"),
		@Result(column = "course_id", property = "course", 
			one = @One(select = "cc.ileiwang.emsapp.dao.CourseDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "student_id", property = "student", 
			one = @One(select = "cc.ileiwang.emsapp.dao.StudentDAO.selectById", 
			fetchType = FetchType.EAGER))
	})
	List<Score> selectMinByStudentId(int student_id);
	
	
	//某学生通过的成绩
	@Select("select * from "+SCORETABLE+" where student_id = #{student_id} and score>=60")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "score", property = "score"),
		@Result(column = "course_id", property = "course", 
			one = @One(select = "cc.ileiwang.emsapp.dao.CourseDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "student_id", property = "student", 
			one = @One(select = "cc.ileiwang.emsapp.dao.StudentDAO.selectById", 
			fetchType = FetchType.EAGER))
	})
	List<Score> selectPassByStudentId(int student_id);
	
	
	//某学生挂科的成绩
	@Select("select * from "+SCORETABLE+" where student_id = #{student_id} and score<60")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "score", property = "score"),
		@Result(column = "course_id", property = "course", 
			one = @One(select = "cc.ileiwang.emsapp.dao.CourseDAO.selectById", 
			fetchType = FetchType.EAGER)),
		@Result(column = "student_id", property = "student", 
			one = @One(select = "cc.ileiwang.emsapp.dao.StudentDAO.selectById", 
			fetchType = FetchType.EAGER))
	})
	List<Score> selectFailByStudentId(int student_id);
	
	//某课程最高分信息
	@Select("select score.score as maxscore,student.num as studentnum,student.name as studentname,clazz.name as clazzname "
			+ "from score,student,clazz "
			+ "where score.course_id=#{course_id} and score.score = (select MAX(score) from score where course_id = #{course_id}) "
			+ "and student.id = score.student_id and clazz.id = student.clazz_id")
	List<Map<String,Object>> selectMaxScoreInfoByCourseId(int course_id);
	
	//某课程最高分信息（使用ALL谓词）
	@Select("select student.id,student.num,student.name,score.score as maxscore "
			+ "from score,student "
			+ "where score >= ALL ( select score from score where course_id=#{course_id}) "
			+ "and course_id = #{course_id} and student.id = student_id")
	List<Map<String,Object>> selectMaxScoreByCourseId(int course_id);
	
	
	//某课程最低分信息
	@Select("select score.score as minscore,student.num as studentnum,student.name as studentname,clazz.name as clazzname "
			+ "from score,student,clazz "
			+ "where score.course_id=#{course_id} and score.score = (select MIN(score) from score where course_id = #{course_id}) "
			+ "and student.id = score.student_id and clazz.id = student.clazz_id")
	List<Map<String,Object>> selectMinScoreInfoByCourseId(int course_id);
	
	//某课程最低分信息（使用ALL谓词）
	@Select("select student.id,student.num,student.name,score.score as maxscore "
			+ "from score,student "
			+ "where score <= ALL ( select score from score where course_id=#{course_id}) "
			+ "and course_id = #{course_id} and student.id = student_id")
	List<Map<String,Object>> selectMinScoreByCourseId(int course_id);
	
	//某课程平均分
	@Select("select AVG(score) as avgscore from "+SCORETABLE+" where course_id=#{course_id}")
	Map<String,Object> selectAvgScoreByCourseId(int course_id);
	
	//某课程大于平均分人数
	@Select("select count(*) as upavgscorecount from score where course_id = #{course_id} and score>=(select AVG(score) from score where course_id = #{course_id})")
	Map<String,Object> selectUpAvgScoreCountByCourseId(int course_id);
	
	//某课程小于平均分人数
	@Select("select count(*) as downavgscorecount from score where course_id = #{course_id} and score<(select AVG(score) from score where course_id = #{course_id})")
	Map<String,Object> selectDownAvgScoreCountByCourseId(int course_id);
	
	//某课程通过人数
	@Select("select count(*) as passcount from score where course_id = #{course_id} and score>=60")
	Map<String,Object> selectPassCountByCourseId(int course_id);
	
	//某课程挂科人数
	@Select("select count(*) as failcount from score where course_id = #{course_id} and score<60")
	Map<String,Object> selectFailCountByCourseId(int course_id);
}
