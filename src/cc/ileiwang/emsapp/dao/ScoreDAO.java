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
* @version 2018��10��11�� ����10:43:25
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
	
	
	//ѧ���ɼ��б�
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
	
	//�γ̳ɼ��б�
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
	
	
	//ĳѧ��ƽ���ɼ�
	@Select("select AVG(score) as avgscore from "+SCORETABLE+" where student_id=#{id}")
	Map<String,Object> selectAvgByStudentId(int id);
	
	//ĳѧ���ѻ�ѧ��
	@Select("select SUM(credit) as getcredit from "+COURSETABLE+" "
			+ "where course.id in(select score.course_id FROM score WHERE score.student_id = #{id} AND score.score >=60)")
	Map<String,Object> selectGetCreditByStudentId(int id);
	
	//ĳѧ����߷�
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
	
	//ĳѧ����ͷ�
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
	
	
	//ĳѧ��ͨ���ĳɼ�
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
	
	
	//ĳѧ���ҿƵĳɼ�
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
	
	//ĳ�γ���߷���Ϣ
	@Select("select score.score as maxscore,student.num as studentnum,student.name as studentname,clazz.name as clazzname "
			+ "from score,student,clazz "
			+ "where score.course_id=#{course_id} and score.score = (select MAX(score) from score where course_id = #{course_id}) "
			+ "and student.id = score.student_id and clazz.id = student.clazz_id")
	List<Map<String,Object>> selectMaxScoreInfoByCourseId(int course_id);
	
	//ĳ�γ���߷���Ϣ��ʹ��ALLν�ʣ�
	@Select("select student.id,student.num,student.name,score.score as maxscore "
			+ "from score,student "
			+ "where score >= ALL ( select score from score where course_id=#{course_id}) "
			+ "and course_id = #{course_id} and student.id = student_id")
	List<Map<String,Object>> selectMaxScoreByCourseId(int course_id);
	
	
	//ĳ�γ���ͷ���Ϣ
	@Select("select score.score as minscore,student.num as studentnum,student.name as studentname,clazz.name as clazzname "
			+ "from score,student,clazz "
			+ "where score.course_id=#{course_id} and score.score = (select MIN(score) from score where course_id = #{course_id}) "
			+ "and student.id = score.student_id and clazz.id = student.clazz_id")
	List<Map<String,Object>> selectMinScoreInfoByCourseId(int course_id);
	
	//ĳ�γ���ͷ���Ϣ��ʹ��ALLν�ʣ�
	@Select("select student.id,student.num,student.name,score.score as maxscore "
			+ "from score,student "
			+ "where score <= ALL ( select score from score where course_id=#{course_id}) "
			+ "and course_id = #{course_id} and student.id = student_id")
	List<Map<String,Object>> selectMinScoreByCourseId(int course_id);
	
	//ĳ�γ�ƽ����
	@Select("select AVG(score) as avgscore from "+SCORETABLE+" where course_id=#{course_id}")
	Map<String,Object> selectAvgScoreByCourseId(int course_id);
	
	//ĳ�γ̴���ƽ��������
	@Select("select count(*) as upavgscorecount from score where course_id = #{course_id} and score>=(select AVG(score) from score where course_id = #{course_id})")
	Map<String,Object> selectUpAvgScoreCountByCourseId(int course_id);
	
	//ĳ�γ�С��ƽ��������
	@Select("select count(*) as downavgscorecount from score where course_id = #{course_id} and score<(select AVG(score) from score where course_id = #{course_id})")
	Map<String,Object> selectDownAvgScoreCountByCourseId(int course_id);
	
	//ĳ�γ�ͨ������
	@Select("select count(*) as passcount from score where course_id = #{course_id} and score>=60")
	Map<String,Object> selectPassCountByCourseId(int course_id);
	
	//ĳ�γ̹ҿ�����
	@Select("select count(*) as failcount from score where course_id = #{course_id} and score<60")
	Map<String,Object> selectFailCountByCourseId(int course_id);
}
