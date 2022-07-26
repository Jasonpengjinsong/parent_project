package com.halead.eduservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.halead.eduservice.entity.EduSubject;
import com.halead.eduservice.entity.subject.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EduSubjectService extends IService<EduSubject> {

    void saveSubject(MultipartFile file, EduSubjectService eduSubjectService);

    List<OneSubject> getAllOneTwoSubject();

}
