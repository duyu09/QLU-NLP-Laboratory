package com.train.cmsCloud.service.impl;

import java.util.List;

import com.train.common.domain.NlpLabAchievement;
import com.train.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.train.cmsCloud.mapper.NlpLabAchievementMapper;
import com.train.cmsCloud.service.INlpLabAchievementService;

/**
 * 成果管理Service业务层处理
 * 
 * @author relief
 * @date 2023-04-07
 */
@Service
public class NlpLabAchievementServiceImpl implements INlpLabAchievementService 
{
    @Autowired
    private NlpLabAchievementMapper nlpLabAchievementMapper;

    /**
     * 查询成果管理
     * 
     * @param id 成果管理主键
     * @return 成果管理
     */
    @Override
    public NlpLabAchievement selectNlpLabAchievementById(Long id)
    {
        return nlpLabAchievementMapper.selectNlpLabAchievementById(id);
    }

    /**
     * 查询成果管理列表
     * 
     * @param nlpLabAchievement 成果管理
     * @return 成果管理
     */
    @Override
    public List<NlpLabAchievement> selectNlpLabAchievementList(NlpLabAchievement nlpLabAchievement)
    {
        return nlpLabAchievementMapper.selectNlpLabAchievementList(nlpLabAchievement);
    }

    /**
     * 新增成果管理
     * 
     * @param nlpLabAchievement 成果管理
     * @return 结果
     */
    @Override
    public int insertNlpLabAchievement(NlpLabAchievement nlpLabAchievement)
    {
        nlpLabAchievement.setCreateTime(DateUtils.getNowDate());
        return nlpLabAchievementMapper.insertNlpLabAchievement(nlpLabAchievement);
    }

    /**
     * 修改成果管理
     * 
     * @param nlpLabAchievement 成果管理
     * @return 结果
     */
    @Override
    public int updateNlpLabAchievement(NlpLabAchievement nlpLabAchievement)
    {
        return nlpLabAchievementMapper.updateNlpLabAchievement(nlpLabAchievement);
    }

    /**
     * 批量删除成果管理
     * 
     * @param ids 需要删除的成果管理主键
     * @return 结果
     */
    @Override
    public int deleteNlpLabAchievementByIds(Long[] ids)
    {
        return nlpLabAchievementMapper.deleteNlpLabAchievementByIds(ids);
    }

    /**
     * 删除成果管理信息
     * 
     * @param id 成果管理主键
     * @return 结果
     */
    @Override
    public int deleteNlpLabAchievementById(Long id)
    {
        return nlpLabAchievementMapper.deleteNlpLabAchievementById(id);
    }
}
