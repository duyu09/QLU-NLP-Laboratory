package com.train.cmsCloud.controller;

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
import com.train.common.domain.NlpDetailsManagement;
import com.train.cmsCloud.service.INlpDetailsManagementService;
import com.train.common.utils.poi.ExcelUtil;
import com.train.common.core.page.TableDataInfo;

/**
 * 招生详情 培养计划 招聘详情 数据（管理）Controller
 *
 * @author ICOVETOUS
 * @date 2023-04-05
 */
@RestController
@RequestMapping("/nlp/admission/detailsManagement")
public class NlpDetailsManagementController extends BaseController
{
    @Autowired
    private INlpDetailsManagementService nlpDetailsManagementService;

    /**
     * 查询招生详情 培养计划 招聘详情 数据（管理）列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:detailsManagement:list')")
    @GetMapping("/list")
    public TableDataInfo list(NlpDetailsManagement nlpDetailsManagement)
    {
        startPage();
        List<NlpDetailsManagement> list = nlpDetailsManagementService.selectNlpDetailsManagementList(nlpDetailsManagement);
        return getDataTable(list);
    }

    /**
     * 导出招生详情 培养计划 招聘详情 数据（管理）列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:detailsManagement:export')")
    @Log(title = "招生详情 培养计划 招聘详情 数据（管理）", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NlpDetailsManagement nlpDetailsManagement)
    {
        List<NlpDetailsManagement> list = nlpDetailsManagementService.selectNlpDetailsManagementList(nlpDetailsManagement);
        ExcelUtil<NlpDetailsManagement> util = new ExcelUtil<NlpDetailsManagement>(NlpDetailsManagement.class);
        util.exportExcel(response, list, "招生详情 培养计划 招聘详情 数据（管理）数据");
    }

    /**
     * 获取招生详情 培养计划 招聘详情 数据（管理）详细信息
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:detailsManagement:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(nlpDetailsManagementService.selectNlpDetailsManagementById(id));
    }

    /**
     * 新增招生详情 培养计划 招聘详情 数据（管理）
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:detailsManagement:add')")
    @Log(title = "招生详情 培养计划 招聘详情 数据（管理）", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NlpDetailsManagement nlpDetailsManagement)
    {
        return toAjax(nlpDetailsManagementService.insertNlpDetailsManagement(nlpDetailsManagement));
    }

    /**
     * 修改招生详情 培养计划 招聘详情 数据（管理）
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:detailsManagement:edit')")
    @Log(title = "招生详情 培养计划 招聘详情 数据（管理）", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NlpDetailsManagement nlpDetailsManagement)
    {
        return toAjax(nlpDetailsManagementService.updateNlpDetailsManagement(nlpDetailsManagement));
    }

    /**
     * 删除招生详情 培养计划 招聘详情 数据（管理）
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:detailsManagement:remove')")
    @Log(title = "招生详情 培养计划 招聘详情 数据（管理）", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(nlpDetailsManagementService.deleteNlpDetailsManagementByIds(ids));
    }
}
