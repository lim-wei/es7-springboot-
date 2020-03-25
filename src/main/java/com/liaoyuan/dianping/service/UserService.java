package com.liaoyuan.dianping.service;

import com.liaoyuan.dianping.common.BusinessException;
import com.liaoyuan.dianping.model.UserModel;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by limw on 2020/3/8.
 */
public interface UserService {

    UserModel getUser(Integer id);

    // 注册
    UserModel register(UserModel registerModel) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException;

    // 登录
    UserModel login(String telphone,String password) throws UnsupportedEncodingException, NoSuchAlgorithmException, BusinessException;

    // 获取所有的用户数
    Integer countAllUser();
}
