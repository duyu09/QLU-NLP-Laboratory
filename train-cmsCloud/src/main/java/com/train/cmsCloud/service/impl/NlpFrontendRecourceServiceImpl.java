package com.train.cmsCloud.service.impl;

import com.train.cmsCloud.mapper.NlpFrontendRecourceMapper;
import com.train.cmsCloud.service.INlpFrontendRecourceService;
import com.train.common.domain.NlpFrontendRecource;
import com.train.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学术资源Service业务层处理
 *
 * @author relief
 * @date 2023-05-21
 */
@Service
public class NlpFrontendRecourceServiceImpl implements INlpFrontendRecourceService
{
    @Autowired
    private NlpFrontendRecourceMapper nlpFrontendRecourceMapper;

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

    /**
     * 新增学术资源
     *
     * @param nlpFrontendRecource 学术资源
     * @return 结果
     */
    @Override
    public int insertNlpFrontendRecource(NlpFrontendRecource nlpFrontendRecource)
    {
        nlpFrontendRecource.setCreateTime(DateUtils.getNowDate());
        return nlpFrontendRecourceMapper.insertNlpFrontendRecource(nlpFrontendRecource);
    }

    /**
     * 修改学术资源
     *
     * @param nlpFrontendRecource 学术资源
     * @return 结果
     */
    @Override
    public int updateNlpFrontendRecource(NlpFrontendRecource nlpFrontendRecource)
    {
        nlpFrontendRecource.setUpdateTime(DateUtils.getNowDate());
        return nlpFrontendRecourceMapper.updateNlpFrontendRecource(nlpFrontendRecource);
    }

    /**
     * 批量删除学术资源
     *
     * @param ids 需要删除的学术资源主键
     * @return 结果
     */
    @Override
    public int deleteNlpFrontendRecourceByIds(Long[] ids)
    {
        return nlpFrontendRecourceMapper.deleteNlpFrontendRecourceByIds(ids);
    }

    /**
     * 删除学术资源信息
     *
     * @param id 学术资源主键
     * @return 结果
     */
    @Override
    public int deleteNlpFrontendRecourceById(Long id)
    {
        return nlpFrontendRecourceMapper.deleteNlpFrontendRecourceById(id);
    }
}
