package com.train.frontendWeb.service.impl;

import com.train.common.domain.NlpFrontendCarousel;
import com.train.frontendWeb.mapper.ShowNlpFrontendCarouselMapper;
import com.train.frontendWeb.service.IShowNlpFrontendCarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowNlpFrontendCarouselServiceImpl implements IShowNlpFrontendCarouselService {

    @Autowired
    private ShowNlpFrontendCarouselMapper showNlpFrontendCarouselMapper;

    /**
     * 查询轮播图
     *
     * @param id 轮播图主键
     * @return
     */
    @Override
    public NlpFrontendCarousel selectNlpFrontendCarouselById(Long id) {
        return showNlpFrontendCarouselMapper.selectNlpFrontendCarouselById(id);
    }

    /**查询轮播图列表
     *
     * @param nlpFrontendCarousel 轮播图
     * @return
     */
    @Override
    public List<NlpFrontendCarousel> selectNlpFrontendCarouselList(NlpFrontendCarousel nlpFrontendCarousel) {
        return showNlpFrontendCarouselMapper.selectNlpFrontendCarouselList(nlpFrontendCarousel);
    }
}
