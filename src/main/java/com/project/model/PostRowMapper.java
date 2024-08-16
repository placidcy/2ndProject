package com.project.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PostRowMapper implements RowMapper<PostDO> {


    @Override
    public PostDO mapRow(ResultSet rs, int rowNum) throws SQLException {
        PostDO post = new PostDO();
        post.setPost_id(rs.getInt("post_id"));
        post.setTitle(rs.getString("title"));
        post.setContent(rs.getString("content"));
        post.setUser_id(rs.getString("user_id"));
        post.setPosition(rs.getString("position"));
        return post;
    }
}
