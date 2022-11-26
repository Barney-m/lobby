package com.stx.lobbyservice.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.stx.centre.core.bean.BaseInfo;

@Entity
public class LbbyAttd extends BaseInfo {
	
	/**
	 * Attendance ID
	 */
	@Id
	@GeneratedValue
	protected Long attdId;
	
	/**
	 * Email
	 */
	@Column
	protected String email;
	
	/**
	 * Signed Method
	 */
	@Column
	protected String signMtd;
	
	/**
	 * Duty Type
	 */
	@Column(name="duty_t", length=100)
	protected String dutyT;
	
	/**
	 * Duty Description
	 */
	@Column
	protected String dutyDsc;
	
	/**
	 * Start Time
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	protected Date sttTime;
	
	/**
	 * End Time
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column
	protected Date endTime;

	/**
	 * @return the attdId
	 */
	public Long getAttdId() {
		return attdId;
	}

	/**
	 * @param attdId the attdId to set
	 */
	public void setAttdId(Long attdId) {
		this.attdId = attdId;
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
	 * @return the signMtd
	 */
	public String getSignMtd() {
		return signMtd;
	}

	/**
	 * @param signMtd the signMtd to set
	 */
	public void setSignMtd(String signMtd) {
		this.signMtd = signMtd;
	}

	/**
	 * @return the dutyT
	 */
	public String getDutyT() {
		return dutyT;
	}

	/**
	 * @param dutyT the dutyT to set
	 */
	public void setDutyT(String dutyT) {
		this.dutyT = dutyT;
	}

	/**
	 * @return the dutyDsc
	 */
	public String getDutyDsc() {
		return dutyDsc;
	}

	/**
	 * @param dutyDsc the dutyDsc to set
	 */
	public void setDutyDsc(String dutyDsc) {
		this.dutyDsc = dutyDsc;
	}

	/**
	 * @return the sttTime
	 */
	public Date getSttTime() {
		return sttTime;
	}

	/**
	 * @param sttTime the sttTime to set
	 */
	public void setSttTime(Date sttTime) {
		this.sttTime = sttTime;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
}
