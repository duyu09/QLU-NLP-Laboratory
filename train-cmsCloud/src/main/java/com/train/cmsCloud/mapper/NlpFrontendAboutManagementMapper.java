package com.train.cmsCloud.mapper;

import java.util.List;

import com.train.common.domain.NlpFrontendAboutManagement;
import org.apache.ibatis.annotations.Mapper;

/**
 * 联系我们(管理)Mapper接口
 *
 * @author relief
 * @date 2023-04-07
 */
@Mapper
public interface NlpFrontendAboutManagementMapper {
    /**
     * 查询联系我们(管理)
     *
     * @param id 联系我们(管理)主键
     * @return 联系我们(管理)
     */
    public NlpFrontendAboutManagement selectNlpFrontendAboutManagementById(Long id);

    /**
     * 查询联系我们(管理)列表
     *
     * @param nlpFrontendAboutManagement 联系我们(管理)
     * @return 联系我们(管理)集合
     */
    public List<NlpFrontendAboutManagement> selectNlpFrontendAboutManagementList(NlpFrontendAboutManagement nlpFrontendAboutManagement);

    /**
     * 新增联系我们(管理)
     *
     * @param nlpFrontendAboutManagement 联系我们(管理)
     * @return 结果
     */
    public int insertNlpFrontendAboutManagement(NlpFrontendAboutManagement nlpFrontendAboutManagement);

    /**
     * 修改联系我们(管理)
     *
     * @param nlpFrontendAboutManagement 联系我们(管理)
     * @return 结果
     */
    public int updateNlpFrontendAboutManagement(NlpFrontendAboutManagement nlpFrontendAboutManagement);

    /**
     * 删除联系我们(管理)
     *
     * @param id 联系我们(管理)主键
     * @return 结果
     */
    public int deleteNlpFrontendAboutManagementById(Long id);

    /**
     * 批量删除联系我们(管理)
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNlpFrontendAboutManagementByIds(Long[] ids);
}

