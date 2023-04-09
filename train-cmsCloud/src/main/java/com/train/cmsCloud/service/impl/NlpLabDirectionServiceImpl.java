package com.train.cmsCloud.service.impl;

import java.util.List;

import com.train.cmsCloud.mapper.NlpLabDirectionMapper;
import com.train.cmsCloud.service.INlpLabDirectionService;
import com.train.common.domain.NlpLabDirection;
import com.train.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 研究方向管理Service业务层处理
 * 
 * @author relief
 * @date 2023-04-07
 */
@Service
public class NlpLabDirectionServiceImpl implements INlpLabDirectionService
{
    @Autowired
    private NlpLabDirectionMapper nlpLabDirectionMapper;

    /**
     * 查询研究方向管理
     * 
     * @param id 研究方向管理主键
     * @return 研究方向管理
     */
    @Override
    public NlpLabDirection selectNlpLabDirectionById(Long id)
    {
        return nlpLabDirectionMapper.selectNlpLabDirectionById(id);
    }

    /**
     * 查询研究方向管理列表
     * 
     * @param nlpLabDirection 研究方向管理
     * @return 研究方向管理
     */
    @Override
    public List<NlpLabDirection> selectNlpLabDirectionList(NlpLabDirection nlpLabDirection)
    {
        return nlpLabDirectionMapper.selectNlpLabDirectionList(nlpLabDirection);
    }

    /**
     * 新增研究方向管理
     * 
     * @param nlpLabDirection 研究方向管理
     * @return 结果
     */
    @Override
    public int insertNlpLabDirection(NlpLabDirection nlpLabDirection)
    {
        nlpLabDirection.setCreateTime(DateUtils.getNowDate());
        return nlpLabDirectionMapper.insertNlpLabDirection(nlpLabDirection);
    }

    /**
     * 修改研究方向管理
     * 
     * @param nlpLabDirection 研究方向管理
     * @return 结果
     */
    @Override
    public int updateNlpLabDirection(NlpLabDirection nlpLabDirection)
    {
        return nlpLabDirectionMapper.updateNlpLabDirection(nlpLabDirection);
    }

    /**
     * 批量删除研究方向管理
     * 
     * @param ids 需要删除的研究方向管理主键
     * @return 结果
     */
    @Override
    public int deleteNlpLabDirectionByIds(Long[] ids)
    {
        return nlpLabDirectionMapper.deleteNlpLabDirectionByIds(ids);
    }

    /**
     * 删除研究方向管理信息
     * 
     * @param id 研究方向管理主键
     * @return 结果
     */
    @Override
    public int deleteNlpLabDirectionById(Long id)
    {
        return nlpLabDirectionMapper.deleteNlpLabDirectionById(id);
    }
}
