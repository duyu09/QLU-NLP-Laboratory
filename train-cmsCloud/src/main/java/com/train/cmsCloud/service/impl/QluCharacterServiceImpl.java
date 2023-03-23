package com.train.cmsCloud.service.impl;

import java.util.List;
import com.train.common.utils.DateUtils;
import com.train.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.train.cmsCloud.mapper.QluCharacterMapper;
import com.train.cmsCloud.domain.QluCharacter;
import com.train.cmsCloud.service.IQluCharacterService;

/**
 * 人物志管理Service业务层处理
 * 
 * @author qluoj
 * @date 2022-01-02
 */
@Service
public class QluCharacterServiceImpl implements IQluCharacterService 
{
    @Autowired
    private QluCharacterMapper qluCharacterMapper;

    /**
     * 查询人物志管理
     * 
     * @param id 人物志管理主键
     * @return 人物志管理
     */
    @Override
    public QluCharacter selectQluCharacterById(String id)
    {
        return qluCharacterMapper.selectQluCharacterById(id);
    }

    /**
     * 查询人物志管理列表
     * 
     * @param qluCharacter 人物志管理
     * @return 人物志管理
     */
    @Override
    public List<QluCharacter> selectQluCharacterList(QluCharacter qluCharacter)
    {
        return qluCharacterMapper.selectQluCharacterList(qluCharacter);
    }

    /**
     * 新增人物志管理
     * 
     * @param qluCharacter 人物志管理
     * @return 结果
     */
    @Override
    public int insertQluCharacter(QluCharacter qluCharacter)
    {
        qluCharacter.setCreateBy(SecurityUtils.getUsername());
        qluCharacter.setCreateTime(DateUtils.getNowDate());
        return qluCharacterMapper.insertQluCharacter(qluCharacter);
    }

    /**
     * 修改人物志管理
     * 
     * @param qluCharacter 人物志管理
     * @return 结果
     */
    @Override
    public int updateQluCharacter(QluCharacter qluCharacter)
    {
        qluCharacter.setUpdateBy(SecurityUtils.getUsername());
        qluCharacter.setUpdateTime(DateUtils.getNowDate());
        return qluCharacterMapper.updateQluCharacter(qluCharacter);
    }

    /**
     * 批量删除人物志管理
     * 
     * @param ids 需要删除的人物志管理主键
     * @return 结果
     */
    @Override
    public int deleteQluCharacterByIds(String[] ids)
    {
        return qluCharacterMapper.deleteQluCharacterByIds(ids);
    }

    /**
     * 删除人物志管理信息
     * 
     * @param id 人物志管理主键
     * @return 结果
     */
    @Override
    public int deleteQluCharacterById(String id)
    {
        return qluCharacterMapper.deleteQluCharacterById(id);
    }
}
