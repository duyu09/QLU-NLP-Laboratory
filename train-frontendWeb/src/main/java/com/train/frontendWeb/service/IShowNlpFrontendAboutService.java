package com.train.frontendWeb.service;

import java.util.List;
import com.train.common.domain.NlpFrontendAbout;

/**
 * 联系我们Service接口
 *
 * @author relief
 * @date 2023-04-07
 */
public interface IShowNlpFrontendAboutService
{
    /**
     * 查询联系我们
     *
     * @param id 联系我们主键
     * @return 联系我们
     */
    public NlpFrontendAbout selectNlpFrontendAboutById(Long id);

    /**
     * 查询联系我们列表
     *
     * @param nlpFrontendAbout 联系我们
     * @return 联系我们集合
     */
    public List<NlpFrontendAbout> selectNlpFrontendAboutList(NlpFrontendAbout nlpFrontendAbout);

}
