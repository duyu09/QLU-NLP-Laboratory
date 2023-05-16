package com.train.web.controller.frontendWeb;

import java.util.List;
import com.train.common.domain.NlpFrontendAbout;
import com.train.common.enums.DataStatus;
import com.train.frontendWeb.service.IShowNlpFrontendAboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.train.common.core.controller.BaseController;
import com.train.common.core.domain.AjaxResult;
import com.train.common.core.page.TableDataInfo;

/**
 * 联系我们Controller
 *
 * @author relief
 * @date 2023-04-07
 */
@RestController
@RequestMapping("/show/nlp/about")
public class ShowNlpFrontendAboutController extends BaseController
{
    @Autowired
    private IShowNlpFrontendAboutService nlpFrontendAboutService;

    /**
     * 查询联系我们列表
     */
    @GetMapping("/list")
    public AjaxResult list(NlpFrontendAbout nlpFrontendAbout)
    {
        nlpFrontendAbout.setStatus(DataStatus.OK.getCode());
        List<NlpFrontendAbout> list = nlpFrontendAboutService.selectNlpFrontendAboutList(nlpFrontendAbout);
        return AjaxResult.success(list);
    }

    /**
     * 获取联系我们详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(nlpFrontendAboutService.selectNlpFrontendAboutById(id));
    }

}
