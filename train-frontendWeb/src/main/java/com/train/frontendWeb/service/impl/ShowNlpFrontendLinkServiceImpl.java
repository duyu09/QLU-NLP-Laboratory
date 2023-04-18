package com.train.frontendWeb.service.impl;

import com.train.common.domain.NlpFrontendLink;
import com.train.frontendWeb.mapper.ShowNlpFrontendLinkMapper;
import com.train.frontendWeb.service.IShowNlpFrontendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowNlpFrontendLinkServiceImpl implements IShowNlpFrontendLinkService {
    @Autowired
    private ShowNlpFrontendLinkMapper nlpFrontendLinkMapper;

    /**
     * 查询友情链接
     *
     * @param id 友情链接主键
     * @return 友情链接
     */
    @Override
    public NlpFrontendLink selectNlpFrontendLinkById(Long id)
    {
        return nlpFrontendLinkMapper.selectNlpFrontendLinkById(id);
    }

    /**
     * 查询友情链接列表
     *
     * @param nlpFrontendLink 友情链接
     * @return 友情链接
     */
    @Override
    public List<NlpFrontendLink> selectNlpFrontendLinkList(NlpFrontendLink nlpFrontendLink)
    {
        return nlpFrontendLinkMapper.selectNlpFrontendLinkList(nlpFrontendLink);
    }
}
