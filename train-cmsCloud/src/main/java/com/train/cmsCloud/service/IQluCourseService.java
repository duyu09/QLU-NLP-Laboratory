package com.train.cmsCloud.service;

import java.util.List;
import com.train.cmsCloud.domain.QluCourse;

/**
 * 视频资源管理Service接口
 * 
 * @author qluoj
 * @date 2022-01-02
 */
public interface IQluCourseService 
{
    /**
     * 查询视频资源管理
     * 
     * @param id 视频资源管理主键
     * @return 视频资源管理
     */
    public QluCourse selectQluCourseById(String id);

    /**
     * 查询视频资源管理列表
     * 
     * @param qluCourse 视频资源管理
     * @return 视频资源管理集合
     */
    public List<QluCourse> selectQluCourseList(QluCourse qluCourse);

    /**
     * 新增视频资源管理
     * 
     * @param qluCourse 视频资源管理
     * @return 结果
     */
    public int insertQluCourse(QluCourse qluCourse);

    /**
     * 修改视频资源管理
     * 
     * @param qluCourse 视频资源管理
     * @return 结果
     */
    public int updateQluCourse(QluCourse qluCourse);

    /**
     * 批量删除视频资源管理
     * 
     * @param ids 需要删除的视频资源管理主键集合
     * @return 结果
     */
    public int deleteQluCourseByIds(String[] ids);

    /**
     * 删除视频资源管理信息
     * 
     * @param id 视频资源管理主键
     * @return 结果
     */
    public int deleteQluCourseById(String id);
}
