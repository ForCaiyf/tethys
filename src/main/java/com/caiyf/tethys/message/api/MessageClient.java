package com.caiyf.tethys.message.api;

/**
 * short message client
 *
 * @author caiyf
 * @date 2020-01-04
 */
public interface MessageClient {

    static final String ERROR_LOG_MSG = "[send-message-err]:";

    /**
     * send short message
     *
     * @param phoneNum
     * @param message
     */
    void sendShortMessage(String phoneNum, String message);

}
