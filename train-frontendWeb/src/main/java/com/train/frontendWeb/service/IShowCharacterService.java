package com.train.frontendWeb.service;

import com.train.frontendWeb.domain.WebCharacter;

import java.util.List;

public interface IShowCharacterService {
    /**
     * 查询人物志管理
     *
     * @param id 人物志管理主键
     * @return 人物志管理
     */
    public WebCharacter selectShowCharacterById(String id);

    /**
     * 查询人物志管理列表
     *
     * @param qluCharacter 人物志管理
     * @return 人物志管理集合
     */
    public List<WebCharacter> selectShowCharacterList(WebCharacter qluCharacter);
}
