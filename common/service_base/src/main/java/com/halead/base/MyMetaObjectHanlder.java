package com.halead.base;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @title: MyMetaObjectHanlder
 * @Author ppjjss
 * @Date: 2022/7/24 23:03
 * @Version 1.0
 */
@Component
public class MyMetaObjectHanlder implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {

       this.setFieldValByName("gmtCreate",new Date(),metaObject);
       this.setFieldValByName("gmtModified",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
      this.setFieldValByName("gmtModified",new Date(),metaObject);
    }
}
