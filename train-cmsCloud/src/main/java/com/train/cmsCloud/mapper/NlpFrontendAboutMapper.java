package com.train.cmsCloud.mapper;

import java.util.List;
import com.train.common.domain.NlpFrontendAbout;
import org.apache.ibatis.annotations.Mapper;

/**
 * 联系我们Mapper接口
 *
 * @author relief
 * @date 2023-04-07
 */
@Mapper
public interface NlpFrontendAboutMapper
{
    /**
     * 查询联系我们
     *
     * @param id 联系我们主键
     * @return 联系我们
     */
    public NlpFrontendAbout selectNlpFrontendAboutById(Long id);

    /**
     * 查询联系我们列表
     *
     * @param nlpFrontendAbout 联系我们
     * @return 联系我们集合
     */
    public List<NlpFrontendAbout> selectNlpFrontendAboutList(NlpFrontendAbout nlpFrontendAbout);

    /**
     * 新增联系我们
     *
     * @param nlpFrontendAbout 联系我们
     * @return 结果
     */
    public int insertNlpFrontendAbout(NlpFrontendAbout nlpFrontendAbout);

    /**
     * 修改联系我们
     *
     * @param nlpFrontendAbout 联系我们
     * @return 结果
     */
    public int updateNlpFrontendAbout(NlpFrontendAbout nlpFrontendAbout);

    /**
     * 删除联系我们
     *
     * @param id 联系我们主键
     * @return 结果
     */
    public int deleteNlpFrontendAboutById(Long id);

    /**
     * 批量删除联系我们
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNlpFrontendAboutByIds(Long[] ids);
}
