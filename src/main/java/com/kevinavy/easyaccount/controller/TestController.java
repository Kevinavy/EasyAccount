package com.kevinavy.easyaccount.controller;

import com.alibaba.fastjson.JSONObject;
import com.kevinavy.easyaccount.client.KevinauthenticationClient;
import com.kevinavy.easyaccount.model.common.http.Result;
import com.kevinavy.easyaccount.model.vo.UserVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController

public class TestController {
    @Resource
    private KevinauthenticationClient kevinauthenticationClient;

    @RequestMapping("/test")
    public void test() {

    }
}
