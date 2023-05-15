package com.train.cmsCloud.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.train.cmsCloud.mapper.NlpAdmissionTeamOverviewImgMapper;
import com.train.common.domain.NlpAdmissionTeamOverviewImg;
import com.train.common.domain.dto.NlpAdmissionTeamOverviewTitleDTO;
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
    @Autowired
    private NlpAdmissionTeamOverviewImgMapper nlpAdmissionTeamOverviewImgMapper;

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

    /**
     * 查询团队掠影 标题和图片 对应的列表
     *
     * @return 结果
     */
    @Override
    public List<NlpAdmissionTeamOverviewTitleDTO> selectNlpAdmissionTeamOverviewTitleDTOList() {

        List<NlpAdmissionTeamOverviewTitle> nlpAdmissionTeamOverviewTitleList =
                nlpAdmissionTeamOverviewTitleMapper.selectNlpAdmissionTeamOverviewTitleList(null);
        List<NlpAdmissionTeamOverviewImg> nlpAdmissionTeamOverviewImgList =
                nlpAdmissionTeamOverviewImgMapper.selectNlpAdmissionTeamOverviewImgList(null);

        List<NlpAdmissionTeamOverviewTitleDTO> nlpAdmissionTeamOverviewTitleDTOListResult = new ArrayList<>(
                nlpAdmissionTeamOverviewTitleList.size());

        Map<Integer, Integer> titleIdToIndex = new HashMap<>();
        int index = 0;
        for (NlpAdmissionTeamOverviewTitle nlpAdmissionTeamOverviewTitle : nlpAdmissionTeamOverviewTitleList) {
            NlpAdmissionTeamOverviewTitleDTO nlpAdmissionTeamOverviewTitleDTO = new NlpAdmissionTeamOverviewTitleDTO();

            // 赋值
            nlpAdmissionTeamOverviewTitleDTO.setId(nlpAdmissionTeamOverviewTitle.getId());
            nlpAdmissionTeamOverviewTitleDTO.setTitle(nlpAdmissionTeamOverviewTitle.getTitle());
            nlpAdmissionTeamOverviewTitleDTO.setPostSort(nlpAdmissionTeamOverviewTitle.getPostSort());
            nlpAdmissionTeamOverviewTitleDTO.setStatus(nlpAdmissionTeamOverviewTitle.getStatus());
            nlpAdmissionTeamOverviewTitleDTO.setCreateTime(nlpAdmissionTeamOverviewTitle.getCreateTime());
            nlpAdmissionTeamOverviewTitleDTO.setCreateBy(nlpAdmissionTeamOverviewTitle.getCreateBy());
            nlpAdmissionTeamOverviewTitleDTO.setUpdateTime(nlpAdmissionTeamOverviewTitle.getUpdateTime());
            nlpAdmissionTeamOverviewTitleDTO.setUpdateBy(nlpAdmissionTeamOverviewTitle.getUpdateBy());
            nlpAdmissionTeamOverviewTitleDTO.setRemark(nlpAdmissionTeamOverviewTitle.getRemark());

            // 添加到结果集
            nlpAdmissionTeamOverviewTitleDTOListResult.add(nlpAdmissionTeamOverviewTitleDTO);

            // titleId -> index
            titleIdToIndex.put(nlpAdmissionTeamOverviewTitle.getId(), index ++);
        }

        for (NlpAdmissionTeamOverviewImg nlpAdmissionTeamOverviewImg : nlpAdmissionTeamOverviewImgList) {
            Integer titleId = nlpAdmissionTeamOverviewImg.getTitleId();
            Integer titleIndex = titleIdToIndex.get(titleId);

            // 添加 img 到对应 title 的 DTO
            nlpAdmissionTeamOverviewTitleDTOListResult.get(titleIndex).addImg(nlpAdmissionTeamOverviewImg);
        }

        return nlpAdmissionTeamOverviewTitleDTOListResult;
    }

}
