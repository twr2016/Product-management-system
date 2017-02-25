package com.course.userinfo.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.course.entity.LoginUser;
import com.course.entity.Menu;
import com.course.entity.Power;
import com.course.entity.Role;
import com.course.entity.UserInfo;
import com.course.loginuser.service.LoginUserServiceImpl;
import com.course.role.service.RoleServiceImpl;
import com.course.userinfo.service.UserInfoServiceImpl;
import com.framework.Page;

@Controller
@RequestMapping("userinfo")
public class UserInfoController {

	@Resource
	private LoginUserServiceImpl loginUserServiceImpl;
	@Resource
	private UserInfoServiceImpl userInfoServiceImpl;
	@Resource
	private RoleServiceImpl RoleServiceImpl;

	@RequestMapping("add")
	public String add(@RequestParam(value = "loginName", required = false) String name,
			@RequestParam(value = "realName", required = false) String realName,
			@RequestParam(value = "birthday", required = false) String birthday) {
		UserInfo u = new UserInfo();
		try {
			name = new String(name.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		u.setLoginName(name);
		u.setRealName(realName);
		u.setBirthday(birthday);
		LoginUser l = new LoginUser();
		l = this.loginUserServiceImpl.getLoginUser(name);
		u.setLoginUser(l);
		
		this.userInfoServiceImpl.addUserInfo(u);
		return "loginuser/list";
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String toEdit(@RequestParam(value = "loginName", required = false) String name, HttpServletRequest request) {
		try {
			name = new String(name.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserInfo u = this.userInfoServiceImpl.getUserInfo(name);
		request.setAttribute("u", u);
		request.setAttribute("action", "edit");
		return "loginuser/user";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(@RequestParam(value = "loginName", required = false) String name,
			@RequestParam(value = "realName", required = false) String realName,
			@RequestParam(value = "birthday", required = false) String birthday,@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "roleid", required = false) int roleId, HttpServletRequest request) {
		try {
			name = new String(name.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("userinfo edit controller"+name);
		UserInfo u = this.userInfoServiceImpl.getUserInfo(name);
		try {
			realName = new String(realName.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		u.setRealName(realName);
		u.setBirthday(birthday);
		LoginUser l = new LoginUser();
		l = this.loginUserServiceImpl.getLoginUser(name);
		Role r=this.RoleServiceImpl.getRole(roleId);
		l.setEmail(email);
		l.setPassword(password);
		l.setRole(r);
		u.setLoginUser(l);
		
		this.loginUserServiceImpl.editLoginUser(l);
		return "redirect:list";
	}

	@RequestMapping("list")
	public String list(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(name = "searchParam", defaultValue = "") String searchParam, HttpServletRequest request,
			Model model) {
		Page<UserInfo> page;
		System.out.println(searchParam);
		String temp = searchParam;
		try {
			temp = new String(temp.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		searchParam = temp;
		if (searchParam == null || "".equals(searchParam)) {
			page = this.userInfoServiceImpl.listUserInfo(pageNum, 5, null);
		} else {
			page = this.userInfoServiceImpl.listUserInfo(pageNum, 5, new Object[] { searchParam });
		}
		request.setAttribute("page", page);
		request.setAttribute("searchParam", searchParam);
		return "userinfo/list";

	}

}
