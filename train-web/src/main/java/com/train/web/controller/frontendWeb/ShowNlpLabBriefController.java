package com.train.web.controller.frontendWeb;

import com.train.cmsCloud.service.INlpLabBriefService;
import com.train.common.core.domain.AjaxResult;
import com.train.common.domain.NlpLabBrief;
import com.train.common.enums.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 简介管理Controller
 *
 * @author relief
 * @date 2023-04-06
 */
@RestController
@RequestMapping("/show/nlp/brief")
public class ShowNlpLabBriefController {

    @Autowired
    private INlpLabBriefService nlpLabBriefService;

    /**
     * 查询简介管理列表
     */
    @GetMapping("/list")
    public AjaxResult list(NlpLabBrief nlpLabBrief)
    {
        nlpLabBrief.setStatus(UserStatus.OK.getCode());
        List<NlpLabBrief> list = nlpLabBriefService.selectNlpLabBriefList(nlpLabBrief);
        return AjaxResult.success(list);
    }

    /**
     * 获取简介管理详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(nlpLabBriefService.selectNlpLabBriefById(id));
    }
}
