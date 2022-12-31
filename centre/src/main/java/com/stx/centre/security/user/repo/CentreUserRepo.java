package com.stx.centre.security.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stx.centre.security.user.bean.CentreUser;

@Repository
public interface CentreUserRepo extends JpaRepository<CentreUser, String> {

}
