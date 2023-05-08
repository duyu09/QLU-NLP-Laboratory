package com.train.web.controller.frontendWeb;

import com.train.cmsCloud.service.INlpDetailsService;
import com.train.common.annotation.Log;
import com.train.common.core.controller.BaseController;
import com.train.common.core.domain.AjaxResult;
import com.train.common.core.page.TableDataInfo;
import com.train.common.domain.NlpDetails;
import com.train.common.enums.BusinessType;
import com.train.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 招生详情 培养计划 招聘详情 数据Controller
 *
 * @author ICOVETOUS
 * @date 2023-04-04
 */
@RestController
@RequestMapping("/show/nlp/admission/details")
public class ShowNlpDetailsController extends BaseController
{
    @Autowired
    private INlpDetailsService nlpDetailsService;

    /**
     * 查询招生详情 培养计划 招聘详情 数据列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:details:list')")
    @GetMapping("/list")
    public TableDataInfo list(NlpDetails nlpDetails)
    {
        startPage();
        List<NlpDetails> list = nlpDetailsService.selectNlpDetailsList(nlpDetails);
        return getDataTable(list);
    }

    /**
     * 导出招生详情 培养计划 招聘详情 数据列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:details:export')")
    @Log(title = "招生详情 培养计划 招聘详情 数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NlpDetails nlpDetails)
    {
        List<NlpDetails> list = nlpDetailsService.selectNlpDetailsList(nlpDetails);
        ExcelUtil<NlpDetails> util = new ExcelUtil<NlpDetails>(NlpDetails.class);
        util.exportExcel(response, list, "招生详情 培养计划 招聘详情 数据数据");
    }

    /**
     * 获取招生详情 培养计划 招聘详情 数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:details:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(nlpDetailsService.selectNlpDetailsById(id));
    }

    /**
     * 新增招生详情 培养计划 招聘详情 数据
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:details:add')")
    @Log(title = "招生详情 培养计划 招聘详情 数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NlpDetails nlpDetails)
    {
        return toAjax(nlpDetailsService.insertNlpDetails(nlpDetails));
    }

    /**
     * 修改招生详情 培养计划 招聘详情 数据
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:details:edit')")
    @Log(title = "招生详情 培养计划 招聘详情 数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NlpDetails nlpDetails)
    {
        return toAjax(nlpDetailsService.updateNlpDetails(nlpDetails));
    }

    /**
     * 删除招生详情 培养计划 招聘详情 数据
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:details:remove')")
    @Log(title = "招生详情 培养计划 招聘详情 数据", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(nlpDetailsService.deleteNlpDetailsByIds(ids));
    }
}
