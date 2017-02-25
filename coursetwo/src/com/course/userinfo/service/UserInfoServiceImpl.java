package com.course.userinfo.service;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.course.entity.LoginUser;
import com.course.entity.UserInfo;
import com.course.loginuser.dao.LoginUserDaoImpl;
import com.course.userinfo.dao.UserInfoDaoImpl;
import com.framework.Page;

@Service
@Transactional(readOnly = true)
public class UserInfoServiceImpl {

	@Resource
	private UserInfoDaoImpl userInfoDaoImpl;

	@Transactional(readOnly = false)
	public void addUserInfo(UserInfo u) {
		this.userInfoDaoImpl.saveUserInfo(u);
	}

	@Transactional(readOnly = false)
	public void editUserInfo(UserInfo u) {
		String name = u.getLoginName();
		try {
			name = new String(name.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserInfo ui = this.userInfoDaoImpl.getUserInfo(name);
		ui.setRealName(u.getRealName());
		ui.setBirthday(u.getBirthday());
		ui.setLoginUser(u.getLoginUser());
		this.userInfoDaoImpl.updateUserInfo(ui);
	}

	@Transactional(readOnly = true)
	public UserInfo getUserInfo(String name) {

		return this.userInfoDaoImpl.getUserInfo(name);
	}

	@Transactional(readOnly = true)
	public Page<UserInfo> listUserInfo(int pageNum, int pageSize, Object[] params) {
		return this.userInfoDaoImpl.findUserInfo(pageNum, pageSize, params);
	}

	@Transactional(readOnly = false)
	public void dropUserInfo(String name) {

		this.userInfoDaoImpl.deleteUserInfo(name);
	}
}
