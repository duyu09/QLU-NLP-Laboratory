package com.train.frontendWeb.mapper;

import com.train.frontendWeb.domain.WebAnnouncement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Along
 */
@Mapper
public interface ShowAnnouncementMapper {

    /**
     * 查询公告通知管理
     *
     * @param id 公告通知管理主键
     * @return 公告通知管理
     */
    public WebAnnouncement selectShowAnnouncementById(String id);

    /**
     * 查询公告通知管理列表
     *
     * @param qluAnnouncement 公告通知管理
     * @return 公告通知管理集合
     */
    public List<WebAnnouncement> selectShowAnnouncementList(WebAnnouncement qluAnnouncement);

}
