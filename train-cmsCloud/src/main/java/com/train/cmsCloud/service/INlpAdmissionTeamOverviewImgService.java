package com.train.cmsCloud.service;

import java.util.List;
import com.train.common.domain.NlpAdmissionTeamOverviewImg;

/**
 * 团队掠影 图片 (img)Service接口
 *
 * @author ICOVETOUS
 * @date 2023-04-21
 */
public interface INlpAdmissionTeamOverviewImgService
{
    /**
     * 查询团队掠影 图片 (img)
     *
     * @param id 团队掠影 图片 (img)主键
     * @return 团队掠影 图片 (img)
     */
    public NlpAdmissionTeamOverviewImg selectNlpAdmissionTeamOverviewImgById(Integer id);

    /**
     * 查询团队掠影 图片 (img)列表
     *
     * @param nlpAdmissionTeamOverviewImg 团队掠影 图片 (img)
     * @return 团队掠影 图片 (img)集合
     */
    public List<NlpAdmissionTeamOverviewImg> selectNlpAdmissionTeamOverviewImgList(NlpAdmissionTeamOverviewImg nlpAdmissionTeamOverviewImg);

    /**
     * 新增团队掠影 图片 (img)
     *
     * @param nlpAdmissionTeamOverviewImg 团队掠影 图片 (img)
     * @return 结果
     */
    public int insertNlpAdmissionTeamOverviewImg(NlpAdmissionTeamOverviewImg nlpAdmissionTeamOverviewImg);

    /**
     * 修改团队掠影 图片 (img)
     *
     * @param nlpAdmissionTeamOverviewImg 团队掠影 图片 (img)
     * @return 结果
     */
    public int updateNlpAdmissionTeamOverviewImg(NlpAdmissionTeamOverviewImg nlpAdmissionTeamOverviewImg);

    /**
     * 批量删除团队掠影 图片 (img)
     *
     * @param ids 需要删除的团队掠影 图片 (img)主键集合
     * @return 结果
     */
    public int deleteNlpAdmissionTeamOverviewImgByIds(Integer[] ids);

    /**
     * 删除团队掠影 图片 (img)信息
     *
     * @param id 团队掠影 图片 (img)主键
     * @return 结果
     */
    public int deleteNlpAdmissionTeamOverviewImgById(Integer id);
}
