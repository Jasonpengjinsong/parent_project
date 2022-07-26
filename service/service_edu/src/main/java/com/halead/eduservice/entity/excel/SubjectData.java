package com.halead.eduservice.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @title: SubjectData
 * @Author ppjjss
 * @Date: 2022/7/24 23:53
 * @Version 1.0
 */
@Data
public class SubjectData {

    @ExcelProperty(index = 0)
    private String oneSubjectName;
    @ExcelProperty(index = 1)
    private String twoSubjectName;
}
