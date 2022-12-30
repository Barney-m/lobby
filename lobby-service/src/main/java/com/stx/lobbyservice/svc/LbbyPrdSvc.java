package com.stx.lobbyservice.svc;

import java.util.List;

import com.stx.lobbyservice.bean.LbbyPrd;

public interface LbbyPrdSvc {
	
	/**
	 * Get a list of LbbyPrd
	 * @return {@link LbbyPrd}
	 */
	List<LbbyPrd> list();
}
