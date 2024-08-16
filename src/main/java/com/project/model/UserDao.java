package com.project.model;

import javax.sql.*;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
	private JdbcTemplate jdbcTemplate;
	
	public UserDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public UserDO selectById(String user_id) {
		UserDO results = null;
		try {
			results = jdbcTemplate.queryForObject("select * from userinfo where user_id = ?", new UserRowMapper(), user_id);
		}
		catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
		
		return results;
	}
	
	public void update(UserDO user) {
		jdbcTemplate.update("update userinfo set password = ? where user_id = ?", user.getPassword(), user.getUser_id());
	}

}
