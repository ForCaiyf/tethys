package com.caiyf.tethys.message.model;

/**
 * zhenzi exception
 *
 * @author caiyf
 * @date 2020-01-05
 */
public class ZhenziException extends RuntimeException {

    public ZhenziException(String msg) {
        super(msg);
    }
    public ZhenziException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
