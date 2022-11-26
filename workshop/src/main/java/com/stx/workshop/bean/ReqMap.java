package com.stx.workshop.bean;

import java.io.Serializable;
import java.util.Map;

public class ReqMap implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -72993854673485121L;
	protected Map<String, Object> reqMap;
	
	public Map<String, Object> getReqMap() {
		return reqMap;
	}
	
	public void setReqMap(Map<String, Object> reqMap) {
		this.reqMap = reqMap;
	}
}
