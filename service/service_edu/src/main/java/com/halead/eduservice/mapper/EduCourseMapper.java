package com.halead.eduservice.mapper;

import com.halead.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.halead.eduservice.entity.vo.CourseWebVo;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2022-07-24
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {

    CourseWebVo getBaseCourseInfo(String courseId);
}
