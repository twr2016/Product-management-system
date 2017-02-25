package com.course.loginuser.dao;

/*
 * 课程设计：产品管理系统
 * 姓名：汤文茹
 * 年级：2014级5班
 * 学号：2014011771
 * *
 */
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.course.entity.LoginUser;
import com.course.entity.Product;
import com.course.entity.UserInfo;
import com.framework.BaseDao;
import com.framework.Page;

@Repository
public class LoginUserDaoImpl extends BaseDao<LoginUser, String> {

	public LoginUser findByNameAndPwd(String name, String pwd) {
		// Query q=this.sessionFactory.getCurrentSession().createQuery("from
		// LoginUser lu where lu.loginName=? and lu.password=?");
		// q.setString(0, name);
		// q.setString(1, pwd);
		// return (LoginUser)q.uniqueResult();

		try {
			return super.findOne("from LoginUser lu where lu.loginName=? and lu.password=?",
					new Object[] { name, pwd });
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public LoginUser findByName(String name) {
		try {
			name = new String(name.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			return super.findOne("from LoginUser lu where lu.loginName=?", new Object[] { name });
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void saveLoginUser(LoginUser l) {
		System.out.println("name:" + l.getLoginName());
		try {
			// super.save(l);
			super.excuteBySql("insert into loginuser(loginname,password,email,roleid) value(?,?,?,?)",
					new Object[] { l.getLoginName(), l.getPassword(), l.getEmail(), l.getRole().getRoleId() });
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateLoginUser(LoginUser l) {
		try {
			this.update(l);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Page<LoginUser> findLoginUser(int pageNum, int pageSize, Object[] params) {
		String hql;
		if (params != null && params.length > 0) {
			hql = "from LoginUser l where l.loginName like ?";
			params[0] = "%" + params[0] + "%";

		} else {
			hql = "from LoginUser";
		}
		try {
			Page<LoginUser> page = new Page<LoginUser>();
			page.setCurrentPageNum(pageNum);
			page.setPageSize(pageSize);
			page = this.findByPage(pageNum, pageSize, hql, params);
			return page;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void deleteLoginUser(String name) {
		
		try {
			this.delete(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
