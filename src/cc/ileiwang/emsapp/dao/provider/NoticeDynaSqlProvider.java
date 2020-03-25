package cc.ileiwang.emsapp.dao.provider;

import static cc.ileiwang.emsapp.util.common.EMSAppConstants.NOTICETABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import cc.ileiwang.emsapp.domain.Notice;

/**
* @author Lei Wang
* @email 3970111@gmail.com
* @blog www.ileiwang.cc
* @version 2018年4月1日 上午10:47:29
*/
public class NoticeDynaSqlProvider {
	
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(NOTICETABLE);
				if (params.get("notice") != null) {
					Notice notice = (Notice) params.get("notice");
					if (notice.getTitle() != null && !notice.getTitle().equals("")) {
						WHERE("title LIKE CONCAT ('%',#{notice.title},'%') ");
					}
					if (notice.getContent() != null && !notice.getContent().equals("")) {
						WHERE("content LIKE CONCAT ('%',#{notice.content},'%') ");
					}
					if (notice.getAdmin() != null && notice.getAdmin().getId()!=0) {
						WHERE("admin_id LIKE CONCAT ('%',#{notice.admin.id},'%') ");
					}
				}
			}
		}.toString();

		return sql;
	}

	// 动态查询总数量
	public String countNotice(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM(NOTICETABLE);
				if (params.get("notice") != null) {
					Notice notice = (Notice) params.get("notice");
					if (notice.getTitle() != null && !notice.getTitle().equals("")) {
						WHERE("title LIKE CONCAT ('%',#{notice.title},'%') ");
					}
				}
			}
		}.toString();
	}

	// 动态插入
	public String insertNotice(Notice notice) {

		return new SQL() {
			{
				INSERT_INTO(NOTICETABLE);
				if (notice.getTitle() != null && !notice.getTitle().equals("")) {
					VALUES("title", "#{title}");
				}
				if (notice.getContent() != null && !notice.getContent().equals("")) {
					VALUES("content", "#{content}");
				}
				if (notice.getCreatedate() != null) {
					VALUES("createdate", "#{createdate}");
				}
				if (notice.getAdmin() != null && notice.getAdmin().getId() != 0) {
					VALUES("admin_id", "#{admin.id}");
				}
			}
		}.toString();
	}

	// 动态更新
	public String updateNotice(Notice notice) {

		return new SQL() {
			{
				UPDATE(NOTICETABLE);
				if (notice.getTitle() != null && !notice.getTitle().equals("")) {
					SET("title = #{title}");
				}
				if (notice.getContent() != null && !notice.getContent().equals("")) {
					SET("content = #{content}");
				}
				if (notice.getCreatedate() != null) {
					SET("createdate = #{createdate}");
				}
				if (notice.getAdmin() != null && notice.getAdmin().getId() != 0) {
					SET("admin_id = #{admin.id}");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

}
