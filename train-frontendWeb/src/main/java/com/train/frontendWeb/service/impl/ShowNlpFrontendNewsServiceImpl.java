package com.train.frontendWeb.service.impl;

import com.train.common.domain.NlpFrontendNews;
import com.train.frontendWeb.mapper.ShowNlpFrontendNewsMapper;
import com.train.frontendWeb.service.IShowNlpFrontendNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowNlpFrontendNewsServiceImpl implements IShowNlpFrontendNewsService {

    @Autowired
    private ShowNlpFrontendNewsMapper nlpFrontendNewsMapper;

    /**
     * 查询新闻动态管理
     *
     * @param id 新闻动态管理主键
     * @return 新闻动态管理
     */
    @Override
    public NlpFrontendNews selectNlpFrontendNewsById(Long id) {
        return nlpFrontendNewsMapper.selectNlpFrontendNewsById(id);
    }

    /**
     * 查询新闻动态管理列表
     *
     * @param nlpFrontendNews 新闻动态管理
     * @return 新闻动态管理
     */
    @Override
    public List<NlpFrontendNews> selectNlpFrontendNewsList(NlpFrontendNews nlpFrontendNews) {
        return nlpFrontendNewsMapper.selectNlpFrontendNewsList(nlpFrontendNews);
    }

    /**
     * 查询新闻动态
     * 包含置顶操作
     *
     * @param nlpFrontendNews
     * @return
     */
    @Override
    public List<NlpFrontendNews> setTopNews(NlpFrontendNews nlpFrontendNews) {
        return nlpFrontendNewsMapper.setTopNews(nlpFrontendNews);
    }

    /**
     * 下一条数据
     * @param nlpFrontendNews
     * @return
     */
    @Override
    public List<NlpFrontendNews> nextOneNews(NlpFrontendNews nlpFrontendNews) {
        return nlpFrontendNewsMapper.nextOneNews(nlpFrontendNews);
    }

    /**
     * 上一条数据
     * @param nlpFrontendNews
     * @return
     */
    @Override
    public List<NlpFrontendNews> previousOneNews(NlpFrontendNews nlpFrontendNews) {
        return nlpFrontendNewsMapper.previousOneNews(nlpFrontendNews);
    }
}
