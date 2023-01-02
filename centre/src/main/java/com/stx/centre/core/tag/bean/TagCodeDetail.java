package com.stx.centre.core.tag.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.stx.centre.core.bean.BaseInfo;

@Entity
@IdClass(TagCodePK.class)
public class TagCodeDetail extends BaseInfo implements Serializable {

	/**
	 * Serial Version ID
	 */
	private static final long serialVersionUID = -2578976484315790548L;

	/**
	 * Tag Type
	 */
	@Id
	protected String tagType;
	
	/**
	 * Tag Code
	 */
	@Id
	protected String tagCode;
	
	/**
	 * Tag Code Description
	 */
	protected String tagCodeDesc;
	
	/**
	 * Tag Group Codes
	 */
	protected String tagGroupCodes;
	
	/**
	 * Tag Code Status
	 */
	protected String tagCodeStatus;

	/**
	 * @return the tagType
	 */
	public String getTagType() {
		return tagType;
	}

	/**
	 * @param tagType the tagType to set
	 */
	public void setTagType(String tagType) {
		this.tagType = tagType;
	}

	/**
	 * @return the tagCode
	 */
	public String getTagCode() {
		return tagCode;
	}

	/**
	 * @param tagCode the tagCode to set
	 */
	public void setTagCode(String tagCode) {
		this.tagCode = tagCode;
	}

	/**
	 * @return the tagCodeDesc
	 */
	public String getTagCodeDesc() {
		return tagCodeDesc;
	}

	/**
	 * @param tagCodeDesc the tagCodeDesc to set
	 */
	public void setTagCodeDesc(String tagCodeDesc) {
		this.tagCodeDesc = tagCodeDesc;
	}

	/**
	 * @return the tagGroupCodes
	 */
	public List<String> getTagGroupCodes() {
		return Arrays.asList(tagGroupCodes.split(","));
	}

	/**
	 * @param tagGroupCodes the tagGroupCodes to set
	 */
	public void setTagGroupCodes(List<String> tagGroupCodes) {
		this.tagGroupCodes = String.join(",", tagGroupCodes);
	}

	/**
	 * @return the tagCodeStatus
	 */
	public String getTagCodeStatus() {
		return tagCodeStatus;
	}

	/**
	 * @param tagCodeStatus the tagCodeStatus to set
	 */
	public void setTagCodeStatus(String tagCodeStatus) {
		this.tagCodeStatus = tagCodeStatus;
	}
	
}
