package com.stx.centre.security.oauth2.web.svc;

import com.stx.centre.security.user.bean.CentreUser;
import com.stx.centre.security.web.bean.CentreIamLoginRsp;
import com.stx.centre.security.web.bean.CentreIamRegisterReq;
import com.stx.centre.security.web.bean.CentreIamRegisterRsp;

public interface CentreAuthMntSvc {
	CentreIamLoginRsp login(String email, String pwd);
	
	CentreIamRegisterRsp register(CentreIamRegisterReq req);
}
