package com.train.frontendWeb.service.impl;

import com.train.frontendWeb.domain.WebCourse;
import com.train.frontendWeb.mapper.ShowCourseMapper;
import com.train.frontendWeb.service.IShowCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowCourseServiceImpl implements IShowCourseService{
    @Autowired
    private ShowCourseMapper qluCourseMapper;

    /**
     * 查询视频资源管理
     *
     * @param id 视频资源管理主键
     * @return 视频资源管理
     */
    @Override
    public WebCourse selectShowCourseById(String id)
    {
        return qluCourseMapper.selectShowCourseById(id);
    }

    /**
     * 查询视频资源管理列表
     *
     * @param qluCourse 视频资源管理
     * @return 视频资源管理
     */
    @Override
    public List<WebCourse> selectShowCourseList(WebCourse qluCourse)
    {
        return qluCourseMapper.selectShowCourseList(qluCourse);
    }
}
