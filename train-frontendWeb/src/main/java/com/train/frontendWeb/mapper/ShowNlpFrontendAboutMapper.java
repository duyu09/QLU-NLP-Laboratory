package com.train.frontendWeb.mapper;

import com.train.common.domain.NlpFrontendAbout;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShowNlpFrontendAboutMapper {

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
