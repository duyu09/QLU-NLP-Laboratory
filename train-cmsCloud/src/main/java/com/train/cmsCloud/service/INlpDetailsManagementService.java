package com.train.cmsCloud.service;

import java.util.List;
import com.train.common.domain.NlpDetailsManagement;

/**
 * 招生详情 培养计划 招聘详情 数据（管理）Service接口
 *
 * @author ICOVETOUS
 * @date 2023-04-05
 */
public interface INlpDetailsManagementService
{
    /**
     * 查询招生详情 培养计划 招聘详情 数据（管理）
     *
     * @param id 招生详情 培养计划 招聘详情 数据（管理）主键
     * @return 招生详情 培养计划 招聘详情 数据（管理）
     */
    public NlpDetailsManagement selectNlpDetailsManagementById(Integer id);

    /**
     * 查询招生详情 培养计划 招聘详情 数据（管理）列表
     *
     * @param nlpDetailsManagement 招生详情 培养计划 招聘详情 数据（管理）
     * @return 招生详情 培养计划 招聘详情 数据（管理）集合
     */
    public List<NlpDetailsManagement> selectNlpDetailsManagementList(NlpDetailsManagement nlpDetailsManagement);

    /**
     * 新增招生详情 培养计划 招聘详情 数据（管理）
     *
     * @param nlpDetailsManagement 招生详情 培养计划 招聘详情 数据（管理）
     * @return 结果
     */
    public int insertNlpDetailsManagement(NlpDetailsManagement nlpDetailsManagement);

    /**
     * 修改招生详情 培养计划 招聘详情 数据（管理）
     *
     * @param nlpDetailsManagement 招生详情 培养计划 招聘详情 数据（管理）
     * @return 结果
     */
    public int updateNlpDetailsManagement(NlpDetailsManagement nlpDetailsManagement);

    /**
     * 批量删除招生详情 培养计划 招聘详情 数据（管理）
     *
     * @param ids 需要删除的招生详情 培养计划 招聘详情 数据（管理）主键集合
     * @return 结果
     */
    public int deleteNlpDetailsManagementByIds(Integer[] ids);

    /**
     * 删除招生详情 培养计划 招聘详情 数据（管理）信息
     *
     * @param id 招生详情 培养计划 招聘详情 数据（管理）主键
     * @return 结果
     */
    public int deleteNlpDetailsManagementById(Integer id);
}
