package com.train.frontendWeb.service.impl;

import com.train.frontendWeb.domain.WebAnnouncement;
import com.train.frontendWeb.mapper.ShowAnnouncementMapper;
import com.train.frontendWeb.service.IShowAnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Along
 */
@Service
public class ShowAnnouncementServiceImpl implements IShowAnnouncementService {

    @Autowired
    private ShowAnnouncementMapper showAnnouncementMapper;

    /**
     * 查询公告通知管理
     *
     * @param id 公告通知管理主键
     * @return 公告通知管理
     */
    @Override
    public WebAnnouncement selectShowAnnouncementById(String id)
    {
        return showAnnouncementMapper.selectShowAnnouncementById(id);
    }

    /**
     * 查询公告通知管理列表
     *
     * @param qluAnnouncement 公告通知管理
     * @return 公告通知管理
     */
    @Override
    public List<WebAnnouncement> selectShowAnnouncementList(WebAnnouncement qluAnnouncement)
    {
        return showAnnouncementMapper.selectShowAnnouncementList(qluAnnouncement);
    }
}
