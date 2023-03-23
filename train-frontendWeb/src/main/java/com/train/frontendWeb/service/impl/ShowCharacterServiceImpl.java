package com.train.frontendWeb.service.impl;

import com.train.frontendWeb.domain.WebCharacter;
import com.train.frontendWeb.mapper.ShowCharacterMapper;
import com.train.frontendWeb.service.IShowCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowCharacterServiceImpl implements IShowCharacterService{

    @Autowired
    private ShowCharacterMapper qluCharacterMapper;

    /**
     * 查询人物志管理
     *
     * @param id 人物志管理主键
     * @return 人物志管理
     */
    @Override
    public WebCharacter selectShowCharacterById(String id)
    {
        return qluCharacterMapper.selectShowCharacterById(id);
    }

    /**
     * 查询人物志管理列表
     *
     * @param qluCharacter 人物志管理
     * @return 人物志管理
     */
    @Override
    public List<WebCharacter> selectShowCharacterList(WebCharacter qluCharacter)
    {
        return qluCharacterMapper.selectShowCharacterList(qluCharacter);
    }
}
