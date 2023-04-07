package com.train.web.controller.cmsCloud;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.train.common.domain.NlpFrontendAbout;
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
import com.train.cmsCloud.service.INlpFrontendAboutService;
import com.train.common.utils.poi.ExcelUtil;
import com.train.common.core.page.TableDataInfo;

/**
 * 联系我们Controller
 *
 * @author relief
 * @date 2023-04-07
 */
@RestController
@RequestMapping("/nlp/frontend/about")
public class NlpFrontendAboutController extends BaseController
{
    @Autowired
    private INlpFrontendAboutService nlpFrontendAboutService;

    /**
     * 查询联系我们列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:about:list')")
    @GetMapping("/list")
    public TableDataInfo list(NlpFrontendAbout nlpFrontendAbout)
    {
        startPage();
        List<NlpFrontendAbout> list = nlpFrontendAboutService.selectNlpFrontendAboutList(nlpFrontendAbout);
        return getDataTable(list);
    }

    /**
     * 导出联系我们列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:about:export')")
    @Log(title = "联系我们", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NlpFrontendAbout nlpFrontendAbout)
    {
        List<NlpFrontendAbout> list = nlpFrontendAboutService.selectNlpFrontendAboutList(nlpFrontendAbout);
        ExcelUtil<NlpFrontendAbout> util = new ExcelUtil<NlpFrontendAbout>(NlpFrontendAbout.class);
        util.exportExcel(response, list, "联系我们数据");
    }

    /**
     * 获取联系我们详细信息
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:about:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(nlpFrontendAboutService.selectNlpFrontendAboutById(id));
    }

    /**
     * 新增联系我们
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:about:add')")
    @Log(title = "联系我们", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NlpFrontendAbout nlpFrontendAbout)
    {
        return toAjax(nlpFrontendAboutService.insertNlpFrontendAbout(nlpFrontendAbout));
    }

    /**
     * 修改联系我们
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:about:edit')")
    @Log(title = "联系我们", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NlpFrontendAbout nlpFrontendAbout)
    {
        return toAjax(nlpFrontendAboutService.updateNlpFrontendAbout(nlpFrontendAbout));
    }

    /**
     * 删除联系我们
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:about:remove')")
    @Log(title = "联系我们", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(nlpFrontendAboutService.deleteNlpFrontendAboutByIds(ids));
    }
}
