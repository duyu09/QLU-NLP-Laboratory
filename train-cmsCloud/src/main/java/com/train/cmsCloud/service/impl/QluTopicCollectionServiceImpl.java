package com.train.cmsCloud.service.impl;

import java.util.List;
import com.train.common.utils.DateUtils;
import com.train.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.train.cmsCloud.mapper.QluTopicCollectionMapper;
import com.train.cmsCloud.domain.QluTopicCollection;
import com.train.cmsCloud.service.IQluTopicCollectionService;

/**
 * 题集资源管理Service业务层处理
 * 
 * @author qluoj
 * @date 2022-01-02
 */
@Service
public class QluTopicCollectionServiceImpl implements IQluTopicCollectionService 
{
    @Autowired
    private QluTopicCollectionMapper qluTopicCollectionMapper;

    /**
     * 查询题集资源管理
     * 
     * @param id 题集资源管理主键
     * @return 题集资源管理
     */
    @Override
    public QluTopicCollection selectQluTopicCollectionById(String id)
    {
        return qluTopicCollectionMapper.selectQluTopicCollectionById(id);
    }

    /**
     * 查询题集资源管理列表
     * 
     * @param qluTopicCollection 题集资源管理
     * @return 题集资源管理
     */
    @Override
    public List<QluTopicCollection> selectQluTopicCollectionList(QluTopicCollection qluTopicCollection)
    {
        return qluTopicCollectionMapper.selectQluTopicCollectionList(qluTopicCollection);
    }

    /**
     * 新增题集资源管理
     * 
     * @param qluTopicCollection 题集资源管理
     * @return 结果
     */
    @Override
    public int insertQluTopicCollection(QluTopicCollection qluTopicCollection)
    {
        qluTopicCollection.setCreateBy(SecurityUtils.getUsername());
        qluTopicCollection.setCreateTime(DateUtils.getNowDate());
        return qluTopicCollectionMapper.insertQluTopicCollection(qluTopicCollection);
    }

    /**
     * 修改题集资源管理
     * 
     * @param qluTopicCollection 题集资源管理
     * @return 结果
     */
    @Override
    public int updateQluTopicCollection(QluTopicCollection qluTopicCollection)
    {
        qluTopicCollection.setUpdateBy(SecurityUtils.getUsername());
        qluTopicCollection.setUpdateTime(DateUtils.getNowDate());
        return qluTopicCollectionMapper.updateQluTopicCollection(qluTopicCollection);
    }

    /**
     * 批量删除题集资源管理
     * 
     * @param ids 需要删除的题集资源管理主键
     * @return 结果
     */
    @Override
    public int deleteQluTopicCollectionByIds(String[] ids)
    {
        return qluTopicCollectionMapper.deleteQluTopicCollectionByIds(ids);
    }

    /**
     * 删除题集资源管理信息
     * 
     * @param id 题集资源管理主键
     * @return 结果
     */
    @Override
    public int deleteQluTopicCollectionById(String id)
    {
        return qluTopicCollectionMapper.deleteQluTopicCollectionById(id);
    }
}
