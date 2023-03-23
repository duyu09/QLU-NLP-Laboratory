package com.train.frontendWeb.mapper;

import com.train.frontendWeb.domain.WebCourse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Along
 */
@Mapper
public interface ShowCourseMapper {
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
