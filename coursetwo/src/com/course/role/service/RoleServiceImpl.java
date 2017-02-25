package com.course.role.service;

/*
 * 课程设计：产品管理系统
 * 姓名：汤文茹
 * 年级：2014级5班
 * 学号：2014011771
 * *
 */
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.course.entity.Role;
import com.course.role.dao.RoleDaoImpl;
import com.framework.Page;

@Service
@Transactional(readOnly = false)
public class RoleServiceImpl {

	@Resource
	private RoleDaoImpl roleDaoImpl;

	public void addRole(Role r) {
		System.out.println("role");
		this.roleDaoImpl.saveRole(r);
	}

	@Transactional(readOnly = true)
	public Page<Role> listRole(int pageNum, int pageSize, Object[] params) {
		return this.roleDaoImpl.findRole(pageNum, pageSize, params);
	}

	@Transactional(readOnly = true)
	public Role getRole(int roleId) {

		return this.roleDaoImpl.getRole(roleId);
	}

	public void editRole(Role r) {
		Role role = this.roleDaoImpl.getRole(r.getRoleId());
		role.setName(r.getName());
		this.roleDaoImpl.updateRole(role);
	}

	public void dropRole(int RoleId) {
		this.roleDaoImpl.deleteRole(RoleId);
	}

}
