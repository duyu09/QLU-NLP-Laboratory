package com.train.cmsCloud.service;

import java.util.List;
import com.train.cmsCloud.domain.QluCharacter;

/**
 * 人物志管理Service接口
 * 
 * @author qluoj
 * @date 2022-01-02
 */
public interface IQluCharacterService 
{
    /**
     * 查询人物志管理
     * 
     * @param id 人物志管理主键
     * @return 人物志管理
     */
    public QluCharacter selectQluCharacterById(String id);

    /**
     * 查询人物志管理列表
     * 
     * @param qluCharacter 人物志管理
     * @return 人物志管理集合
     */
    public List<QluCharacter> selectQluCharacterList(QluCharacter qluCharacter);

    /**
     * 新增人物志管理
     * 
     * @param qluCharacter 人物志管理
     * @return 结果
     */
    public int insertQluCharacter(QluCharacter qluCharacter);

    /**
     * 修改人物志管理
     * 
     * @param qluCharacter 人物志管理
     * @return 结果
     */
    public int updateQluCharacter(QluCharacter qluCharacter);

    /**
     * 批量删除人物志管理
     * 
     * @param ids 需要删除的人物志管理主键集合
     * @return 结果
     */
    public int deleteQluCharacterByIds(String[] ids);

    /**
     * 删除人物志管理信息
     * 
     * @param id 人物志管理主键
     * @return 结果
     */
    public int deleteQluCharacterById(String id);
}
