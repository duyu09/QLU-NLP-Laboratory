package com.train.cmsCloud.service;

import com.train.common.domain.NlpLabAchievement;

import java.util.List;


/**
 * 成果管理Service接口
 * 
 * @author relief
 * @date 2023-04-07
 */
public interface INlpLabAchievementService 
{
    /**
     * 查询成果管理
     * 
     * @param id 成果管理主键
     * @return 成果管理
     */
    public NlpLabAchievement selectNlpLabAchievementById(Long id);

    /**
     * 查询成果管理列表
     * 
     * @param nlpLabAchievement 成果管理
     * @return 成果管理集合
     */
    public List<NlpLabAchievement> selectNlpLabAchievementList(NlpLabAchievement nlpLabAchievement);

    /**
     * 新增成果管理
     * 
     * @param nlpLabAchievement 成果管理
     * @return 结果
     */
    public int insertNlpLabAchievement(NlpLabAchievement nlpLabAchievement);

    /**
     * 修改成果管理
     * 
     * @param nlpLabAchievement 成果管理
     * @return 结果
     */
    public int updateNlpLabAchievement(NlpLabAchievement nlpLabAchievement);

    /**
     * 批量删除成果管理
     * 
     * @param ids 需要删除的成果管理主键集合
     * @return 结果
     */
    public int deleteNlpLabAchievementByIds(Long[] ids);

    /**
     * 删除成果管理信息
     * 
     * @param id 成果管理主键
     * @return 结果
     */
    public int deleteNlpLabAchievementById(Long id);
}
