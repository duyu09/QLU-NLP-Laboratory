package com.train.cmsCloud.mapper;

import com.train.common.domain.NlpLabTeacher;
import com.train.common.domain.dto.NlpLabTeacherDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 职称Mapper接口
 * 
 * @author relief
 * @date 2023-05-16
 */
@Mapper
public interface NlpLabTeacherMapper 
{
    /**
     * 查询职称
     * 
     * @param id 职称主键
     * @return 职称
     */
    public NlpLabTeacher selectNlpLabTeacherById(Long id);

    /**
     * 查询职称列表
     * 
     * @param nlpLabTeacher 职称
     * @return 职称集合
     */
    public List<NlpLabTeacher> selectNlpLabTeacherList(NlpLabTeacher nlpLabTeacher);

    /**
     * 新增职称
     * 
     * @param nlpLabTeacher 职称
     * @return 结果
     */
    public int insertNlpLabTeacher(NlpLabTeacher nlpLabTeacher);

    /**
     * 修改职称
     * 
     * @param nlpLabTeacher 职称
     * @return 结果
     */
    public int updateNlpLabTeacher(NlpLabTeacher nlpLabTeacher);

    /**
     * 删除职称
     * 
     * @param id 职称主键
     * @return 结果
     */
    public int deleteNlpLabTeacherById(Long id);

    /**
     * 批量删除职称
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNlpLabTeacherByIds(Long[] ids);

    public NlpLabTeacher selectNlpLabTeacherByName(String name);
}
