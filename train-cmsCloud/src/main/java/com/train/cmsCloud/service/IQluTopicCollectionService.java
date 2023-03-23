package com.train.cmsCloud.service;

import java.util.List;
import com.train.cmsCloud.domain.QluTopicCollection;

/**
 * 题集资源管理Service接口
 * 
 * @author qluoj
 * @date 2022-01-02
 */
public interface IQluTopicCollectionService 
{
    /**
     * 查询题集资源管理
     * 
     * @param id 题集资源管理主键
     * @return 题集资源管理
     */
    public QluTopicCollection selectQluTopicCollectionById(String id);

    /**
     * 查询题集资源管理列表
     * 
     * @param qluTopicCollection 题集资源管理
     * @return 题集资源管理集合
     */
    public List<QluTopicCollection> selectQluTopicCollectionList(QluTopicCollection qluTopicCollection);

    /**
     * 新增题集资源管理
     * 
     * @param qluTopicCollection 题集资源管理
     * @return 结果
     */
    public int insertQluTopicCollection(QluTopicCollection qluTopicCollection);

    /**
     * 修改题集资源管理
     * 
     * @param qluTopicCollection 题集资源管理
     * @return 结果
     */
    public int updateQluTopicCollection(QluTopicCollection qluTopicCollection);

    /**
     * 批量删除题集资源管理
     * 
     * @param ids 需要删除的题集资源管理主键集合
     * @return 结果
     */
    public int deleteQluTopicCollectionByIds(String[] ids);

    /**
     * 删除题集资源管理信息
     * 
     * @param id 题集资源管理主键
     * @return 结果
     */
    public int deleteQluTopicCollectionById(String id);
}
