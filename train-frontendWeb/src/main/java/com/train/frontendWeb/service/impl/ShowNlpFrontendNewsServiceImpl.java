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
        // 查询所有数据
        List<NlpFrontendNews> list = nlpFrontendNewsMapper.selectNlpFrontendNewsList(new NlpFrontendNews());

        // 初始化设置基础数据
        NlpFrontendNewsDTO frontendNews = new NlpFrontendNewsDTO();
        // 上一页数据对象暂存
        NlpFrontendNews beforeNews = new NlpFrontendNews();
        // 下一页数据对象暂存
        NlpFrontendNews afterNews = new NlpFrontendNews();

        // 数据配置逻辑
        for (NlpFrontendNews news : list) {
            if (frontendNews.getId().equals(id)) {
                afterNews = news;
                break;
            }
            beforeNews = frontendNews;
            frontendNews = (NlpFrontendNewsDTO) news;
        }

        // 基础数据填充 判断是否拥有上一条
        if (StringUtils.isNotEmpty(beforeNews.getTitle())){
            frontendNews.setBeforeId(beforeNews.getId());
            frontendNews.setBeforeTitle(beforeNews.getTitle());
        }
        // 基础数据填充 判断是否拥有下一条
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
