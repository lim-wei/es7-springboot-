package com.liaoyuan.dianping.service.impl;

import com.liaoyuan.dianping.common.BusinessException;
import com.liaoyuan.dianping.common.EmBusinessError;
import com.liaoyuan.dianping.dal.UserModelMapper;
import com.liaoyuan.dianping.model.UserModel;
import com.liaoyuan.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * Created by limw on 2020/3/8.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserModelMapper userModelMapper;

    @Override
    public UserModel getUser(Integer id) {
        return userModelMapper.selectByPrimaryKey(id);
    }


    /*----------------------- 注册方法 -----------------------*/
    @Override
    @Transactional // 保证事务性
    public UserModel register(UserModel registerUser) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        registerUser.setPassword(encodeByMd5(registerUser.getPassword()));    // 用加密密码替换明文密码
        registerUser.setCreatedAt(new Date());
        registerUser.setUpdatedAt(new Date());
        try {
            userModelMapper.insertSelective(registerUser);
        }catch (DuplicateKeyException ex){ //
            throw new BusinessException(EmBusinessError.REGISTER_DUP_FAIL);
        }

        return getUser(registerUser.getId());
    }

    private String encodeByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // 使用MD5算法来加密密码
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        return base64Encoder.encode(messageDigest.digest(str.getBytes("utf-8")));
    }
    /*----------------------- 注册方法 -----------------------*/

    /*----------------------- 登录方法 -----------------------*/
    @Override
    public UserModel login(String telphone, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException, BusinessException {
        UserModel userModel = userModelMapper.selectByTelphoneAndPassword(telphone,encodeByMd5(password));
        // 没有查找到相关用户
        if (userModel == null){
            throw new BusinessException(EmBusinessError.LOGIN_FAIL);
        }
        return userModel;
    }
    /*----------------------- 登录方法 -----------------------*/

    /*----------------------- 获取所有的用户数 -----------------------*/
    @Override
    public Integer countAllUser() {
        return userModelMapper.countAllUser();
    }
    /*----------------------- 获取所有的用户数 -----------------------*/

}
