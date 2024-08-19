package com.project.model;

import java.sql.*;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class ReplyDao {
	
	private final JdbcTemplate jdbcTemplate;
	private String sql;

	public ReplyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<ReplyDO> selectRepliesByPost(long postId) {
		this.sql = "select reply_id, user_id, content, to_char(created_at, 'YYYY-MM-DD HH24:MI:SS') created_at, likes from reply where post_id = ? order by reply_id";
		
		return this.jdbcTemplate.query(sql, new PreparedStatementSetter() { 
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setLong(1, postId);
			}
		}, new ReplyRowMapper());
	}
	
	public void insertReply(ReplyDO reply) {
		this.sql = "insert into reply(reply_id, user_id, post_id, content, create_at, likes) values(seq_reply_reply_id.nextval, ?, ?, ?, sysdate, ?)";
		
		KeyHolder keyHorder = new GeneratedKeyHolder();
		this.jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {

				PreparedStatement pstmt = conn.prepareStatement(sql, new String [] { "reply_id" });
				pstmt.setString(1, reply.getUser_id());
				pstmt.setLong(2, reply.getPost_id());
				pstmt.setString(3, reply.getContent());
				pstmt.setInt(4, reply.getLikes());
				return pstmt;
			}
		}, keyHorder);
	}
	
	public void updateLikes(int likes, int reply_id) {
		this.sql = "update reply set likes = ? where reply_id = ?";
		this.jdbcTemplate.update(sql, likes, reply_id);
	}
	
	public int countReply(String user_id,Long post_id) {
		this.sql = "select count(*) from reply where user_id = ? and post_id = ?";
		return this.jdbcTemplate.queryForObject(sql, Integer.class, user_id, post_id);	
	}
	public int countReply(String user_id) {
		this.sql = "select count(*) from reply where user_id = ?";
		return this.jdbcTemplate.queryForObject(sql, Integer.class, user_id);	
	}
	
}
