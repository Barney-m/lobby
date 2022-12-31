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
	@Column(name = "modified", nullable = false)
	protected Long modified;
	
	/**
	 * Created By
	 */
	@Column(name = "created_by", nullable = false)
	protected String createdBy;
	
	/**
	 * Created At
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	protected Date createdAt;
	
	/**
	 * Updated By
	 */
	@Column(name = "updated_by", nullable = false)
	protected String updatedBy;
	
	/**
	 * Updated At
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = false)
	protected Date updatedAt;

	/**
	 * @return the modified
	 */
	public Long getModified() {
		return modified;
	}

	/**
	 * @param modified the modified to set
	 */
	public void setModified(Long modified) {
		this.modified = modified;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
