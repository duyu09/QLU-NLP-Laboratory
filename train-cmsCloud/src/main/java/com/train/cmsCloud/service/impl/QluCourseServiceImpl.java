package com.train.cmsCloud.service.impl;

import java.util.List;
import com.train.common.utils.DateUtils;
import com.train.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.train.cmsCloud.mapper.QluCourseMapper;
import com.train.cmsCloud.domain.QluCourse;
import com.train.cmsCloud.service.IQluCourseService;

/**
 * 视频资源管理Service业务层处理
 * 
 * @author qluoj
 * @date 2022-01-02
 */
@Service
public class QluCourseServiceImpl implements IQluCourseService 
{
    @Autowired
    private QluCourseMapper qluCourseMapper;

    /**
     * 查询视频资源管理
     * 
     * @param id 视频资源管理主键
     * @return 视频资源管理
     */
    @Override
    public QluCourse selectQluCourseById(String id)
    {
        return qluCourseMapper.selectQluCourseById(id);
    }

    /**
     * 查询视频资源管理列表
     * 
     * @param qluCourse 视频资源管理
     * @return 视频资源管理
     */
    @Override
    public List<QluCourse> selectQluCourseList(QluCourse qluCourse)
    {
        return qluCourseMapper.selectQluCourseList(qluCourse);
    }

    /**
     * 新增视频资源管理
     * 
     * @param qluCourse 视频资源管理
     * @return 结果
     */
    @Override
    public int insertQluCourse(QluCourse qluCourse)
    {
        qluCourse.setCreateBy(SecurityUtils.getUsername());
        qluCourse.setCreateTime(DateUtils.getNowDate());
        return qluCourseMapper.insertQluCourse(qluCourse);
    }

    /**
     * 修改视频资源管理
     * 
     * @param qluCourse 视频资源管理
     * @return 结果
     */
    @Override
    public int updateQluCourse(QluCourse qluCourse)
    {
        qluCourse.setUpdateBy(SecurityUtils.getUsername());
        qluCourse.setUpdateTime(DateUtils.getNowDate());
        return qluCourseMapper.updateQluCourse(qluCourse);
    }

    /**
     * 批量删除视频资源管理
     * 
     * @param ids 需要删除的视频资源管理主键
     * @return 结果
     */
    @Override
    public int deleteQluCourseByIds(String[] ids)
    {
        return qluCourseMapper.deleteQluCourseByIds(ids);
    }

    /**
     * 删除视频资源管理信息
     * 
     * @param id 视频资源管理主键
     * @return 结果
     */
    @Override
    public int deleteQluCourseById(String id)
    {
        return qluCourseMapper.deleteQluCourseById(id);
    }
}
