package com.train.cmsCloud.service;

import java.util.List;
import com.train.common.domain.NlpDetails;

/**
 * 招生详情 培养计划 招聘详情 数据Service接口
 *
 * @author ICOVETOUS
 * @date 2023-04-04
 */
public interface INlpDetailsService
{
    /**
     * 查询招生详情 培养计划 招聘详情 数据
     *
     * @param id 招生详情 培养计划 招聘详情 数据主键
     * @return 招生详情 培养计划 招聘详情 数据
     */
    public NlpDetails selectNlpDetailsById(Integer id);

    /**
     * 查询招生详情 培养计划 招聘详情 数据列表
     *
     * @param nlpDetails 招生详情 培养计划 招聘详情 数据
     * @return 招生详情 培养计划 招聘详情 数据集合
     */
    public List<NlpDetails> selectNlpDetailsList(NlpDetails nlpDetails);

    /**
     * 新增招生详情 培养计划 招聘详情 数据
     *
     * @param nlpDetails 招生详情 培养计划 招聘详情 数据
     * @return 结果
     */
    public int insertNlpDetails(NlpDetails nlpDetails);

    /**
     * 修改招生详情 培养计划 招聘详情 数据
     *
     * @param nlpDetails 招生详情 培养计划 招聘详情 数据
     * @return 结果
     */
    public int updateNlpDetails(NlpDetails nlpDetails);

    /**
     * 批量删除招生详情 培养计划 招聘详情 数据
     *
     * @param ids 需要删除的招生详情 培养计划 招聘详情 数据主键集合
     * @return 结果
     */
    public int deleteNlpDetailsByIds(Integer[] ids);

    /**
     * 删除招生详情 培养计划 招聘详情 数据信息
     *
     * @param id 招生详情 培养计划 招聘详情 数据主键
     * @return 结果
     */
    public int deleteNlpDetailsById(Integer id);
}
