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
		int size = 15;
		int startRow = (page - 1) * size + 1;
		int endRow = page * size;

		String countSql = "SELECT COUNT(*) FROM post";
		Long totalElements = jdbcTemplate.queryForObject(countSql, Long.class);

		// Paging data
		String sql = "SELECT * FROM (" +
				"SELECT post_id, position, title, to_char(created_date, 'YYYY-MM-DD HH24:MI:SS') AS created_date, " +
				"user_id, content, tags, view_count, " +
				"ROW_NUMBER() OVER (ORDER BY created_date DESC) AS rn " +
				"FROM post) " +
				"WHERE rn BETWEEN ? AND ?";

		List<PostDO> content = jdbcTemplate.query(sql, new Object[]{startRow, endRow}, new PostRowMapper());

		return new PageResponse<>(content, page, size, totalElements);
	}


	public PostDO selectPostById(long post_id) {
		this.sql = "select post_id, position, title, to_char(created_date, 'YYYY-MM-DD HH24:MI:SS') created_date, user_id, content, tags, view_count from post where post_id = ?";
		return this.jdbcTemplate.queryForObject(sql, new PostRowMapper(), post_id);
	}
	
	public int countPostByUserId(String user_id) {
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

	public PageResponse<PostDO> searchPaginatedPost(String keyword, int page) {
		int size = 15;
		int startRow = (page - 1) * size + 1;
		int endRow = page * size;

		String countSql = "SELECT COUNT(*) FROM post WHERE title LIKE ? OR content LIKE ?";
		String keywordPattern = "%" + keyword + "%";
		Long totalElements = jdbcTemplate.queryForObject(countSql, new Object[]{keywordPattern, keywordPattern}, Long.class);

		String sql =
				"SELECT * FROM (" +
					"SELECT post_id, position, title, to_char(created_date, 'YYYY-MM-DD HH24:MI:SS') AS created_date, " +
						"user_id, content, tags, view_count, " +
						"ROW_NUMBER() OVER (ORDER BY created_date DESC) AS rn " +
					"FROM post WHERE title LIKE ? OR content LIKE ?" +
				") " +
				"WHERE rn BETWEEN ? AND ?";

		List<PostDO> content = jdbcTemplate.query(sql,
				new Object[]{keywordPattern, keywordPattern, startRow, endRow},
				new PostRowMapper());

		return new PageResponse<>(content, page, size, totalElements);
	}

	public PageResponse<PostDO> searchPositionPaginatedPost(String position, int page) {
		int size = 15;
		int startRow = (page - 1) * size + 1;
		int endRow = page * size;

		String countSql = "SELECT COUNT(*) FROM post WHERE position = ?";
		Long totalElements = jdbcTemplate.queryForObject(countSql, Long.class, position);

		//paging
		this.sql = "SELECT * FROM ("
					+ "SELECT post_id, position, title, to_char(created_date, 'YYYY-MM-DD HH24:MI:SS') created_date, user_id, content, tags, view_count, "
					+ "ROW_NUMBER() OVER (ORDER BY created_date DESC) AS rn "
					+ "FROM post WHERE position = ?) "
				+ "WHERE rn BETWEEN ? AND ?";

		List<PostDO> content = this.jdbcTemplate.query(sql, new Object[]{position, startRow, endRow}, new PostRowMapper());
		return new PageResponse<>(content, page, size, totalElements);
	}
}
