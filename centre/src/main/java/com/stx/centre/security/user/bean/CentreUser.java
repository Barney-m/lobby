package com.stx.centre.security.user.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.StringUtils;

import com.stx.centre.core.bean.BaseInfo;

@Entity
public class CentreUser extends BaseInfo {
	/**
	 * User ID
	 */
	@Id
	protected String userId;
	
	/**
	 * Full Name
	 */
	protected String fullName;
	
	/**
	 * Email
	 */
	protected String email;
	
	/**
	 * Address
	 */
	protected String address;
	
	/**
	 * Date of Birth
	 */
	protected Date dob;
	
	/**
	 * Mobile No.
	 */
	protected String mobileNo;
	
	/**
	 * Rank
	 */
	protected String rank;
	
	/**
	 * User Status
	 */
	protected String userStatus;
	
	/**
	 * Is First Time Indicator
	 */
	protected boolean isFirstTimeIdc;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		if (StringUtils.isNotBlank(dob.toString())) {
			return dob;
		}
		
		return null;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return the rank
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}

	/**
	 * @return the userStatus
	 */
	public String getUserStatus() {
		return userStatus;
	}

	/**
	 * @param userStatus the userStatus to set
	 */
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	/**
	 * @return the isFirstTimeIdc
	 */
	public boolean isFirstTimeIdc() {
		return isFirstTimeIdc;
	}

	/**
	 * @param isFirstTimeIdc the isFirstTimeIdc to set
	 */
	public void setFirstTimeIdc(boolean isFirstTimeIdc) {
		this.isFirstTimeIdc = isFirstTimeIdc;
	}

}
