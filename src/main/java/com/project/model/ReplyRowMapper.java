package com.project.model;

import java.sql.*;

import org.springframework.jdbc.core.RowMapper;

public class ReplyRowMapper implements RowMapper<ReplyDO> {

	public ReplyDO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReplyDO reply = new ReplyDO();
		
		reply.setReply_id(rs.getInt("reply_id"));
		reply.setUser_id(rs.getString("user_id"));
		reply.setContent(rs.getString("content"));
		reply.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime().toString());
		reply.setLikes(rs.getInt("likes"));
		
		return reply;
	}
	
}
