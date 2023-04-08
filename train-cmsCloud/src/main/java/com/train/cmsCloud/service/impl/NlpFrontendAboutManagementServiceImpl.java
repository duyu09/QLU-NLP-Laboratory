package com.train.cmsCloud.service.impl;

import java.util.List;

import com.train.common.domain.NlpFrontendAboutManagement;
import com.train.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.train.cmsCloud.mapper.NlpFrontendAboutManagementMapper;
import com.train.cmsCloud.service.INlpFrontendAboutManagementService;

/**
 * 联系我们(管理)Service业务层处理
 *
 * @author relief
 * @date 2023-04-07
 */
@Service
public class NlpFrontendAboutManagementServiceImpl implements INlpFrontendAboutManagementService
{
    @Autowired
    private NlpFrontendAboutManagementMapper nlpFrontendAboutManagementMapper;

    /**
     * 查询联系我们(管理)
     *
     * @param id 联系我们(管理)主键
     * @return 联系我们(管理)
     */
    @Override
    public NlpFrontendAboutManagement selectNlpFrontendAboutManagementById(Long id)
    {
        return nlpFrontendAboutManagementMapper.selectNlpFrontendAboutManagementById(id);
    }

    /**
     * 查询联系我们(管理)列表
     *
     * @param nlpFrontendAboutManagement 联系我们(管理)
     * @return 联系我们(管理)
     */
    @Override
    public List<NlpFrontendAboutManagement> selectNlpFrontendAboutManagementList(NlpFrontendAboutManagement nlpFrontendAboutManagement)
    {
        return nlpFrontendAboutManagementMapper.selectNlpFrontendAboutManagementList(nlpFrontendAboutManagement);
    }

    /**
     * 新增联系我们(管理)
     *
     * @param nlpFrontendAboutManagement 联系我们(管理)
     * @return 结果
     */
    @Override
    public int insertNlpFrontendAboutManagement(NlpFrontendAboutManagement nlpFrontendAboutManagement)
    {
        nlpFrontendAboutManagement.setCreateTime(DateUtils.getNowDate());
        return nlpFrontendAboutManagementMapper.insertNlpFrontendAboutManagement(nlpFrontendAboutManagement);
    }

    /**
     * 修改联系我们(管理)
     *
     * @param nlpFrontendAboutManagement 联系我们(管理)
     * @return 结果
     */
    @Override
    public int updateNlpFrontendAboutManagement(NlpFrontendAboutManagement nlpFrontendAboutManagement)
    {
        nlpFrontendAboutManagement.setUpdateTime(DateUtils.getNowDate());
        return nlpFrontendAboutManagementMapper.updateNlpFrontendAboutManagement(nlpFrontendAboutManagement);
    }

    /**
     * 批量删除联系我们(管理)
     *
     * @param ids 需要删除的联系我们(管理)主键
     * @return 结果
     */
    @Override
    public int deleteNlpFrontendAboutManagementByIds(Long[] ids)
    {
        return nlpFrontendAboutManagementMapper.deleteNlpFrontendAboutManagementByIds(ids);
    }

    /**
     * 删除联系我们(管理)信息
     *
     * @param id 联系我们(管理)主键
     * @return 结果
     */
    @Override
    public int deleteNlpFrontendAboutManagementById(Long id)
    {
        return nlpFrontendAboutManagementMapper.deleteNlpFrontendAboutManagementById(id);
    }
}
