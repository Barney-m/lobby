package com.stx.lobbyservice.svc;

import java.util.List;

import com.stx.lobbyservice.bean.LbbyAttd;

public interface LbbyAttdSvc {
	
	/**
	 * Get a list of LbbyAttd
	 * @return {@link LbbyAttd}
	 */
	List<LbbyAttd> list();
	
	LbbyAttd test();
}
