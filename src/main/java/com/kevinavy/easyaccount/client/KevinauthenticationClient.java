package com.kevinavy.easyaccount.client;

import com.kevinavy.easyaccount.model.common.http.Result;
import com.kevinavy.easyaccount.model.dto.UserDto;
import com.kevinavy.easyaccount.model.vo.AccountVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "kevinauthentication", url = "http://127.0.0.1:9909/api/v1/kevinauthentication")
@Component
public interface KevinauthenticationClient {
    @PostMapping("/account/login")
    Result login(@RequestBody UserDto userDto);

    @PostMapping("/account/register")
    Result register(@RequestBody UserDto userDto);

    @GetMapping("/authentication/validToken/{token}")
    public Result validToken(@PathVariable String token);
}
