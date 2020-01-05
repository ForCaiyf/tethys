package com.caiyf.tethys.message.impl;

import com.alibaba.fastjson.JSONObject;
import com.caiyf.tethys.message.api.MessageClient;
import com.caiyf.tethys.message.model.ZhenziConfig;
import com.caiyf.tethys.message.model.ZhenziException;
import com.caiyf.tethys.message.model.ZhenziResultModel;
import com.zhenzi.sms.ZhenziSmsClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * zhenzi short message platform
 *
 * @author caiyf
 * @date 2020-01-04
 */
@Component
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
            throw new ZhenziException("参数缺失");
        }
        ZhenziSmsClient client;
        ZhenziResultModel result;
        try {
            client = new ZhenziSmsClient(config.getApiUrl(), config.getAppId(), config.getAppSecret());
            String resultString = client.send(phoneNum, message);
            result = convertResult(resultString);
        } catch (Exception e) {
            log.error("{} send error, cause: {}", ERROR_LOG_MSG, e.getMessage());
            throw new  ZhenziException("发送异常", e);
        }
        if (Objects.isNull(result) || result.getCode() != 0) {
            throw new ZhenziException("发送失败");
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

    /**
     * convert result
     *
     * @param resultString
     * @return
     */
    private ZhenziResultModel convertResult(String resultString) {
        if (StringUtils.isEmpty(resultString)) {
            return ZhenziResultModel.returnEmptyResult();
        }
        return JSONObject.parseObject(resultString, ZhenziResultModel.class);
    }

}
