package com.kevinavy.easyaccount.exception;


import com.kevinavy.easyaccount.constant.constnt.ResultCode;
import com.kevinavy.easyaccount.model.common.http.Result;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        logger.error("global exception: ", e);
        return Result.error(ResultCode.ERROR, "全局异常", e);
    }
}
