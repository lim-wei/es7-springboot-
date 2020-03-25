package com.liaoyuan.dianping.common;

/**
 * 通用的结果处理
 * Created by limw on 2020/3/9.
 */
public class CommonRes {

    // 表明读取请求的返回结果，要么为success，要么为fail
    private String status;

    // 若status=success时，表明对应的返回json数据
    // 若status=fail时，则data内将使用通用的错误码对应的格式
    private Object data;


    // -----------------------------定义一个通用的创建返回对象的方法-----------------------------

    public static CommonRes create(Object result){
        return CommonRes.create(result,"success");
    }

    public static CommonRes create(Object result,String status){
        CommonRes commonRes = new CommonRes();
        commonRes.setData(result);
        commonRes.setStatus(status);
        return commonRes;
    }
    //-----------------------------定义一个通用的创建返回对象的方法-----------------------------

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
