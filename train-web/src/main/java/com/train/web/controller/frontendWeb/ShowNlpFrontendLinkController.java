package com.train.web.controller.frontendWeb;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.train.common.domain.NlpFrontendLink;
import com.train.frontendWeb.service.IShowNlpFrontendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.train.common.core.controller.BaseController;
import com.train.common.core.domain.AjaxResult;
import com.train.common.core.page.TableDataInfo;

/**
 * 友情链接Controller
 *
 * @author relief
 * @date 2023-04-07
 */
@RestController
//@RequestMapping("/show/nlp/link")
public class ShowNlpFrontendLinkController extends BaseController
{
    @Autowired
    private IShowNlpFrontendLinkService nlpFrontendLinkService;

    /**
     * 查询友情链接列表
     */
//    @GetMapping("/list")
    public TableDataInfo list(NlpFrontendLink nlpFrontendLink)
    {
        startPage();
        List<NlpFrontendLink> list = nlpFrontendLinkService.selectNlpFrontendLinkList(nlpFrontendLink);
        return getDataTable(list);
    }


    /**
     * 获取友情链接详细信息
     */
//    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(nlpFrontendLinkService.selectNlpFrontendLinkById(id));
    }

}
