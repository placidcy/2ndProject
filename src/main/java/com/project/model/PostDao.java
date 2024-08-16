package com.project.model;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class PostDao {
	private final JdbcTemplate jdbcTemplate;
	private String sql;
	
	@Autowired
	public PostDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void insertPost(PostDO post) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		this.jdbcTemplate.update(new PostPreparedStatement(post, new String[] {"post_id"}), keyHolder);
		Number keyValue = keyHolder.getKey();
		post.setPost_id(keyValue.longValue());
		//내가 쓴글 기능이 있을 때 필요
	}

	public List<PostDO> selectAllPost() {
		//-- 메인페이지 게시글 조회
		//SELECT post_id, title, content, position, view_count, created_date FROM post;
		return this.jdbcTemplate
				.query("SELECT post_id, title, content, position, view_count, created_date FROM post",
						new PostRowMapper());
	}
	
	public int countPost(UserDO userInfo) {
		this.sql = "select count(*) from post where user_id = ?";
		return this.jdbcTemplate.queryForObject(sql, Integer.class, userInfo.getUser_id());	
	}
	
}
