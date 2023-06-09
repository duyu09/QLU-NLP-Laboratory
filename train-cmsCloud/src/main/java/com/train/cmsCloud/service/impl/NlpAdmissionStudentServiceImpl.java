package com.train.cmsCloud.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.train.common.enums.UserStatus;
import com.train.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.train.cmsCloud.mapper.NlpAdmissionStudentMapper;
import com.train.common.domain.NlpAdmissionStudent;
import com.train.cmsCloud.service.INlpAdmissionStudentService;

/**
 * 学生 数据Service业务层处理
 *
 * @author ICOVETOUS
 * @date 2023-04-05
 */
@Service
public class NlpAdmissionStudentServiceImpl implements INlpAdmissionStudentService
{
    @Autowired
    private NlpAdmissionStudentMapper nlpAdmissionStudentMapper;

    /**
     * 查询学生 数据
     *
     * @param id 学生 数据主键
     * @return 学生 数据
     */
    @Override
    public NlpAdmissionStudent selectNlpAdmissionStudentById(Integer id)
    {
        return nlpAdmissionStudentMapper.selectNlpAdmissionStudentById(id);
    }

    /**
     * 查询学生 数据列表
     *
     * @param nlpAdmissionStudent 学生 数据
     * @return 学生 数据
     */
    @Override
    public List<NlpAdmissionStudent> selectNlpAdmissionStudentList(NlpAdmissionStudent nlpAdmissionStudent)
    {
        return nlpAdmissionStudentMapper.selectNlpAdmissionStudentList(nlpAdmissionStudent);
    }

    /**
     * 新增学生 数据
     *
     * @param nlpAdmissionStudent 学生 数据
     * @return 结果
     */
    @Override
    public int insertNlpAdmissionStudent(NlpAdmissionStudent nlpAdmissionStudent)
    {
        nlpAdmissionStudent.setCreateTime(DateUtils.getNowDate());
        return nlpAdmissionStudentMapper.insertNlpAdmissionStudent(nlpAdmissionStudent);
    }

    /**
     * 修改学生 数据
     *
     * @param nlpAdmissionStudent 学生 数据
     * @return 结果
     */
    @Override
    public int updateNlpAdmissionStudent(NlpAdmissionStudent nlpAdmissionStudent)
    {
        nlpAdmissionStudent.setUpdateTime(DateUtils.getNowDate());
        return nlpAdmissionStudentMapper.updateNlpAdmissionStudent(nlpAdmissionStudent);
    }

    /**
     * 批量删除学生 数据
     *
     * @param ids 需要删除的学生 数据主键
     * @return 结果
     */
    @Override
    public int deleteNlpAdmissionStudentByIds(Integer[] ids)
    {
        return nlpAdmissionStudentMapper.deleteNlpAdmissionStudentByIds(ids);
    }

    /**
     * 删除学生 数据信息
     *
     * @param id 学生 数据主键
     * @return 结果
     */
    @Override
    public int deleteNlpAdmissionStudentById(Integer id)
    {
        return nlpAdmissionStudentMapper.deleteNlpAdmissionStudentById(id);
    }

    /**
     * 查询学生 数据
     *
     * @return 学生数据 根据是否毕业分组
     */
    @Override
    public List<List<NlpAdmissionStudent>> selectNlpAdmissionStudentSeparatelyList()
    {
        List<List<NlpAdmissionStudent>> listResult = new ArrayList<>();

        NlpAdmissionStudent student = new NlpAdmissionStudent();
        student.setStatus(UserStatus.OK.getCode());
        List<NlpAdmissionStudent> listAll = nlpAdmissionStudentMapper.selectNlpAdmissionStudentList(student);

        List<NlpAdmissionStudent> list1 = new ArrayList<>();
        List<NlpAdmissionStudent> list2 = new ArrayList<>();
        for (NlpAdmissionStudent nlpAdmissionStudent : listAll)
        {
            if (Objects.equals(nlpAdmissionStudent.getAtSchool(), "0")) {
                // 在校
                list1.add(nlpAdmissionStudent);
            }
            else {
                // 毕业
                list2.add(nlpAdmissionStudent);
            }
        }

        listResult.add(list1);
        listResult.add(list2);

        return listResult;
    }
}
