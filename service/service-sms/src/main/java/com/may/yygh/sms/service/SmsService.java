package com.may.yygh.sms.service;

import org.springframework.stereotype.Service;

@Service
public interface SmsService {
    //发送手机验证码
    boolean send(String phone, String code);

}
