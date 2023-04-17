package com.train.cmsCloud.mapper;

import java.util.List;
import com.train.common.domain.NlpLabProject;
import org.apache.ibatis.annotations.Mapper;

/**
 * 项目管理Mapper接口
 * 
 * @author relief
 * @date 2023-04-07
 */
@Mapper
public interface NlpLabProjectMapper 
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
     * 删除项目管理
     * 
     * @param id 项目管理主键
     * @return 结果
     */
    public int deleteNlpLabProjectById(Long id);

    /**
     * 批量删除项目管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNlpLabProjectByIds(Long[] ids);
}
