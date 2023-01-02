package com.stx.centre.core.tag.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.stx.centre.core.bean.BaseInfo;

@Entity
public class TagCodeGroup extends BaseInfo implements Serializable {
	
	/**
	 * Serial Version ID
	 */
	private static final long serialVersionUID = -2238482407104192219L;

	/**
	 * Tag Group Code
	 */
	@Id
	protected String tagGroupCode;
	
	/**
	 * Tag Type
	 */
	protected String tagType;
	
	/**
	 * Tag Group Description
	 */
	protected String tagGroupDesc;

	/**
	 * @return the tagGroupCode
	 */
	public String getTagGroupCode() {
		return tagGroupCode;
	}

	/**
	 * @param tagGroupCode the tagGroupCode to set
	 */
	public void setTagGroupCode(String tagGroupCode) {
		this.tagGroupCode = tagGroupCode;
	}

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
	 * @return the tagGroupDesc
	 */
	public String getTagGroupDesc() {
		return tagGroupDesc;
	}

	/**
	 * @param tagGroupDesc the tagGroupDesc to set
	 */
	public void setTagGroupDesc(String tagGroupDesc) {
		this.tagGroupDesc = tagGroupDesc;
	}
	
}
