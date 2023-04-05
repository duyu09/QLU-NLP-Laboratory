package com.train.cmsCloud.service.impl;

import java.util.List;
import com.train.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.train.cmsCloud.mapper.NlpDetailsManagementMapper;
import com.train.common.domain.NlpDetailsManagement;
import com.train.cmsCloud.service.INlpDetailsManagementService;

/**
 * 招生详情 培养计划 招聘详情 数据（管理）Service业务层处理
 *
 * @author ICOVETOUS
 * @date 2023-04-05
 */
@Service
public class NlpDetailsManagementServiceImpl implements INlpDetailsManagementService
{
    @Autowired
    private NlpDetailsManagementMapper nlpDetailsManagementMapper;

    /**
     * 查询招生详情 培养计划 招聘详情 数据（管理）
     *
     * @param id 招生详情 培养计划 招聘详情 数据（管理）主键
     * @return 招生详情 培养计划 招聘详情 数据（管理）
     */
    @Override
    public NlpDetailsManagement selectNlpDetailsManagementById(Integer id)
    {
        return nlpDetailsManagementMapper.selectNlpDetailsManagementById(id);
    }

    /**
     * 查询招生详情 培养计划 招聘详情 数据（管理）列表
     *
     * @param nlpDetailsManagement 招生详情 培养计划 招聘详情 数据（管理）
     * @return 招生详情 培养计划 招聘详情 数据（管理）
     */
    @Override
    public List<NlpDetailsManagement> selectNlpDetailsManagementList(NlpDetailsManagement nlpDetailsManagement)
    {
        return nlpDetailsManagementMapper.selectNlpDetailsManagementList(nlpDetailsManagement);
    }

    /**
     * 新增招生详情 培养计划 招聘详情 数据（管理）
     *
     * @param nlpDetailsManagement 招生详情 培养计划 招聘详情 数据（管理）
     * @return 结果
     */
    @Override
    public int insertNlpDetailsManagement(NlpDetailsManagement nlpDetailsManagement)
    {
        nlpDetailsManagement.setCreateTime(DateUtils.getNowDate());
        return nlpDetailsManagementMapper.insertNlpDetailsManagement(nlpDetailsManagement);
    }

    /**
     * 修改招生详情 培养计划 招聘详情 数据（管理）
     *
     * @param nlpDetailsManagement 招生详情 培养计划 招聘详情 数据（管理）
     * @return 结果
     */
    @Override
    public int updateNlpDetailsManagement(NlpDetailsManagement nlpDetailsManagement)
    {
        nlpDetailsManagement.setUpdateTime(DateUtils.getNowDate());
        return nlpDetailsManagementMapper.updateNlpDetailsManagement(nlpDetailsManagement);
    }

    /**
     * 批量删除招生详情 培养计划 招聘详情 数据（管理）
     *
     * @param ids 需要删除的招生详情 培养计划 招聘详情 数据（管理）主键
     * @return 结果
     */
    @Override
    public int deleteNlpDetailsManagementByIds(Integer[] ids)
    {
        return nlpDetailsManagementMapper.deleteNlpDetailsManagementByIds(ids);
    }

    /**
     * 删除招生详情 培养计划 招聘详情 数据（管理）信息
     *
     * @param id 招生详情 培养计划 招聘详情 数据（管理）主键
     * @return 结果
     */
    @Override
    public int deleteNlpDetailsManagementById(Integer id)
    {
        return nlpDetailsManagementMapper.deleteNlpDetailsManagementById(id);
    }
}
