package com.train.web.controller.cmsCloud;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.train.cmsCloud.service.INlpFrontendRecourceService;
import com.train.common.domain.NlpFrontendRecource;
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
 * 学术资源Controller
 *
 * @author relief
 * @date 2023-05-21
 */
@RestController
@RequestMapping("/nlp/frontend/recource")
public class NlpFrontendRecourceController extends BaseController
{
    @Autowired
    private INlpFrontendRecourceService nlpFrontendRecourceService;

    /**
     * 查询学术资源列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:recource:list')")
    @GetMapping("/list")
    public TableDataInfo list(NlpFrontendRecource nlpFrontendRecource)
    {
        startPage();
        List<NlpFrontendRecource> list = nlpFrontendRecourceService.selectNlpFrontendRecourceList(nlpFrontendRecource);
        return getDataTable(list);
    }

    /**
     * 导出学术资源列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:recource:export')")
    @Log(title = "学术资源", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NlpFrontendRecource nlpFrontendRecource)
    {
        List<NlpFrontendRecource> list = nlpFrontendRecourceService.selectNlpFrontendRecourceList(nlpFrontendRecource);
        ExcelUtil<NlpFrontendRecource> util = new ExcelUtil<NlpFrontendRecource>(NlpFrontendRecource.class);
        util.exportExcel(response, list, "学术资源数据");
    }

    /**
     * 获取学术资源详细信息
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:recource:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(nlpFrontendRecourceService.selectNlpFrontendRecourceById(id));
    }

    /**
     * 新增学术资源
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:recource:add')")
    @Log(title = "学术资源", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NlpFrontendRecource nlpFrontendRecource)
    {
        return toAjax(nlpFrontendRecourceService.insertNlpFrontendRecource(nlpFrontendRecource));
    }

    /**
     * 修改学术资源
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:recource:edit')")
    @Log(title = "学术资源", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NlpFrontendRecource nlpFrontendRecource)
    {
        return toAjax(nlpFrontendRecourceService.updateNlpFrontendRecource(nlpFrontendRecource));
    }

    /**
     * 删除学术资源
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:recource:remove')")
    @Log(title = "学术资源", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(nlpFrontendRecourceService.deleteNlpFrontendRecourceByIds(ids));
    }
}
