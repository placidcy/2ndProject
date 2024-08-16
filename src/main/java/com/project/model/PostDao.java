package com.project.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class PostDao {
	private final JdbcTemplate jdbcTemplate;

	@Autowired
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

	public List<PostDO> selectAll() {
		//-- 메인페이지 게시글 조회
		//SELECT post_id, title, content, position, view_count, created_date FROM post;
		return this.jdbcTemplate
				.query("SELECT post_id, title, content, position, view_count, created_date FROM post",
						new PostRowMapper());
	}
}
