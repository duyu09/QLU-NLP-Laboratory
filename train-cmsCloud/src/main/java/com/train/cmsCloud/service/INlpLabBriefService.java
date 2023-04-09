package com.train.cmsCloud.service;

import java.util.List;

import com.train.common.domain.NlpLabBrief;

/**
 * 简介管理Service接口
 * 
 * @author relief
 * @date 2023-04-06
 */
public interface INlpLabBriefService 
{
    /**
     * 查询简介管理
     * 
     * @param id 简介管理主键
     * @return 简介管理
     */
    public NlpLabBrief selectNlpLabBriefById(Long id);

    /**
     * 查询简介管理列表
     * 
     * @param nlpLabBrief 简介管理
     * @return 简介管理集合
     */
    public List<NlpLabBrief> selectNlpLabBriefList(NlpLabBrief nlpLabBrief);

    /**
     * 新增简介管理
     * 
     * @param nlpLabBrief 简介管理
     * @return 结果
     */
    public int insertNlpLabBrief(NlpLabBrief nlpLabBrief);

    /**
     * 修改简介管理
     * 
     * @param nlpLabBrief 简介管理
     * @return 结果
     */
    public int updateNlpLabBrief(NlpLabBrief nlpLabBrief);

    /**
     * 批量删除简介管理
     * 
     * @param ids 需要删除的简介管理主键集合
     * @return 结果
     */
    public int deleteNlpLabBriefByIds(Long[] ids);

    /**
     * 删除简介管理信息
     * 
     * @param id 简介管理主键
     * @return 结果
     */
    public int deleteNlpLabBriefById(Long id);
}
