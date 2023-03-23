package com.train.web.controller.frontendWeb;

import com.train.frontendWeb.domain.WebAnnouncement;
import com.train.frontendWeb.service.IShowAnnouncementService;
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
 * 公告通知展示Controller
 * 
 * @author qluoj
 * @date 2022-01-02
 */
@RestController
@RequestMapping("/show/announcement")
public class ShowAnnouncementController extends BaseController
{
    @Autowired
    private IShowAnnouncementService showAnnouncementService;

    @Autowired
    private ISysDictTypeService dictTypeService;

    /**
     * 查询公告通知管理列表
     */
    @GetMapping(value = "/list/{dictType}")
    public AjaxResult list(@PathVariable String dictType)
    {
        WebAnnouncement qluAnnouncement = new WebAnnouncement();
        List<Object> data = new ArrayList<>();

        // 根据类别获取分类
        List<SysDictData> sysDictDataList = dictTypeService.selectDictDataByType(dictType);

        for (SysDictData sysDictData: sysDictDataList) {
            Map<String,Object> characterMap = new LinkedHashMap<>();

            qluAnnouncement.setConfigId( sysDictData.getDictValue() );
            characterMap.put("title", sysDictData.getDictLabel());
            characterMap.put("announcements",showAnnouncementService.selectShowAnnouncementList(qluAnnouncement));
            data.add(characterMap);
        }
        return AjaxResult.success(data);
    }

    /**
     * 获取公告通知管理详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(showAnnouncementService.selectShowAnnouncementById(id));
    }

}
