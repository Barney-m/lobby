package com.stx.lobbyservice.svc.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stx.lobbyservice.bean.LbbyAttd;
import com.stx.lobbyservice.bean.LbbyPrd;
import com.stx.lobbyservice.repo.LbbyAttdRepo;
import com.stx.lobbyservice.repo.LbbyPrdRepo;
import com.stx.lobbyservice.svc.LbbyAttdSvc;
import com.stx.lobbyservice.svc.LbbyPrdSvc;

@Service
public class LbbyPrdSvcImpl implements LbbyPrdSvc {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private LbbyPrdRepo lbbyPrdRepo;
	
	public List<LbbyPrd> list() {
		return lbbyPrdRepo.findAll();
	}
	
	// For Testing Purpose
	public LbbyAttd test() {
		TypedQuery<LbbyAttd> query = em.createQuery("select lbbyUsr from LbbyUsr lbbyUsr", LbbyAttd.class);

		return query.getSingleResult();
	}
}
