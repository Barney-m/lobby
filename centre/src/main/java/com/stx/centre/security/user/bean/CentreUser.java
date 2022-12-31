package com.stx.centre.security.user.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.stx.centre.core.bean.BaseInfo;

@Entity
public class CentreUser extends BaseInfo {
	@Id
	protected String userId;
	
	protected String fullName;
	
	protected String email;
	
	protected String address;
	
	protected Date dob;
	
	protected String mobileNo;
	
	protected String rank;
	
	protected String userStatus;
	
	protected boolean isFirstTimeIdc;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		if (StringUtils.isBlank(dob.toString())) {
			return null;
		}

		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public boolean getIsFirstTimeIdc() {
		return isFirstTimeIdc;
	}

	public void setIsFirstTimeIdc(boolean isFirstTimeIdc) {
		this.isFirstTimeIdc = isFirstTimeIdc;
	}
	
}
