package com.halead.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.halead.base.HaledException;
import com.halead.eduservice.entity.EduSubject;
import com.halead.eduservice.entity.excel.SubjectData;
import com.halead.eduservice.service.EduSubjectService;

import javax.naming.Name;

/**
 * @title: SubjectExcelListener
 * @Author ppjjss
 * @Date: 2022/7/24 23:50
 * @Version 1.0
 */
public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {

    private EduSubjectService eduSubjectService;

    public SubjectExcelListener() {
    }

    public SubjectExcelListener(EduSubjectService eduSubjectService) {
        this.eduSubjectService = eduSubjectService;
    }

    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        if (subjectData == null) {
            throw new HaledException(20001, "文件数据为空");
        }
        EduSubject existOneSubject = this.existOneSubject(eduSubjectService, subjectData.getOneSubjectName());
        if (existOneSubject == null) {
            existOneSubject = new EduSubject();
            existOneSubject.setParentId("0");
            existOneSubject.setTitle(subjectData.getOneSubjectName());
            eduSubjectService.save(existOneSubject);
        }
        String id = existOneSubject.getId();
       EduSubject existTwoSubject= this.existTwoSubject(eduSubjectService,subjectData.getTwoSubjectName(),id);
       if(existTwoSubject == null){
           existTwoSubject= new EduSubject();
           existTwoSubject.setParentId(id);
           existTwoSubject.setTitle(subjectData.getTwoSubjectName());
           eduSubjectService.save(existTwoSubject);
       }
    }

    private EduSubject existTwoSubject(EduSubjectService eduSubjectService, String name, String id) {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id",id);
        EduSubject twoSubject = eduSubjectService.getOne(wrapper);
        return twoSubject;
    }

    private EduSubject existOneSubject(EduSubjectService eduSubjectService, String name) {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title", name);
        wrapper.eq("parent_id", "0");
        EduSubject eduSubject = eduSubjectService.getOne(wrapper);
        return eduSubject;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
