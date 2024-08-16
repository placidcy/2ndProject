package com.project.model;

import java.sql.*;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
	private JdbcTemplate jdbcTemplate;
	private String sql;
	
	public UserDao() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("scott");
		ds.setPassword("tiger");
		ds.setInitialSize(5);
		ds.setMinIdle(5);
		ds.setMaxIdle(10);
		ds.setMinEvictableIdleTimeMillis(60000 * 3);
		ds.setTimeBetweenEvictionRunsMillis(1000 * 10);
		
		this.jdbcTemplate = new JdbcTemplate(ds);
	}	
	
	public UserDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public UserDO selectById(String user_id) {
		UserDO userDo = null;
		this.sql = "select user_id, name, nickname, email, password, to_char(create_date, 'YYYY-MM-DD HH24:MI:SS') create_date from userinfo where user_id = ?";
		
		try {
			userDo = this.jdbcTemplate.queryForObject(sql, new UserRowMapper(), user_id);
		}
		catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
		
		return userDo;
	}
	
//	public void update(UserDO user) {
//		jdbcTemplate.update("update userinfo set password = ? where user_id = ?", user.getPassword(), user.getUser_id());
//	}
	
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
	
	

	

}
