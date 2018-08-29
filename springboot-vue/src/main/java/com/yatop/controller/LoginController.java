package com.yatop.controller;

import com.yatop.modal.Account;
import com.yatop.util.JwtUtil;
import com.yatop.util.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@CrossOrigin("*")
public class LoginController {

    private static final String USERNAME="admin";
    private static final String PASSWORD="123456";

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/loginIn")
    public ResponseMessage login(@RequestBody Account account){
        if(USERNAME.equals(account.getUserName()) && PASSWORD.equals(account.getPassword())){
            try {
                //生成token
                String token = jwtUtil.createToken(1001,account.getPassword());
                //登入成功 返回token
                return ResponseMessage.success(token);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return ResponseMessage.error("账号或密码错误");
            }
        }else {
            return ResponseMessage.error("账号或密码错误");
        }
    }
}
