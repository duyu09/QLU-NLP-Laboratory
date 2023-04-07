package com.train.web.controller.cmsCloud;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.train.common.domain.NlpFrontendLink;
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
import com.train.cmsCloud.service.INlpFrontendLinkService;
import com.train.common.utils.poi.ExcelUtil;
import com.train.common.core.page.TableDataInfo;

/**
 * 友情链接Controller
 *
 * @author relief
 * @date 2023-04-07
 */
@RestController
@RequestMapping("/nlp/frontend/link")
public class NlpFrontendLinkController extends BaseController
{
    @Autowired
    private INlpFrontendLinkService nlpFrontendLinkService;

    /**
     * 查询友情链接列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:link:list')")
    @GetMapping("/list")
    public TableDataInfo list(NlpFrontendLink nlpFrontendLink)
    {
        startPage();
        List<NlpFrontendLink> list = nlpFrontendLinkService.selectNlpFrontendLinkList(nlpFrontendLink);
        return getDataTable(list);
    }

    /**
     * 导出友情链接列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:link:export')")
    @Log(title = "友情链接", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NlpFrontendLink nlpFrontendLink)
    {
        List<NlpFrontendLink> list = nlpFrontendLinkService.selectNlpFrontendLinkList(nlpFrontendLink);
        ExcelUtil<NlpFrontendLink> util = new ExcelUtil<NlpFrontendLink>(NlpFrontendLink.class);
        util.exportExcel(response, list, "友情链接数据");
    }

    /**
     * 获取友情链接详细信息
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:link:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(nlpFrontendLinkService.selectNlpFrontendLinkById(id));
    }

    /**
     * 新增友情链接
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:link:add')")
    @Log(title = "友情链接", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NlpFrontendLink nlpFrontendLink)
    {
        return toAjax(nlpFrontendLinkService.insertNlpFrontendLink(nlpFrontendLink));
    }

    /**
     * 修改友情链接
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:link:edit')")
    @Log(title = "友情链接", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NlpFrontendLink nlpFrontendLink)
    {
        return toAjax(nlpFrontendLinkService.updateNlpFrontendLink(nlpFrontendLink));
    }

    /**
     * 删除友情链接
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:link:remove')")
    @Log(title = "友情链接", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(nlpFrontendLinkService.deleteNlpFrontendLinkByIds(ids));
    }
}
