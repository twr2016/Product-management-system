package com.course.role.dao;

/*
 * 课程设计：产品管理系统
 * 姓名：汤文茹
 * 年级：2014级5班
 * 学号：2014011771
 * *
 */
import org.springframework.stereotype.Repository;

import com.course.entity.Role;
import com.framework.BaseDao;
import com.framework.Page;

@Repository
public class RoleDaoImpl extends BaseDao<Role, Integer> {

	public void saveRole(Role r) {
		try {
			this.save(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Page<Role> findRole(int pageNum, int pageSize, Object[] params) {
		String hql;
		if (params != null && params.length > 0) {
			hql = "from Role r where r.name like ?";
			params[0] = "%" + params[0] + "%";

		} else {
			hql = "from Role";
		}
		try {
			Page<Role> page = new Page<Role>();
			page.setCurrentPageNum(pageNum);
			page.setPageSize(pageSize);
			page = this.findByPage(pageNum, pageSize, hql, params);
			return page;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Role getRole(int roleId) {

		try {
			Role r = this.get(roleId);
			return r;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public void updateRole(Role r) {
		try {
			this.update(r);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteRole(int roleId) {
		try {
			this.delete(roleId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
