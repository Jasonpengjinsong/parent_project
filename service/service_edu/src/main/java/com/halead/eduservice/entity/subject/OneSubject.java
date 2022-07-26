package com.halead.eduservice.entity.subject;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @title: OneSubject
 * @Author ppjjss
 * @Date: 2022/7/25 0:16
 * @Version 1.0
 */
@Data
public class OneSubject {

    private String id;

    private String title;

    private List<TwoSubject> children = new ArrayList();
}
