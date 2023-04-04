package com.train.cmsCloud.service.impl;

import java.util.List;
import com.train.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.train.cmsCloud.mapper.NlpDetailsMapper;
import com.train.common.domain.NlpDetails;
import com.train.cmsCloud.service.INlpDetailsService;

/**
 * 招生详情 培养计划 招聘详情 数据Service业务层处理
 *
 * @author ICOVETOUS
 * @date 2023-04-04
 */
@Service
public class NlpDetailsServiceImpl implements INlpDetailsService
{
    @Autowired
    private NlpDetailsMapper nlpDetailsMapper;

    /**
     * 查询招生详情 培养计划 招聘详情 数据
     *
     * @param id 招生详情 培养计划 招聘详情 数据主键
     * @return 招生详情 培养计划 招聘详情 数据
     */
    @Override
    public NlpDetails selectNlpDetailsById(Integer id)
    {
        return nlpDetailsMapper.selectNlpDetailsById(id);
    }

    /**
     * 查询招生详情 培养计划 招聘详情 数据列表
     *
     * @param nlpDetails 招生详情 培养计划 招聘详情 数据
     * @return 招生详情 培养计划 招聘详情 数据
     */
    @Override
    public List<NlpDetails> selectNlpDetailsList(NlpDetails nlpDetails)
    {
        return nlpDetailsMapper.selectNlpDetailsList(nlpDetails);
    }

    /**
     * 新增招生详情 培养计划 招聘详情 数据
     *
     * @param nlpDetails 招生详情 培养计划 招聘详情 数据
     * @return 结果
     */
    @Override
    public int insertNlpDetails(NlpDetails nlpDetails)
    {
        nlpDetails.setCreateTime(DateUtils.getNowDate());
        return nlpDetailsMapper.insertNlpDetails(nlpDetails);
    }

    /**
     * 修改招生详情 培养计划 招聘详情 数据
     *
     * @param nlpDetails 招生详情 培养计划 招聘详情 数据
     * @return 结果
     */
    @Override
    public int updateNlpDetails(NlpDetails nlpDetails)
    {
        nlpDetails.setUpdateTime(DateUtils.getNowDate());
        return nlpDetailsMapper.updateNlpDetails(nlpDetails);
    }

    /**
     * 批量删除招生详情 培养计划 招聘详情 数据
     *
     * @param ids 需要删除的招生详情 培养计划 招聘详情 数据主键
     * @return 结果
     */
    @Override
    public int deleteNlpDetailsByIds(Integer[] ids)
    {
        return nlpDetailsMapper.deleteNlpDetailsByIds(ids);
    }

    /**
     * 删除招生详情 培养计划 招聘详情 数据信息
     *
     * @param id 招生详情 培养计划 招聘详情 数据主键
     * @return 结果
     */
    @Override
    public int deleteNlpDetailsById(Integer id)
    {
        return nlpDetailsMapper.deleteNlpDetailsById(id);
    }
}
