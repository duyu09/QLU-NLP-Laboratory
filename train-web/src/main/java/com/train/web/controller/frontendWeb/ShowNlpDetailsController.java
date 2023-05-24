package com.train.web.controller.frontendWeb;

import com.train.cmsCloud.service.INlpDetailsService;
import com.train.common.annotation.Log;
import com.train.common.core.controller.BaseController;
import com.train.common.core.domain.AjaxResult;
import com.train.common.core.page.TableDataInfo;
import com.train.common.domain.NlpDetails;
import com.train.common.enums.BusinessType;
import com.train.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 招生详情 培养计划 招聘详情 数据Controller
 *
 * @author ICOVETOUS
 * @date 2023-04-04
 */
@RestController
@RequestMapping("/show/nlp/details")
public class ShowNlpDetailsController extends BaseController
{
    @Autowired
    private INlpDetailsService nlpDetailsService;

    /**
     * 查询招生详情 培养计划 招聘详情 数据列表
     */
    @GetMapping("/list")
    public TableDataInfo list()
    {
        startPage();
        List<NlpDetails> list = nlpDetailsService.selectNlpDetailsListShow();
        return getDataTable(list);
    }
}
