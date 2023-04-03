package com.train.cmsCloud.mapper;

import java.util.List;
import com.train.common.domain.NlpFrontendCarousel;
import org.apache.ibatis.annotations.Mapper;

/**
 * 轮播图Mapper接口
 *
 * @author relief
 * @date 2023-04-03
 */
@Mapper
public interface NlpFrontendCarouselMapper
{
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

    /**
     * 新增轮播图
     *
     * @param nlpFrontendCarousel 轮播图
     * @return 结果
     */
    public int insertNlpFrontendCarousel(NlpFrontendCarousel nlpFrontendCarousel);

    /**
     * 修改轮播图
     *
     * @param nlpFrontendCarousel 轮播图
     * @return 结果
     */
    public int updateNlpFrontendCarousel(NlpFrontendCarousel nlpFrontendCarousel);

    /**
     * 删除轮播图
     *
     * @param id 轮播图主键
     * @return 结果
     */
    public int deleteNlpFrontendCarouselById(Long id);

    /**
     * 批量删除轮播图
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNlpFrontendCarouselByIds(Long[] ids);
}
