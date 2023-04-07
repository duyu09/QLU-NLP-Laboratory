package com.train.cmsCloud.service.impl;

import java.util.List;

import com.train.common.domain.NlpFrontendLink;
import com.train.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.train.cmsCloud.mapper.NlpFrontendLinkMapper;
import com.train.cmsCloud.service.INlpFrontendLinkService;

/**
 * 友情链接Service业务层处理
 *
 * @author relief
 * @date 2023-04-07
 */
@Service
public class NlpFrontendLinkServiceImpl implements INlpFrontendLinkService
{
    @Autowired
    private NlpFrontendLinkMapper nlpFrontendLinkMapper;

    /**
     * 查询友情链接
     *
     * @param id 友情链接主键
     * @return 友情链接
     */
    @Override
    public NlpFrontendLink selectNlpFrontendLinkById(Long id)
    {
        return nlpFrontendLinkMapper.selectNlpFrontendLinkById(id);
    }

    /**
     * 查询友情链接列表
     *
     * @param nlpFrontendLink 友情链接
     * @return 友情链接
     */
    @Override
    public List<NlpFrontendLink> selectNlpFrontendLinkList(NlpFrontendLink nlpFrontendLink)
    {
        return nlpFrontendLinkMapper.selectNlpFrontendLinkList(nlpFrontendLink);
    }

    /**
     * 新增友情链接
     *
     * @param nlpFrontendLink 友情链接
     * @return 结果
     */
    @Override
    public int insertNlpFrontendLink(NlpFrontendLink nlpFrontendLink)
    {
        nlpFrontendLink.setCreateTime(DateUtils.getNowDate());
        return nlpFrontendLinkMapper.insertNlpFrontendLink(nlpFrontendLink);
    }

    /**
     * 修改友情链接
     *
     * @param nlpFrontendLink 友情链接
     * @return 结果
     */
    @Override
    public int updateNlpFrontendLink(NlpFrontendLink nlpFrontendLink)
    {
        nlpFrontendLink.setUpdateTime(DateUtils.getNowDate());
        return nlpFrontendLinkMapper.updateNlpFrontendLink(nlpFrontendLink);
    }

    /**
     * 批量删除友情链接
     *
     * @param ids 需要删除的友情链接主键
     * @return 结果
     */
    @Override
    public int deleteNlpFrontendLinkByIds(Long[] ids)
    {
        return nlpFrontendLinkMapper.deleteNlpFrontendLinkByIds(ids);
    }

    /**
     * 删除友情链接信息
     *
     * @param id 友情链接主键
     * @return 结果
     */
    @Override
    public int deleteNlpFrontendLinkById(Long id)
    {
        return nlpFrontendLinkMapper.deleteNlpFrontendLinkById(id);
    }
}
