package com.liaoyuan.dianping.common;

/**
 * 通用的错误处理
 * Created by limw on 2020/3/9.
 */
public class CommonError {

    // 错误码
    private Integer errCode;

    // 错误描述
    private String errMsg;

    public CommonError(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public CommonError(EmBusinessError emBusinessError){
        this.errCode = emBusinessError.getErrCode();
        this.errMsg = emBusinessError.getErrMsg();
    }

    public  Integer getErrCode() {
        return errCode;
    }

    public void    setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String  getErrMsg() {
        return errMsg;
    }

    public void    setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }




}
