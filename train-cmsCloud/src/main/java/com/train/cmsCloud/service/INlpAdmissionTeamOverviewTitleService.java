package com.train.cmsCloud.service;

import java.util.List;
import com.train.common.domain.NlpAdmissionTeamOverviewTitle;
import com.train.common.domain.dto.NlpAdmissionTeamOverviewTitleDTO;

/**
 * 团队掠影 标题 (title)Service接口
 *
 * @author ICOVETOUS
 * @date 2023-04-21
 */
public interface INlpAdmissionTeamOverviewTitleService
{
    /**
     * 查询团队掠影 标题 (title)
     *
     * @param id 团队掠影 标题 (title)主键
     * @return 团队掠影 标题 (title)
     */
    public NlpAdmissionTeamOverviewTitle selectNlpAdmissionTeamOverviewTitleById(Integer id);

    /**
     * 查询团队掠影 标题 (title)列表
     *
     * @param nlpAdmissionTeamOverviewTitle 团队掠影 标题 (title)
     * @return 团队掠影 标题 (title)集合
     */
    public List<NlpAdmissionTeamOverviewTitle> selectNlpAdmissionTeamOverviewTitleList(NlpAdmissionTeamOverviewTitle nlpAdmissionTeamOverviewTitle);

    /**
     * 新增团队掠影 标题 (title)
     *
     * @param nlpAdmissionTeamOverviewTitle 团队掠影 标题 (title)
     * @return 结果
     */
    public int insertNlpAdmissionTeamOverviewTitle(NlpAdmissionTeamOverviewTitle nlpAdmissionTeamOverviewTitle);

    /**
     * 修改团队掠影 标题 (title)
     *
     * @param nlpAdmissionTeamOverviewTitle 团队掠影 标题 (title)
     * @return 结果
     */
    public int updateNlpAdmissionTeamOverviewTitle(NlpAdmissionTeamOverviewTitle nlpAdmissionTeamOverviewTitle);

    /**
     * 批量删除团队掠影 标题 (title)
     *
     * @param ids 需要删除的团队掠影 标题 (title)主键集合
     * @return 结果
     */
    public int deleteNlpAdmissionTeamOverviewTitleByIds(Integer[] ids);

    /**
     * 删除团队掠影 标题 (title)信息
     *
     * @param id 团队掠影 标题 (title)主键
     * @return 结果
     */
    public int deleteNlpAdmissionTeamOverviewTitleById(Integer id);

    /**
     * 查询团队掠影 标题和图片 对应的列表
     *
     * @return 结果
     */
    List<NlpAdmissionTeamOverviewTitleDTO> selectNlpAdmissionTeamOverviewTitleDTOList();
}
