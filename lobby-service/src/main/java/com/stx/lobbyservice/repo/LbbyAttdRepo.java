package com.stx.lobbyservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stx.lobbyservice.bean.LbbyAttd;

@Repository
public interface LbbyAttdRepo extends JpaRepository<LbbyAttd, Long> {

}
