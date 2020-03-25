package cc.ileiwang.emsapp.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
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
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Many;

import cc.ileiwang.emsapp.domain.*;
import cc.ileiwang.emsapp.dao.provider.*;
import static cc.ileiwang.emsapp.util.common.EMSAppConstants.STUDENTTABLE;
/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018��10��11�� ����10:40:19
*/
public interface StudentDAO {

	//ģ����ѯ
	@SelectProvider(type=StudentDynaSqlProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="num",property="num"),
		@Result(column="name",property="name"),
		@Result(column="birthday",property="birthday",javaType = java.util.Date.class),
		@Result(column="idcard",property="idcard"),
		@Result(column="sex",property="sex"),
		@Result(column="password",property="password"),
		@Result(column="tel",property="tel"),
		@Result(column="qq",property="qq"),
		@Result(column="email",property="email"),
		@Result(column="address",property="address"),
		
		@Result(column = "clazz_id", property = "clazz", 
		one=@One(
				select = "cc.ileiwang.emsapp.dao.ClazzDAO.selectById", 
				fetchType = FetchType.EAGER)),
		
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.CourseDAO.selectByStudentId",
				fetchType=FetchType.LAZY)),
		
		@Result(column="id",property="scores",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.ScoreDAO.selectByStudentId",
				fetchType=FetchType.LAZY))
	})
	List<Student> selectByParam(Map<String, Object> params);
	
	//ͳ��ѧ����
	@SelectProvider(type=StudentDynaSqlProvider.class,method="countStudent")
	int count(Map<String, Object> params);

	//���
	@SelectProvider(type=StudentDynaSqlProvider.class,method="insertStudent")
	void save(Student student);
	
	//����
	@SelectProvider(type=StudentDynaSqlProvider.class,method="updateStudent")
	void update(Student student);
	
	//ѡ��ȫ��ѧ��
	@Select("select * from "+STUDENTTABLE)
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="num",property="num"),
		@Result(column="name",property="name"),
		@Result(column="birthday",property="birthday",javaType = java.util.Date.class),
		@Result(column="idcard",property="idcard"),
		@Result(column="sex",property="sex"),
		@Result(column="password",property="password"),
		@Result(column="tel",property="tel"),
		@Result(column="qq",property="qq"),
		@Result(column="email",property="email"),
		@Result(column="address",property="address"),
		@Result(column = "clazz_id", property = "clazz", 
		one = @One(
				select = "cc.ileiwang.emsapp.dao.ClazzDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.CourseDAO.selectByStudentId",
				fetchType=FetchType.LAZY)),
		@Result(column="id",property="scores",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.ScoreDAO.selectByStudentId",
				fetchType=FetchType.LAZY))
	})
	List<Student> selectAllStudent();
	
	
	//��ѯѡ��ĳ�γ̻�δ��ӳɼ���ѧ��
	@Select("select * from "+STUDENTTABLE+" where id in (select student_id from stucou_item WHERE NOT EXISTS(select * from score where student_id = stucou_item.student_id and course_id=#{course_id}) and course_id=#{course_id})")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="num",property="num"),
		@Result(column="name",property="name"),
		@Result(column="birthday",property="birthday",javaType = java.util.Date.class),
		@Result(column="idcard",property="idcard"),
		@Result(column="sex",property="sex"),
		@Result(column="password",property="password"),
		@Result(column="tel",property="tel"),
		@Result(column="qq",property="qq"),
		@Result(column="email",property="email"),
		@Result(column="address",property="address"),
		@Result(column = "clazz_id", property = "clazz", 
		one = @One(
				select = "cc.ileiwang.emsapp.dao.ClazzDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.CourseDAO.selectByStudentId",
				fetchType=FetchType.LAZY)),
		@Result(column="id",property="scores",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.ScoreDAO.selectByStudentId",
				fetchType=FetchType.LAZY))
	})
	List<Student> selectByByCourseIdWithNoScore(int course_id);
	
	//����IDѡ��ѧ��
	@Select("select * from "+STUDENTTABLE+" where id = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="num",property="num"),
		@Result(column="name",property="name"),
		@Result(column="birthday",property="birthday",javaType = java.util.Date.class),
		@Result(column="idcard",property="idcard"),
		@Result(column="sex",property="sex"),
		@Result(column="password",property="password"),
		@Result(column="tel",property="tel"),
		@Result(column="qq",property="qq"),
		@Result(column="email",property="email"),
		@Result(column="address",property="address"),
		@Result(column = "clazz_id", property = "clazz", 
		one=@One(
				select = "cc.ileiwang.emsapp.dao.ClazzDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.CourseDAO.selectByStudentId",
				fetchType=FetchType.LAZY)),
		@Result(column="id",property="scores",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.ScoreDAO.selectByStudentId",
				fetchType=FetchType.LAZY))
	})
	Student selectById(int id);
	
	//����ѧ��ѡ��ѧ��
	@Select("select * from "+STUDENTTABLE+" where num = #{num}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="num",property="num"),
		@Result(column="name",property="name"),
		@Result(column="birthday",property="birthday",javaType = java.util.Date.class),
		@Result(column="idcard",property="idcard"),
		@Result(column="sex",property="sex"),
		@Result(column="password",property="password"),
		@Result(column="tel",property="tel"),
		@Result(column="qq",property="qq"),
		@Result(column="email",property="email"),
		@Result(column="address",property="address"),
		@Result(column = "clazz_id", property = "clazz", 
		one = @One(
				select = "cc.ileiwang.emsapp.dao.ClazzDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.CourseDAO.selectByStudentId",
				fetchType=FetchType.LAZY)),
		@Result(column="id",property="scores",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.ScoreDAO.selectByStudentId",
				fetchType=FetchType.LAZY))
	})
	Student selectByNum(@Param("num")String num);
	
	//����ѧ�������ѯ
	@Select("select * from "+STUDENTTABLE+" where num = #{num} and password = #{password}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="num",property="num"),
		@Result(column="name",property="name"),
		@Result(column="birthday",property="birthday",javaType = java.util.Date.class),
		@Result(column="idcard",property="idcard"),
		@Result(column="sex",property="sex"),
		@Result(column="password",property="password"),
		@Result(column="tel",property="tel"),
		@Result(column="qq",property="qq"),
		@Result(column="email",property="email"),
		@Result(column="address",property="address"),
		@Result(column = "clazz_id", property = "clazz", 
		one = @One(
				select = "cc.ileiwang.emsapp.dao.ClazzDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.CourseDAO.selectByStudentId",
				fetchType=FetchType.LAZY)),
		@Result(column="id",property="scores",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.ScoreDAO.selectByStudentId",
				fetchType=FetchType.LAZY))
	})
	Student selectByNumAndPassword(@Param("num")String num,@Param("password")String password);
	
	// ���ݰ༶��ѯ����ѧ��
	@Select("select * from student where clazz_id = #{clazz_id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="num",property="num"),
		@Result(column="name",property="name"),
		@Result(column="birthday",property="birthday",javaType = java.util.Date.class),
		@Result(column="idcard",property="idcard"),
		@Result(column="sex",property="sex"),
		@Result(column="password",property="password"),
		@Result(column="tel",property="tel"),
		@Result(column="qq",property="qq"),
		@Result(column="email",property="email"),
		@Result(column="address",property="address"),
		@Result(column = "clazz_id", property = "clazz", 
		one = @One(
				select = "cc.ileiwang.emsapp.dao.ClazzDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.CourseDAO.selectByStudentId",
				fetchType=FetchType.LAZY)),
		@Result(column="id",property="scores",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.ScoreDAO.selectByStudentId",
				fetchType=FetchType.LAZY))
	})
	List<Student> selectByClazzId(int clazz_id);
	
	// ����ѧԺ��ѯ����ѧ��
	@Select("SELECT student.* "
			+ "FROM student,clazz,major,college "
			+ "WHERE student.clazz_id = clazz.id  AND clazz.major_id = major.id "
			+ "AND major.college_id = college.id  AND college.id=#{college_id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="num",property="num"),
		@Result(column="name",property="name"),
		@Result(column="birthday",property="birthday",javaType = java.util.Date.class),
		@Result(column="idcard",property="idcard"),
		@Result(column="sex",property="sex"),
		@Result(column="password",property="password"),
		@Result(column="tel",property="tel"),
		@Result(column="qq",property="qq"),
		@Result(column="email",property="email"),
		@Result(column="address",property="address"),
		@Result(column = "clazz_id", property = "clazz", 
		one = @One(
				select = "cc.ileiwang.emsapp.dao.ClazzDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.CourseDAO.selectByStudentId",
				fetchType=FetchType.LAZY)),
		@Result(column="id",property="scores",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.ScoreDAO.selectByStudentId",
				fetchType=FetchType.LAZY))
	})
	List<Student> selectByCollegeId(int college_id);
	
	// ����רҵ��ѯ����ѧ��
	@Select("SELECT student.* FROM student,clazz,major WHERE student.clazz_id = clazz.id "
			+ "AND clazz.major_id = major.id AND major.id = #{major_id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="num",property="num"),
		@Result(column="name",property="name"),
		@Result(column="birthday",property="birthday",javaType = java.util.Date.class),
		@Result(column="idcard",property="idcard"),
		@Result(column="sex",property="sex"),
		@Result(column="password",property="password"),
		@Result(column="tel",property="tel"),
		@Result(column="qq",property="qq"),
		@Result(column="email",property="email"),
		@Result(column="address",property="address"),
		@Result(column = "clazz_id", property = "clazz", 
		one = @One(
				select = "cc.ileiwang.emsapp.dao.ClazzDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.CourseDAO.selectByStudentId",
				fetchType=FetchType.LAZY)),
		@Result(column="id",property="scores",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.ScoreDAO.selectByStudentId",
				fetchType=FetchType.LAZY))
	})
	List<Student> selectByMajorId(int major_id);
	
	
	// ����ѧ��-�γ̱��ѯ����ѧ��
	@Select("select * from student where id in "
			+ "(SELECT student_id FROM stucou_item where course_id = #{course_id})")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="num",property="num"),
		@Result(column="name",property="name"),
		@Result(column="birthday",property="birthday",javaType = java.util.Date.class),
		@Result(column="idcard",property="idcard"),
		@Result(column="sex",property="sex"),
		@Result(column="password",property="password"),
		@Result(column="tel",property="tel"),
		@Result(column="qq",property="qq"),
		@Result(column="email",property="email"),
		@Result(column="address",property="address"),
		@Result(column = "clazz_id", property = "clazz", 
		one = @One(
				select = "cc.ileiwang.emsapp.dao.ClazzDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.CourseDAO.selectByStudentId",
				fetchType=FetchType.LAZY)),
		@Result(column="id",property="scores",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.ScoreDAO.selectByStudentId",
				fetchType=FetchType.LAZY))
	})
	List<Student> selectByCourseId(int course_id);
	
	
	//��ѯƽ���ɼ�����ʼ�����ѧ��
	@Select("select student.* from score,student where student.id = student_id "
			+ "group by student_id having avg(score) between ${start} and ${end}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="num",property="num"),
		@Result(column="name",property="name"),
		@Result(column="birthday",property="birthday",javaType = java.util.Date.class),
		@Result(column="idcard",property="idcard"),
		@Result(column="sex",property="sex"),
		@Result(column="password",property="password"),
		@Result(column="tel",property="tel"),
		@Result(column="qq",property="qq"),
		@Result(column="email",property="email"),
		@Result(column="address",property="address"),
		
		@Result(column = "clazz_id", property = "clazz", 
		one=@One(
				select = "cc.ileiwang.emsapp.dao.ClazzDAO.selectById", 
				fetchType = FetchType.EAGER)),
		
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.CourseDAO.selectByStudentId",
				fetchType=FetchType.LAZY)),
		
		@Result(column="id",property="scores",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.ScoreDAO.selectByStudentId",
				fetchType=FetchType.LAZY))
	})
	List<Student> avgScoreBetweenAnd(@Param("start")int start,@Param("end")int end);
	
	
	//����IDɾ��ѧ��
	@Delete("delete from "+STUDENTTABLE+" where id = #{id} ")
	void deleteById(int id);
	
	//����ѧ��ɾ��ѧ��
	@Delete("delete from "+STUDENTTABLE+" where num = #{num} ")
	void deleteByNum(String num);
	
	//���ݰ༶ɾ������ѧ��
	@Delete("delete from "+STUDENTTABLE+" where clazz_id = #{clazz_id} ")
	void deleteByClazzId(int clazz_id);
	
	
	//���ݿγ̺�ɾ������ѧ������ѧ��-�γ̱����ȡ����ѧ��ID��
	@Delete("delete from "+STUDENTTABLE+" where id in (select student_id from stucou_item where course_id = #{course_id})")
	void deleteByCourseId(int course_id);
	
	
	//�޸�����
	@Update("update " + STUDENTTABLE + " set password = '${password}' where id = ${student_id}")
	void changepasswd(@Param("student_id")int student_id, @Param("password")String password);
	//�һ�����
	@Select("select password from " + STUDENTTABLE + " where num = '${num}' and name = '${name}' and tel = '${tel}'")
	String findpasswd(@Param("num") String num, @Param("name") String name,@Param("tel")String tel);
		
}
