package com.train.cmsCloud.mapper;

import com.train.common.domain.NlpLabDirection;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
/**
 * 研究方向管理Mapper接口
 * 
 * @author relief
 * @date 2023-04-07
 */
public interface NlpLabDirectionMapper 
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
     * 删除研究方向管理
     * 
     * @param id 研究方向管理主键
     * @return 结果
     */
    public int deleteNlpLabDirectionById(Long id);

    /**
     * 批量删除研究方向管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNlpLabDirectionByIds(Long[] ids);
}
