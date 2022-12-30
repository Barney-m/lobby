package com.stx.lobbyservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stx.lobbyservice.bean.LbbyPrdInvt;

@Repository
public interface LbbyPrdInvtRepo extends JpaRepository<LbbyPrdInvt, Long> {

}
