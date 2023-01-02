package com.stx.centre.core.tag.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.stx.centre.core.bean.BaseInfo;

@Entity
public class TagCodeHeader extends BaseInfo implements Serializable {

	/**
	 * Serial Version ID
	 */
	private static final long serialVersionUID = 2371967933399065403L;

	/**
	 * Tag Type
	 */
	@Id
	protected String tagType;
	
	/**
	 * Tag Description
	 */
	protected String tagDesc;
	
	/**
	 * Allow Change Indicator
	 */
	protected boolean allowChangeIdc;

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
	 * @return the tagDesc
	 */
	public String getTagDesc() {
		return tagDesc;
	}

	/**
	 * @param tagDesc the tagDesc to set
	 */
	public void setTagDesc(String tagDesc) {
		this.tagDesc = tagDesc;
	}

	/**
	 * @return the allowChangeIdc
	 */
	public boolean isAllowChangeIdc() {
		return allowChangeIdc;
	}

	/**
	 * @param allowChangeIdc the allowChangeIdc to set
	 */
	public void setAllowChangeIdc(boolean allowChangeIdc) {
		this.allowChangeIdc = allowChangeIdc;
	}
	
}
