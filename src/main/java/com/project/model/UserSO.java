package com.project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.project.exception.MemberNotFoundException;

public class UserSO {

	@Autowired
	private UserDao userDao;
	
	@Transactional
	public void changePassword(String user_id, String oldPassword, String newPassword) {
		UserDO user = userDao.selectById(user_id);
		if(user == null) {
			throw new MemberNotFoundException();
		}
		
		user.changePassword(oldPassword, newPassword);
		userDao.updatePasswordUserInfo(user);
	}
}
