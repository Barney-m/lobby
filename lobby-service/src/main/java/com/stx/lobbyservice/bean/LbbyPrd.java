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
public class LbbyPrd extends BaseInfo {
	
	/**
	 * Product ID
	 */
	@Id
	@GeneratedValue
	protected Long prdId;
	
	/**
	 * Product Name
	 */
	protected String prdNm;
	
	/**
	 * Product Description
	 */
	protected String prdDsc;
	
	/**
	 * Product Type
	 */
	protected String prdT;
	
	/**
	 * Price Amount
	 */
	protected BigDecimal pceAmt;
	
	/**
	 * Price Amount Basis
	 */
	protected String pceAmtBas;
	
	/**
	 * Product Status
	 */
	protected String prdSts;

	public Long getPrdId() {
		return prdId;
	}

	public void setPrdId(Long prdId) {
		this.prdId = prdId;
	}

	public String getPrdNm() {
		return prdNm;
	}

	public void setPrdNm(String prdNm) {
		this.prdNm = prdNm;
	}

	public String getPrdDsc() {
		return prdDsc;
	}

	public void setPrdDsc(String prdDsc) {
		this.prdDsc = prdDsc;
	}

	public String getPrdT() {
		return prdT;
	}

	public void setPrdT(String prdT) {
		this.prdT = prdT;
	}

	public BigDecimal getPceAmt() {
		return pceAmt;
	}

	public void setPceAmt(BigDecimal pceAmt) {
		this.pceAmt = pceAmt;
	}

	public String getPceAmtBas() {
		return pceAmtBas;
	}

	public void setPceAmtBas(String pceAmtBas) {
		this.pceAmtBas = pceAmtBas;
	}

	public String getPrdSts() {
		return prdSts;
	}

	public void setPrdSts(String prdSts) {
		this.prdSts = prdSts;
	}
}
