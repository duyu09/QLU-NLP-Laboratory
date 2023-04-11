package com.train.cmsCloud.service.impl;

import java.util.List;

import com.train.common.domain.NlpFrontendNews;
import com.train.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.train.cmsCloud.mapper.NlpFrontendNewsMapper;
import com.train.cmsCloud.service.INlpFrontendNewsService;

/**
 * 新闻动态管理Service业务层处理
 *
 * @author relief
 * @date 2023-04-05
 */
@Service
public class NlpFrontendNewsServiceImpl implements INlpFrontendNewsService
{
    @Autowired
    private NlpFrontendNewsMapper nlpFrontendNewsMapper;

    /**
     * 查询新闻动态管理
     *
     * @param id 新闻动态管理主键
     * @return 新闻动态管理
     */
    @Override
    public NlpFrontendNews selectNlpFrontendNewsById(Long id)
    {
        return nlpFrontendNewsMapper.selectNlpFrontendNewsById(id);
    }

    /**
     * 查询新闻动态管理列表
     *
     * @param nlpFrontendNews 新闻动态管理
     * @return 新闻动态管理
     */
    @Override
    public List<NlpFrontendNews> selectNlpFrontendNewsList(NlpFrontendNews nlpFrontendNews)
    {
        return nlpFrontendNewsMapper.selectNlpFrontendNewsList(nlpFrontendNews);
    }

    /**
     * 新增新闻动态管理
     *
     * @param nlpFrontendNews 新闻动态管理
     * @return 结果
     */
    @Override
    public int insertNlpFrontendNews(NlpFrontendNews nlpFrontendNews)
    {
        nlpFrontendNews.setCreateTime(DateUtils.getNowDate());
        return nlpFrontendNewsMapper.insertNlpFrontendNews(nlpFrontendNews);
    }

    /**
     * 修改新闻动态管理
     *
     * @param nlpFrontendNews 新闻动态管理
     * @return 结果
     */
    @Override
    public int updateNlpFrontendNews(NlpFrontendNews nlpFrontendNews)
    {
        nlpFrontendNews.setUpdateTime(DateUtils.getNowDate());
        return nlpFrontendNewsMapper.updateNlpFrontendNews(nlpFrontendNews);
    }

    /**
     * 批量删除新闻动态管理
     *
     * @param ids 需要删除的新闻动态管理主键
     * @return 结果
     */
    @Override
    public int deleteNlpFrontendNewsByIds(Long[] ids)
    {
        return nlpFrontendNewsMapper.deleteNlpFrontendNewsByIds(ids);
    }

    /**
     * 删除新闻动态管理信息
     *
     * @param id 新闻动态管理主键
     * @return 结果
     */
    @Override
    public int deleteNlpFrontendNewsById(Long id)
    {
        return nlpFrontendNewsMapper.deleteNlpFrontendNewsById(id);
    }


    //置顶
    @Override
    public List<NlpFrontendNews> setTopNews(NlpFrontendNews nlpFrontendNews)
    {
        return nlpFrontendNewsMapper.setTopNews(nlpFrontendNews);
    }
}
