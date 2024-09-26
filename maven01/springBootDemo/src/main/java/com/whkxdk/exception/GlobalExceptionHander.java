package com.whkxdk.exception;

import com.whkxdk.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * className:       GlobalExceptionHander
 * author:          wenhao2002
 * date:            2024/5/10 20:09
 */
@RestControllerAdvice
public class GlobalExceptionHander {

    @ExceptionHandler(Exception.class)
    public Result exception(Exception e){
        e.printStackTrace();
        return Result.error("出现异常错误，请联系管理员");
    }
}
