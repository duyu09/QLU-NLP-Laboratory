package com.train.web.controller.frontendWeb;

import com.train.common.core.controller.BaseController;
import com.train.common.core.domain.AjaxResult;
import com.train.common.core.page.TableDataInfo;
import com.train.common.domain.NlpFrontendNews;
import com.train.frontendWeb.service.IShowNlpFrontendNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/nlp/frontend/news")
//@RequestMapping("/news")
public class ShowNlpFrontendNewsController extends BaseController {
    @Autowired
    private IShowNlpFrontendNewsService nlpFrontendNewsService;

    /**
     * 查询新闻动态管理列表
     * 包含置顶的新闻
     */
//    @GetMapping("/list")
    public TableDataInfo list(NlpFrontendNews nlpFrontendNews)
    {
        startPage();
        List<NlpFrontendNews> list = nlpFrontendNewsService.setTopNews(nlpFrontendNews);
        return getDataTable(list);
    }


    /**
     * 获取新闻动态管理详细信息
     */
//    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(nlpFrontendNewsService.selectNlpFrontendNewsById(id));
    }

    /**
     * 获取下一条
     * @param nlpFrontendNews
     * @return
     */
//    @GetMapping("/list")
//    @RequestMapping("/next")
    public TableDataInfo nextOne(NlpFrontendNews nlpFrontendNews)
    {
        startPage();
        List<NlpFrontendNews> list = nlpFrontendNewsService.nextOneNews(nlpFrontendNews);
        return getDataTable(list);
    }

    /**
     * 获取上一条
     * @param nlpFrontendNews
     * @return
     */
//    @GetMapping("/list")
//    @RequestMapping("/before")
    public TableDataInfo previousOne(NlpFrontendNews nlpFrontendNews)
    {
        startPage();
        List<NlpFrontendNews> list = nlpFrontendNewsService.previousOneNews(nlpFrontendNews);
        return getDataTable(list);
    }


}
