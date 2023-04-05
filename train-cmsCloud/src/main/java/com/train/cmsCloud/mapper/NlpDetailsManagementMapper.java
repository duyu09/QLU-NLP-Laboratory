package com.train.cmsCloud.mapper;

import java.util.List;
import com.train.common.domain.NlpDetailsManagement;
import org.apache.ibatis.annotations.Mapper;

/**
 * 招生详情 培养计划 招聘详情 数据（管理）Mapper接口
 *
 * @author ICOVETOUS
 * @date 2023-04-05
 */
@Mapper
public interface NlpDetailsManagementMapper
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
     * 删除招生详情 培养计划 招聘详情 数据（管理）
     *
     * @param id 招生详情 培养计划 招聘详情 数据（管理）主键
     * @return 结果
     */
    public int deleteNlpDetailsManagementById(Integer id);

    /**
     * 批量删除招生详情 培养计划 招聘详情 数据（管理）
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNlpDetailsManagementByIds(Integer[] ids);
}
