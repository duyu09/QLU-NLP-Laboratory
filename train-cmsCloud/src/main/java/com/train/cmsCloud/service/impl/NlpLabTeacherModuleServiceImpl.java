package com.train.cmsCloud.service.impl;

import com.train.cmsCloud.mapper.NlpLabTeacherModuleMapper;
import com.train.cmsCloud.service.INlpLabTeacherModuleService;
import com.train.common.domain.NlpLabTeacherModule;
import com.train.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 成员编辑器Service业务层处理
 * 
 * @author relief
 * @date 2023-05-18
 */
@Transactional
@Service
public class NlpLabTeacherModuleServiceImpl implements INlpLabTeacherModuleService
{
    @Autowired
    private NlpLabTeacherModuleMapper nlpLabTeacherModuleMapper;

    /**
     * 查询成员编辑器
     * 
     * @param id 成员编辑器主键
     * @return 成员编辑器
     */
    @Override
    public NlpLabTeacherModule selectNlpLabTeacherModuleById(Long id)
    {
        return nlpLabTeacherModuleMapper.selectNlpLabTeacherModuleById(id);
    }

    /**
     * 查询成员编辑器列表
     * 
     * @param nlpLabTeacherModule 成员编辑器
     * @return 成员编辑器
     */
    @Override
    public List<NlpLabTeacherModule> selectNlpLabTeacherModuleList(NlpLabTeacherModule nlpLabTeacherModule)
    {
        return nlpLabTeacherModuleMapper.selectNlpLabTeacherModuleList(nlpLabTeacherModule);
    }

    /**
     * 新增成员编辑器
     * 
     * @param nlpLabTeacherModule 成员编辑器
     * @return 结果
     */
    @Override
    public int insertNlpLabTeacherModule(NlpLabTeacherModule nlpLabTeacherModule)
    {
        nlpLabTeacherModule.setCreateTime(DateUtils.getNowDate());
        return nlpLabTeacherModuleMapper.insertNlpLabTeacherModule(nlpLabTeacherModule);
    }

    /**
     * 修改成员编辑器
     * 
     * @param nlpLabTeacherModule 成员编辑器
     * @return 结果
     */
    @Override
    public int updateNlpLabTeacherModule(NlpLabTeacherModule nlpLabTeacherModule)
    {
        return nlpLabTeacherModuleMapper.updateNlpLabTeacherModule(nlpLabTeacherModule);
    }

    /**
     * 批量删除成员编辑器
     * 
     * @param ids 需要删除的成员编辑器主键
     * @return 结果
     */
    @Override
    public int deleteNlpLabTeacherModuleByIds(Long[] ids)
    {
        return nlpLabTeacherModuleMapper.deleteNlpLabTeacherModuleByIds(ids);
    }

    /**
     * 删除成员编辑器信息
     * 
     * @param id 成员编辑器主键
     * @return 结果
     */
    @Override
    public int deleteNlpLabTeacherModuleById(Long id)
    {
        return nlpLabTeacherModuleMapper.deleteNlpLabTeacherModuleById(id);
    }
}
