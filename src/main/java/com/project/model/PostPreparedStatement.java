package com.project.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;

public class PostPreparedStatement implements PreparedStatementCreator{

	private PostDO post;
	private String [] keyColumns;
	
	public PostPreparedStatement(PostDO post) {
		this.post = post;
		this.keyColumns = null;
	}
	
	public PostPreparedStatement(PostDO post, String [] keyColumns) {
		this.post = post;
		this.keyColumns = keyColumns;
	}
	
	@Override
	public PreparedStatement createPreparedStatement(Connection conn) throws SQLException{
		String sql = "insert into post (post_id, title, content, tags, user_id, position) values (seq_post_post_id.nextval, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		if(keyColumns.length > 0) {
			pstmt = conn.prepareStatement(sql, keyColumns);
		}
		else {
			pstmt = conn.prepareStatement(sql);
		}
		
		pstmt.setString(1, post.getTitle());
		pstmt.setString(2, post.getContent());
		pstmt.setString(3, post.getTags());
		pstmt.setString(4, post.getUser_id());
		pstmt.setString(5, post.getPosition());
		
		return pstmt;
	}
}
