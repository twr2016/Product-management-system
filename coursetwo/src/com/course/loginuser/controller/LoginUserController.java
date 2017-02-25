package com.course.loginuser.controller;

/*
 * 课程设计：产品管理系统
 * 姓名：汤文茹
 * 年级：2014级5班
 * 学号：2014011771
 * *
 */
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.course.entity.LoginUser;
import com.course.entity.Menu;
import com.course.entity.Power;
import com.course.entity.Product;
import com.course.entity.Role;
import com.course.entity.UserInfo;
import com.course.loginuser.service.LoginUserServiceImpl;
import com.course.role.controller.RoleController;
import com.course.role.service.RoleServiceImpl;
import com.course.userinfo.service.UserInfoServiceImpl;
import com.framework.Page;

@Controller
@RequestMapping("loginuser")
public class LoginUserController {

	@Resource
	private LoginUserServiceImpl loginUserServiceImpl;
	@Resource
	private RoleServiceImpl roleServiceImpl;
	@Resource
	private UserInfoServiceImpl userinfoServiceImpl;

	@RequestMapping("add")
	public String add(@RequestParam(value = "loginName", required = false) String name,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "roleid", required = false) int roleid,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "realName", required = false) String realName,
			@RequestParam(value = "birthday", required = false) String birthday) {
		LoginUser l = new LoginUser();
		try {
			name = new String(name.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			realName = new String(realName.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		l.setLoginName(name);
		l.setEmail(email);
		l.setPassword(password);
		Role r = new Role();
		r = this.roleServiceImpl.getRole(roleid);
		l.setRole(r);
		UserInfo u=new UserInfo();
		u.setLoginUser(l);
		u.setBirthday(birthday);
		u.setRealName(realName);
		this.userinfoServiceImpl.addUserInfo(u);
		l.setUserInfo(u);
		System.out.println(l.getRole().getRoleId());
		this.loginUserServiceImpl.addLoginUser(l);
		return "redirect:list";
	}

	@RequestMapping("login")
	public String login(@RequestParam(value = "loginName", required = false) String name,
			@RequestParam(value = "password", required = false) String password, HttpSession session) {
		try {
			name = new String(name.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LoginUser lu = this.loginUserServiceImpl.login(name, password);
		if (lu != null) {
			session.setAttribute("realName", lu.getRole().getName());
			session.setAttribute("name", lu.getLoginName());
			Set<Power> set = lu.getRole().getPris();
			Iterator i = set.iterator();
			HashMap menus = new HashMap();
			while (i.hasNext()) {
				Menu menu = (Menu) ((Power) i.next()).getMenu();
				Menu pmenu = menu.getParentMenu();
				if (!menus.containsKey(pmenu)) {
					List list = new ArrayList();
					menus.put(pmenu, list);
				}
				((List) menus.get(pmenu)).add(menu);
			}
			session.setAttribute("menus", menus);
			return "main";
		} else {
			return "login";
		}
	}

	@RequestMapping("regist")
	public String regist(@RequestParam(value = "loginName", required = false) String name,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "roleid", required = false) int roleid,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "realName", required = false) String realName,
			@RequestParam(value = "birthday", required = false) String birthday) {
		LoginUser l = new LoginUser();
		try {
			name = new String(name.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			realName = new String(realName.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		l.setLoginName(name);
		l.setEmail(email);
		l.setPassword(password);
		Role r = new Role();
		r = this.roleServiceImpl.getRole(roleid);
		l.setRole(r);
		UserInfo u=new UserInfo();
		u.setLoginUser(l);
		u.setBirthday(birthday);
		u.setRealName(realName);
		this.userinfoServiceImpl.addUserInfo(u);
		l.setUserInfo(u);
		System.out.println(l.getRole().getRoleId());
		this.loginUserServiceImpl.addLoginUser(l);

		return "login";
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String toEdit(@RequestParam(value = "loginName", required = false) String name, HttpServletRequest request) {
		LoginUser l = this.loginUserServiceImpl.getLoginUser(name);
		request.setAttribute("l", l);
		request.setAttribute("action", "edit");
		return "loginuser/form";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(@RequestParam(value = "loginName", required = false) String name,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "roleid", required = false) int roleid,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "realName", required = false) String realName,
			@RequestParam(value = "birthday", required = false) String birthday,HttpServletRequest request) {
		try {
			name = new String(name.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			realName = new String(realName.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LoginUser l = this.loginUserServiceImpl.getLoginUser(name);
		l.setEmail(email);
		l.setPassword(password);
		Role r = new Role();
		r = this.roleServiceImpl.getRole(roleid);
		l.setRole(r);
		UserInfo u=l.getUserInfo();
		u.setBirthday(birthday);
		u.setRealName(realName);
		this.loginUserServiceImpl.editLoginUser(l);
		return "redirect:list";
	}

	@RequestMapping(value = "edito", method = RequestMethod.GET)
	public String toEdito(@RequestParam("loginName") String name, HttpServletRequest request) {

		try {
			name = new String(name.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("to edito"+name);
		LoginUser l = this.loginUserServiceImpl.getLoginUser(name);
		request.setAttribute("l", l);
		request.setAttribute("action", "edito");
		return "redirect:login";
	}

	@RequestMapping(value = "edito", method = RequestMethod.POST)
	public String edito(LoginUser l, HttpServletRequest request) {
		String name=l.getLoginName();
		try {
			name = new String(name.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LoginUser lu=this.loginUserServiceImpl.getLoginUser(name);
		lu.setEmail(l.getEmail());
		lu.setPassword(l.getPassword());
		this.loginUserServiceImpl.editLoginUser(lu);
		return "login";
	}

	@RequestMapping("list")
	public String list(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum,
			@RequestParam(name = "searchParam", defaultValue = "") String searchParam, HttpServletRequest request,
			Model model) {
		Page<LoginUser> page;
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
			page = this.loginUserServiceImpl.listLoginUser(pageNum, 5, null);
		} else {
			page = this.loginUserServiceImpl.listLoginUser(pageNum, 5, new Object[] { searchParam });
		}
		request.setAttribute("page", page);
		request.setAttribute("searchParam", searchParam);
		return "loginuser/list";

	}

	@RequestMapping(value = "delete")
	public String delete(@RequestParam("loginName") String name, HttpServletRequest request) {
		String temp = name;
		try {
			temp = new String(temp.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("delete controller"+temp);
		this.loginUserServiceImpl.dropLoginUser(temp);
		;
		return "redirect:list";
	}

	@RequestMapping("deleteall")
	public String deleteall(@RequestParam("values") String[] values, HttpServletRequest request) {
		for (int i = 0; i < values.length; i++) {
			this.loginUserServiceImpl.dropLoginUser(values[i]);
		}

		return "redirect:list";
	}
}