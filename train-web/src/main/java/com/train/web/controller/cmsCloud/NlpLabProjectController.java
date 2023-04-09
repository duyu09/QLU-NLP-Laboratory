package com.train.web.controller.cmsCloud;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.train.common.domain.NlpLabProject;
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
import com.train.cmsCloud.service.INlpLabProjectService;
import com.train.common.utils.poi.ExcelUtil;
import com.train.common.core.page.TableDataInfo;

/**
 * 项目管理Controller
 * 
 * @author relief
 * @date 2023-04-07
 */
@RestController
@RequestMapping("/nlp/project")
public class NlpLabProjectController extends BaseController
{
    @Autowired
    private INlpLabProjectService nlpLabProjectService;

    /**
     * 查询项目管理列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:project:list')")
    @GetMapping("/list")
    public TableDataInfo list(NlpLabProject nlpLabProject)
    {
        startPage();
        List<NlpLabProject> list = nlpLabProjectService.selectNlpLabProjectList(nlpLabProject);
        return getDataTable(list);
    }

    /**
     * 导出项目管理列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:project:export')")
    @Log(title = "项目管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NlpLabProject nlpLabProject)
    {
        List<NlpLabProject> list = nlpLabProjectService.selectNlpLabProjectList(nlpLabProject);
        ExcelUtil<NlpLabProject> util = new ExcelUtil<NlpLabProject>(NlpLabProject.class);
        util.exportExcel(response, list, "项目管理数据");
    }

    /**
     * 获取项目管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('nlp:project:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(nlpLabProjectService.selectNlpLabProjectById(id));
    }

    /**
     * 新增项目管理
     */
    @PreAuthorize("@ss.hasPermi('nlp:project:add')")
    @Log(title = "项目管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NlpLabProject nlpLabProject)
    {
        return toAjax(nlpLabProjectService.insertNlpLabProject(nlpLabProject));
    }

    /**
     * 修改项目管理
     */
    @PreAuthorize("@ss.hasPermi('nlp:project:edit')")
    @Log(title = "项目管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NlpLabProject nlpLabProject)
    {
        return toAjax(nlpLabProjectService.updateNlpLabProject(nlpLabProject));
    }

    /**
     * 删除项目管理
     */
    @PreAuthorize("@ss.hasPermi('nlp:project:remove')")
    @Log(title = "项目管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(nlpLabProjectService.deleteNlpLabProjectByIds(ids));
    }
}
