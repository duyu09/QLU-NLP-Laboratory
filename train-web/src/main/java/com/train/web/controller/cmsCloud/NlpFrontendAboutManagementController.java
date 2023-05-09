package com.train.web.controller.cmsCloud;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.train.common.constant.UserConstants;
import com.train.common.domain.NlpFrontendAboutManagement;
import com.train.common.utils.StringUtils;
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
import com.train.cmsCloud.service.INlpFrontendAboutManagementService;
import com.train.common.core.page.TableDataInfo;

/**
 * 联系我们(管理)Controller
 *
 * @author relief
 * @date 2023-04-07
 */
@RestController
@RequestMapping("/nlp/frontend/aboutManagement")
public class NlpFrontendAboutManagementController extends BaseController
{
    @Autowired
    private INlpFrontendAboutManagementService nlpFrontendAboutManagementService;

    /**
     * 查询联系我们(管理)列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:aboutManagement:list')")
    @GetMapping("/list")
    public TableDataInfo list(NlpFrontendAboutManagement nlpFrontendAboutManagement)
    {
        startPage();
        List<NlpFrontendAboutManagement> list = nlpFrontendAboutManagementService.selectNlpFrontendAboutManagementList(nlpFrontendAboutManagement);
        return getDataTable(list);
    }

    /**
     * 导出联系我们(管理)列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:aboutManagement:export')")
    @Log(title = "联系我们(管理)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NlpFrontendAboutManagement nlpFrontendAboutManagement)
    {
        List<NlpFrontendAboutManagement> list = nlpFrontendAboutManagementService.selectNlpFrontendAboutManagementList(nlpFrontendAboutManagement);
        ExcelUtil<NlpFrontendAboutManagement> util = new ExcelUtil<NlpFrontendAboutManagement>(NlpFrontendAboutManagement.class);
        util.exportExcel(response, list, "联系我们(管理)数据");
    }

    /**
     * 获取联系我们(管理)详细信息
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:aboutManagement:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(nlpFrontendAboutManagementService.selectNlpFrontendAboutManagementById(id));
    }

    /**
     * 新增联系我们(管理)
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:aboutManagement:add')")
    @Log(title = "联系我们(管理)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NlpFrontendAboutManagement nlpFrontendAboutManagement)
    {
        if (UserConstants.NOT_UNIQUE.equals(nlpFrontendAboutManagementService.checkTypeUnique(nlpFrontendAboutManagement.getType())))
        {
            return AjaxResult.error("新增类型失败，该类型已存在");
        }
        nlpFrontendAboutManagement.setType(nlpFrontendAboutManagement.getType());
        return toAjax(nlpFrontendAboutManagementService.insertNlpFrontendAboutManagement(nlpFrontendAboutManagement));
    }

    /**
     * 修改联系我们(管理)
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:aboutManagement:edit')")
    @Log(title = "联系我们(管理)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NlpFrontendAboutManagement nlpFrontendAboutManagement)
    {
        nlpFrontendAboutManagementService.checkTypeAllowed(nlpFrontendAboutManagement);
        if (StringUtils.isNotEmpty(nlpFrontendAboutManagement.getType())
                && UserConstants.NOT_UNIQUE.equals(nlpFrontendAboutManagementService.checkTypeUnique(nlpFrontendAboutManagement.getType())))
        {
            return AjaxResult.error("修改失败，类型重复，请重试");
        }

        return toAjax(nlpFrontendAboutManagementService.updateNlpFrontendAboutManagement(nlpFrontendAboutManagement));
    }

    /**
     * 删除联系我们(管理)
     */
    @PreAuthorize("@ss.hasPermi('nlp:frontend:aboutManagement:remove')")
    @Log(title = "联系我们(管理)", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(nlpFrontendAboutManagementService.deleteNlpFrontendAboutManagementByIds(ids));
    }


}
