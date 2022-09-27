package com.kevinavy.easyaccount.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kevinavy.easyaccount.client.KevinauthenticationClient;
import com.kevinavy.easyaccount.constant.constnt.ResultCode;
import com.kevinavy.easyaccount.mapper.UserMapper;
import com.kevinavy.easyaccount.model.common.http.Result;
import com.kevinavy.easyaccount.model.dto.UserDto;
import com.kevinavy.easyaccount.model.po.UserPo;
import com.kevinavy.easyaccount.model.vo.UserVo;
import com.kevinavy.easyaccount.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private KevinauthenticationClient kevinauthenticationClient;

    @Override
    public Result login(UserVo userVo) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userVo, userDto);
        Result result = kevinauthenticationClient.login(userDto);
        if (result.getCode().equals(ResultCode.SUCCESS)) {
            String uuid = JSONObject.parseObject(JSONObject.toJSONString(result.getData())).getString("uuid");
            QueryWrapper<UserPo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("uuid", uuid);
            if (!userMapper.exists(queryWrapper)) {
                UserPo userPo = new UserPo();
                userPo.setUuid(uuid);
                userMapper.insert(userPo);
            }
        }
        return result;
    }

    @Override
    public Result register(UserVo userVo) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userVo, userDto);
        Result result = kevinauthenticationClient.login(userDto);
        if (result.getCode().equals(ResultCode.SUCCESS)) {
            UserPo userPo = new UserPo();
            userPo.setUuid(result.getData().toString());
            userMapper.insert(userPo);
        }
        return result;
    }
}
