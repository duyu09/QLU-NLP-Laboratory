package com.train.web.controller.frontendWeb;

import com.train.cmsCloud.service.INlpAdmissionTeamOverviewImgService;
import com.train.common.annotation.Log;
import com.train.common.core.controller.BaseController;
import com.train.common.core.domain.AjaxResult;
import com.train.common.core.page.TableDataInfo;
import com.train.common.domain.NlpAdmissionTeamOverviewImg;
import com.train.common.enums.BusinessType;
import com.train.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 团队掠影 图片 (img)Controller
 *
 * @author ICOVETOUS
 * @date 2023-04-21
 */
@RestController
@RequestMapping("/show/nlp/teamOverviewImg")
public class ShowNlpAdmissionTeamOverviewImgController extends BaseController
{
    @Autowired
    private INlpAdmissionTeamOverviewImgService nlpAdmissionTeamOverviewImgService;

    /**
     * 查询团队掠影 图片 (img)列表
     */
    @GetMapping("/list")
    public TableDataInfo list(NlpAdmissionTeamOverviewImg nlpAdmissionTeamOverviewImg)
    {
        startPage();
        List<NlpAdmissionTeamOverviewImg> list = nlpAdmissionTeamOverviewImgService.selectNlpAdmissionTeamOverviewImgList(nlpAdmissionTeamOverviewImg);
        return getDataTable(list);
    }

    /**
     * 获取团队掠影 图片 (img)详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(nlpAdmissionTeamOverviewImgService.selectNlpAdmissionTeamOverviewImgById(id));
    }

}
