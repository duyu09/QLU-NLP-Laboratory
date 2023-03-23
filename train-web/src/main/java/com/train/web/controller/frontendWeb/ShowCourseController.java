package com.train.web.controller.frontendWeb;

import com.train.frontendWeb.domain.WebCourse;
import com.train.frontendWeb.service.IShowCourseService;
import com.train.common.core.controller.BaseController;
import com.train.common.core.domain.AjaxResult;
import com.train.common.core.domain.entity.SysDictData;
import com.train.common.core.page.TableDataInfo;
import com.train.system.service.ISysDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 视频资源管理Controller
 * 
 * @author qluoj
 * @date 2022-01-02
 */
@RestController
@RequestMapping("/show/course")
public class ShowCourseController extends BaseController
{
    @Autowired
    private IShowCourseService qluCourseService;

    @Autowired
    private ISysDictTypeService dictTypeService;
    /**
     * 查询视频资源管理列表
     */
    @GetMapping(value = "/list/{dictType}")
    public AjaxResult list(@PathVariable String dictType)
    {
        WebCourse qluCourse = new WebCourse();
        List<Object> data = new ArrayList<>();

        // 根据类别获取分类
        List<SysDictData> sysDictDataList = dictTypeService.selectDictDataByType(dictType);

        for (SysDictData sysDictData: sysDictDataList) {
            Map<String,Object> characterMap = new LinkedHashMap<>();

            qluCourse.setConfigId( sysDictData.getDictValue() );
            characterMap.put("title", sysDictData.getDictLabel());
            characterMap.put("courses",qluCourseService.selectShowCourseList(qluCourse));
            data.add(characterMap);
        }
        return AjaxResult.success(data);
    }
    @GetMapping("/list")
    public TableDataInfo list(WebCourse qluCourse)
    {
        startPage();
        List<WebCourse> list = qluCourseService.selectShowCourseList(qluCourse);
        return getDataTable(list);
    }

    /**
     * 获取视频资源管理详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(qluCourseService.selectShowCourseById(id));
    }

}
