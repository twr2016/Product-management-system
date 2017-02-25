package com.course.role.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.course.entity.Role;
import com.course.role.service.RoleServiceImpl;
import com.framework.Page;

@Controller
@RequestMapping("role")
public class RoleController {

	@Resource
	private RoleServiceImpl roleServiceImpl;
	
	@RequestMapping("add")
	public String add(Role role){
		String temp=role.getName();
		try {
			temp=new String(temp.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		role.setName(temp);
		this.roleServiceImpl.addRole(role);
		return "redirect:list";
	}
	
	@RequestMapping(value="edit",method=RequestMethod.GET)
	public String toEdit(@RequestParam("roleId") int roleId,
			HttpServletRequest request){
		Role r=this.roleServiceImpl.getRole(roleId);
		
		request.setAttribute("r", r);
		request.setAttribute("action", "edit");
		return "role/form";
	}
	
	@RequestMapping(value="edit",method=RequestMethod.POST)
	public String edit(Role r,HttpServletRequest request){
		String temp=r.getName();
		try {
			temp=new String(temp.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.setName(temp);
		this.roleServiceImpl.editRole(r);
		return "redirect:list";
	}

	@RequestMapping(value = "delete")
	public String delete(@RequestParam("roleId") int roleId, HttpServletRequest request) {
		this.roleServiceImpl.dropRole(roleId);
		return "redirect:list";
	}
	
	@RequestMapping("list")
	public String list(@RequestParam(name="pageNum", defaultValue="1") int pageNum,
			@RequestParam(name="searchParam",defaultValue="") String searchParam,HttpServletRequest request,
			Model model){
		Page<Role> page;
		System.out.println(searchParam);
		String temp=searchParam;
		try {
			temp=new String(temp.getBytes("iso-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		searchParam=temp;
		if(searchParam==null || "".equals(searchParam)){
			page=this.roleServiceImpl.listRole(pageNum, 5, null);	
		}else{
			page=this.roleServiceImpl.listRole(pageNum, 5, new Object[]{searchParam});
		}
		request.setAttribute("page", page);
		request.setAttribute("searchParam", searchParam);
		return "role/list";
		
	}
	@RequestMapping("deleteall")
	public String deleteall(@RequestParam("values") String[] values, HttpServletRequest request) {
		for(int i=0;i<values.length;i++){
			this.roleServiceImpl.dropRole(Integer.parseInt(values[i]));
		}
		
		return "redirect:list";
	}

	public RoleServiceImpl getRoleServiceImpl() {
		
		return roleServiceImpl;
	}

	public void setRoleServiceImpl(RoleServiceImpl roleServiceImpl) {
		this.roleServiceImpl = roleServiceImpl;
	} 
	
	
}


