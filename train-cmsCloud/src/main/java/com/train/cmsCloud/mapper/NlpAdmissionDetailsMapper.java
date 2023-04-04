package com.train.cmsCloud.mapper;

import java.util.List;
import com.train.common.domain.NlpAdmissionDetails;
import org.apache.ibatis.annotations.Mapper;

/**
 * 招生详情数据Mapper接口
 *
 * @author ICOVETOUS
 * @date 2023-04-04
 */
@Mapper
public interface NlpAdmissionDetailsMapper
{
    /**
     * 查询招生详情数据
     *
     * @param id 招生详情数据主键
     * @return 招生详情数据
     */
    public NlpAdmissionDetails selectNlpAdmissionDetailsById(Integer id);

    /**
     * 查询招生详情数据列表
     *
     * @param nlpAdmissionDetails 招生详情数据
     * @return 招生详情数据集合
     */
    public List<NlpAdmissionDetails> selectNlpAdmissionDetailsList(NlpAdmissionDetails nlpAdmissionDetails);

    /**
     * 新增招生详情数据
     *
     * @param nlpAdmissionDetails 招生详情数据
     * @return 结果
     */
    public int insertNlpAdmissionDetails(NlpAdmissionDetails nlpAdmissionDetails);

    /**
     * 修改招生详情数据
     *
     * @param nlpAdmissionDetails 招生详情数据
     * @return 结果
     */
    public int updateNlpAdmissionDetails(NlpAdmissionDetails nlpAdmissionDetails);

    /**
     * 删除招生详情数据
     *
     * @param id 招生详情数据主键
     * @return 结果
     */
    public int deleteNlpAdmissionDetailsById(Integer id);

    /**
     * 批量删除招生详情数据
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNlpAdmissionDetailsByIds(Integer[] ids);
}
