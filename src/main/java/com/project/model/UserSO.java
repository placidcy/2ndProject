package com.project.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.exception.MemberNotFoundException;

@Service
public class UserSO {

	private final UserDao userDao;
	@Autowired
	public UserSO(UserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional
	public void changePassword(String user_id, String oldPassword, String newPassword) {
		UserDO user = userDao.selectById(user_id);
		if(user == null) {
			throw new MemberNotFoundException();
		}
		
		user.changePassword(oldPassword, newPassword);
		userDao.updatePasswordUserInfo(user);
	}

	public UserDO login(String user_id, String password) {
        return userDao.selectById(user_id);
	}
}
