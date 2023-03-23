package com.train.cmsCloud.mapper;

import java.util.List;
import com.train.cmsCloud.domain.QluCourse;
import org.apache.ibatis.annotations.Mapper;

/**
 * 视频资源管理Mapper接口
 * 
 * @author qluoj
 * @date 2022-01-02
 */
@Mapper
public interface QluCourseMapper 
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
     * 删除视频资源管理
     * 
     * @param id 视频资源管理主键
     * @return 结果
     */
    public int deleteQluCourseById(String id);

    /**
     * 批量删除视频资源管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteQluCourseByIds(String[] ids);
}
