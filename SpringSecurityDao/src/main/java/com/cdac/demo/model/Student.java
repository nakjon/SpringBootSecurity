package com.cdac.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
     
	@Id
	@GeneratedValue
	private Integer sid;
	private String sname;
	private String password;
	private String srole;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSrole() {
		return srole;
	}
	public void setSrole(String srole) {
		this.srole = srole;
	}
	
	
}
