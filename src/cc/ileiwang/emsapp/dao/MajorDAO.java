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
import org.apache.ibatis.annotations.Many;

import cc.ileiwang.emsapp.domain.*;
import cc.ileiwang.emsapp.dao.provider.*;

import static cc.ileiwang.emsapp.util.common.EMSAppConstants.MAJORTABLE;
/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018年10月11日 上午10:42:43
*/
public interface MajorDAO {
	
	@SelectProvider(type=MajorDynaSqlProvider.class,method="selectWhitParam")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "name", property = "name"),
		@Result(column = "clazznum", property = "clazznum"),
		@Result(column = "college_id", property = "college", 
		one = @One(
				select = "cc.ileiwang.emsapp.dao.CollegeDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="clazzs",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.ClazzDAO.selectByMajorId",
				fetchType=FetchType.LAZY)),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.CourseDAO.selectByMajorId",
				fetchType=FetchType.LAZY)),
		@Result(column="id",property="teachers",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.TeacherDAO.selectByMajorId",
				fetchType=FetchType.LAZY))
	})
	List<Major> selectByParam(Map<String, Object> params);
	
	@SelectProvider(type=MajorDynaSqlProvider.class,method="countMajor")
	int count(Map<String, Object> params);

	@SelectProvider(type=MajorDynaSqlProvider.class,method="insertMajor")
	void save(Major major);
	
	@SelectProvider(type=MajorDynaSqlProvider.class,method="updateMajor")
	void update(Major major);
	
	@Select("select * from "+MAJORTABLE)
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "name", property = "name"),
		@Result(column = "clazznum", property = "clazznum"),
		@Result(column = "college_id", property = "college", 
		one = @One(
				select = "cc.ileiwang.emsapp.dao.CollegeDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="clazzs",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.ClazzDAO.selectByMajorId",
				fetchType=FetchType.LAZY)),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.CourseDAO.selectByMajorId",
				fetchType=FetchType.LAZY)),
		@Result(column="id",property="teachers",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.TeacherDAO.selectByMajorId",
				fetchType=FetchType.LAZY))
	})
	List<Major> selectAll();
	
	@Select("select * from "+MAJORTABLE +" where college_id = #{college_id}")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "name", property = "name"),
		@Result(column = "clazznum", property = "clazznum"),
		@Result(column = "college_id", property = "college", 
		one = @One(
				select = "cc.ileiwang.emsapp.dao.CollegeDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="clazzs",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.ClazzDAO.selectByMajorId",
				fetchType=FetchType.LAZY)),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.CourseDAO.selectByMajorId",
				fetchType=FetchType.LAZY)),
		@Result(column="id",property="teachers",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.TeacherDAO.selectByMajorId",
				fetchType=FetchType.LAZY))
	})
	List<Major> selectByCollegeId(int college_id);
	
	@Select("select * from "+MAJORTABLE+" where id = #{id}")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "name", property = "name"),
		@Result(column = "clazznum", property = "clazznum"),
		@Result(column = "college_id", property = "college", 
		one=@One(
				select = "cc.ileiwang.emsapp.dao.CollegeDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="clazzs",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.ClazzDAO.selectByMajorId",
				fetchType=FetchType.LAZY)),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.CourseDAO.selectByMajorId",
				fetchType=FetchType.LAZY)),
		@Result(column="id",property="teachers",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.TeacherDAO.selectByMajorId",
				fetchType=FetchType.LAZY))
	})
	Major selectById(int id);
	
	@Select("select * from "+MAJORTABLE+" where num = #{num}")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "name", property = "name"),
		@Result(column = "clazznum", property = "clazznum"),
		@Result(column = "college_id", property = "college", 
		one = @One(
				select = "cc.ileiwang.emsapp.dao.CollegeDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="clazzs",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.ClazzDAO.selectByMajorId",
				fetchType=FetchType.LAZY)),
		@Result(column="id",property="courses",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.CourseDAO.selectByMajorId",
				fetchType=FetchType.LAZY)),
		@Result(column="id",property="teachers",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.TeacherDAO.selectByMajorId",
				fetchType=FetchType.LAZY))
	})
	Major selectByNum(String num);
	
	@Delete("delete from "+MAJORTABLE+" where id = #{id} ")
	void deleteById(int id);
	
	@Delete("delete from "+MAJORTABLE+" where num = #{num} ")
	void deleteByNum(String num);

}
