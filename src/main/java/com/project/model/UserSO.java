package com.project.model;

import com.project.model.response.LoginUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.exception.MemberNotFoundException;
import com.project.exception.WrongIdPasswordException;

@Service
public class UserSO {

	@Autowired
	private UserDao userDao;
	
	public UserSO() {
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


	public String login(String user_id, String password) {
        return userDao.login(user_id, password);
  }

	public LoginUserResponse findUser(String user_id) {
		UserDO user = userDao.selectById(user_id);

		return new LoginUserResponse(user.getUser_id(), user.getNickname());
  }
	
	public boolean checkLogin(String user_id, String password) {
		boolean result = false;
		try {
			userDao.login(user_id, password);	
			result = true;
		}catch(WrongIdPasswordException e){
			e.printStackTrace();
		}
		
        return result;

	}
}
