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

import static cc.ileiwang.emsapp.util.common.EMSAppConstants.CLAZZTABLE;
/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018年10月11日 上午10:41:25
*/
public interface ClazzDAO {
	@SelectProvider(type=ClazzDynaSqlProvider.class,method="selectWhitParam")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "stunum", property = "stunum"),
		@Result(column = "name", property = "name"),
		@Result(column = "major_id", property = "major", 
		one = @One(
				select = "cc.ileiwang.emsapp.dao.MajorDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="students",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.StudentDAO.selectByClazzId",
				fetchType=FetchType.LAZY))
	})
	List<Clazz> selectByParam(Map<String, Object> params);
	
	@SelectProvider(type=ClazzDynaSqlProvider.class,method="countClazz")
	int count(Map<String, Object> params);

	@SelectProvider(type=ClazzDynaSqlProvider.class,method="insertClazz")
	void save(Clazz clazz);
	
	@SelectProvider(type=ClazzDynaSqlProvider.class,method="updateClazz")
	void update(Clazz clazz);
	
	@Select("select * from "+CLAZZTABLE)
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "stunum", property = "stunum"),
		@Result(column = "name", property = "name"),
		@Result(column = "major_id", property = "major", 
		one = @One(
				select = "cc.ileiwang.emsapp.dao.MajorDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="students",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.StudentDAO.selectByClazzId",
				fetchType=FetchType.LAZY))
	})
	List<Clazz> selectAll();
	
	
	@Select("select * from "+CLAZZTABLE+" where major_id = #{major_id}")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "stunum", property = "stunum"),
		@Result(column = "name", property = "name"),
		@Result(column = "major_id", property = "major", 
		one = @One(
				select = "cc.ileiwang.emsapp.dao.MajorDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="students",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.StudentDAO.selectByClazzId",
				fetchType=FetchType.LAZY))
	})
	List<Clazz> selectByMajorId(int major_id);
	
	
	//按学院查询班级
	@Select("SELECT clazz.* "
			+ "FROM clazz,major,college "
			+ "WHERE clazz.major_id = major.id AND major.college_id = college.id "
			+ "AND college.id = #{college_id}")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "stunum", property = "stunum"),
		@Result(column = "name", property = "name"),
		@Result(column = "major_id", property = "major", 
		one = @One(
				select = "cc.ileiwang.emsapp.dao.MajorDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="students",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.StudentDAO.selectByClazzId",
				fetchType=FetchType.LAZY))
	})
	List<Clazz> selectByCollegeId(int college_id);
	
	@Select("select * from "+CLAZZTABLE+" where id = #{id}")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "stunum", property = "stunum"),
		@Result(column = "name", property = "name"),
		@Result(column = "major_id", property = "major",
		one = @One(
				select = "cc.ileiwang.emsapp.dao.MajorDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="students",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.StudentDAO.selectByClazzId",
				fetchType=FetchType.LAZY))
	})
	Clazz selectById(@Param("id")int id);
	
	@Select("select * from "+CLAZZTABLE+" where num = #{num}")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "stunum", property = "stunum"),
		@Result(column = "name", property = "name"),
		@Result(column = "major_id", property = "major", 
		one = @One(
				select = "cc.ileiwang.emsapp.dao.MajorDAO.selectById", 
				fetchType = FetchType.EAGER)),
		@Result(column="id",property="students",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.StudentDAO.selectByClazzId",
				fetchType=FetchType.LAZY))
	})
	Clazz selectByNum(String num);
	
	@Delete("delete from "+CLAZZTABLE+" where id = #{id} ")
	void deleteById(int id);
	
	@Delete("delete from "+CLAZZTABLE+" where num = #{num} ")
	void deleteByNum(String num);
}
