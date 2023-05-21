package com.train.web.controller.frontendWeb;

import com.train.common.core.controller.BaseController;
import com.train.common.core.domain.AjaxResult;
import com.train.common.domain.NlpFrontendNews;
import com.train.common.enums.UserStatus;
import com.train.frontendWeb.service.IShowNlpFrontendNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/show/nlp/news")
public class ShowNlpFrontendNewsController extends BaseController {

    @Autowired
    private IShowNlpFrontendNewsService nlpFrontendNewsService;

    /**
     * 查询新闻动态管理列表
     * 包含置顶的新闻
     */
    @GetMapping("/list")
    public AjaxResult list(NlpFrontendNews nlpFrontendNews)
    {
        nlpFrontendNews.setStatus(UserStatus.OK.getCode());
        List<NlpFrontendNews> list = nlpFrontendNewsService.selectNlpFrontendNewsList(nlpFrontendNews);
        return AjaxResult.success(list);
    }


    /**
     * 获取新闻动态管理详细信息
     */
    @GetMapping(value = "/byId/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(nlpFrontendNewsService.selectNlpFrontendNewsById(id));
    }

}
