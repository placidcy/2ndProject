package com.project.model;

import com.project.exception.WrongIdPasswordException;
import javax.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
	private final JdbcTemplate jdbcTemplate;

	@Autowired
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

	public UserDO login(String user_id, String password) {
		UserDO result;
		try {
			result = jdbcTemplate.queryForObject("select * from userinfo where user_id = ? and password = ?",
					new UserRowMapper(),
					user_id, password
			);
		} catch(EmptyResultDataAccessException e) {
			throw new WrongIdPasswordException();
		}

		return result;
	}

}
