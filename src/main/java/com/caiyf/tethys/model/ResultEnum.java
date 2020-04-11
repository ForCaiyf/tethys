package com.caiyf.tethys.model;

import lombok.Getter;

/**
 * @desc 状态码
 * @date 2019/04/10
 * @author caiyf
 */
@Getter
public enum ResultEnum {

    /** 通用状态码 */
    SUCCESS(1000, "请求成功"),
    PARAMETER_VALID(1001, "参数异常"),
    UNKNOWN_ERROR(1002, "未知错误");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}