package com.solider.rocketmq_use_fast.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author <a href="https://github.com/wzh-solider">solider</a>
 * @version 1.0
 * @description: 全局异常处理器
 * @Date 2024/7/28 20:42
 * @since 1.0
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public void exception(Exception e) {
        log.info("this app have exception --> {}", e.getMessage());
    }

}
