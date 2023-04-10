package com.train.cmsCloud.service.impl;

import java.util.List;

import com.train.common.domain.NlpLabProject;
import com.train.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.train.cmsCloud.mapper.NlpLabProjectMapper;
import com.train.cmsCloud.service.INlpLabProjectService;

/**
 * 项目管理Service业务层处理
 * 
 * @author relief
 * @date 2023-04-07
 */
@Service
public class NlpLabProjectServiceImpl implements INlpLabProjectService 
{
    @Autowired
    private NlpLabProjectMapper nlpLabProjectMapper;

    /**
     * 查询项目管理
     * 
     * @param id 项目管理主键
     * @return 项目管理
     */
    @Override
    public NlpLabProject selectNlpLabProjectById(Long id)
    {
        return nlpLabProjectMapper.selectNlpLabProjectById(id);
    }

    /**
     * 查询项目管理列表
     * 
     * @param nlpLabProject 项目管理
     * @return 项目管理
     */
    @Override
    public List<NlpLabProject> selectNlpLabProjectList(NlpLabProject nlpLabProject)
    {
        return nlpLabProjectMapper.selectNlpLabProjectList(nlpLabProject);
    }

    /**
     * 新增项目管理
     * 
     * @param nlpLabProject 项目管理
     * @return 结果
     */
    @Override
    public int insertNlpLabProject(NlpLabProject nlpLabProject)
    {
        nlpLabProject.setCreateTime(DateUtils.getNowDate());
        return nlpLabProjectMapper.insertNlpLabProject(nlpLabProject);
    }

    /**
     * 修改项目管理
     * 
     * @param nlpLabProject 项目管理
     * @return 结果
     */
    @Override
    public int updateNlpLabProject(NlpLabProject nlpLabProject)
    {
        return nlpLabProjectMapper.updateNlpLabProject(nlpLabProject);
    }

    /**
     * 批量删除项目管理
     * 
     * @param ids 需要删除的项目管理主键
     * @return 结果
     */
    @Override
    public int deleteNlpLabProjectByIds(Long[] ids)
    {
        return nlpLabProjectMapper.deleteNlpLabProjectByIds(ids);
    }

    /**
     * 删除项目管理信息
     * 
     * @param id 项目管理主键
     * @return 结果
     */
    @Override
    public int deleteNlpLabProjectById(Long id)
    {
        return nlpLabProjectMapper.deleteNlpLabProjectById(id);
    }
}
