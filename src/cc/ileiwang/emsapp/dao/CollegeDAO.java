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
//import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Many;

import cc.ileiwang.emsapp.domain.*;
import cc.ileiwang.emsapp.dao.provider.*;

import static cc.ileiwang.emsapp.util.common.EMSAppConstants.COLLEGETABLE;
/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018年10月11日 上午10:41:45
*/
public interface CollegeDAO {
	
	@SelectProvider(type=CollegeDynaSqlProvider.class,method="selectWhitParam")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "name", property = "name"),
		@Result(column="id",property="majors",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.MajorDAO.selectByCollegeId",
				fetchType=FetchType.LAZY))
	})
	List<College> selectByParam(Map<String, Object> params);
	
	@SelectProvider(type=CollegeDynaSqlProvider.class,method="countCollege")
	int count(Map<String, Object> params);

	@SelectProvider(type=CollegeDynaSqlProvider.class,method="insertCollege")
	void save(College college);
	
	@SelectProvider(type=CollegeDynaSqlProvider.class,method="updateCollege")
	void update(College college);
	
	@Select("select * from "+COLLEGETABLE)
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "name", property = "name"),
		@Result(column="id",property="majors",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.MajorDAO.selectByCollegeId",
				fetchType=FetchType.LAZY))
	})
	List<College> selectAll();
	
	@Select("select * from "+COLLEGETABLE+" where id = #{id}")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "name", property = "name"),
		@Result(column="id",property="majors",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.MajorDAO.selectByCollegeId",
				fetchType=FetchType.LAZY))
	})
	College selectById(int id);
	
	@Select("select * from "+COLLEGETABLE+" where num = #{num}")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "num", property = "num"),
		@Result(column = "name", property = "name"),
		@Result(column="id",property="majors",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.MajorDAO.selectByCollegeId",
				fetchType=FetchType.LAZY))
	})
	College selectByNum(String num);
	
	@Delete("delete from "+COLLEGETABLE+" where id = #{id} ")
	void deleteById(int id);
	
	@Delete("delete from "+COLLEGETABLE+" where num = #{num} ")
	void deleteByNum(String num);

}
