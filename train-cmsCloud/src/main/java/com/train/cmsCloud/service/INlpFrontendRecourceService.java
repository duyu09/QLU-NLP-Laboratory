package com.train.cmsCloud.service;

import java.util.List;
import com.train.common.domain.NlpFrontendRecource;

/**
 * 学术资源Service接口
 *
 * @author relief
 * @date 2023-05-21
 */
public interface INlpFrontendRecourceService
{
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

    /**
     * 新增学术资源
     *
     * @param nlpFrontendRecource 学术资源
     * @return 结果
     */
    public int insertNlpFrontendRecource(NlpFrontendRecource nlpFrontendRecource);

    /**
     * 修改学术资源
     *
     * @param nlpFrontendRecource 学术资源
     * @return 结果
     */
    public int updateNlpFrontendRecource(NlpFrontendRecource nlpFrontendRecource);

    /**
     * 批量删除学术资源
     *
     * @param ids 需要删除的学术资源主键集合
     * @return 结果
     */
    public int deleteNlpFrontendRecourceByIds(Long[] ids);

    /**
     * 删除学术资源信息
     *
     * @param id 学术资源主键
     * @return 结果
     */
    public int deleteNlpFrontendRecourceById(Long id);
}
