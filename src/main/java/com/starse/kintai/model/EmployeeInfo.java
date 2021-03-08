package com.starse.kintai.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "employee_info")
public class EmployeeInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="employeeId")
	private int employeeId;	
	
	@Column(name = "name")
	@NotEmpty(message = "お名前を入力してください")
	private String name;

	@Column(name="mail", nullable = false, unique = true)
	private String mail;
	
	@Column(name="password")
	@NotEmpty(message = "暗証番号を入れてください")
	private String password;
	
	/*
	 * @Column(name="phone_no") private String phoneNo;
	 * 
	 * @Column(name="group_no") private String groupNo;
	 * 
	 * @Column(name="position") private String position;	 */
	
	private Role role;
		
		public enum Role{
			Admin, Employee
		}
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	/*
	 * public String getPhoneNo() { return phoneNo; }
	 * 
	 * public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }
	 * 
	 * public String getGroupNo() { return groupNo; }
	 * 
	 * public void setGroupNo(String groupNo) { this.groupNo = groupNo; }
	 * 
	 * public String getPosition() { return position; }
	 * 
	 * public void setPosition(String position) { this.position = position; }
	 */	
}
