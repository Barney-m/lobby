package com.stx.centre.core.tag.rest;

import com.stx.centre.security.oauth2.web.rest.constant.CentreAuthRestConst;

public class TagCodeConst {
	public static final String TAG_CODE_ENDPOINT = CentreAuthRestConst.CTR_ENDPOINT + "/tagCode";
	
	public static final String TAG_CODE_DETAIL_ENDPOINT = "/detail";
	
	public static final String TAG_CODE_HEADER_ENDPOINT = "/header";
	
	public static final String TAG_CODE_GROUP_ENDPOINT = "/group";
	
	/**
	 * Detail Route
	 */
	public static final String DETAIL_FIND_ALL = TAG_CODE_DETAIL_ENDPOINT + "/";

	public static final String DETAIL_FIND_BY_TAG_TYPE = TAG_CODE_DETAIL_ENDPOINT + "/{tagType}";
}
