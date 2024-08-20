package com.project.model;

import com.project.model.response.PageResponse;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

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
	
	public void updatePost(PostDO post) {
		this.sql = "update post set title = ?, content = ?, tags = ?, position = ? where post_id = ?";
		this.jdbcTemplate.update(sql, post.getTitle(), post.getContent(), post.getTags(), post.getPosition(), post.getPost_id());
	}
	
	public void deletePost(long post_id) {
		this.sql = "delete from post where post_id = ?";
		this.jdbcTemplate.update(sql, post_id);
	}

	public List<PostDO> selectAllPost() {
		//-- 메인페이지 게시글 조회
		return this.jdbcTemplate
				.query("SELECT post_id, position, title, to_char(created_date, 'YYYY-MM-DD HH24:MI:SS') created_date, user_id, content, tags, view_count FROM post",
						new PostRowMapper());
	}

	public PageResponse<PostDO> selectPaginatedPost(int page) {
		int size = 15; // 페이지당 데이터 수를 15로 고정
		int startRow = (page - 1) * size + 1;
		int endRow = page * size;

		// 전체 데이터 수를 계산하는 쿼리
		String countSql = "SELECT COUNT(*) FROM post";
		Long totalElements = jdbcTemplate.queryForObject(countSql, Long.class);

		// 페이징된 데이터를 가져오는 쿼리
		String sql = "SELECT * FROM (" +
				"SELECT post_id, position, title, to_char(created_date, 'YYYY-MM-DD HH24:MI:SS') AS created_date, " +
				"user_id, content, tags, view_count, " +
				"ROW_NUMBER() OVER (ORDER BY created_date DESC) AS rn " +
				"FROM post) " +
				"WHERE rn BETWEEN ? AND ?";

		List<PostDO> content = jdbcTemplate.query(sql, new Object[]{startRow, endRow}, new PostRowMapper());

		// PageResponse 객체를 생성하여 반환
		return new PageResponse<>(content, page, size, totalElements);
	}


	public PostDO selectPostById(long post_id) {
		this.sql = "select post_id, position, title, to_char(created_date, 'YYYY-MM-DD HH24:MI:SS') created_date, user_id, content, tags, view_count from post where post_id = ?";
		return this.jdbcTemplate.queryForObject(sql, new PostRowMapper(), post_id);
	}
	
	public int countPost(String user_id) {
		this.sql = "select count(*) from post where user_id = ?";
		return this.jdbcTemplate.queryForObject(sql, Integer.class, user_id);	
	}
	

	public List<PostDO> search(String keyword) {
		this.sql = "select post_id, position, title, to_char(created_date, 'YYYY-MM-DD HH24:MI:SS') created_date, user_id, content, tags, view_count "
				+ "from post "
				+ "where title like '%" + keyword + "%' or content like '%" + keyword + "%'";

		return this.jdbcTemplate.query(sql, new PostRowMapper());
	}
	
	public PostDO getPostById(long post_id) {
		return this.selectPostById(post_id);
	}

	public List<PostDO> hotPost(){
		this.sql = "select post_id, position, title, to_char(created_date, 'YYYY-MM-DD HH24:MI:SS') created_date, user_id, content, tags, view_count from (select post_id, position, title, created_date, user_id, content, tags, view_count, row_number() over (order by view_count) as row_num from post) where rowNum < 6";
		return this.jdbcTemplate.query(sql, new PostRowMapper());
	}

	public List<PostDO> searchPosition(String position) {
		this.sql = "select post_id, position, title, to_char(created_date, 'YYYY-MM-DD HH24:MI:SS') created_date, user_id, content, tags, view_count "
				+ "from post "
				+ "where position = ?";

		return this.jdbcTemplate.query(sql, new PostRowMapper(), position);
	}

	public List<PostDO> updateViewCount(long postId) {
		this.sql = "update post set view_count = view_count + 1 where post_id = ?";
		this.jdbcTemplate.update(sql, postId);
		return this.selectAllPost();
	}
}
