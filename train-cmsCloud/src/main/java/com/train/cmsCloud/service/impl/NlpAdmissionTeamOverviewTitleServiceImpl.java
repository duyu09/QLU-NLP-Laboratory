package com.train.cmsCloud.service.impl;

import java.util.List;
import com.train.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.train.cmsCloud.mapper.NlpAdmissionTeamOverviewTitleMapper;
import com.train.common.domain.NlpAdmissionTeamOverviewTitle;
import com.train.cmsCloud.service.INlpAdmissionTeamOverviewTitleService;

/**
 * 团队掠影 标题 (title)Service业务层处理
 *
 * @author ICOVETOUS
 * @date 2023-04-21
 */
@Service
public class NlpAdmissionTeamOverviewTitleServiceImpl implements INlpAdmissionTeamOverviewTitleService
{
    @Autowired
    private NlpAdmissionTeamOverviewTitleMapper nlpAdmissionTeamOverviewTitleMapper;

    /**
     * 查询团队掠影 标题 (title)
     *
     * @param id 团队掠影 标题 (title)主键
     * @return 团队掠影 标题 (title)
     */
    @Override
    public NlpAdmissionTeamOverviewTitle selectNlpAdmissionTeamOverviewTitleById(Integer id)
    {
        return nlpAdmissionTeamOverviewTitleMapper.selectNlpAdmissionTeamOverviewTitleById(id);
    }

    /**
     * 查询团队掠影 标题 (title)列表
     *
     * @param nlpAdmissionTeamOverviewTitle 团队掠影 标题 (title)
     * @return 团队掠影 标题 (title)
     */
    @Override
    public List<NlpAdmissionTeamOverviewTitle> selectNlpAdmissionTeamOverviewTitleList(NlpAdmissionTeamOverviewTitle nlpAdmissionTeamOverviewTitle)
    {
        return nlpAdmissionTeamOverviewTitleMapper.selectNlpAdmissionTeamOverviewTitleList(nlpAdmissionTeamOverviewTitle);
    }

    /**
     * 新增团队掠影 标题 (title)
     *
     * @param nlpAdmissionTeamOverviewTitle 团队掠影 标题 (title)
     * @return 结果
     */
    @Override
    public int insertNlpAdmissionTeamOverviewTitle(NlpAdmissionTeamOverviewTitle nlpAdmissionTeamOverviewTitle)
    {
        nlpAdmissionTeamOverviewTitle.setCreateTime(DateUtils.getNowDate());
        return nlpAdmissionTeamOverviewTitleMapper.insertNlpAdmissionTeamOverviewTitle(nlpAdmissionTeamOverviewTitle);
    }

    /**
     * 修改团队掠影 标题 (title)
     *
     * @param nlpAdmissionTeamOverviewTitle 团队掠影 标题 (title)
     * @return 结果
     */
    @Override
    public int updateNlpAdmissionTeamOverviewTitle(NlpAdmissionTeamOverviewTitle nlpAdmissionTeamOverviewTitle)
    {
        nlpAdmissionTeamOverviewTitle.setUpdateTime(DateUtils.getNowDate());
        return nlpAdmissionTeamOverviewTitleMapper.updateNlpAdmissionTeamOverviewTitle(nlpAdmissionTeamOverviewTitle);
    }

    /**
     * 批量删除团队掠影 标题 (title)
     *
     * @param ids 需要删除的团队掠影 标题 (title)主键
     * @return 结果
     */
    @Override
    public int deleteNlpAdmissionTeamOverviewTitleByIds(Integer[] ids)
    {
        return nlpAdmissionTeamOverviewTitleMapper.deleteNlpAdmissionTeamOverviewTitleByIds(ids);
    }

    /**
     * 删除团队掠影 标题 (title)信息
     *
     * @param id 团队掠影 标题 (title)主键
     * @return 结果
     */
    @Override
    public int deleteNlpAdmissionTeamOverviewTitleById(Integer id)
    {
        return nlpAdmissionTeamOverviewTitleMapper.deleteNlpAdmissionTeamOverviewTitleById(id);
    }
}
