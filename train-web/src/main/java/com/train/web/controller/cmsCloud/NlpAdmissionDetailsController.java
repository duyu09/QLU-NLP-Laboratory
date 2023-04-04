package com.train.web.controller.cmsCloud;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.train.common.domain.NlpAdmissionDetails;
import com.train.cmsCloud.service.INlpAdmissionDetailsService;
import com.train.common.utils.poi.ExcelUtil;
import com.train.common.core.page.TableDataInfo;

/**
 * 招生详情数据Controller
 *
 * @author ICOVETOUS
 * @date 2023-04-04
 */
@RestController
@RequestMapping("/nlp/admission/admissionDetails")
public class NlpAdmissionDetailsController extends BaseController
{
    @Autowired
    private INlpAdmissionDetailsService nlpAdmissionDetailsService;

    /**
     * 查询招生详情数据列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:admissionDetails:list')")
    @GetMapping("/list")
    public TableDataInfo list(NlpAdmissionDetails nlpAdmissionDetails)
    {
        startPage();
        List<NlpAdmissionDetails> list = nlpAdmissionDetailsService.selectNlpAdmissionDetailsList(nlpAdmissionDetails);
        return getDataTable(list);
    }

    /**
     * 导出招生详情数据列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:admissionDetails:export')")
    @Log(title = "招生详情数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NlpAdmissionDetails nlpAdmissionDetails)
    {
        List<NlpAdmissionDetails> list = nlpAdmissionDetailsService.selectNlpAdmissionDetailsList(nlpAdmissionDetails);
        ExcelUtil<NlpAdmissionDetails> util = new ExcelUtil<NlpAdmissionDetails>(NlpAdmissionDetails.class);
        util.exportExcel(response, list, "招生详情数据数据");
    }

    /**
     * 获取招生详情数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:admissionDetails:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(nlpAdmissionDetailsService.selectNlpAdmissionDetailsById(id));
    }

    /**
     * 新增招生详情数据
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:admissionDetails:add')")
    @Log(title = "招生详情数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NlpAdmissionDetails nlpAdmissionDetails)
    {
        return toAjax(nlpAdmissionDetailsService.insertNlpAdmissionDetails(nlpAdmissionDetails));
    }

    /**
     * 修改招生详情数据
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:admissionDetails:edit')")
    @Log(title = "招生详情数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NlpAdmissionDetails nlpAdmissionDetails)
    {
        return toAjax(nlpAdmissionDetailsService.updateNlpAdmissionDetails(nlpAdmissionDetails));
    }

    /**
     * 删除招生详情数据
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:admissionDetails:remove')")
    @Log(title = "招生详情数据", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(nlpAdmissionDetailsService.deleteNlpAdmissionDetailsByIds(ids));
    }
}
