package com.caiyf.tethys.message.impl;

import com.caiyf.tethys.message.api.MessageClient;
import com.caiyf.tethys.message.model.ZhenziConfig;
import com.zhenzi.sms.ZhenziSmsClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * zhenzi short message platform
 *
 * @author caiyf
 * @date 2020-01-04
 */
public class ZhenziClient implements MessageClient {

    @Autowired
    private ZhenziConfig config;

    private static Logger log = LoggerFactory.getLogger(MessageClient.class);

    /**
     * send short message
     *
     * @param phoneNum
     * @param message
     */
    public void sendShortMessage(String phoneNum, String message) {
        if (checkParam(phoneNum, message)) {
            // todo: customized exception
            throw new RuntimeException("参数缺失");
        }
        ZhenziSmsClient client;
        String result;
        try {
            client = new ZhenziSmsClient(config.getApiUrl(), config.getAppId(), config.getAppSecret());
            result = client.send(phoneNum, message);

        } catch (Exception e) {
            log.error("{} send error, cause: {}", ERROR_LOG_MSG, e.getMessage());
            throw new  RuntimeException("发送失败");
        }
    }

    /**
     * param check
     *
     * @param phoneNum
     * @param message
     * @return
     */
    private boolean checkParam(String phoneNum, String message) {
        if (!StringUtils.isEmpty(phoneNum) || !StringUtils.isEmpty(message)) {
            log.error("{} miss param, phoneNum: {}, message: {}", ERROR_LOG_MSG, phoneNum, message);
            return false;
        }
        // todo: match phone pattern
        return true;
    }

}
