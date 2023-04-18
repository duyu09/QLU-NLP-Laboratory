package com.train.frontendWeb.service;

import com.train.common.domain.NlpFrontendNews;

import java.util.List;

public interface IShowNlpFrontendNewsService {
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
     * 查询新闻动态管理列表
     * 包含置顶的新闻
     *
     * @param nlpFrontendNews
     * @return
     */
    public List<NlpFrontendNews> setTopNews(NlpFrontendNews nlpFrontendNews);

    /**
     * 下一条数据
     * @param nlpFrontendNews
     * @return
     */
    public List<NlpFrontendNews> nextOneNews(NlpFrontendNews nlpFrontendNews);

    /**
     * 上一条数据
     * @param nlpFrontendNews
     * @return
     */
    public List<NlpFrontendNews> previousOneNews(NlpFrontendNews nlpFrontendNews);
}
