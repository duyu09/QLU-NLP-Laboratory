package com.train.frontendWeb.mapper;

import com.train.common.domain.NlpFrontendNews;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShowNlpFrontendNewsMapper {

    /**
     * 查询新闻动态管理列表
     *
     * @param nlpFrontendNews 新闻动态管理
     * @return 新闻动态管理集合
     */
    public List<NlpFrontendNews> selectNlpFrontendNewsList(NlpFrontendNews nlpFrontendNews);


    /**
     * 查询id
     *
     * @param id
     * @return
     */
    public NlpFrontendNews selectNlpFrontendNewsById(Long id);


}
