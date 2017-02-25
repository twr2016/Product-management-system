package com.course.entity;

/*
 * 课程设计：产品管理系统
 * 姓名：汤文茹
 * 年级：2014级5班
 * 学号：2014011771
 * *
 */
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "userinfo")
public class UserInfo {
	private String loginName;
	private String realName;
	private String birthday;

	private LoginUser loginUser;

	@Id
	@GenericGenerator(name = "foreignkey", strategy = "foreign", parameters = @Parameter(value = "loginUser", name = "property") )
	@GeneratedValue(generator = "foreignkey")
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Column(name = "realname")
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@OneToOne
	@PrimaryKeyJoinColumn
	public LoginUser getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(LoginUser loginUser) {
		this.loginUser = loginUser;
	}

}
