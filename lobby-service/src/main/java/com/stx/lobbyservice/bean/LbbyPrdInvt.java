package com.stx.lobbyservice.bean;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.stx.centre.core.bean.BaseInfo;

@Entity
public class LbbyPrdInvt extends BaseInfo {
	
	/**
	 * Product ID
	 */
	@Id
	protected Long prdId;
	
	/**
	 * Stocks
	 */
	protected Long stock;
	
	/**
	 * Supplier Code
	 */
	protected String splrCode;
	
	/**
	 * Supplied Quantity
	 */
	protected Long splQty;
	
	/**
	 * Supply Outstanding Quantity
	 */
	protected Long splOstQty;
	
	/**
	 * Supply Outstanding Quantity Due Date
	 */
	protected Date splOstQtyDueDt;
	
	/**
	 * Outstanding Amount
	 */
	protected BigDecimal ostAmt;
	
	/**
	 * Outstanding Amount Due Date
	 */
	protected Date ostAmtDueDt;

	public Long getPrdId() {
		return prdId;
	}

	public void setPrdId(Long prdId) {
		this.prdId = prdId;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public String getSplrCode() {
		return splrCode;
	}

	public void setSplrCode(String splrCode) {
		this.splrCode = splrCode;
	}

	public Long getSplQty() {
		return splQty;
	}

	public void setSplQty(Long splQty) {
		this.splQty = splQty;
	}

	public Long getSplOstQty() {
		return splOstQty;
	}

	public void setSplOstQty(Long splOstQty) {
		this.splOstQty = splOstQty;
	}

	public Date getSplOstQtyDueDt() {
		return splOstQtyDueDt;
	}

	public void setSplOstQtyDueDt(Date splOstQtyDueDt) {
		this.splOstQtyDueDt = splOstQtyDueDt;
	}

	public BigDecimal getOstAmt() {
		return ostAmt;
	}

	public void setOstAmt(BigDecimal ostAmt) {
		this.ostAmt = ostAmt;
	}

	public Date getOstAmtDueDt() {
		return ostAmtDueDt;
	}

	public void setOstAmtDueDt(Date ostAmtDueDt) {
		this.ostAmtDueDt = ostAmtDueDt;
	}
	
	
}
