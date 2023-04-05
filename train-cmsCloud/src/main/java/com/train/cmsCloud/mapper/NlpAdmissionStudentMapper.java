package com.train.cmsCloud.mapper;

import java.util.List;
import com.train.common.domain.NlpAdmissionStudent;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学生 数据Mapper接口
 *
 * @author ICOVETOUS
 * @date 2023-04-05
 */
@Mapper
public interface NlpAdmissionStudentMapper
{
    /**
     * 查询学生 数据
     *
     * @param id 学生 数据主键
     * @return 学生 数据
     */
    public NlpAdmissionStudent selectNlpAdmissionStudentById(Integer id);

    /**
     * 查询学生 数据列表
     *
     * @param nlpAdmissionStudent 学生 数据
     * @return 学生 数据集合
     */
    public List<NlpAdmissionStudent> selectNlpAdmissionStudentList(NlpAdmissionStudent nlpAdmissionStudent);

    /**
     * 新增学生 数据
     *
     * @param nlpAdmissionStudent 学生 数据
     * @return 结果
     */
    public int insertNlpAdmissionStudent(NlpAdmissionStudent nlpAdmissionStudent);

    /**
     * 修改学生 数据
     *
     * @param nlpAdmissionStudent 学生 数据
     * @return 结果
     */
    public int updateNlpAdmissionStudent(NlpAdmissionStudent nlpAdmissionStudent);

    /**
     * 删除学生 数据
     *
     * @param id 学生 数据主键
     * @return 结果
     */
    public int deleteNlpAdmissionStudentById(Integer id);

    /**
     * 批量删除学生 数据
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNlpAdmissionStudentByIds(Integer[] ids);
}
