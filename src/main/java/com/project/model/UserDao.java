package com.project.model;

import com.project.exception.WrongIdPasswordException;
import javax.sql.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
	private final JdbcTemplate jdbcTemplate;

	private String sql;

	@Autowired
	public UserDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public UserDO selectById(String user_id) {
		UserDO userDo = null;
		this.sql = "select user_id, name, nickname, email, password, to_char(created_date, 'YYYY-MM-DD HH24:MI:SS') create_date from userinfo where user_id = ?";
		
		try {
			userDo = this.jdbcTemplate.queryForObject(sql, new UserRowMapper(), user_id);
		}
		catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
		
		return userDo;
	}
	
	
	public int updateNicknameUserInfo(UserDO userInfo) {
		this.sql = "update userinfo set nickname = ? where user_id = ? ";
		
		int rowCount = 0;
		
		rowCount = this.jdbcTemplate.update(sql, userInfo.getNickname(), userInfo.getUser_id());
		
		return rowCount;
	}

	public int updatePasswordUserInfo(UserDO userInfo) {
		this.sql = "update userinfo set password = ? where user_id = ? ";
		
		int rowCount = 0;
		
		rowCount = this.jdbcTemplate.update(sql, userInfo.getPassword(), userInfo.getUser_id());
		
		return rowCount;
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
