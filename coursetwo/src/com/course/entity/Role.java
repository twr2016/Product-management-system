package com.course.entity;

/*
 * �γ���ƣ���Ʒ����ϵͳ
 * ������������
 * �꼶��2014��5��
 * ѧ�ţ�2014011771
 * *
 */
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

	private Integer roleId;
	private String name;

	private Set<Power> pris = new HashSet<Power>(0);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "rolename")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "role_pri", joinColumns = {
			@JoinColumn(name = "roleid", referencedColumnName = "roleid") }, inverseJoinColumns = {
					@JoinColumn(name = "powerid", referencedColumnName = "powerid") })
	public Set<Power> getPris() {
		return pris;
	}

	public void setPris(Set<Power> pris) {
		this.pris = pris;
	}

}
