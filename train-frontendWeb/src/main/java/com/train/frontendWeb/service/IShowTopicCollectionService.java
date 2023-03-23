package com.train.frontendWeb.service;

import com.train.frontendWeb.domain.WebTopicCollection;

import java.util.List;

public interface IShowTopicCollectionService {
    /**
     * 查询题集资源管理
     *
     * @param id 题集资源管理主键
     * @return 题集资源管理
     */
    public WebTopicCollection selectShowTopicCollectionById(String id);

    /**
     * 查询题集资源管理列表
     *
     * @param qluTopicCollection 题集资源管理
     * @return 题集资源管理集合
     */
    public List<WebTopicCollection> selectShowTopicCollectionList(WebTopicCollection qluTopicCollection);
}
