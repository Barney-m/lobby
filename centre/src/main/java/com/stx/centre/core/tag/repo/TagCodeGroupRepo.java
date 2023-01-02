package com.stx.centre.core.tag.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stx.centre.core.tag.bean.TagCodeGroup;

@Repository
public interface TagCodeGroupRepo extends JpaRepository<TagCodeGroup, String> {

}
