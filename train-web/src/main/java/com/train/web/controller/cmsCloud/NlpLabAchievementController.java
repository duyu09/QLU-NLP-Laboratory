package com.train.web.controller.cmsCloud;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.train.common.domain.NlpLabAchievement;
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
import com.train.cmsCloud.service.INlpLabAchievementService;
import com.train.common.utils.poi.ExcelUtil;
import com.train.common.core.page.TableDataInfo;

/**
 * 成果管理Controller
 * 
 * @author relief
 * @date 2023-04-07
 */
@RestController
@RequestMapping("/nlp/achievement")
public class NlpLabAchievementController extends BaseController
{
    @Autowired
    private INlpLabAchievementService nlpLabAchievementService;

    /**
     * 查询成果管理列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:achievement:list')")
    @GetMapping("/list")
    public TableDataInfo list(NlpLabAchievement nlpLabAchievement)
    {
        startPage();
        List<NlpLabAchievement> list = nlpLabAchievementService.selectNlpLabAchievementList(nlpLabAchievement);
        return getDataTable(list);
    }

    /**
     * 导出成果管理列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:achievement:export')")
    @Log(title = "成果管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NlpLabAchievement nlpLabAchievement)
    {
        List<NlpLabAchievement> list = nlpLabAchievementService.selectNlpLabAchievementList(nlpLabAchievement);
        ExcelUtil<NlpLabAchievement> util = new ExcelUtil<NlpLabAchievement>(NlpLabAchievement.class);
        util.exportExcel(response, list, "成果管理数据");
    }

    /**
     * 获取成果管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('nlp:achievement:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(nlpLabAchievementService.selectNlpLabAchievementById(id));
    }

    /**
     * 新增成果管理
     */
    @PreAuthorize("@ss.hasPermi('nlp:achievement:add')")
    @Log(title = "成果管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NlpLabAchievement nlpLabAchievement)
    {
        return toAjax(nlpLabAchievementService.insertNlpLabAchievement(nlpLabAchievement));
    }

    /**
     * 修改成果管理
     */
    @PreAuthorize("@ss.hasPermi('nlp:achievement:edit')")
    @Log(title = "成果管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NlpLabAchievement nlpLabAchievement)
    {
        return toAjax(nlpLabAchievementService.updateNlpLabAchievement(nlpLabAchievement));
    }

    /**
     * 删除成果管理
     */
    @PreAuthorize("@ss.hasPermi('nlp:achievement:remove')")
    @Log(title = "成果管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(nlpLabAchievementService.deleteNlpLabAchievementByIds(ids));
    }
}
