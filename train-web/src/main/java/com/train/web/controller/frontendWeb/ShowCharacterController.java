package com.train.web.controller.frontendWeb;

import com.train.frontendWeb.domain.WebCharacter;
import com.train.frontendWeb.service.IShowCharacterService;
import com.train.common.core.controller.BaseController;
import com.train.common.core.domain.AjaxResult;
import com.train.common.core.domain.entity.SysDictData;
import com.train.system.service.ISysDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 人物志管理Controller
 * 
 * @author qluoj
 * @date 2022-01-02
 */
@RestController
@RequestMapping("/show/character")
public class ShowCharacterController extends BaseController
{
    @Autowired
    private IShowCharacterService qluCharacterService;

    @Autowired
    private ISysDictTypeService dictTypeService;
    /**
     * 查询人物志
     */
    @GetMapping(value = "/list/{dictType}")
    public AjaxResult list(@PathVariable String dictType)
    {
        WebCharacter qluCharacter = new WebCharacter();
        List<Object> data = new ArrayList<>();

        // 根据类别获取分类
        List<SysDictData> sysDictDataList = dictTypeService.selectDictDataByType(dictType);

        for (SysDictData sysDictData: sysDictDataList) {
            Map<String,Object> characterMap = new LinkedHashMap<>();

            qluCharacter.setConfigId( sysDictData.getDictValue() );
            characterMap.put("title", sysDictData.getDictLabel());
            characterMap.put("characters",qluCharacterService.selectShowCharacterList(qluCharacter));
            data.add(characterMap);
        }
        return AjaxResult.success(data);
    }

    /**
     * 获取人物志管理详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(qluCharacterService.selectShowCharacterById(id));
    }

}
