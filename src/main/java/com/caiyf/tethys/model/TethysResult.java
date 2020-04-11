package com.caiyf.tethys.model;

import lombok.Getter;

/**
 * @desc 通用返回结果
 * @date 2019/04/10
 * @author caiyf
 */
@Getter
public class TethysResult<T> {

    private Integer code;
    private String msg;
    private T data;

    private TethysResult(T data) {
        this.code = ResultEnum.SUCCESS.getCode();
        this.msg = ResultEnum.SUCCESS.getMsg();
        this.data = data;
    }
    private TethysResult(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    /**
     * 成功时返回
     * @param data
     * @param <T>
     * @return
     */
    public static <T> TethysResult<T> getSuccessResult(T data) {
        return new TethysResult<T>(data);
    }

    /**
     * 异常时返回
     * @param resultEnum
     * @param <T>
     * @return
     */
    public static <T> TethysResult<T> getExceptionResult(ResultEnum resultEnum) {
        return new TethysResult<T>(resultEnum);
    }

}