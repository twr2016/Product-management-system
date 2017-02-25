package com.course.loginuser.service;

/*
 * 课程设计：产品管理系统
 * 姓名：汤文茹
 * 年级：2014级5班
 * 学号：2014011771
 * *
 */
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.course.entity.LoginUser;
import com.course.entity.Product;
import com.course.loginuser.dao.LoginUserDaoImpl;
import com.framework.Page;

@Service
@Transactional(readOnly = true)
public class LoginUserServiceImpl {

	@Resource
	private LoginUserDaoImpl loginUserDaoImpl;

	@Transactional(readOnly = false)
	public void addLoginUser(LoginUser l) {
		this.loginUserDaoImpl.saveLoginUser(l);
		;
	}

	public LoginUser login(String name, String pwd) {
		return this.loginUserDaoImpl.findByNameAndPwd(name, pwd);
	}

	@Transactional(readOnly = false)
	public void editLoginUser(LoginUser l) {
		String name = l.getLoginName();
		try {
			name = new String(name.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LoginUser lu = this.loginUserDaoImpl.findByName(name);
		lu.setEmail(l.getEmail());
		lu.setPassword(l.getPassword());
		lu.setRole(l.getRole());
		lu.setUserInfo(l.getUserInfo());
		this.loginUserDaoImpl.updateLoginUser(lu);
	}

	@Transactional(readOnly = true)
	public LoginUser getLoginUser(String name) {

		return this.loginUserDaoImpl.findByName(name);
	}

	@Transactional(readOnly = true)
	public Page<LoginUser> listLoginUser(int pageNum, int pageSize, Object[] params) {
		return this.loginUserDaoImpl.findLoginUser(pageNum, pageSize, params);
	}

	@Transactional(readOnly = false)
	public void dropLoginUser(String name) {
		
		this.loginUserDaoImpl.deleteLoginUser(name);
	}
}
