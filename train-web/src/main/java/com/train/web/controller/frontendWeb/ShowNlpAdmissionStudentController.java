package com.train.web.controller.frontendWeb;

import com.train.cmsCloud.service.INlpAdmissionStudentService;
import com.train.common.annotation.Log;
import com.train.common.core.controller.BaseController;
import com.train.common.core.domain.AjaxResult;
import com.train.common.core.page.TableDataInfo;
import com.train.common.domain.NlpAdmissionStudent;
import com.train.common.enums.BusinessType;
import com.train.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 学生 数据Controller
 *
 * @author ICOVETOUS
 * @date 2023-04-05
 */
@RestController
@RequestMapping("/show/nlp/admission/admissionStudent")
public class ShowNlpAdmissionStudentController extends BaseController
{
    @Autowired
    private INlpAdmissionStudentService nlpAdmissionStudentService;

    /**
     * 查询学生 数据列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:admissionStudent:list')")
    @GetMapping("/list")
    public TableDataInfo list(NlpAdmissionStudent nlpAdmissionStudent)
    {
        startPage();
        List<NlpAdmissionStudent> list = nlpAdmissionStudentService.selectNlpAdmissionStudentList(nlpAdmissionStudent);
        return getDataTable(list);
    }

    /**
     * 导出学生 数据列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:admissionStudent:export')")
    @Log(title = "学生 数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NlpAdmissionStudent nlpAdmissionStudent)
    {
        List<NlpAdmissionStudent> list = nlpAdmissionStudentService.selectNlpAdmissionStudentList(nlpAdmissionStudent);
        ExcelUtil<NlpAdmissionStudent> util = new ExcelUtil<NlpAdmissionStudent>(NlpAdmissionStudent.class);
        util.exportExcel(response, list, "学生 数据数据");
    }

    /**
     * 获取学生 数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:admissionStudent:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(nlpAdmissionStudentService.selectNlpAdmissionStudentById(id));
    }

    /**
     * 新增学生 数据
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:admissionStudent:add')")
    @Log(title = "学生 数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NlpAdmissionStudent nlpAdmissionStudent)
    {
        return toAjax(nlpAdmissionStudentService.insertNlpAdmissionStudent(nlpAdmissionStudent));
    }

    /**
     * 修改学生 数据
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:admissionStudent:edit')")
    @Log(title = "学生 数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NlpAdmissionStudent nlpAdmissionStudent)
    {
        return toAjax(nlpAdmissionStudentService.updateNlpAdmissionStudent(nlpAdmissionStudent));
    }

    /**
     * 删除学生 数据
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:admissionStudent:remove')")
    @Log(title = "学生 数据", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(nlpAdmissionStudentService.deleteNlpAdmissionStudentByIds(ids));
    }
}
