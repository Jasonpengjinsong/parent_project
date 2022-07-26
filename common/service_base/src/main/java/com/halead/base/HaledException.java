package com.halead.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @title: HaledException
 * @Author ppjjss
 * @Date: 2022/7/24 23:00
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HaledException extends RuntimeException{
    private Integer code;

    private String message;

    @Override
    public String toString() {
        return "HaledException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
