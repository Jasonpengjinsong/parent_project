package com.halead.eduservice.controller;

import com.halead.eduservice.entity.subject.OneSubject;
import com.halead.eduservice.service.EduSubjectService;
import com.halead.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @title: EduSubjectController
 * @Author ppjjss
 * @Date: 2022/7/24 23:36
 * @Version 1.0
 */
@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
public class EduSubjectController {

    @Autowired
    private EduSubjectService eduSubjectService;
    /**
     * 添加课程分类
     */
    @PostMapping("addSubject")
    public R addSubject(MultipartFile file){

        eduSubjectService.saveSubject(file,eduSubjectService);
        return R.ok();
    }

    /**
     * 获取课程分类
     * @return
     */
    @GetMapping("getAllSubject")
    public R getAllSubject(){
      List<OneSubject> list=  eduSubjectService.getAllOneTwoSubject();
        return R.ok().data("list", list);
    }
}
