package com.train.frontendWeb.mapper;

import com.train.frontendWeb.domain.WebCharacter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Along
 */
@Mapper
public interface ShowCharacterMapper {
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
