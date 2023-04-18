package com.train.frontendWeb.mapper;

import com.train.common.domain.NlpFrontendLink;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 友情链接Mapper接口
 *
 * @author relief
 * @date 2023-04-07
 */
@Mapper
public interface ShowNlpFrontendLinkMapper
{
    /**
     * 查询友情链接
     *
     * @param id 友情链接主键
     * @return 友情链接
     */
    public NlpFrontendLink selectNlpFrontendLinkById(Long id);

    /**
     * 查询友情链接列表
     *
     * @param nlpFrontendLink 友情链接
     * @return 友情链接集合
     */
    public List<NlpFrontendLink> selectNlpFrontendLinkList(NlpFrontendLink nlpFrontendLink);

}
