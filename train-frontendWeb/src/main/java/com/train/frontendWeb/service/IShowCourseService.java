package com.train.frontendWeb.service;

import com.train.frontendWeb.domain.WebCourse;

import java.util.List;

public interface IShowCourseService {
    /**
     * 查询视频资源管理
     *
     * @param id 视频资源管理主键
     * @return 视频资源管理
     */
    public WebCourse selectShowCourseById(String id);

    /**
     * 查询视频资源管理列表
     *
     * @param qluCourse 视频资源管理
     * @return 视频资源管理集合
     */
    public List<WebCourse> selectShowCourseList(WebCourse qluCourse);

}
