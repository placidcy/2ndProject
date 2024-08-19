package com.project.model;

import com.project.exception.WrongIdPasswordException;
import javax.sql.*;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

	private final JdbcTemplate jdbcTemplate; 
	private String sql;

	public UserDao(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	public UserDO selectById(String user_id) {
		UserDO userDo = null;

		this.sql = "select user_id, name, nickname, email, password, to_char(created_date, 'YYYY-MM-DD HH24:MI:SS') created_date "
				+ "from userinfo "
				+ "where user_id = ?";
		
		try {
			userDo = this.jdbcTemplate.queryForObject(sql, new UserRowMapper(), user_id);
		}
		catch(EmptyResultDataAccessException e) {
			System.out.println("user_id = " + user_id);
			throw new WrongIdPasswordException();
		}
		
		return userDo;
	}

	public int insertUser(UserDO user) {
		String sql = "INSERT INTO userinfo (user_id, name, nickname, email, password) VALUES (?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, user.getUser_id(), user.getName(), user.getNickname(), user.getEmail(), user.getPassword());
	}


	public int updateNicknameUserInfo(UserDO user) {
		this.sql = "update userinfo set nickname = ? where user_id = ? ";
		
		int rowCount = 0;
		
		rowCount = this.jdbcTemplate.update(sql, user.getNickname(), user.getUser_id());
		
		return rowCount;
	}

	public int updatePasswordUserInfo(UserDO user) {
		this.sql = "update userinfo set password = ? where user_id = ? ";
		
		int rowCount = 0;
		
		rowCount = this.jdbcTemplate.update(sql, user.getPassword(), user.getUser_id());
		
		return rowCount;
	}
	

	public UserDO login(String user_id, String password) {
		UserDO user = null;
		try {
			user = jdbcTemplate.queryForObject("select user_id, name, nickname, email, password, to_char(created_date, 'YYYY-MM-DD HH24:MI:SS') created_date from userinfo where user_id = ? and password = ?",
					new UserRowMapper(),
					user_id, password
			);

		} catch(EmptyResultDataAccessException e) {
			throw new WrongIdPasswordException();
		}
		return user;
	}
	
	

}
