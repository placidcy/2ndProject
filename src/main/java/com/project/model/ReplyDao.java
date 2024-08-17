package com.project.model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class ReplyDao {
	
	private JdbcTemplate jdbcTemplate;
	private String sql;

	@Autowired
	public ReplyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
//	public List<ReplyDO> selectAllReply() {
	
//	}
	
//	public void insertReply(ReplyDO reply) {
//		
//	}
	
//	public int insertLikes() {
//		
//	}
	
}
