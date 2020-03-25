package cc.ileiwang.emsapp.dao;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;
//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.InsertProvider;
//import org.apache.ibatis.annotations.Update;
//import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.annotations.Delete;
//import org.apache.ibatis.annotations.DeleteProvider;
//import org.apache.ibatis.annotations.Options;
//import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import cc.ileiwang.emsapp.domain.*;
import cc.ileiwang.emsapp.dao.provider.*;
import static cc.ileiwang.emsapp.util.common.EMSAppConstants.ADMINTABLE;

/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018年10月11日 上午10:40:41
*/
public interface AdminDAO {
	
	//分页查询，页号包含在参数params内
	@SelectProvider(type=AdminDynaSqlProvider.class,method="selectWhitParam")
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
		@Result(column="id",property="notices",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.NoticeDAO.selectByAdminId",
				fetchType=FetchType.LAZY))
	})
	List<Admin> selectByParam(Map<String, Object> params);
	
	//统计符合某条件的数量，条件包含在params内
	@SelectProvider(type=AdminDynaSqlProvider.class,method="countAdmin")
	int count(Map<String, Object> params);

	//插入，插入的值保存在参数admin中
	@SelectProvider(type=AdminDynaSqlProvider.class,method="insertAdmin")
	void save(Admin admin);
	
	//修改，修改的值保存在参数admin中
	@SelectProvider(type=AdminDynaSqlProvider.class,method="updateAdmin")
	void update(Admin admin);
	
	
	//查询所有
	@Select("select * from "+ADMINTABLE)
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
		@Result(column="id",property="notices",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.NoticeDAO.selectByAdminId",
				fetchType=FetchType.LAZY))
	})
	List<Admin> selectAll();
	
	
	//按ID查询
	@Select("select * from "+ADMINTABLE+" where id = #{id}")
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
		@Result(column="id",property="notices",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.NoticeDAO.selectByAdminId",
				fetchType=FetchType.LAZY))
	})
	Admin selectById(int id);
	
	//按管理员号查询
	@Select("select * from "+ADMINTABLE+" where num = #{num}")
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
		@Result(column="id",property="notices",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.NoticeDAO.selectByAdminId",
				fetchType=FetchType.LAZY))
	})
	Admin selectByNum(String num);
	
	//按账号密码查询
	@Select("select * from "+ADMINTABLE+" where num = #{num} and password = #{password}")
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
		@Result(column="id",property="notices",
		many=@Many(
				select="cc.ileiwang.emsapp.dao.NoticeDAO.selectByAdminId",
				fetchType=FetchType.LAZY))
	})
	Admin selectByNumAndPassword(@Param("num")String num,@Param("password")String password);
	
	//按ID删除
	@Delete("delete from "+ADMINTABLE+" where id = #{id} ")
	void deleteById(int id);
	
	//按管理员号删除
	@Delete("delete from "+ADMINTABLE+" where num = #{num} ")
	void deleteByNum(String num);
	
	//按姓名删除
	@Delete("delete from "+ADMINTABLE+" where name = #{name} ")
	void deleteByName(String name);
}
