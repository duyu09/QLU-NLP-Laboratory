package com.train.web.controller.cmsCloud;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.train.cmsCloud.service.INlpLabTeacherService;
import com.train.common.core.domain.entity.SysUser;
import com.train.common.domain.NlpLabTeacher;
import com.train.common.domain.dto.NlpLabTeacherDto;
import com.train.common.enums.UserStatus;
import com.train.common.utils.poi.ExcelUtil;
import com.train.system.service.ISysUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.train.common.annotation.Log;
import com.train.common.core.controller.BaseController;
import com.train.common.core.domain.AjaxResult;
import com.train.common.enums.BusinessType;
import com.train.common.core.page.TableDataInfo;

/**
 * 老师Controller
 *
 * @author relief
 * @date 2023-05-16
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/nlp/teacher")
public class NlpLabTeacherController extends BaseController
{
    @Autowired
    private INlpLabTeacherService nlpLabTeacherService;

    /**
     * 查询老师列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:teacher:list')")
    @GetMapping("/list")
    public TableDataInfo list(NlpLabTeacher nlpLabTeacher)
    {
        startPage();
        List<NlpLabTeacher> list = nlpLabTeacherService.selectNlpLabTeacherList(nlpLabTeacher);
        return getDataTable(list);
    }

    /**
     * 导出老师列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:teacher:export')")
    @Log(title = "老师", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NlpLabTeacher nlpLabTeacher)
    {
        List<NlpLabTeacher> list = nlpLabTeacherService.selectNlpLabTeacherList(nlpLabTeacher);
        ExcelUtil<NlpLabTeacher> util = new ExcelUtil<NlpLabTeacher>(NlpLabTeacher.class);
        util.exportExcel(response, list, "老师数据");
    }

    /**
     * 获取老师详细信息
     */
    @PreAuthorize("@ss.hasPermi('nlp:teacher:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(nlpLabTeacherService.selectNlpLabTeacherById(id));
    }

    /**
     * 获取老师详细信息
     */
    @GetMapping(value = "/user")
    public AjaxResult getTeacherUser()
    {
        return AjaxResult.success(nlpLabTeacherService.selectNlpLabTeacherById(getUserId()));
    }

    @PreAuthorize("@ss.hasPermi('nlp:teacher:add')")
    @Log(title = " ", businessType = BusinessType.INSERT)
    @PostMapping()
    public AjaxResult add(@RequestBody NlpLabTeacherDto nlpLabTeacherDto)
    {
        nlpLabTeacherDto.setCreateBy(getUsername());
        return toAjax(nlpLabTeacherService.insertNlpLabTeacher(nlpLabTeacherDto));
    }

    /**
     * 修改
     */
    @PreAuthorize("@ss.hasPermi('nlp:teacher:edit')")
    @Log(title = "老师", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NlpLabTeacherDto nlpLabTeacherDto)
    {
        nlpLabTeacherDto.setUpdateBy(getUsername());
        return toAjax(nlpLabTeacherService.updateNlpLabTeacher(nlpLabTeacherDto));
    }

    /**
     * 修改
     */
    @PreAuthorize("@ss.hasPermi('nlp:teacher:edit')")
    @Log(title = "老师", businessType = BusinessType.UPDATE)
    @PutMapping("/save")
    public AjaxResult save(@RequestBody NlpLabTeacherDto nlpLabTeacherDto)
    {
        return toAjax(nlpLabTeacherService.updateNlpLabTeacher(nlpLabTeacherDto));
    }

    /**
     * 删除老师
     */
    @PreAuthorize("@ss.hasPermi('nlp:teacher:remove')")
    @Log(title = "老师", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(nlpLabTeacherService.deleteNlpLabTeacherByIds(ids));
    }

}
