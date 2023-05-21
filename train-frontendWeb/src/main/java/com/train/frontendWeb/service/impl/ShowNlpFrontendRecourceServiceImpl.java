package com.train.frontendWeb.service.impl;

import com.train.common.domain.NlpFrontendRecource;
import com.train.frontendWeb.mapper.ShowNlpFrontendRecourceMapper;
import com.train.frontendWeb.service.IShowNlpFrontendRecourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowNlpFrontendRecourceServiceImpl implements IShowNlpFrontendRecourceService {
    @Autowired
    private ShowNlpFrontendRecourceMapper nlpFrontendRecourceMapper;

    /**
     * 查询学术资源
     *
     * @param id 学术资源主键
     * @return 学术资源
     */
    @Override
    public NlpFrontendRecource selectNlpFrontendRecourceById(Long id)
    {
        return nlpFrontendRecourceMapper.selectNlpFrontendRecourceById(id);
    }

    /**
     * 查询学术资源列表
     *
     * @param nlpFrontendRecource 学术资源
     * @return 学术资源
     */
    @Override
    public List<NlpFrontendRecource> selectNlpFrontendRecourceList(NlpFrontendRecource nlpFrontendRecource)
    {
        return nlpFrontendRecourceMapper.selectNlpFrontendRecourceList(nlpFrontendRecource);
    }
}
