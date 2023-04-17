package com.train.cmsCloud.mapper;

import com.train.common.domain.NlpLabAchievement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
/**
 * 成果管理Mapper接口
 * 
 * @author relief
 * @date 2023-04-07
 */
public interface NlpLabAchievementMapper 
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
     * 删除成果管理
     * 
     * @param id 成果管理主键
     * @return 结果
     */
    public int deleteNlpLabAchievementById(Long id);

    /**
     * 批量删除成果管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNlpLabAchievementByIds(Long[] ids);
}
