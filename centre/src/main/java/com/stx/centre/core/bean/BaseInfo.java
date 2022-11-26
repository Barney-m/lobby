package com.stx.centre.core.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class BaseInfo {
	
	/**
	 * Modified Count
	 */
	@Column(name = "mdf_cnt", nullable = false)
	protected Long mdfCnt;
	
	/**
	 * Created By
	 */
	@Column(name = "crt_by", nullable = false)
	protected String crtBy;
	
	/**
	 * Created At
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "crt_at", nullable = false)
	protected Date crtAt;
	
	/**
	 * Updated By
	 */
	@Column(name = "upd_by", nullable = false)
	protected String updBy;
	
	/**
	 * Updated At
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "upd_at", nullable = false)
	protected Date updAt;

	/**
	 * @return the mdfCnt
	 */
	public Long getMdfCnt() {
		return mdfCnt;
	}

	/**
	 * @param mdfCnt the mdfCnt to set
	 */
	public void setMdfCnt(Long mdfCnt) {
		this.mdfCnt = mdfCnt;
	}

	/**
	 * @return the crtBy
	 */
	public String getCrtBy() {
		return crtBy;
	}

	/**
	 * @param crtBy the crtBy to set
	 */
	public void setCrtBy(String crtBy) {
		this.crtBy = crtBy;
	}

	/**
	 * @return the crtAt
	 */
	public Date getCrtAt() {
		return crtAt;
	}

	/**
	 * @param crtAt the crtAt to set
	 */
	public void setCrtAt(Date crtAt) {
		this.crtAt = crtAt;
	}

	/**
	 * @return the updBy
	 */
	public String getUpdBy() {
		return updBy;
	}

	/**
	 * @param updBy the updBy to set
	 */
	public void setUpdBy(String updBy) {
		this.updBy = updBy;
	}

	/**
	 * @return the updAt
	 */
	public Date getUpdAt() {
		return updAt;
	}

	/**
	 * @param updAt the updAt to set
	 */
	public void setUpdAt(Date updAt) {
		this.updAt = updAt;
	}

}
