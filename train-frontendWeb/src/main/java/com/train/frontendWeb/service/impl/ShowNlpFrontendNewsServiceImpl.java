package com.train.frontendWeb.service.impl;

import com.train.common.domain.NlpFrontendNews;
import com.train.common.utils.StringUtils;
import com.train.frontendWeb.dto.NlpFrontendNewsDTO;
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
    public NlpFrontendNewsDTO selectNlpFrontendNewsById(Long id) {
        List<NlpFrontendNews> list = nlpFrontendNewsMapper.selectNlpFrontendNewsList(new NlpFrontendNews());
        NlpFrontendNewsDTO frontendNews = new NlpFrontendNewsDTO();

        NlpFrontendNews beforeNews = new NlpFrontendNews();
        NlpFrontendNews afterNews = new NlpFrontendNews();

        for (NlpFrontendNews news : list) {
            if (id.equals(news.getId())){
                if (id.equals(frontendNews.getId())) {
                    afterNews = news;
                    break;
                }
            }else {
                beforeNews = frontendNews;
                frontendNews = (NlpFrontendNewsDTO) news;
            }
        }
        if (StringUtils.isNotEmpty(beforeNews.getTitle())){
            frontendNews.setBeforeId(beforeNews.getId());
            frontendNews.setBeforeTitle(beforeNews.getTitle());
        }
        if (StringUtils.isNotEmpty(afterNews.getTitle())){
            frontendNews.setAfterId(afterNews.getId());
            frontendNews.setAfterTitle(afterNews.getTitle());
        }

        return frontendNews;
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

}
