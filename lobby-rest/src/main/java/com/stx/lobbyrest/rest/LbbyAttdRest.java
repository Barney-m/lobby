package com.stx.lobbyrest.rest;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stx.lobbyrest.constant.LbbyRestConst;
import com.stx.lobbyservice.bean.LbbyAttd;
import com.stx.lobbyservice.svc.LbbyAttdSvc;
import com.stx.workshop.annotation.StxAuth;
import com.stx.workshop.util.OpUtil;


@RestController
@RequestMapping(LbbyRestConst.LBBY_ATTD_ENDPOINT)
public class LbbyAttdRest {

	@Autowired
	LbbyAttdSvc lbbyAttdSvc;

	@StxAuth
	@GetMapping
	public List<LbbyAttd> findAllUsrs() {
		return lbbyAttdSvc.list();
	}
	
	@GetMapping("/abc")
	public BigDecimal findAllUsr() {
		BigDecimal a = new BigDecimal("10");
		BigDecimal b = new BigDecimal("20");
		return OpUtil.add(a, b);
	}
}
