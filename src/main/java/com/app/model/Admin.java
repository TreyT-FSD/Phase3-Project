package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long adminId;
	
	@Column
	private String adminUsername;
	
	@Column
	private String adminPwd;
	
	public Admin() {
		super();
	}
	
	public Admin(String adminUsername, String adminPwd) {
		super();
		this.adminUsername = adminUsername;
		this.adminPwd = adminPwd;
	}

	public Admin(long adminId, String adminUsername, String adminPwd) {
		super();
		this.adminId = adminId;
		this.adminUsername = adminUsername;
		this.adminPwd = adminPwd;
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminUsername=" + adminUsername + ", adminPwd=" + adminPwd + "]";
	}
	
	
}
