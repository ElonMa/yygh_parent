package com.may.yygh.hosp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.may.yygh.model.user.UserInfo;
import com.may.yygh.vo.user.LoginVo;

import java.util.Map;

public interface UserInfoService extends IService<UserInfo> {
    //会员登录
    Map<String, Object> login(LoginVo loginVo);

}

