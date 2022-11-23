package com.stx.lobbyservice.svc.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stx.lobbyservice.bean.LbbyAttd;
import com.stx.lobbyservice.repo.LbbyAttdRepo;
import com.stx.lobbyservice.svc.LbbyAttdSvc;

@Service
public class LbbyAttdSvcImpl implements LbbyAttdSvc {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private LbbyAttdRepo lbbyAttdRepo;
	
	public List<LbbyAttd> list() {
		return lbbyAttdRepo.findAll();
	}
	
	// For Testing Purpose
	public LbbyAttd test() {
		TypedQuery<LbbyAttd> query = em.createQuery("select lbbyUsr from LbbyUsr lbbyUsr", LbbyAttd.class);

		return query.getSingleResult();
	}
}
