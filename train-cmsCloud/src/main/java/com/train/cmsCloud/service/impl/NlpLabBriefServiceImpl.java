package com.train.cmsCloud.service.impl;

import java.util.List;

import com.train.cmsCloud.mapper.NlpLabBriefMapper;
import com.train.cmsCloud.service.INlpLabBriefService;
import com.train.common.domain.NlpLabBrief;
import com.train.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 简介管理Service业务层处理
 * 
 * @author relief
 * @date 2023-04-06
 */
@Service
public class NlpLabBriefServiceImpl implements INlpLabBriefService
{
    @Autowired
    private NlpLabBriefMapper nlpLabBriefMapper;

    /**
     * 查询简介管理
     * 
     * @param id 简介管理主键
     * @return 简介管理
     */
    @Override
    public NlpLabBrief selectNlpLabBriefById(Long id)
    {
        return nlpLabBriefMapper.selectNlpLabBriefById(id);
    }

    /**
     * 查询简介管理列表
     * 
     * @param nlpLabBrief 简介管理
     * @return 简介管理
     */
    @Override
    public List<NlpLabBrief> selectNlpLabBriefList(NlpLabBrief nlpLabBrief)
    {
        return nlpLabBriefMapper.selectNlpLabBriefList(nlpLabBrief);
    }

    /**
     * 新增简介管理
     * 
     * @param nlpLabBrief 简介管理
     * @return 结果
     */
    @Override
    public int insertNlpLabBrief(NlpLabBrief nlpLabBrief)
    {
        nlpLabBrief.setCreateTime(DateUtils.getNowDate());
        return nlpLabBriefMapper.insertNlpLabBrief(nlpLabBrief);
    }

    /**
     * 修改简介管理
     * 
     * @param nlpLabBrief 简介管理
     * @return 结果
     */
    @Override
    public int updateNlpLabBrief(NlpLabBrief nlpLabBrief)
    {
        return nlpLabBriefMapper.updateNlpLabBrief(nlpLabBrief);
    }

    /**
     * 批量删除简介管理
     * 
     * @param ids 需要删除的简介管理主键
     * @return 结果
     */
    @Override
    public int deleteNlpLabBriefByIds(Long[] ids)
    {
        return nlpLabBriefMapper.deleteNlpLabBriefByIds(ids);
    }

    /**
     * 删除简介管理信息
     * 
     * @param id 简介管理主键
     * @return 结果
     */
    @Override
    public int deleteNlpLabBriefById(Long id)
    {
        return nlpLabBriefMapper.deleteNlpLabBriefById(id);
    }
}
