package com.train.cmsCloud.service;

import java.util.List;

import com.train.common.domain.NlpLabDirection;

/**
 * 研究方向管理Service接口
 * 
 * @author relief
 * @date 2023-04-07
 */
public interface INlpLabDirectionService 
{
    /**
     * 查询研究方向管理
     * 
     * @param id 研究方向管理主键
     * @return 研究方向管理
     */
    public NlpLabDirection selectNlpLabDirectionById(Long id);

    /**
     * 查询研究方向管理列表
     * 
     * @param nlpLabDirection 研究方向管理
     * @return 研究方向管理集合
     */
    public List<NlpLabDirection> selectNlpLabDirectionList(NlpLabDirection nlpLabDirection);

    /**
     * 新增研究方向管理
     * 
     * @param nlpLabDirection 研究方向管理
     * @return 结果
     */
    public int insertNlpLabDirection(NlpLabDirection nlpLabDirection);

    /**
     * 修改研究方向管理
     * 
     * @param nlpLabDirection 研究方向管理
     * @return 结果
     */
    public int updateNlpLabDirection(NlpLabDirection nlpLabDirection);

    /**
     * 批量删除研究方向管理
     * 
     * @param ids 需要删除的研究方向管理主键集合
     * @return 结果
     */
    public int deleteNlpLabDirectionByIds(Long[] ids);

    /**
     * 删除研究方向管理信息
     * 
     * @param id 研究方向管理主键
     * @return 结果
     */
    public int deleteNlpLabDirectionById(Long id);
}
