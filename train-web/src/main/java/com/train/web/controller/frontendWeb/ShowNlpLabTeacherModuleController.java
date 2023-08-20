package com.train.web.controller.frontendWeb;

import com.train.cmsCloud.service.INlpLabTeacherModuleService;
import com.train.common.core.controller.BaseController;
import com.train.common.core.domain.AjaxResult;
import com.train.common.core.page.TableDataInfo;
import com.train.common.domain.NlpLabTeacherModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/show/nlp/module")
public class ShowNlpLabTeacherModuleController extends BaseController {
    @Autowired
    private INlpLabTeacherModuleService nlpLabTeacherModuleService;

    /**
     * 查询成员编辑器列表
     */
    @GetMapping("/list")
    public TableDataInfo list(NlpLabTeacherModule nlpLabTeacherModule)
    {
        startPage();
        List<NlpLabTeacherModule> list = nlpLabTeacherModuleService.selectNlpLabTeacherModuleList(nlpLabTeacherModule);
        return getDataTable(list);
    }
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(nlpLabTeacherModuleService.selectNlpLabTeacherModuleById(id));
    }
}
