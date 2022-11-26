package com.stx.centre.security.user.svc.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stx.centre.security.user.bean.CtrUsr;
import com.stx.centre.security.user.repo.CtrUsrRepo;
import com.stx.centre.security.user.svc.CtrUsrSvc;

@Service
public class CtrUsrSvcImpl implements CtrUsrSvc {
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private CtrUsrRepo ctrUsrRepo;
	
	public List<CtrUsr> list() {
		return ctrUsrRepo.findAll();
	}
}
