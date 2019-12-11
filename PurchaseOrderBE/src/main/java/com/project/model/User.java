package com.project.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Table_User")
public class User {


	@Id
	//@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="User_Id")
	private int  userId;
	
	
	@Column(name="User_Name")
	//@Pattern(regexp="[^0-9]*", message="Enter valid name")
	//@NotEmpty
	private String userName;
	
	@Column(name="User_Email")
	//@NotEmpty
	//@Email(message="email is not valid")
	private String userEmail;
			
	@Column(name="User_Address")
	//@NotEmpty
	private String userAddress;
	
	@Column(name="User_Mobile")
	//@NotNull
	private long userPhone;

	@Column(name="User_IsActive")
	private String isActive;
	
	@Column(name="Created_Date")
	private LocalDate createdDate;
	
	@Column(name="Updated_Date")
	private LocalDate updatedDate;
	
	@Column(name="Created_By")
	private String createdBy;
	
	@Column(name="Updated_By")
	private String updatedBy;
	
	@Column(name="User_password")
	//@NotEmpty
	//@Size(min = 4, max = 16 ,message="Enter password")
	private String userPass;
	
	@Column(name="User_Role")
	private String role;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public long getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(long userPhone) {
		this.userPhone = userPhone;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userAddress="
				+ userAddress + ", userPhone=" + userPhone + ", isActive=" + isActive + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy
				+ ", userPass=" + userPass + ", role=" + role + "]";
	}
	
	
	
	
	
}
