package com.halead.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.halead.eduservice.entity.EduSubject;
import com.halead.eduservice.entity.subject.OneSubject;
import com.halead.eduservice.entity.subject.TwoSubject;
import com.halead.eduservice.listener.SubjectExcelListener;
import com.halead.eduservice.mapper.EduSubjectMapper;
import com.halead.eduservice.service.EduSubjectService;
import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @title: EduSubjectServiceImpl
 * @Author ppjjss
 * @Date: 2022/7/24 23:39
 * @Version 1.0
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    /**
     * 添加课程分类
     * @param file
     * @param eduSubjectService
     */
    @Override
    public void saveSubject(MultipartFile file, EduSubjectService eduSubjectService) {

        try {
            InputStream inputStream = file.getInputStream();
            EasyExcel.read(inputStream,EduSubject.class,new SubjectExcelListener()).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询课程列表
     * @return
     */
    @Override
    public List<OneSubject> getAllOneTwoSubject() {

        QueryWrapper<EduSubject> wrapperOne = new QueryWrapper<>();
        wrapperOne.eq("parent_id","0");
        List<EduSubject> oneSubjectList = baseMapper.selectList(wrapperOne);

        QueryWrapper<EduSubject> wrapperTwo = new QueryWrapper<>();
        wrapperTwo.ne("parent_id","0");
        List<EduSubject> twoSubjectList = baseMapper.selectList(wrapperTwo);

        ArrayList<OneSubject> finalSubjectList = new ArrayList<>();

        for (int i = 0; i < oneSubjectList.size(); i++) {

            EduSubject eduSubject = oneSubjectList.get(i);
            OneSubject oneSubject = new OneSubject();
            BeanUtils.copyProperties(eduSubject,oneSubject);
            finalSubjectList.add(oneSubject);
            ArrayList<TwoSubject> twoFinalSubjectList = new ArrayList<>();
            for (int j = 0; j < twoSubjectList.size(); j++) {
                EduSubject tSubject = twoSubjectList.get(j);
                if(tSubject.getParentId().equals(eduSubject.getId())){
                    TwoSubject twoSubject = new TwoSubject();
                    BeanUtils.copyProperties(tSubject,twoSubject);
                    twoFinalSubjectList.add(twoSubject);
                }
            }
            oneSubject.setChildren(twoFinalSubjectList);
        }
        return finalSubjectList;
    }
}
