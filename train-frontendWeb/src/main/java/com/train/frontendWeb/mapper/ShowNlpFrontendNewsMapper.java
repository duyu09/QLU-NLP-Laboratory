package com.train.frontendWeb.mapper;

import com.train.common.domain.NlpFrontendNews;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShowNlpFrontendNewsMapper {
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

    //置顶
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
