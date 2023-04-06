package com.train.cmsCloud.service;

import com.train.common.domain.NlpFrontendNews;

import java.util.List;

/**
 * 新闻动态管理Service接口
 *
 * @author relief
 * @date 2023-04-05
 */
public interface INlpFrontendNewsService
{
    /**
     * 查询新闻动态管理
     *
     * @param id 新闻动态管理主键
     * @return 新闻动态管理
     */
    public NlpFrontendNews selectNlpFrontendNewsById(Long id);

    /**
     * 查询新闻动态管理列表
     *
     * @param nlpFrontendNews 新闻动态管理
     * @return 新闻动态管理集合
     */
    public List<NlpFrontendNews> selectNlpFrontendNewsList(NlpFrontendNews nlpFrontendNews);

    /**
     * 新增新闻动态管理
     *
     * @param nlpFrontendNews 新闻动态管理
     * @return 结果
     */
    public int insertNlpFrontendNews(NlpFrontendNews nlpFrontendNews);

    /**
     * 修改新闻动态管理
     *
     * @param nlpFrontendNews 新闻动态管理
     * @return 结果
     */
    public int updateNlpFrontendNews(NlpFrontendNews nlpFrontendNews);

    /**
     * 批量删除新闻动态管理
     *
     * @param ids 需要删除的新闻动态管理主键集合
     * @return 结果
     */
    public int deleteNlpFrontendNewsByIds(Long[] ids);

    /**
     * 删除新闻动态管理信息
     *
     * @param id 新闻动态管理主键
     * @return 结果
     */
    public int deleteNlpFrontendNewsById(Long id);

    public List<NlpFrontendNews> setTopNews(NlpFrontendNews nlpFrontendNews);
}
