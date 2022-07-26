package com.halead.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @title: ExceptionUtil
 * @Author ppjjss
 * @Date: 2022/7/25 19:50
 * @Version 1.0
 */
public class ExceptionUtil {

    public static String getMessage(Exception e) {

        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw= new PrintWriter(sw);

            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
        } finally {
            if(sw!= null){
                try {
                    sw.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            if(pw!= null){
                try {
                    sw.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
        return sw.toString();

    }
}
