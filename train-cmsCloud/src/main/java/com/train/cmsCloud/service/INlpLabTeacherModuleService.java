package com.train.cmsCloud.service;

import com.train.common.domain.NlpLabTeacherModule;

import java.util.List;


/**
 * 成员编辑器Service接口
 * 
 * @author relief
 * @date 2023-05-18
 */
public interface INlpLabTeacherModuleService 
{
    /**
     * 查询成员编辑器
     * 
     * @param id 成员编辑器主键
     * @return 成员编辑器
     */
    public NlpLabTeacherModule selectNlpLabTeacherModuleById(Long id);

    /**
     * 查询成员编辑器列表
     * 
     * @param nlpLabTeacherModule 成员编辑器
     * @return 成员编辑器集合
     */
    public List<NlpLabTeacherModule> selectNlpLabTeacherModuleList(NlpLabTeacherModule nlpLabTeacherModule);

    /**
     * 新增成员编辑器
     * 
     * @param nlpLabTeacherModule 成员编辑器
     * @return 结果
     */
    public int insertNlpLabTeacherModule(NlpLabTeacherModule nlpLabTeacherModule);

    /**
     * 修改成员编辑器
     * 
     * @param nlpLabTeacherModule 成员编辑器
     * @return 结果
     */
    public int updateNlpLabTeacherModule(NlpLabTeacherModule nlpLabTeacherModule);

    /**
     * 批量删除成员编辑器
     * 
     * @param ids 需要删除的成员编辑器主键集合
     * @return 结果
     */
    public int deleteNlpLabTeacherModuleByIds(Long[] ids);

    /**
     * 删除成员编辑器信息
     * 
     * @param id 成员编辑器主键
     * @return 结果
     */
    public int deleteNlpLabTeacherModuleById(Long id);
}
