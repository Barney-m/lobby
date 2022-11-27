package com.stx.centre.security.user.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.stx.centre.core.bean.BaseInfo;

@Entity
public class CtrUsr extends BaseInfo{
	@Id
	protected String usrId;
	
	protected String fullNm;
	
	protected String email;
	
	protected String addr;
	
	protected Date dob;
	
	protected String mblNo;
	
	protected String rnk;
	
	protected String usrSts;
	
	protected boolean isFrtIdc;

	@JsonGetter("user_id")
	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	@JsonGetter("full_name")
	public String getFullNm() {
		return fullNm;
	}

	public void setFullNm(String fullNm) {
		this.fullNm = fullNm;
	}

	@JsonGetter("email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonGetter("address")
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@JsonGetter("dob")
	public Date getDob() {
		if (StringUtils.isBlank(dob.toString())) {
			return null;
		}

		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@JsonGetter("mobile_no")
	public String getMblNo() {
		return mblNo;
	}

	public void setMblNo(String mblNo) {
		this.mblNo = mblNo;
	}

	@JsonGetter("rank")
	public String getRnk() {
		return rnk;
	}

	public void setRnk(String rnk) {
		this.rnk = rnk;
	}

	@JsonGetter("user_status")
	public String getUsrSts() {
		return usrSts;
	}

	public void setUsrSts(String usrSts) {
		this.usrSts = usrSts;
	}

	@JsonGetter("is_frt_idc")
	public boolean isFrtIdc() {
		return isFrtIdc;
	}

	public void setFrtIdc(boolean isFrtIdc) {
		this.isFrtIdc = isFrtIdc;
	}
	
}
