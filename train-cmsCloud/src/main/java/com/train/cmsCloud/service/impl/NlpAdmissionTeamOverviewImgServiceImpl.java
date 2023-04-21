package com.train.cmsCloud.service.impl;

import java.util.List;
import com.train.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.train.cmsCloud.mapper.NlpAdmissionTeamOverviewImgMapper;
import com.train.common.domain.NlpAdmissionTeamOverviewImg;
import com.train.cmsCloud.service.INlpAdmissionTeamOverviewImgService;

/**
 * 团队掠影 图片 (img)Service业务层处理
 *
 * @author ICOVETOUS
 * @date 2023-04-21
 */
@Service
public class NlpAdmissionTeamOverviewImgServiceImpl implements INlpAdmissionTeamOverviewImgService
{
    @Autowired
    private NlpAdmissionTeamOverviewImgMapper nlpAdmissionTeamOverviewImgMapper;

    /**
     * 查询团队掠影 图片 (img)
     *
     * @param id 团队掠影 图片 (img)主键
     * @return 团队掠影 图片 (img)
     */
    @Override
    public NlpAdmissionTeamOverviewImg selectNlpAdmissionTeamOverviewImgById(Integer id)
    {
        return nlpAdmissionTeamOverviewImgMapper.selectNlpAdmissionTeamOverviewImgById(id);
    }

    /**
     * 查询团队掠影 图片 (img)列表
     *
     * @param nlpAdmissionTeamOverviewImg 团队掠影 图片 (img)
     * @return 团队掠影 图片 (img)
     */
    @Override
    public List<NlpAdmissionTeamOverviewImg> selectNlpAdmissionTeamOverviewImgList(NlpAdmissionTeamOverviewImg nlpAdmissionTeamOverviewImg)
    {
        return nlpAdmissionTeamOverviewImgMapper.selectNlpAdmissionTeamOverviewImgList(nlpAdmissionTeamOverviewImg);
    }

    /**
     * 新增团队掠影 图片 (img)
     *
     * @param nlpAdmissionTeamOverviewImg 团队掠影 图片 (img)
     * @return 结果
     */
    @Override
    public int insertNlpAdmissionTeamOverviewImg(NlpAdmissionTeamOverviewImg nlpAdmissionTeamOverviewImg)
    {
        nlpAdmissionTeamOverviewImg.setCreateTime(DateUtils.getNowDate());
        return nlpAdmissionTeamOverviewImgMapper.insertNlpAdmissionTeamOverviewImg(nlpAdmissionTeamOverviewImg);
    }

    /**
     * 修改团队掠影 图片 (img)
     *
     * @param nlpAdmissionTeamOverviewImg 团队掠影 图片 (img)
     * @return 结果
     */
    @Override
    public int updateNlpAdmissionTeamOverviewImg(NlpAdmissionTeamOverviewImg nlpAdmissionTeamOverviewImg)
    {
        nlpAdmissionTeamOverviewImg.setUpdateTime(DateUtils.getNowDate());
        return nlpAdmissionTeamOverviewImgMapper.updateNlpAdmissionTeamOverviewImg(nlpAdmissionTeamOverviewImg);
    }

    /**
     * 批量删除团队掠影 图片 (img)
     *
     * @param ids 需要删除的团队掠影 图片 (img)主键
     * @return 结果
     */
    @Override
    public int deleteNlpAdmissionTeamOverviewImgByIds(Integer[] ids)
    {
        return nlpAdmissionTeamOverviewImgMapper.deleteNlpAdmissionTeamOverviewImgByIds(ids);
    }

    /**
     * 删除团队掠影 图片 (img)信息
     *
     * @param id 团队掠影 图片 (img)主键
     * @return 结果
     */
    @Override
    public int deleteNlpAdmissionTeamOverviewImgById(Integer id)
    {
        return nlpAdmissionTeamOverviewImgMapper.deleteNlpAdmissionTeamOverviewImgById(id);
    }
}
