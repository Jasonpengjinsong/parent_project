package com.halead.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import sun.net.www.http.HttpClient;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @title: ResponseUtil
 * @Author ppjjss
 * @Date: 2022/7/24 19:51
 * @Version 1.0
 */
public class ResponseUtil {

    public static void out(HttpServletResponse response,R r){
        ObjectMapper mapper = new ObjectMapper();
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        try {
            mapper.writeValue(response.getWriter(),r);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
