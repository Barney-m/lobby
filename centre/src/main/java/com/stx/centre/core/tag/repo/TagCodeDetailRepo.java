package com.stx.centre.core.tag.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stx.centre.core.tag.bean.TagCodeDetail;

@Repository
public interface TagCodeDetailRepo extends JpaRepository<TagCodeDetail, String> {

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
