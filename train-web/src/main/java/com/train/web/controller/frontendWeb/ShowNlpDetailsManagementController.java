package com.train.web.controller.frontendWeb;

import com.train.cmsCloud.service.INlpDetailsManagementService;
import com.train.common.annotation.Log;
import com.train.common.core.controller.BaseController;
import com.train.common.core.domain.AjaxResult;
import com.train.common.core.page.TableDataInfo;
import com.train.common.domain.NlpDetailsManagement;
import com.train.common.enums.BusinessType;
import com.train.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 招生详情 培养计划 招聘详情 数据（管理）Controller
 *
 * @author ICOVETOUS
 * @date 2023-04-05
 */
@RestController
@RequestMapping("/show/nlp/detailsManagement")
public class ShowNlpDetailsManagementController extends BaseController
{
    @Autowired
    private INlpDetailsManagementService nlpDetailsManagementService;

    /**
     * 查询招生详情 培养计划 招聘详情 数据（管理）列表
     */
    @GetMapping("/list")
    public TableDataInfo list(NlpDetailsManagement nlpDetailsManagement)
    {
        startPage();
        List<NlpDetailsManagement> list = nlpDetailsManagementService.selectNlpDetailsManagementList(nlpDetailsManagement);
        return getDataTable(list);
    }


    /**
     * 获取招生详情 培养计划 招聘详情 数据（管理）详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(nlpDetailsManagementService.selectNlpDetailsManagementById(id));
    }

}
