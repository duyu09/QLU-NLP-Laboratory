package com.train.frontendWeb.service;

import com.train.common.domain.NlpFrontendRecource;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IShowNlpFrontendRecourceService {
    /**
     * 查询学术资源
     *
     * @param id 学术资源主键
     * @return 学术资源
     */
    public NlpFrontendRecource selectNlpFrontendRecourceById(Long id);

    /**
     * 查询学术资源列表
     *
     * @param nlpFrontendRecource 学术资源
     * @return 学术资源集合
     */
    public List<NlpFrontendRecource> selectNlpFrontendRecourceList(NlpFrontendRecource nlpFrontendRecource);
}
