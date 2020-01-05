package com.caiyf.tethys.message;

import com.caiyf.tethys.TethysApplication;
import com.caiyf.tethys.message.impl.ZhenziClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TethysApplication.class)
public class ZhenziClientTest {

    @Autowired
    private ZhenziClient zhenziClient;

    @Test
    public void sendShortMessageTest() throws Exception {
        // zhenziClient.sendShortMessage("18846831262", "短信发送测试");
    }

}
