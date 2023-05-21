package com.train.web.controller.frontendWeb;

import com.train.common.core.controller.BaseController;
import com.train.common.core.domain.AjaxResult;
import com.train.common.core.page.TableDataInfo;
import com.train.common.domain.NlpFrontendRecource;
import com.train.frontendWeb.service.IShowNlpFrontendRecourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/show/nlp/resource")
public class ShowNlpFrontendRecourceController extends BaseController {
    @Autowired
    private IShowNlpFrontendRecourceService nlpFrontendRecourceService;

    /**
     * 查询学术资源列表
     */
    @GetMapping("/list")
    public TableDataInfo list(NlpFrontendRecource nlpFrontendRecource)
    {
        startPage();
        List<NlpFrontendRecource> list = nlpFrontendRecourceService.selectNlpFrontendRecourceList(nlpFrontendRecource);
        return getDataTable(list);
    }


    /**
     * 获取学术资源详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(nlpFrontendRecourceService.selectNlpFrontendRecourceById(id));
    }

}
