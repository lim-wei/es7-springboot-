package com.liaoyuan.dianping.controller;

import com.liaoyuan.dianping.common.BusinessException;
import com.liaoyuan.dianping.common.CommonRes;
import com.liaoyuan.dianping.common.CommonUtil;
import com.liaoyuan.dianping.common.EmBusinessError;
import com.liaoyuan.dianping.model.UserModel;
import com.liaoyuan.dianping.request.LoginReq;
import com.liaoyuan.dianping.request.RegisterReq;
import com.liaoyuan.dianping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by limw on 2020/3/8.
 */
@Controller("/user")
@RequestMapping("/user")
public class UserController {

    public static final String CURRENT_USER_SESSION = "currentUserSession";    // 获取当前登录的状态

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping("/index")
    public ModelAndView index(){
        String username="liaoyuan";
        ModelAndView modelAndView = new ModelAndView("/index.html");
        modelAndView.addObject("name",username);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/get")
    public CommonRes getUser(@RequestParam(name = "id")Integer id) throws BusinessException {
        UserModel userModel = userService.getUser(id);
        if (userModel == null){
            //return CommonRes.create(new CommonError(EmBusinessError.NO_OBJECT_FOUND),"fail");
            throw new BusinessException(EmBusinessError.NO_OBJECT_FOUND); //会把异常抛到tomcat，需要定义一个异常拦截器进行处理
        }else {
            return CommonRes.create(userModel);
        }
    }

    /*----------------------- 注册方法 -----------------------*/
    @ResponseBody
    @RequestMapping("/register")
    public CommonRes register(@Valid @RequestBody RegisterReq registerReq, BindingResult bindingResult) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        if (bindingResult.hasErrors()){    // 如果有失败操作
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, CommonUtil.processErrorString(bindingResult));
        }

        UserModel registerUser = new UserModel();
        registerUser.setTelphone(registerReq.getTelphone());
        registerUser.setPassword(registerReq.getPassword());
        registerUser.setGender(registerReq.getGender());
        registerUser.setNickName(registerReq.getNickName());

        UserModel resUserModel = userService.register(registerUser);    // 进行密码加密，以及保证事务性

        return CommonRes.create(resUserModel);
    }
    /*----------------------- 注册方法 -----------------------*/

    /*----------------------- 登录方法 -----------------------*/
    @ResponseBody
    @RequestMapping("/login")
    public CommonRes login(@Valid @RequestBody LoginReq loginReq,BindingResult bindingResult) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        if (bindingResult.hasErrors()){    // 如果有失败操作
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, CommonUtil.processErrorString(bindingResult));
        }
        UserModel userModel=userService.login(loginReq.getTelphone(),loginReq.getPassword());
        httpServletRequest.getSession().setAttribute(CURRENT_USER_SESSION, userModel);

        return CommonRes.create(userModel);
    }
    /*----------------------- 登录方法 -----------------------*/

    /*----------------------- 注销登录 -----------------------*/
    @ResponseBody
    @RequestMapping("/logout")
    public CommonRes logout() throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        httpServletRequest.getSession().invalidate();
        return CommonRes.create(null);    // 当前session无效化
    }
    /*----------------------- 注销登录 -----------------------*/

    /*----------------------- 获取当前用户信息 -----------------------*/
    @ResponseBody
    @RequestMapping("/getcurrentuser")
    public CommonRes getCurrentUser(){
        // 根据session获取当前用户信息
        UserModel userModel = (UserModel) httpServletRequest.getSession().getAttribute(CURRENT_USER_SESSION);
        return CommonRes.create(userModel);
    }
    /*----------------------- 获取当前用户信息 -----------------------*/

}
