package com.train.cmsCloud.service.impl;

import java.util.List;

import com.train.common.constant.UserConstants;
import com.train.common.domain.NlpFrontendAbout;
import com.train.common.domain.NlpFrontendAboutManagement;
import com.train.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.train.cmsCloud.mapper.NlpFrontendAboutMapper;
import com.train.cmsCloud.service.INlpFrontendAboutService;

/**
 * 联系我们Service业务层处理
 *
 * @author relief
 * @date 2023-04-07
 */
@Service
public class NlpFrontendAboutServiceImpl implements INlpFrontendAboutService
{
    @Autowired
    private NlpFrontendAboutMapper nlpFrontendAboutMapper;

    /**
     * 查询联系我们
     *
     * @param id 联系我们主键
     * @return 联系我们
     */
    @Override
    public NlpFrontendAbout selectNlpFrontendAboutById(Long id)
    {
        return nlpFrontendAboutMapper.selectNlpFrontendAboutById(id);
    }

    /**
     * 查询联系我们列表
     *
     * @param nlpFrontendAbout 联系我们
     * @return 联系我们
     */
    @Override
    public List<NlpFrontendAbout> selectNlpFrontendAboutList(NlpFrontendAbout nlpFrontendAbout)
    {
        return nlpFrontendAboutMapper.selectNlpFrontendAboutList(nlpFrontendAbout);
    }

    /**
     * 新增联系我们
     *
     * @param nlpFrontendAbout 联系我们
     * @return 结果
     */
    @Override
    public int insertNlpFrontendAbout(NlpFrontendAbout nlpFrontendAbout)
    {
        nlpFrontendAbout.setCreateTime(DateUtils.getNowDate());
        return nlpFrontendAboutMapper.insertNlpFrontendAbout(nlpFrontendAbout);
    }

    /**
     * 修改联系我们
     *
     * @param nlpFrontendAbout 联系我们
     * @return 结果
     */
    @Override
    public int updateNlpFrontendAbout(NlpFrontendAbout nlpFrontendAbout)
    {
        nlpFrontendAbout.setUpdateTime(DateUtils.getNowDate());
        return nlpFrontendAboutMapper.updateNlpFrontendAbout(nlpFrontendAbout);
    }

    /**
     * 批量删除联系我们
     *
     * @param ids 需要删除的联系我们主键
     * @return 结果
     */
    @Override
    public int deleteNlpFrontendAboutByIds(Long[] ids)
    {
        return nlpFrontendAboutMapper.deleteNlpFrontendAboutByIds(ids);
    }

    /**
     * 删除联系我们信息
     *
     * @param id 联系我们主键
     * @return 结果
     */
    @Override
    public int deleteNlpFrontendAboutById(Long id)
    {
        return nlpFrontendAboutMapper.deleteNlpFrontendAboutById(id);
    }

    @Override
    public NlpFrontendAbout selectNlpFrontendAboutByType(String type) {
        return nlpFrontendAboutMapper.selectNlpFrontendAboutByType(type);
    }

    @Override
    public void checkTypeAllowed(NlpFrontendAbout nlpFrontendAbout) {

    }


    @Override
    public String checkTypeUnique(String type, Long id) {
        NlpFrontendAbout management = new NlpFrontendAbout();
        management.setType(type);
        List<NlpFrontendAbout> list =  nlpFrontendAboutMapper.selectNlpFrontendAboutList(management);
        if (list.size() > 0)
        {
            if (list.size() == 1 && id.equals(list.get(0).getId())) {
                return UserConstants.UNIQUE;
            }
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }
}
