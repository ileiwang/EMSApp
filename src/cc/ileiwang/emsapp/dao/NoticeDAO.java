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

import static cc.ileiwang.emsapp.util.common.EMSAppConstants.NOTICETABLE;
/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018年10月11日 上午10:43:02
*/
public interface NoticeDAO {
	
	@SelectProvider(type=NoticeDynaSqlProvider.class,method="selectWhitParam")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "title", property = "title"),
		@Result(column = "content", property = "content"),
		@Result(column = "createdate", property = "createdate", javaType = java.util.Date.class),
		@Result(column = "admin_id", property = "admin", 
			one = @One(select = "cc.ileiwang.emsapp.dao.AdminDAO.selectById", 
			fetchType = FetchType.EAGER))
	})
	List<Notice> selectByParam(Map<String, Object> params);
	
	@Select("select * from "+NOTICETABLE+" where admin_id = #{admin_id}" )
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "title", property = "title"),
		@Result(column = "content", property = "content"),
		@Result(column = "createdate", property = "createdate", javaType = java.util.Date.class),
		@Result(column = "admin_id", property = "admin", 
			one = @One(select = "cc.ileiwang.emsapp.dao.AdminDAO.selectById", 
			fetchType = FetchType.EAGER))
	})
	List<Notice> selectByAdminId(int admin_id);
	
	@SelectProvider(type=NoticeDynaSqlProvider.class,method="countNotice")
	int count(Map<String, Object> params);

	@SelectProvider(type=NoticeDynaSqlProvider.class,method="insertNotice")
	void save(Notice notice);
	
	@SelectProvider(type=NoticeDynaSqlProvider.class,method="updateNotice")
	void update(Notice notice);
	
	@Select("select * from "+NOTICETABLE)
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "title", property = "title"),
		@Result(column = "content", property = "content"),
		@Result(column = "createdate", property = "createdate", javaType = java.util.Date.class),
		@Result(column = "admin_id", property = "admin", 
			one = @One(select = "cc.ileiwang.emsapp.dao.AdminDAO.selectById", 
			fetchType = FetchType.EAGER))
	})
	List<Notice> selectAll();
	
	@Select("select * from "+NOTICETABLE+" where id = #{id}")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "title", property = "title"),
		@Result(column = "content", property = "content"),
		@Result(column = "createdate", property = "createdate", javaType = java.util.Date.class),
		@Result(column = "admin_id", property = "admin", 
			one = @One(select = "cc.ileiwang.emsapp.dao.AdminDAO.selectById", 
			fetchType = FetchType.EAGER))
	})
	Notice selectById(int id);
	
	@Select("select * from "+NOTICETABLE+" where title = #{title}")
	@Results({ 
		@Result(id = true, column = "id", property = "id"), 
		@Result(column = "title", property = "title"),
		@Result(column = "content", property = "content"),
		@Result(column = "createdate", property = "createdate", javaType = java.util.Date.class),
		@Result(column = "admin_id", property = "admin", 
			one = @One(select = "cc.ileiwang.emsapp.dao.AdminDAO.selectById", 
			fetchType = FetchType.EAGER))
	})
	Notice selectByTitle(String title);
	
	@Delete("delete from "+NOTICETABLE+" where id = #{id} ")
	void deleteById(int id);
	
	@Delete("delete from "+NOTICETABLE+" where title = #{title} ")
	void deleteByTitle(String title);

}
