package com.stx.lobbyservice;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.stx.lobbyservice.bean.LbbyAttd;
import com.stx.lobbyservice.svc.LbbyAttdSvc;

@SpringBootTest
class LobbyServiceApplicationTests {

	@Autowired
	private LbbyAttdSvc lbbyAttdSvc;
	
	@Test
    public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
        List<LbbyAttd> lbbyAttds = lbbyAttdSvc.list();
        LbbyAttd lbbyAttd = lbbyAttdSvc.test();
        	
//        Assert.assertEquals(lbbyAttd.getAttdId(), 0);
//        Assert.assertEquals(lbbyAttd.getAttdId(), Long.getLong("0"));
    }

}
