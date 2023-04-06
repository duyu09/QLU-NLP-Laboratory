package com.train.web.controller.cmsCloud;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.train.common.domain.NlpFrontendNews;
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
import com.train.cmsCloud.service.INlpFrontendNewsService;
import com.train.common.utils.poi.ExcelUtil;
import com.train.common.core.page.TableDataInfo;

/**
 * 新闻动态管理Controller
 *
 * @author relief
 * @date 2023-04-05
 */
@RestController
@RequestMapping("/nlp/frontend/news")
public class NlpFrontendNewsController extends BaseController
{
    @Autowired
    private INlpFrontendNewsService nlpFrontendNewsService;

    /**
     * 查询新闻动态管理列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:news:list')")
    @GetMapping("/list")
    public TableDataInfo list(NlpFrontendNews nlpFrontendNews)
    {
        startPage();
//        List<NlpFrontendNews> list = nlpFrontendNewsService.selectNlpFrontendNewsList(nlpFrontendNews);
        List<NlpFrontendNews> list = nlpFrontendNewsService.setTopNews(nlpFrontendNews);
        return getDataTable(list);
    }

    /**
     * 导出新闻动态管理列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:news:export')")
    @Log(title = "新闻动态管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NlpFrontendNews nlpFrontendNews)
    {
        List<NlpFrontendNews> list = nlpFrontendNewsService.selectNlpFrontendNewsList(nlpFrontendNews);
        ExcelUtil<NlpFrontendNews> util = new ExcelUtil<NlpFrontendNews>(NlpFrontendNews.class);
        util.exportExcel(response, list, "新闻动态管理数据");
    }

    /**
     * 获取新闻动态管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:news:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(nlpFrontendNewsService.selectNlpFrontendNewsById(id));
    }

    /**
     * 新增新闻动态管理
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:news:add')")
    @Log(title = "新闻动态管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NlpFrontendNews nlpFrontendNews)
    {
        return toAjax(nlpFrontendNewsService.insertNlpFrontendNews(nlpFrontendNews));
    }

    /**
     * 修改新闻动态管理
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:news:edit')")
    @Log(title = "新闻动态管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NlpFrontendNews nlpFrontendNews)
    {
        return toAjax(nlpFrontendNewsService.updateNlpFrontendNews(nlpFrontendNews));
    }

    /**
     * 删除新闻动态管理
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:news:remove')")
    @Log(title = "新闻动态管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(nlpFrontendNewsService.deleteNlpFrontendNewsByIds(ids));
    }


}
