package com.train.web.controller.frontendWeb;

import com.train.cmsCloud.service.INlpLabAchievementService;
import com.train.common.core.domain.AjaxResult;
import com.train.common.domain.NlpLabAchievement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 成果管理Controller
 *
 * @author relief
 * @date 2023-04-07
 */
@RestController
@RequestMapping("/show/nlp/achievement")
public class ShowNlpLabAchievementController {

    @Autowired
    private INlpLabAchievementService nlpLabAchievementService;

    /**
     * 查询成果管理列表
     */
    @GetMapping("/list")
    public AjaxResult list(NlpLabAchievement nlpLabAchievement)
    {
        List<NlpLabAchievement> list = nlpLabAchievementService.selectNlpLabAchievementList(nlpLabAchievement);
        return AjaxResult.success(list);
    }

    /**
     * 获取成果管理详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(nlpLabAchievementService.selectNlpLabAchievementById(id));
    }
}
