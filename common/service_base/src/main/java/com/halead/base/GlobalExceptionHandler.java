package com.halead.base;


import com.halead.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @title: GlobalExceptionHandler
 * @Author ppjjss
 * @Date: 2022/7/24 22:53
 * @Version 1.0
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e) {
        e.printStackTrace();
        return R.error();
    }

    @ExceptionHandler(HaledException.class)
    @ResponseBody
    public R error(HaledException e){
        e.printStackTrace();
        return R.error().message(e.getMessage()).code(e.getCode());
    }


}
