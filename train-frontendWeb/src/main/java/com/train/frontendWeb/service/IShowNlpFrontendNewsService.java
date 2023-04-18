package com.train.frontendWeb.service;

import com.train.common.domain.NlpFrontendNews;
import com.train.frontendWeb.dto.NlpFrontendNewsDTO;

import java.util.List;

public interface IShowNlpFrontendNewsService {
    /**
     * 查询新闻动态管理
     *
     * @param id 新闻动态管理主键
     * @return 新闻动态管理
     */
    public NlpFrontendNewsDTO selectNlpFrontendNewsById(Long id);

    /**
     * 查询新闻动态管理列表
     *
     * @param nlpFrontendNews 新闻动态管理
     * @return 新闻动态管理集合
     */
    public List<NlpFrontendNews> selectNlpFrontendNewsList(NlpFrontendNews nlpFrontendNews);

}
