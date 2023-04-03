package com.train.cmsCloud.service.impl;

import java.util.List;

import com.train.common.domain.NlpFrontendCarousel;
import com.train.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.train.cmsCloud.mapper.NlpFrontendCarouselMapper;
import com.train.cmsCloud.service.INlpFrontendCarouselService;

/**
 * 轮播图Service业务层处理
 *
 * @author relief
 * @date 2023-04-03
 */
@Service
public class NlpFrontendCarouselServiceImpl implements INlpFrontendCarouselService
{
    @Autowired
    private NlpFrontendCarouselMapper nlpFrontendCarouselMapper;

    /**
     * 查询轮播图
     *
     * @param id 轮播图主键
     * @return 轮播图
     */
    @Override
    public NlpFrontendCarousel selectNlpFrontendCarouselById(Long id)
    {
        return nlpFrontendCarouselMapper.selectNlpFrontendCarouselById(id);
    }

    /**
     * 查询轮播图列表
     *
     * @param nlpFrontendCarousel 轮播图
     * @return 轮播图
     */
    @Override
    public List<NlpFrontendCarousel> selectNlpFrontendCarouselList(NlpFrontendCarousel nlpFrontendCarousel)
    {
        return nlpFrontendCarouselMapper.selectNlpFrontendCarouselList(nlpFrontendCarousel);
    }

    /**
     * 新增轮播图
     *
     * @param nlpFrontendCarousel 轮播图
     * @return 结果
     */
    @Override
    public int insertNlpFrontendCarousel(NlpFrontendCarousel nlpFrontendCarousel)
    {
        nlpFrontendCarousel.setCreateTime(DateUtils.getNowDate());
        return nlpFrontendCarouselMapper.insertNlpFrontendCarousel(nlpFrontendCarousel);
    }

    /**
     * 修改轮播图
     *
     * @param nlpFrontendCarousel 轮播图
     * @return 结果
     */
    @Override
    public int updateNlpFrontendCarousel(NlpFrontendCarousel nlpFrontendCarousel)
    {
        nlpFrontendCarousel.setUpdateTime(DateUtils.getNowDate());
        return nlpFrontendCarouselMapper.updateNlpFrontendCarousel(nlpFrontendCarousel);
    }

    /**
     * 批量删除轮播图
     *
     * @param ids 需要删除的轮播图主键
     * @return 结果
     */
    @Override
    public int deleteNlpFrontendCarouselByIds(Long[] ids)
    {
        return nlpFrontendCarouselMapper.deleteNlpFrontendCarouselByIds(ids);
    }

    /**
     * 删除轮播图信息
     *
     * @param id 轮播图主键
     * @return 结果
     */
    @Override
    public int deleteNlpFrontendCarouselById(Long id)
    {
        return nlpFrontendCarouselMapper.deleteNlpFrontendCarouselById(id);
    }
}
