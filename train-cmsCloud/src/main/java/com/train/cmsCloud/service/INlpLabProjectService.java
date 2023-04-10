package com.train.cmsCloud.service;

import com.train.common.domain.NlpLabProject;

import java.util.List;


/**
 * 项目管理Service接口
 * 
 * @author relief
 * @date 2023-04-07
 */
public interface INlpLabProjectService 
{
    /**
     * 查询项目管理
     * 
     * @param id 项目管理主键
     * @return 项目管理
     */
    public NlpLabProject selectNlpLabProjectById(Long id);

    /**
     * 查询项目管理列表
     * 
     * @param nlpLabProject 项目管理
     * @return 项目管理集合
     */
    public List<NlpLabProject> selectNlpLabProjectList(NlpLabProject nlpLabProject);

    /**
     * 新增项目管理
     * 
     * @param nlpLabProject 项目管理
     * @return 结果
     */
    public int insertNlpLabProject(NlpLabProject nlpLabProject);

    /**
     * 修改项目管理
     * 
     * @param nlpLabProject 项目管理
     * @return 结果
     */
    public int updateNlpLabProject(NlpLabProject nlpLabProject);

    /**
     * 批量删除项目管理
     * 
     * @param ids 需要删除的项目管理主键集合
     * @return 结果
     */
    public int deleteNlpLabProjectByIds(Long[] ids);

    /**
     * 删除项目管理信息
     * 
     * @param id 项目管理主键
     * @return 结果
     */
    public int deleteNlpLabProjectById(Long id);
}
