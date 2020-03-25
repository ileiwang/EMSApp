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
* @version 2018��10��11�� ����10:40:41
*/
public interface AdminDAO {
	
	//��ҳ��ѯ��ҳ�Ű����ڲ���params��
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
	
	//ͳ�Ʒ���ĳ����������������������params��
	@SelectProvider(type=AdminDynaSqlProvider.class,method="countAdmin")
	int count(Map<String, Object> params);

	//���룬�����ֵ�����ڲ���admin��
	@SelectProvider(type=AdminDynaSqlProvider.class,method="insertAdmin")
	void save(Admin admin);
	
	//�޸ģ��޸ĵ�ֵ�����ڲ���admin��
	@SelectProvider(type=AdminDynaSqlProvider.class,method="updateAdmin")
	void update(Admin admin);
	
	
	//��ѯ����
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
	
	
	//��ID��ѯ
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
	
	//������Ա�Ų�ѯ
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
	
	//���˺������ѯ
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
	
	//��IDɾ��
	@Delete("delete from "+ADMINTABLE+" where id = #{id} ")
	void deleteById(int id);
	
	//������Ա��ɾ��
	@Delete("delete from "+ADMINTABLE+" where num = #{num} ")
	void deleteByNum(String num);
	
	//������ɾ��
	@Delete("delete from "+ADMINTABLE+" where name = #{name} ")
	void deleteByName(String name);
}
