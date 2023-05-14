package com.train.web.controller.frontendWeb;

import com.train.common.core.controller.BaseController;
import com.train.common.core.domain.AjaxResult;
import com.train.common.core.page.TableDataInfo;
import com.train.common.domain.NlpFrontendCarousel;
import com.train.frontendWeb.service.IShowNlpFrontendCarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/show/nlp/carousel")
public class ShowNlpFrontendCarouselController extends BaseController {
    @Autowired
    private IShowNlpFrontendCarouselService nlpFrontendCarouselService;

    /**
     * 查询轮播图列表
     *
     * /show/nlp/carousel/list 查询轮播图列表
     */

    @GetMapping("/list")
    public AjaxResult list(NlpFrontendCarousel nlpFrontendCarousel) {
        List<NlpFrontendCarousel> list = nlpFrontendCarouselService.selectNlpFrontendCarouselList(nlpFrontendCarousel);
        return AjaxResult.success(list);
    }

    /**
     * 获取轮播图详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(nlpFrontendCarouselService.selectNlpFrontendCarouselById(id));
    }



}

