package com.train.web.controller.frontendWeb;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.train.cmsCloud.service.INlpLabTeacherService;
import com.train.common.domain.NlpLabTeacher;
import com.train.common.domain.dto.NlpLabTeacherDto;
import com.train.common.utils.poi.ExcelUtil;
import org.springframework.http.ResponseEntity;
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
@RestController
@RequestMapping("/show/nlp/teacher")
public class ShowNlpLabTeacherController extends BaseController
{
    @Autowired
    private INlpLabTeacherService nlpLabTeacherService;

    /**
     * 查询老师列表
     */
    @GetMapping("/list")
    public TableDataInfo list(NlpLabTeacher nlpLabTeacher)
    {
        startPage();
        List<NlpLabTeacher> list = nlpLabTeacherService.selectNlpLabTeacherList(nlpLabTeacher);
        return getDataTable(list);
    }

    /**
     * 获取老师详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(nlpLabTeacherService.selectNlpLabTeacherById(id));
    }

    /**
     * 新增
     */
    @GetMapping("/all")
    public AjaxResult list(){
        return AjaxResult.success(nlpLabTeacherService.selectNlpLabTeacherDtoList());
    }
    //以下为测试代码
    @PostMapping("/add")
    public AjaxResult add(@RequestBody NlpLabTeacherDto nlpLabTeacherDto)
    {
        //记得加上createBy
        return toAjax(nlpLabTeacherService.insertNlpLabTeacher(nlpLabTeacherDto));
    }
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody NlpLabTeacherDto nlpLabTeacherDto)
    {
//        nlpLabTeacherDto.setUpdateBy(getUsername());
        return toAjax(nlpLabTeacherService.updateNlpLabTeacher(nlpLabTeacherDto));
    }
    @PostMapping ("/delete")
    public AjaxResult remove(@RequestBody NlpLabTeacher nlpLabTeacher)
    {
        return toAjax(nlpLabTeacherService.deleteNlpLabTeacherById(nlpLabTeacher.getId()));
    }
}
