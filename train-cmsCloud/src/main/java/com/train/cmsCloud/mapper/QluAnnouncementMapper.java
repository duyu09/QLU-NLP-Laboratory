package com.train.cmsCloud.mapper;

import java.util.List;
import com.train.cmsCloud.domain.QluAnnouncement;
import org.apache.ibatis.annotations.Mapper;

/**
 * 公告通知管理Mapper接口
 * 
 * @author qluoj
 * @date 2022-01-02
 */
@Mapper
public interface QluAnnouncementMapper 
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
     * 删除公告通知管理
     * 
     * @param id 公告通知管理主键
     * @return 结果
     */
    public int deleteQluAnnouncementById(String id);

    /**
     * 批量删除公告通知管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteQluAnnouncementByIds(String[] ids);
}
