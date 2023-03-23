package com.train.cmsCloud.service;

import java.util.List;
import com.train.cmsCloud.domain.QluAnnouncement;

/**
 * 公告通知管理Service接口
 * 
 * @author qluoj
 * @date 2022-01-02
 */
public interface IQluAnnouncementService 
{
    /**
     * 查询公告通知管理
     * 
     * @param id 公告通知管理主键
     * @return 公告通知管理
     */
    public QluAnnouncement selectQluAnnouncementById(String id);

    /**
     * 查询公告通知管理列表
     * 
     * @param qluAnnouncement 公告通知管理
     * @return 公告通知管理集合
     */
    public List<QluAnnouncement> selectQluAnnouncementList(QluAnnouncement qluAnnouncement);

    /**
     * 新增公告通知管理
     * 
     * @param qluAnnouncement 公告通知管理
     * @return 结果
     */
    public int insertQluAnnouncement(QluAnnouncement qluAnnouncement);

    /**
     * 修改公告通知管理
     * 
     * @param qluAnnouncement 公告通知管理
     * @return 结果
     */
    public int updateQluAnnouncement(QluAnnouncement qluAnnouncement);

    /**
     * 批量删除公告通知管理
     * 
     * @param ids 需要删除的公告通知管理主键集合
     * @return 结果
     */
    public int deleteQluAnnouncementByIds(String[] ids);

    /**
     * 删除公告通知管理信息
     * 
     * @param id 公告通知管理主键
     * @return 结果
     */
    public int deleteQluAnnouncementById(String id);
}
