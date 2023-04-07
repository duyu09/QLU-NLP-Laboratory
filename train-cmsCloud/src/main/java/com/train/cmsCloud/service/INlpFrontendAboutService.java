package com.train.cmsCloud.service;

import java.util.List;
import com.train.common.domain.NlpFrontendAbout;

/**
 * 联系我们Service接口
 *
 * @author relief
 * @date 2023-04-07
 */
public interface INlpFrontendAboutService
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

    /**
     * 新增联系我们
     *
     * @param nlpFrontendAbout 联系我们
     * @return 结果
     */
    public int insertNlpFrontendAbout(NlpFrontendAbout nlpFrontendAbout);

    /**
     * 修改联系我们
     *
     * @param nlpFrontendAbout 联系我们
     * @return 结果
     */
    public int updateNlpFrontendAbout(NlpFrontendAbout nlpFrontendAbout);

    /**
     * 批量删除联系我们
     *
     * @param ids 需要删除的联系我们主键集合
     * @return 结果
     */
    public int deleteNlpFrontendAboutByIds(Long[] ids);

    /**
     * 删除联系我们信息
     *
     * @param id 联系我们主键
     * @return 结果
     */
    public int deleteNlpFrontendAboutById(Long id);
}
