package com.train.cmsCloud.service;

import java.util.List;
import com.train.common.domain.NlpFrontendLink;

/**
 * 友情链接Service接口
 *
 * @author relief
 * @date 2023-04-07
 */
public interface INlpFrontendLinkService
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

    /**
     * 新增友情链接
     *
     * @param nlpFrontendLink 友情链接
     * @return 结果
     */
    public int insertNlpFrontendLink(NlpFrontendLink nlpFrontendLink);

    /**
     * 修改友情链接
     *
     * @param nlpFrontendLink 友情链接
     * @return 结果
     */
    public int updateNlpFrontendLink(NlpFrontendLink nlpFrontendLink);

    /**
     * 批量删除友情链接
     *
     * @param ids 需要删除的友情链接主键集合
     * @return 结果
     */
    public int deleteNlpFrontendLinkByIds(Long[] ids);

    /**
     * 删除友情链接信息
     *
     * @param id 友情链接主键
     * @return 结果
     */
    public int deleteNlpFrontendLinkById(Long id);
}
