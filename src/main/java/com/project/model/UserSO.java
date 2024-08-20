package com.project.model;

import com.project.model.request.editProfileRequest;
import com.project.model.response.LoginUserResponse;
import com.project.model.request.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
	public void SignupUser(SignupRequest request) {
		UserDO user = new UserDO(request.getUser_id(), request.getName(), request.getNickname(), request.getEmail(), request.getPassword(), null);
		userDao.insertUser(user);
	}

	@Transactional
	public void editProfile(String userId, editProfileRequest request) {
		UserDO user = new UserDO(userId, request.getName(), request.getNickname(), request.getEmail());
		userDao.updateUser(user);
	}



	@Transactional
	public void changePassword(String user_id, String oldPasswd, String newPasswd) {
		UserDO user = userDao.selectById(user_id);
		if(user == null) {
			throw new MemberNotFoundException();
		}
		
		user.changePassword(oldPasswd, newPasswd);
		userDao.updatePasswordUserInfo(user);
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

	public LoginUserResponse login(String user_id, String password) {
		UserDO user;
		try {
			user = userDao.login(user_id, password);
		} catch (WrongIdPasswordException e) {
			throw new WrongIdPasswordException();
		}

		return new LoginUserResponse(user.getUser_id(), user.getNickname());
	}
	
	public boolean checkIsUserID(String name, String email) {
		boolean checkResult = false;
		
		try {
			this.userDao.findID(name, email);
			checkResult = true;
		}
		
		catch(EmptyResultDataAccessException ex) {
			ex.getStackTrace();
		}
		
		return checkResult;
	}
}
