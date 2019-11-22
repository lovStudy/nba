package com.cn.nba.common;

public class BizException extends RuntimeException {

    private String errMsg;
    private String errKey;


    public BizException(String message) {
        super(message);
        this.errMsg = message;
    }

    public BizException(String errKey, String message) {
        super(message);
        this.errKey = errKey;
        this.errMsg = message;
    }

}
