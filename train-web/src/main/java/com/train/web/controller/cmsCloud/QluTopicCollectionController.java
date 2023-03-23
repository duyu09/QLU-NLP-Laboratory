package com.train.web.controller.cmsCloud;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.train.common.annotation.Log;
import com.train.common.core.controller.BaseController;
import com.train.common.core.domain.AjaxResult;
import com.train.common.enums.BusinessType;
import com.train.cmsCloud.domain.QluTopicCollection;
import com.train.cmsCloud.service.IQluTopicCollectionService;
import com.train.common.utils.poi.ExcelUtil;
import com.train.common.core.page.TableDataInfo;

/**
 * 题集资源管理Controller
 * 
 * @author qluoj
 * @date 2022-01-02
 */
@RestController
@RequestMapping("/addqluoj/collection")
public class QluTopicCollectionController extends BaseController
{
    @Autowired
    private IQluTopicCollectionService qluTopicCollectionService;

    /**
     * 查询题集资源管理列表
     */
    @PreAuthorize("@ss.hasPermi('addqluoj:collection:list')")
    @GetMapping("/list")
    public TableDataInfo list(QluTopicCollection qluTopicCollection)
    {
        startPage();
        List<QluTopicCollection> list = qluTopicCollectionService.selectQluTopicCollectionList(qluTopicCollection);
        return getDataTable(list);
    }

    /**
     * 导出题集资源管理列表
     */
    @PreAuthorize("@ss.hasPermi('addqluoj:collection:export')")
    @Log(title = "题集资源管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, QluTopicCollection qluTopicCollection)
    {
        List<QluTopicCollection> list = qluTopicCollectionService.selectQluTopicCollectionList(qluTopicCollection);
        ExcelUtil<QluTopicCollection> util = new ExcelUtil<QluTopicCollection>(QluTopicCollection.class);
        util.exportExcel(response, list, "题集资源管理数据");
    }

    /**
     * 获取题集资源管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('addqluoj:collection:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(qluTopicCollectionService.selectQluTopicCollectionById(id));
    }

    /**
     * 新增题集资源管理
     */
    @PreAuthorize("@ss.hasPermi('addqluoj:collection:add')")
    @Log(title = "题集资源管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody QluTopicCollection qluTopicCollection)
    {
        return toAjax(qluTopicCollectionService.insertQluTopicCollection(qluTopicCollection));
    }

    /**
     * 修改题集资源管理
     */
    @PreAuthorize("@ss.hasPermi('addqluoj:collection:edit')")
    @Log(title = "题集资源管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody QluTopicCollection qluTopicCollection)
    {
        return toAjax(qluTopicCollectionService.updateQluTopicCollection(qluTopicCollection));
    }

    /**
     * 删除题集资源管理
     */
    @PreAuthorize("@ss.hasPermi('addqluoj:collection:remove')")
    @Log(title = "题集资源管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(qluTopicCollectionService.deleteQluTopicCollectionByIds(ids));
    }
}
