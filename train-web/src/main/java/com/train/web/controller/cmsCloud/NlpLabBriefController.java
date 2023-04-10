package com.train.web.controller.cmsCloud;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.train.cmsCloud.service.INlpLabBriefService;
import com.train.common.domain.NlpLabBrief;
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
import com.train.common.utils.poi.ExcelUtil;
import com.train.common.core.page.TableDataInfo;

/**
 * 简介管理Controller
 * 
 * @author relief
 * @date 2023-04-06
 */
@RestController
@RequestMapping("/nlp/brief")
public class NlpLabBriefController extends BaseController
{
    @Autowired
    private INlpLabBriefService nlpLabBriefService;

    /**
     * 查询简介管理列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:brief:list')")
    @GetMapping("/list")
    public TableDataInfo list(NlpLabBrief nlpLabBrief)
    {
        startPage();
        List<NlpLabBrief> list = nlpLabBriefService.selectNlpLabBriefList(nlpLabBrief);
        return getDataTable(list);
    }

    /**
     * 导出简介管理列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:brief:export')")
    @Log(title = "简介管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NlpLabBrief nlpLabBrief)
    {
        List<NlpLabBrief> list = nlpLabBriefService.selectNlpLabBriefList(nlpLabBrief);
        ExcelUtil<NlpLabBrief> util = new ExcelUtil<NlpLabBrief>(NlpLabBrief.class);
        util.exportExcel(response, list, "简介管理数据");
    }

    /**
     * 获取简介管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('nlp:brief:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(nlpLabBriefService.selectNlpLabBriefById(id));
    }

    /**
     * 新增简介管理
     */
    @PreAuthorize("@ss.hasPermi('nlp:brief:add')")
    @Log(title = "简介管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NlpLabBrief nlpLabBrief)
    {
        return toAjax(nlpLabBriefService.insertNlpLabBrief(nlpLabBrief));
    }

    /**
     * 修改简介管理
     */
    @PreAuthorize("@ss.hasPermi('nlp:brief:edit')")
    @Log(title = "简介管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NlpLabBrief nlpLabBrief)
    {
        return toAjax(nlpLabBriefService.updateNlpLabBrief(nlpLabBrief));
    }

    /**
     * 删除简介管理
     */
    @PreAuthorize("@ss.hasPermi('nlp:brief:remove')")
    @Log(title = "简介管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(nlpLabBriefService.deleteNlpLabBriefByIds(ids));
    }
}
