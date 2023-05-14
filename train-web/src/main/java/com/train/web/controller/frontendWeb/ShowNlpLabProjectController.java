package com.train.web.controller.frontendWeb;

import com.train.cmsCloud.service.INlpLabProjectService;
import com.train.common.core.domain.AjaxResult;
import com.train.common.domain.NlpLabProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 项目管理Controller
 *
 * @author relief
 * @date 2023-04-07
 */
@RestController
@RequestMapping("/show/nlp/project")
public class ShowNlpLabProjectController {

    @Autowired
    private INlpLabProjectService nlpLabProjectService;

    /**
     * 查询项目管理列表
     */
    @GetMapping("/list")
    public AjaxResult list(NlpLabProject nlpLabProject)
    {
        List<NlpLabProject> list = nlpLabProjectService.selectNlpLabProjectList(nlpLabProject);
        return AjaxResult.success(list);
    }

    /**
     * 获取项目管理详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(nlpLabProjectService.selectNlpLabProjectById(id));
    }
}
