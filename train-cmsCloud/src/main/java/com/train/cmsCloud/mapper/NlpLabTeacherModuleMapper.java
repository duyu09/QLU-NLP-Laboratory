package com.train.cmsCloud.mapper;

import com.train.common.domain.NlpLabTeacherModule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 成员编辑器Mapper接口
 * 
 * @author relief
 * @date 2023-05-18
 */
@Mapper
public interface NlpLabTeacherModuleMapper 
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
     * 删除成员编辑器
     * 
     * @param id 成员编辑器主键
     * @return 结果
     */
    public int deleteNlpLabTeacherModuleById(Long id);

    /**
     * 批量删除成员编辑器
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int  deleteNlpLabTeacherModuleByIds(Long[] ids);
//    通过teacherId进行删除操作
    public int deleteNlpLabTeacherModuleByTeacherId(Long teacherId);
}
