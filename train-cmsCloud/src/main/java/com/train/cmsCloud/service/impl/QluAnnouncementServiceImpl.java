package com.train.cmsCloud.service.impl;

import java.util.List;
import com.train.common.utils.DateUtils;
import com.train.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.train.cmsCloud.mapper.QluAnnouncementMapper;
import com.train.cmsCloud.domain.QluAnnouncement;
import com.train.cmsCloud.service.IQluAnnouncementService;

/**
 * 公告通知管理Service业务层处理
 * 
 * @author qluoj
 * @date 2022-01-02
 */
@Service
public class QluAnnouncementServiceImpl implements IQluAnnouncementService 
{
    @Autowired
    private QluAnnouncementMapper qluAnnouncementMapper;

    /**
     * 查询公告通知管理
     * 
     * @param id 公告通知管理主键
     * @return 公告通知管理
     */
    @Override
    public QluAnnouncement selectQluAnnouncementById(String id)
    {
        return qluAnnouncementMapper.selectQluAnnouncementById(id);
    }

    /**
     * 查询公告通知管理列表
     * 
     * @param qluAnnouncement 公告通知管理
     * @return 公告通知管理
     */
    @Override
    public List<QluAnnouncement> selectQluAnnouncementList(QluAnnouncement qluAnnouncement)
    {
        return qluAnnouncementMapper.selectQluAnnouncementList(qluAnnouncement);
    }

    /**
     * 新增公告通知管理
     * 
     * @param qluAnnouncement 公告通知管理
     * @return 结果
     */
    @Override
    public int insertQluAnnouncement(QluAnnouncement qluAnnouncement)
    {
        qluAnnouncement.setCreateBy(SecurityUtils.getUsername());
        qluAnnouncement.setCreateTime(DateUtils.getNowDate());
        return qluAnnouncementMapper.insertQluAnnouncement(qluAnnouncement);
    }

    /**
     * 修改公告通知管理
     * 
     * @param qluAnnouncement 公告通知管理
     * @return 结果
     */
    @Override
    public int updateQluAnnouncement(QluAnnouncement qluAnnouncement)
    {
        qluAnnouncement.setUpdateBy(SecurityUtils.getUsername());
        qluAnnouncement.setUpdateTime(DateUtils.getNowDate());
        return qluAnnouncementMapper.updateQluAnnouncement(qluAnnouncement);
    }

    /**
     * 批量删除公告通知管理
     * 
     * @param ids 需要删除的公告通知管理主键
     * @return 结果
     */
    @Override
    public int deleteQluAnnouncementByIds(String[] ids)
    {
        return qluAnnouncementMapper.deleteQluAnnouncementByIds(ids);
    }

    /**
     * 删除公告通知管理信息
     * 
     * @param id 公告通知管理主键
     * @return 结果
     */
    @Override
    public int deleteQluAnnouncementById(String id)
    {
        return qluAnnouncementMapper.deleteQluAnnouncementById(id);
    }
}
