package com.train.frontendWeb.service.impl;

import com.train.common.domain.NlpFrontendAbout;
import com.train.frontendWeb.mapper.ShowNlpFrontendAboutMapper;
import com.train.frontendWeb.service.IShowNlpFrontendAboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowNlpFrontendAboutServiceImpl implements IShowNlpFrontendAboutService {
    @Autowired
    private ShowNlpFrontendAboutMapper nlpFrontendAboutMapper;

    /**
     * 查询联系我们
     *
     * @param id 联系我们主键
     * @return 联系我们
     */
    @Override
    public NlpFrontendAbout selectNlpFrontendAboutById(Long id)
    {
        return nlpFrontendAboutMapper.selectNlpFrontendAboutById(id);
    }

    /**
     * 查询联系我们列表
     *
     * @param nlpFrontendAbout 联系我们
     * @return 联系我们
     */
    @Override
    public List<NlpFrontendAbout> selectNlpFrontendAboutList(NlpFrontendAbout nlpFrontendAbout)
    {
        return nlpFrontendAboutMapper.selectNlpFrontendAboutList(nlpFrontendAbout);
    }

    /**
     * 查询类型
     *
     * @param type 类型
     * @return 联系我们
     */
    @Override
    public NlpFrontendAbout selectNlpFrontendAboutByType(String type)
    {
        return nlpFrontendAboutMapper.selectNlpFrontendAboutByType(type);
    }
}
