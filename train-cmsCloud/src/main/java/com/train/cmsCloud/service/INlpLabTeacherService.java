package com.train.cmsCloud.service;

import com.train.common.core.domain.entity.SysUser;
import com.train.common.domain.NlpLabTeacher;
import com.train.common.domain.NlpLabTeacherModule;
import com.train.common.domain.dto.NlpLabTeacherDto;

import java.util.List;

/**
 * 职称Service接口
 *
 * @author relief
 * @date 2023-05-16
 */
public interface INlpLabTeacherService
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
     * @param职称
     * @return 结果
     */
    public int insertNlpLabTeacher(NlpLabTeacherDto nlpLabTeacherdto);

    /**
     * 修改职称
     *
     * @param nlpLabTeacher 职称
     * @return 结果
     */
    public int updateNlpLabTeacher(NlpLabTeacherDto nlpLabTeacher);

    /**
     * 修改职称
     *
     * @param nlpLabTeacher 职称
     * @return 结果
     */
    public int save(NlpLabTeacherDto nlpLabTeacher);

    /**
     * 批量删除职称
     *
     * @param ids 需要删除的职称主键集合
     * @return 结果
     */
    public int deleteNlpLabTeacherByIds(Long[] ids);

    /**
     * 删除职称信息
     *
     * @param id 职称主键
     * @return 结果
     */
    public int deleteNlpLabTeacherById(Long id);
//    查询老师编辑器具体内容
    List<NlpLabTeacherDto> selectNlpLabTeacherDtoList();

    NlpLabTeacherDto selectNlpLabTeacherDtoById(Long id);

}
