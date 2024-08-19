package com.project.model;

import org.apache.tomcat.jdbc.pool.DataSource;

public class Test {
	
	public static void main(String[] args) {
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
		UserDao userDao = new UserDao(ds);
		UserDO userInfo = userDao.selectById("USER005");
		System.out.print(userInfo.getName());
	}

}
