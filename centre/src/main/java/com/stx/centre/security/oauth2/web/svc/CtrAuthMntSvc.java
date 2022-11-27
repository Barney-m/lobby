package com.stx.centre.security.oauth2.web.svc;

import com.stx.centre.security.user.bean.CtrUsr;
import com.stx.centre.security.web.bean.CtrIamLoginRsp;
import com.stx.centre.security.web.bean.CtrIamRegisterReq;
import com.stx.centre.security.web.bean.CtrIamRegisterRsp;

public interface CtrAuthMntSvc {
	CtrIamLoginRsp login(String email, String pwd);
	
	CtrIamRegisterRsp register(CtrIamRegisterReq req);
}
