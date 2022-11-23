package com.stx.workshop.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Customized RuntimeException
 * 
 * @author Ken Shen
 * @version 1.0
 */
public class SvcException extends RuntimeException {
	
	private static final long serialVersionUID = -6086099031627193511L;

	/**
	 * Error Message
	 */
	protected String msg;
	
	/**
	 * Exception ID
	 */
	protected String exId;
	
	/**
	 * Exception Parameters
	 */
	protected Object[] params;
	
	/**
	 * Nested Exceptions
	 */
	protected List<SvcException> nstExs;
	
	/**
	 * Wrapped Exception
	 */
	protected Throwable wrpEx;
	
	/**
	 * Initialize SvcException
	 */
	public SvcException() {
		super();
		gnrExUid();
	}
	
	/**
	 * Initialize SvcException
	 * 
	 * @param msg - Error Message
	 */
	public SvcException(String msg) {
		super(msg);
		this.msg = msg;
		gnrExUid();
	}
	
	/**
	 * Initialize SvcException
	 * 
	 * @param msg - Error Message
	 * @param params - Exception Parameters
	 */
	public SvcException(String msg, Object[] params) {
		super(msg);
		this.params = params;
		gnrExUid();
	}
	
	/**
	 * Initialize SvcException
	 * 
	 * @param ex - Wrapped Exception
	 */
	public SvcException(Throwable ex) {
		super(ex);
		this.wrpEx = ex;
		gnrExUid();
	}
	
	/**
	 * Initialize SvcException
	 * 
	 * @param msg - Error Message
	 * @param ex - Wrapped Exception
	 */
	public SvcException(String msg, Throwable ex) {
		this(msg);
		this.wrpEx = ex;
		gnrExUid();
	}
	
	/**
	 * Initialize SvcException
	 * 
	 * @param msg - Error Message
	 * @param params - Exception Parameters
	 * @param ex - Wrapped Exception
	 */
	public SvcException(String msg, Object[] params, Throwable ex) {
		this(msg, params);
		this.params = params;
		this.wrpEx = ex;
		gnrExUid();
	}
	
	/**
	 * Add Nested Exception
	 * 
	 * @param svcEx - SvcException
	 */
	public void addNstEx(SvcException svcEx) {
		if (null == nstExs) {
			nstExs = new ArrayList<>();
		}
		
		nstExs.add(svcEx);
	}
	
	/**
	 * @return nstExs - Nested Exceptions
	 */
	public List<SvcException> getNstExs() {
		return nstExs;
	}
	
	/**
	 * @param nstExs - Nested Exceptions
	 */
	public void setNstExs(List<SvcException> nstExs) {
		this.nstExs = nstExs;
	}
	
	/**
	 * @return wrpEx - Wrapped Exception
	 */
	public Throwable getWrpEx() {
		return wrpEx;
	}
	
	/**
	 * @param wrpEx - Wrapped Exception
	 */
	public void setWrpEx(Throwable wrpEx) {
		this.wrpEx = wrpEx;
	}
	
	/**
	 * @return params - Exception Parameters
	 */
	public Object[] getParams() {
		return params;
	}
	
	/**
	 * @param params - Exception Parameters
	 */
	public void setParams(Object[] params) {
		this.params = params;
	}
	
	/**
	 * @return msg - Error Message
	 */
	public String getMsg() {
		return msg;
	}
	
	/**
	 * @param msg - Error Message
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	/**
	 * @return exId - Exception ID
	 */
	public String getExId() {
		return exId;
	}
	
	/**
	 * @param exId - Exception ID
	 */
	public void setExId(String exId) {
		this.exId = exId;
	}
	
	/**
	 * @see java.lang.Throwable#getCause()
	 */
	@Override
	public synchronized Throwable getCause() {
		return this.wrpEx;
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder exBld = new StringBuilder();
		exBld.append("SvcException { ")
				.append("Message=").append(msg)
				.append(" Exception ID=").append(exId)
				.append(" Parameters=").append(Arrays.toString(params))
				.append(" Nested Exceptions=").append(nstExs)
				.append(" Wrapped Exception=").append(wrpEx)
				.append(" }");
		return exBld.toString();
	}
	
	/**
	 * Generate Exception ID
	 */
	private void gnrExUid() {
		UUID uid = UUID.randomUUID();
		
		int hashUid = uid.toString().hashCode();
		this.exId = String.valueOf(hashUid).replace("-", "");
	}
}
