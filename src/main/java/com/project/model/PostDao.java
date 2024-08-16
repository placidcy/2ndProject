package com.project.model;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class PostDao {
	private JdbcTemplate jdbcTemplate;
	
	public PostDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void insert(PostDO post) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.jdbcTemplate.update(new PostPreparedStatement(post, new String[] {"post_id"}), keyHolder);
		Number keyValue = keyHolder.getKey();
		post.setPost_id(keyValue.longValue());
		//내가 쓴글 기능이 있을 때 필요
	}
}
