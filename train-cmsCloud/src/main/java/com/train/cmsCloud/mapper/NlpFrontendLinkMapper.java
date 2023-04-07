package com.train.cmsCloud.mapper;

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
public interface NlpFrontendLinkMapper
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
     * 删除友情链接
     *
     * @param id 友情链接主键
     * @return 结果
     */
    public int deleteNlpFrontendLinkById(Long id);

    /**
     * 批量删除友情链接
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNlpFrontendLinkByIds(Long[] ids);
}
