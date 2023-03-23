package com.train.web.controller.frontendWeb;

import com.train.frontendWeb.domain.WebTopicCollection;
import com.train.frontendWeb.service.IShowTopicCollectionService;
import com.train.common.core.controller.BaseController;
import com.train.common.core.domain.AjaxResult;
import com.train.common.core.domain.entity.SysDictData;
import com.train.system.service.ISysDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 题集资源管理Controller
 * 
 * @author qluoj
 * @date 2022-01-02
 */
@RestController
@RequestMapping("/show/collection")
public class ShowTopicCollectionController extends BaseController
{
    @Autowired
    private IShowTopicCollectionService qluTopicCollectionService;

    @Autowired
    private ISysDictTypeService dictTypeService;

    /**
     * 查询题集资源管理列表
     */
    @GetMapping(value = "/list/{dictType}/{remark}")
    public AjaxResult list(@PathVariable String dictType,@PathVariable String remark)
    {
        WebTopicCollection qluTopicCollection = new WebTopicCollection();
        List<Object> data = new ArrayList<>();

        // 根据类别获取分类
        List<SysDictData> sysDictDataList = dictTypeService.selectDictDataByType(dictType);

        for (SysDictData sysDictData: sysDictDataList) {

            if( sysDictData.getRemark().equals(remark)){
                Map<String,Object> characterMap = new LinkedHashMap<>();

                qluTopicCollection.setConfigId( sysDictData.getDictValue() );
                characterMap.put("title", sysDictData.getDictLabel());
                characterMap.put("topicCollections",qluTopicCollectionService.selectShowTopicCollectionList(qluTopicCollection));
                data.add(characterMap);
            }
        }
        return AjaxResult.success(data);
    }

}
