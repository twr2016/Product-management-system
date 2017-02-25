package com.course.userinfo.dao;

import org.springframework.stereotype.Repository;

import com.course.entity.Role;
import com.course.entity.UserInfo;
import com.framework.BaseDao;
import com.framework.Page;

@Repository
public class UserInfoDaoImpl extends BaseDao<UserInfo, Integer> {

	public void saveUserInfo(UserInfo u) {
		try {
			this.save(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Page<UserInfo> findUserInfo(int pageNum, int pageSize, Object[] params) {
		String hql;
		if (params != null && params.length > 0) {
			hql = "from UserInfo u where u.loginName like ?";
			params[0] = "%" + params[0] + "%";

		} else {
			hql = "from UserInfo";
		}
		try {
			Page<UserInfo> page = new Page<UserInfo>();
			page.setCurrentPageNum(pageNum);
			page.setPageSize(pageSize);
			page = this.findByPage(pageNum, pageSize, hql, params);
			return page;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public UserInfo getUserInfo(String name) {

		try {
			UserInfo u = this.get(name);
			return u;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void updateUserInfo(UserInfo u) {
		try {
			this.update(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteUserInfo(String name) {
		try {
			this.delete(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

