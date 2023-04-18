package com.train.frontendWeb.service;

import com.train.common.domain.NlpFrontendCarousel;
import java.util.List;


public interface IShowNlpFrontendCarouselService {

    /**
     * 查询轮播图
     *
     * @param id 轮播图主键
     * @return 轮播图
     */
    public NlpFrontendCarousel selectNlpFrontendCarouselById(Long id);

    /**
     * 查询轮播图列表
     *
     * @param nlpFrontendCarousel 轮播图
     * @return 轮播图集合
     */
    public List<NlpFrontendCarousel> selectNlpFrontendCarouselList(NlpFrontendCarousel nlpFrontendCarousel);
}
