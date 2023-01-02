package com.stx.centre.core.tag.bean;

import java.io.Serializable;
import java.util.Objects;

public class TagCodePK implements Serializable {

	private static final long serialVersionUID = 3134648598507455608L;

	/**
	 * Tag Type
	 */
	protected String tagType;
	
	/**
	 * Tag Code
	 */
	protected String tagCode;

    public TagCodePK(String tagType, String tagCode) {
        this.tagType = tagType;
        this.tagCode = tagCode;
    }

    public TagCodePK() {
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

    @Override
    public boolean equals(Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        TagCodePK pk = (TagCodePK) o;
        return Objects.equals( tagType, pk.tagType ) &&
                Objects.equals( tagCode, pk.tagCode );
    }

    @Override
    public int hashCode() {
        return Objects.hash( tagType, tagCode );
    }

}