package com.train.frontendWeb.mapper;

import com.train.common.domain.NlpFrontendCarousel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShowNlpFrontendCarouselMapper {
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
