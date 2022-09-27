package com.kevinavy.easyaccount;

import com.kevinavy.easyaccount.client.KevinauthenticationClient;
import com.kevinavy.easyaccount.model.common.http.Result;
import com.kevinavy.easyaccount.model.vo.AccountVo;
import com.kevinavy.easyaccount.model.vo.UserVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class EasyAccountApplicationTests {

    @Resource
    KevinauthenticationClient kevinauthenticationClient;

    @Test
    void contextLoads() {
        UserVo userVo = new UserVo();

        System.out.print(1);
    }

}
