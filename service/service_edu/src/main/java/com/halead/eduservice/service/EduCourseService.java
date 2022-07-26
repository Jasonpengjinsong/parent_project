package com.halead.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.halead.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.halead.eduservice.entity.vo.CourseFrontVo;
import com.halead.eduservice.entity.vo.CourseInfoVo;
import com.halead.eduservice.entity.vo.CoursePublishVo;
import com.halead.eduservice.entity.vo.CourseWebVo;

import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2022-07-24
 */
public interface EduCourseService extends IService<EduCourse> {

    String saveCourseInfo(CourseInfoVo courseInfoVo);

    CourseInfoVo getCourseInfo(String courseId);

    void updateCourseInfo(CourseInfoVo courseInfoVo);

    CoursePublishVo publishCourseInfo(String id);

    void removeCourse(String courseId);

    Map<String, Object> getCourseFrontList(Page<EduCourse> pageCourse, CourseFrontVo courseFrontVo);

    CourseWebVo getBaseCourseInfo(String courseId);
}
