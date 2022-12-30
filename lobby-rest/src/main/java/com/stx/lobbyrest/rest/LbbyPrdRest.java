package com.stx.lobbyrest.rest;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stx.lobbyrest.constant.LbbyRestConst;
import com.stx.lobbyservice.bean.LbbyPrd;
import com.stx.lobbyservice.svc.LbbyPrdSvc;
import com.stx.workshop.annotation.StxAuth;
import com.stx.workshop.util.OpUtil;

@RestController
@RequestMapping(LbbyRestConst.LBBY_PRD_ENDPOINT)
public class LbbyPrdRest {
	@Autowired
	LbbyPrdSvc lbbyPrdSvc;

	@StxAuth
	@GetMapping
	public List<LbbyPrd> findAllPrds() {
		return lbbyPrdSvc.list();
	}
	
	@GetMapping("/abc")
	public BigDecimal findAllUsr() {
		BigDecimal a = new BigDecimal("10");
		BigDecimal b = new BigDecimal("20");
		return OpUtil.add(a, b);
	}
}
