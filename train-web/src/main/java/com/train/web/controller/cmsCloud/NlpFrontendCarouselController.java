package com.train.web.controller.cmsCloud;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.train.common.domain.NlpFrontendCarousel;
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
import com.train.cmsCloud.service.INlpFrontendCarouselService;
import com.train.common.core.page.TableDataInfo;

/**
 * 轮播图Controller
 *
 * @author relief
 * @date 2023-04-03
 */
@RestController
@RequestMapping("/nlp/frontend/carousel")
public class NlpFrontendCarouselController extends BaseController
{
    @Autowired
    private INlpFrontendCarouselService nlpFrontendCarouselService;

    /**
     * 查询轮播图列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:carousel:list')")
    @GetMapping("/list")
    public TableDataInfo list(NlpFrontendCarousel nlpFrontendCarousel)
    {
        startPage();
        List<NlpFrontendCarousel> list = nlpFrontendCarouselService.selectNlpFrontendCarouselList(nlpFrontendCarousel);
        return getDataTable(list);
    }

    /**
     * 导出轮播图列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:carousel:export')")
    @Log(title = "轮播图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NlpFrontendCarousel nlpFrontendCarousel)
    {
        List<NlpFrontendCarousel> list = nlpFrontendCarouselService.selectNlpFrontendCarouselList(nlpFrontendCarousel);
        ExcelUtil<NlpFrontendCarousel> util = new ExcelUtil<NlpFrontendCarousel>(NlpFrontendCarousel.class);
        util.exportExcel(response, list, "轮播图数据");
    }

    /**
     * 获取轮播图详细信息
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:carousel:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(nlpFrontendCarouselService.selectNlpFrontendCarouselById(id));
    }

    /**
     * 新增轮播图
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:carousel:add')")
    @Log(title = "轮播图", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NlpFrontendCarousel nlpFrontendCarousel)
    {
        return toAjax(nlpFrontendCarouselService.insertNlpFrontendCarousel(nlpFrontendCarousel));
    }

    /**
     * 修改轮播图
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:carousel:edit')")
    @Log(title = "轮播图", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NlpFrontendCarousel nlpFrontendCarousel)
    {
        return toAjax(nlpFrontendCarouselService.updateNlpFrontendCarousel(nlpFrontendCarousel));
    }

    /**
     * 删除轮播图
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:carousel:remove')")
    @Log(title = "轮播图", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(nlpFrontendCarouselService.deleteNlpFrontendCarouselByIds(ids));
    }
}
