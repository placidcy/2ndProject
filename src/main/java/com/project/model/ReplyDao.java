package com.project.model;

import java.sql.*;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class ReplyDao {
	
	private JdbcTemplate jdbcTemplate;
	private String sql;

	@Autowired
	public ReplyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<ReplyDO> selectAllReply() {
		this.sql = "select reply_id, user_id, content, to_char(created_at, 'YYYY-MM-DD HH24:MI:SS') created_at, likes from reply order by reply_id";
		
		List<ReplyDO> replyList = this.jdbcTemplate.query(sql, new ReplyRowMapper());
		
		return replyList;
	}
	
	public void insertReply(ReplyDO reply) {
		this.sql = "insert into reply(user) values()";
		
	}
	
	
}
