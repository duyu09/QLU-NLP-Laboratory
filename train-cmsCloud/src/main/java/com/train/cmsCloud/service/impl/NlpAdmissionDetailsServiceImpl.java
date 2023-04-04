package com.train.cmsCloud.service.impl;

import java.util.List;
import com.train.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.train.cmsCloud.mapper.NlpAdmissionDetailsMapper;
import com.train.common.domain.NlpAdmissionDetails;
import com.train.cmsCloud.service.INlpAdmissionDetailsService;

/**
 * 招生详情数据Service业务层处理
 *
 * @author ICOVETOUS
 * @date 2023-04-04
 */
@Service
public class NlpAdmissionDetailsServiceImpl implements INlpAdmissionDetailsService
{
    @Autowired
    private NlpAdmissionDetailsMapper nlpAdmissionDetailsMapper;

    /**
     * 查询招生详情数据
     *
     * @param id 招生详情数据主键
     * @return 招生详情数据
     */
    @Override
    public NlpAdmissionDetails selectNlpAdmissionDetailsById(Integer id)
    {
        return nlpAdmissionDetailsMapper.selectNlpAdmissionDetailsById(id);
    }

    /**
     * 查询招生详情数据列表
     *
     * @param nlpAdmissionDetails 招生详情数据
     * @return 招生详情数据
     */
    @Override
    public List<NlpAdmissionDetails> selectNlpAdmissionDetailsList(NlpAdmissionDetails nlpAdmissionDetails)
    {
        return nlpAdmissionDetailsMapper.selectNlpAdmissionDetailsList(nlpAdmissionDetails);
    }

    /**
     * 新增招生详情数据
     *
     * @param nlpAdmissionDetails 招生详情数据
     * @return 结果
     */
    @Override
    public int insertNlpAdmissionDetails(NlpAdmissionDetails nlpAdmissionDetails)
    {
        nlpAdmissionDetails.setCreateTime(DateUtils.getNowDate());
        return nlpAdmissionDetailsMapper.insertNlpAdmissionDetails(nlpAdmissionDetails);
    }

    /**
     * 修改招生详情数据
     *
     * @param nlpAdmissionDetails 招生详情数据
     * @return 结果
     */
    @Override
    public int updateNlpAdmissionDetails(NlpAdmissionDetails nlpAdmissionDetails)
    {
        nlpAdmissionDetails.setUpdateTime(DateUtils.getNowDate());
        return nlpAdmissionDetailsMapper.updateNlpAdmissionDetails(nlpAdmissionDetails);
    }

    /**
     * 批量删除招生详情数据
     *
     * @param ids 需要删除的招生详情数据主键
     * @return 结果
     */
    @Override
    public int deleteNlpAdmissionDetailsByIds(Integer[] ids)
    {
        return nlpAdmissionDetailsMapper.deleteNlpAdmissionDetailsByIds(ids);
    }

    /**
     * 删除招生详情数据信息
     *
     * @param id 招生详情数据主键
     * @return 结果
     */
    @Override
    public int deleteNlpAdmissionDetailsById(Integer id)
    {
        return nlpAdmissionDetailsMapper.deleteNlpAdmissionDetailsById(id);
    }
}
