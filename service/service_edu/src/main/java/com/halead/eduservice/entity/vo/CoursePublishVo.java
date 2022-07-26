package com.halead.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @title: CoursePublishVo
 * @Author ppjjss
 * @Date: 2022/7/25 0:45
 * @Version 1.0
 */
@Data
public class CoursePublishVo {

    private String id;
    private String title;
    private String cover;
    private Integer lessonNum;
    private String subjectLevelOne;
    private String subjectLevelTwo;
    private String teacherName;
    private String price;//只用于显示

}
