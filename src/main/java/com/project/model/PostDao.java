package com.project.model;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class PostDao {
	private final JdbcTemplate jdbcTemplate;
	private String sql;
	
	public PostDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void insertPost(PostDO post, String user_id) {
		this.sql = "insert into post (post_id, title, content, tags, user_id, position) values(seq_post_post_id.nextval, ?, ?, ?, ?, ?)";
		this.jdbcTemplate.update(sql, post.getTitle(), post.getContent(), post.getTags(), user_id, post.getPosition());
	}

	public List<PostDO> selectAllPost() {
		//-- 메인페이지 게시글 조회
		//SELECT post_id, title, content, position, view_count, created_date FROM post;
		return this.jdbcTemplate
				.query("SELECT post_id, title, content, position, view_count, created_date FROM post",
						new PostRowMapper());
	}
	
	public int countPost(String user_id) {
		this.sql = "select count(*) from post where user_id = ?";
		return this.jdbcTemplate.queryForObject(sql, Integer.class, user_id);	
	}
	
}
