package com.train.frontendWeb.service;

import java.util.List;
import com.train.common.domain.NlpFrontendLink;

/**
 * 友情链接Service接口
 *
 * @author relief
 * @date 2023-04-07
 */
public interface IShowNlpFrontendLinkService
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
