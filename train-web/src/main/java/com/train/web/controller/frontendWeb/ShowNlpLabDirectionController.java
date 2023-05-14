package com.train.web.controller.frontendWeb;

import com.train.cmsCloud.service.INlpLabDirectionService;
import com.train.common.core.domain.AjaxResult;
import com.train.common.domain.NlpLabDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 研究方向管理Controller
 *
 * @author relief
 * @date 2023-04-07
 */
@RestController
@RequestMapping("/show/nlp/direction")
public class ShowNlpLabDirectionController {

    @Autowired
    private INlpLabDirectionService nlpLabDirectionService;

    /**
     * 查询研究方向管理列表
     */
    @GetMapping("/list")
    public AjaxResult list(NlpLabDirection nlpLabDirection)
    {
        List<NlpLabDirection> list = nlpLabDirectionService.selectNlpLabDirectionList(nlpLabDirection);
        return AjaxResult.success(list);
    }

    /**
     * 获取研究方向管理详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(nlpLabDirectionService.selectNlpLabDirectionById(id));
    }
}
