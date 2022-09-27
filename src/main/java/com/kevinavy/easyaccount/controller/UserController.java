package com.kevinavy.easyaccount.controller;

import com.kevinavy.easyaccount.client.KevinauthenticationClient;
import com.kevinavy.easyaccount.model.common.http.Result;
import com.kevinavy.easyaccount.model.dto.UserDto;
import com.kevinavy.easyaccount.model.vo.AccountVo;
import com.kevinavy.easyaccount.model.vo.UserVo;
import com.kevinavy.easyaccount.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/v1/easyAccount/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody UserVo userVo) {
        return userService.login(userVo);
    }

    @PostMapping("/register")
    public Result register(@RequestBody UserVo userVo) {

        return userService.register(userVo);
    }
}
