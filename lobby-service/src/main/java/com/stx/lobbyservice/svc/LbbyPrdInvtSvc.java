package com.stx.lobbyservice.svc;

import java.util.List;

import com.stx.lobbyservice.bean.LbbyPrdInvt;

public interface LbbyPrdInvtSvc {
	
	/**
	 * Get a list of LbbyPrdInvt
	 * @return {@link LbbyPrdInvt}
	 */
	List<LbbyPrdInvt> list();
}
