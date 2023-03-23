package com.train.frontendWeb.service.impl;

import com.train.frontendWeb.domain.WebTopicCollection;
import com.train.frontendWeb.mapper.ShowTopicCollectionMapper;
import com.train.frontendWeb.service.IShowTopicCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowTopicCollectionServiceImpl implements IShowTopicCollectionService {
    @Autowired
    private ShowTopicCollectionMapper qluTopicCollectionMapper;

    /**
     * 查询题集资源管理
     *
     * @param id 题集资源管理主键
     * @return 题集资源管理
     */
    @Override
    public WebTopicCollection selectShowTopicCollectionById(String id)
    {
        return qluTopicCollectionMapper.selectShowTopicCollectionById(id);
    }

    /**
     * 查询题集资源管理列表
     *
     * @param qluTopicCollection 题集资源管理
     * @return 题集资源管理
     */
    @Override
    public List<WebTopicCollection> selectShowTopicCollectionList(WebTopicCollection qluTopicCollection)
    {
        return qluTopicCollectionMapper.selectShowTopicCollectionList(qluTopicCollection);
    }

}
