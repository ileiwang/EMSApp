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
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Many;

import cc.ileiwang.emsapp.domain.*;
import cc.ileiwang.emsapp.dao.provider.*;

import static cc.ileiwang.emsapp.util.common.EMSAppConstants.TEACHERTABLE;
/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018年10月11日 上午10:43:44
*/
public interface TeacherDAO {
	
	@SelectProvider(type=TeacherDynaSqlProvider.class,method="selectWhitParam")
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
		@Result(column = "major_id", property = "major", 
		one=@One(
				select="cc.ileiwang.emsapp.dao.MajorDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.CourseDAO.selectByTeacherId",
				fetchType=FetchType.LAZY))
	})
	List<Teacher> selectByParam(Map<String, Object> params);
	
	@SelectProvider(type=TeacherDynaSqlProvider.class,method="countTeacher")
	int count(Map<String, Object> params);

	@SelectProvider(type=TeacherDynaSqlProvider.class,method="insertTeacher")
	void save(Teacher teacher);
	
	@SelectProvider(type=TeacherDynaSqlProvider.class,method="updateTeacher")
	void update(Teacher teacher);
	
	@Select("select * from "+TEACHERTABLE)
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
		@Result(column = "major_id", property = "major", 
		one = @One(
				select = "cc.ileiwang.emsapp.dao.MajorDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.CourseDAO.selectByTeacherId",
				fetchType=FetchType.LAZY))
	})
	List<Teacher> selectAll();
	
	
	@Select("select * from "+TEACHERTABLE+" where major_id = #{major_id}")
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
		@Result(column = "major_id", property = "major", 
		one=@One(
				select = "cc.ileiwang.emsapp.dao.MajorDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.CourseDAO.selectByTeacherId",
				fetchType=FetchType.LAZY))
	})
	List<Teacher> selectByMajorId(int major_id);
	
	
	@Select("SELECT teacher.* FROM teacher,major "
			+ "WHERE teacher.major_id = major.id AND major.college_id = #{college_id}")
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
		@Result(column = "major_id", property = "major", 
		one=@One(
				select = "cc.ileiwang.emsapp.dao.MajorDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.CourseDAO.selectByTeacherId",
				fetchType=FetchType.LAZY))
	})
	List<Teacher> selectByCollegeId(int college_id);
	
	
	@Select("select * from "+TEACHERTABLE+" where id = #{id}")
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
		@Result(column = "major_id", property = "major", 
		one=@One(
				select="cc.ileiwang.emsapp.dao.MajorDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.CourseDAO.selectByTeacherId",
				fetchType=FetchType.LAZY))
	})
	Teacher selectById(int id);
	
	@Select("select * from "+TEACHERTABLE+" where num = #{num}")
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
		@Result(column = "major_id", property = "major", 
		one = @One(
				select = "cc.ileiwang.emsapp.dao.MajorDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.CourseDAO.selectByTeacherId",
				fetchType=FetchType.LAZY))
	})
	Teacher selectByNum(String num);
	
	//根据账号密码查询
	@Select("select * from "+TEACHERTABLE+" where num = #{num} and password = #{password}")
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
		@Result(column = "major_id", property = "major", 
		one = @One(
				select = "cc.ileiwang.emsapp.dao.MajorDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.CourseDAO.selectByTeacherId",
				fetchType=FetchType.LAZY))
	})
	Teacher selectByNumAndPassword(@Param("num")String num,@Param("password")String password);
	
	@Delete("delete from "+TEACHERTABLE+" where id = #{id} ")
	void deleteById(int id);
	
	@Delete("delete from "+TEACHERTABLE+" where num = #{num} ")
	void deleteByNum(String num);

}
