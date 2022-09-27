package com.kevinavy.easyaccount.service;

import com.kevinavy.easyaccount.model.common.http.Result;
import com.kevinavy.easyaccount.model.vo.UserVo;

public interface UserService {
    Result login(UserVo userVo);

    Result register(UserVo userVo);
}
