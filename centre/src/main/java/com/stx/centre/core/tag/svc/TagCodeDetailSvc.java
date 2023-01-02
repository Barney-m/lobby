package com.stx.centre.core.tag.svc;

import java.util.List;

import com.stx.centre.core.orm.IBaseORM;
import com.stx.centre.core.tag.bean.TagCodeDetail;
import com.stx.centre.core.tag.bean.TagCodePK;

public interface TagCodeDetailSvc extends IBaseORM<TagCodeDetail, TagCodePK> {

	/**
	 * Find All Tag Code Details
	 * 
	 * @param tagType
	 * @return {@link List<TagCodeDetail>}
	 */
	List<TagCodeDetail> findAll();
	
	/**
	 * Find All Tag Code Detail By Tag Type
	 * 
	 * @param tagType
	 * @return {@link List<TagCodeDetail>}
	 */
	List<TagCodeDetail> findByTagType(String tagType);
	
	/**
	 * Find All Tag Code Detail By Tag Type And Tag Code
	 * 
	 * @param tagType
	 * @param tagCode
	 * @return {@link TagCodeDetail}
	 */
	TagCodeDetail findByTagTypeAndTagCode(String tagType, String tagCode);
}
