package com.stx.centre.core.tag.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stx.centre.core.tag.bean.TagCodeDetail;
import com.stx.centre.core.tag.svc.TagCodeDetailSvc;

@RestController
@RequestMapping(TagCodeConst.TAG_CODE_ENDPOINT)
public class TagCodeRest {
	
	@Autowired
	TagCodeDetailSvc tagCodeDetailSvc;
	
	/**
	 * Get All Tag Code Details
	 * 
	 * @return {@link List<TagCodeDetail>}
	 */
	@GetMapping(TagCodeConst.DETAIL_FIND_ALL)
	public List<TagCodeDetail> getAllTagCodeDetails() {
		return tagCodeDetailSvc.findAll();
	}
	
	/**
	 * Get All Tag Code Details By Tag Type
	 * 
	 * @param tagType
	 * @return {@link List<TagCodeDetail>}
	 */
	@GetMapping(TagCodeConst.DETAIL_FIND_BY_TAG_TYPE)
	public List<TagCodeDetail> getAllTagCodeDetailsByTagType(@PathVariable String tagType) {
		return tagCodeDetailSvc.findByTagType(tagType);
	}
}
