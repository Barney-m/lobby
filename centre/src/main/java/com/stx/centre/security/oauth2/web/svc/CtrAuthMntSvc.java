package com.stx.centre.security.oauth2.web.svc;

import com.stx.centre.security.user.bean.CtrUsr;
import com.stx.centre.security.web.bean.CtrIamLoginRsp;

public interface CtrAuthMntSvc {
	CtrIamLoginRsp login(String email, String pwd);
}
