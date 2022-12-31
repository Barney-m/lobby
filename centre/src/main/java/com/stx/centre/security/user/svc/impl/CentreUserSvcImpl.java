package com.stx.centre.security.user.svc.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stx.centre.security.user.bean.CentreUser;
import com.stx.centre.security.user.repo.CentreUserRepo;
import com.stx.centre.security.user.svc.CentreUserSvc;

@Service
public class CentreUserSvcImpl implements CentreUserSvc {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private CentreUserRepo centreUserRepo;
	
	public List<CentreUser> list() {
		return centreUserRepo.findAll();
	}
}
