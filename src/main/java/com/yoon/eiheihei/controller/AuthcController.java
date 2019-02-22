package com.yoon.eiheihei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/auth")
public class AuthcController {

    @RequestMapping(value = "/redirect_login")
    @ResponseBody
    public String redirectLogin() {
        return "login!";
    }

    @RequestMapping(value = "/success")
    @ResponseBody
    public String loginSuccess() {
        return "login success!";
    }

    @RequestMapping(value = "/fail")
    @ResponseBody
    public String loginFail() {
        return "login fail!";
    }
}
