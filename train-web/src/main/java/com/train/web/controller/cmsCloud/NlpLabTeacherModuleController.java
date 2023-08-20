package com.train.web.controller.cmsCloud;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.train.cmsCloud.service.INlpLabTeacherModuleService;
import com.train.common.domain.NlpLabTeacherModule;
import com.train.common.utils.poi.ExcelUtil;
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
import com.train.common.core.page.TableDataInfo;

/**
 * 成员编辑器Controller
 * 
 * @author relief
 * @date 2023-05-18
 */
@RestController
@RequestMapping("/nlp/module")
public class NlpLabTeacherModuleController extends BaseController
{
    @Autowired
    private INlpLabTeacherModuleService nlpLabTeacherModuleService;

    /**
     * 查询成员编辑器列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:module:list')")
    @GetMapping("/list")
    public TableDataInfo list(NlpLabTeacherModule nlpLabTeacherModule)
    {
        startPage();
        List<NlpLabTeacherModule> list = nlpLabTeacherModuleService.selectNlpLabTeacherModuleList(nlpLabTeacherModule);
        return getDataTable(list);
    }

    /**
     * 导出成员编辑器列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:module:export')")
    @Log(title = "成员编辑器", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NlpLabTeacherModule nlpLabTeacherModule)
    {
        List<NlpLabTeacherModule> list = nlpLabTeacherModuleService.selectNlpLabTeacherModuleList(nlpLabTeacherModule);
        ExcelUtil<NlpLabTeacherModule> util = new ExcelUtil<NlpLabTeacherModule>(NlpLabTeacherModule.class);
        util.exportExcel(response, list, "成员编辑器数据");
    }

    /**
     * 获取成员编辑器详细信息
     */
    @PreAuthorize("@ss.hasPermi('nlp:module:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(nlpLabTeacherModuleService.selectNlpLabTeacherModuleById(id));
    }

    /**
     * 新增成员编辑器
     */
    @PreAuthorize("@ss.hasPermi('nlp:module:add')")
    @Log(title = "成员编辑器", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NlpLabTeacherModule nlpLabTeacherModule)
    {
        return toAjax(nlpLabTeacherModuleService.insertNlpLabTeacherModule(nlpLabTeacherModule));
    }

    /**
     * 修改成员编辑器
     */
    @PreAuthorize("@ss.hasPermi('nlp:module:edit')")
    @Log(title = "成员编辑器", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NlpLabTeacherModule nlpLabTeacherModule)
    {
        return toAjax(nlpLabTeacherModuleService.updateNlpLabTeacherModule(nlpLabTeacherModule));
    }

    /**
     * 删除成员编辑器
     */
    @PreAuthorize("@ss.hasPermi('nlp:module:remove')")
    @Log(title = "成员编辑器", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(nlpLabTeacherModuleService.deleteNlpLabTeacherModuleByIds(ids));
    }
}
