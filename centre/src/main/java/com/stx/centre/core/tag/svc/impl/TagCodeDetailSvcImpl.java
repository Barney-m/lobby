package com.stx.centre.core.tag.svc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stx.centre.core.orm.BaseORM;
import com.stx.centre.core.tag.bean.TagCodeDetail;
import com.stx.centre.core.tag.bean.TagCodePK;
import com.stx.centre.core.tag.repo.TagCodeDetailRepo;
import com.stx.centre.core.tag.svc.TagCodeDetailSvc;
import com.stx.workshop.factory.ClassObjFactory;

@Service
public class TagCodeDetailSvcImpl extends BaseORM<TagCodeDetail, TagCodePK> implements TagCodeDetailSvc {

	@Autowired
	private TagCodeDetailRepo tagCodeDetailRepo;
	
	@Override
	protected void getClassObject() {
        this.clazz = TagCodeDetail.class;
    }
	
	/**
	 * @see com.stx.centre.core.tag.svc#findAllTagCodeDetails()
	 */
	public List<TagCodeDetail> findAll() {
		return tagCodeDetailRepo.findAll();
	}
	
	/**
	 * @see com.stx.centre.core.tag.svc.impl#findByTagType(String tagType)
	 */
	public List<TagCodeDetail> findByTagType(String tagType) {
		return tagCodeDetailRepo.findByTagType(tagType);
	}
	
	/**
	 * @see com.stx.centre.core.tag.svc.impl#findByTagTypeAndTagCode(String tagType, String tagCode)
	 */
	public TagCodeDetail findByTagTypeAndTagCode(String tagType, String tagCode) {
		return tagCodeDetailRepo.findByTagTypeAndTagCode(tagType, tagCode);
	}
	
	public TagCodeDetail test() {
		TagCodePK tagCodePk = ClassObjFactory.newInstance(TagCodePK.class);
		tagCodePk.setTagType("CTY");
		tagCodePk.setTagCode("AU");
		return findByPrimaryKey(tagCodePk);
//		return ClassObjFactory.newInstance(TagCodeDetail.class);
	}
}
