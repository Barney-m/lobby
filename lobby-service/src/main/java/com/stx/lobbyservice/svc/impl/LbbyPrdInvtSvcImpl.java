package com.stx.lobbyservice.svc.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stx.lobbyservice.bean.LbbyAttd;
import com.stx.lobbyservice.bean.LbbyPrdInvt;
import com.stx.lobbyservice.repo.LbbyPrdInvtRepo;
import com.stx.lobbyservice.svc.LbbyPrdInvtSvc;

@Service
public class LbbyPrdInvtSvcImpl implements LbbyPrdInvtSvc {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private LbbyPrdInvtRepo lbbyPrdInvtRepo;
	
	public List<LbbyPrdInvt> list() {
		return lbbyPrdInvtRepo.findAll();
	}
	
	// For Testing Purpose
	public LbbyAttd test() {
		TypedQuery<LbbyAttd> query = em.createQuery("select lbbyUsr from LbbyUsr lbbyUsr", LbbyAttd.class);

		return query.getSingleResult();
	}
}
