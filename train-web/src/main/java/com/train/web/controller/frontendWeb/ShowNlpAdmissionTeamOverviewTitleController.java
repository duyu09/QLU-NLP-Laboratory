package com.train.web.controller.frontendWeb;

import com.train.cmsCloud.service.INlpAdmissionTeamOverviewTitleService;
import com.train.common.annotation.Log;
import com.train.common.core.controller.BaseController;
import com.train.common.core.domain.AjaxResult;
import com.train.common.core.page.TableDataInfo;
import com.train.common.domain.NlpAdmissionTeamOverviewTitle;
import com.train.common.domain.dto.NlpAdmissionTeamOverviewTitleDTO;
import com.train.common.enums.BusinessType;
import com.train.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 团队掠影 标题 (title)Controller
 *
 * @author ICOVETOUS
 * @date 2023-04-21
 */
@RestController
@RequestMapping("/show/nlp/teamOverviewTitle")
public class ShowNlpAdmissionTeamOverviewTitleController extends BaseController
{
    @Autowired
    private INlpAdmissionTeamOverviewTitleService nlpAdmissionTeamOverviewTitleService;

    /**
     * 查询团队掠影 标题 (title)列表
     */
    @GetMapping("/list")
    public TableDataInfo list(NlpAdmissionTeamOverviewTitle nlpAdmissionTeamOverviewTitle)
    {
        startPage();
        List<NlpAdmissionTeamOverviewTitle> list = nlpAdmissionTeamOverviewTitleService.selectNlpAdmissionTeamOverviewTitleList(nlpAdmissionTeamOverviewTitle);
        return getDataTable(list);
    }

    /**
     * 获取团队掠影 标题 (title)详细信息
     */
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(nlpAdmissionTeamOverviewTitleService.selectNlpAdmissionTeamOverviewTitleById(id));
    }

    /**
     * 查询团队掠影 标题和图片 对应的列表
     */
    @GetMapping("/all")
    public TableDataInfo all()
    {
        startPage();
        List<NlpAdmissionTeamOverviewTitleDTO> list = nlpAdmissionTeamOverviewTitleService.selectNlpAdmissionTeamOverviewTitleDTOList();
        return getDataTable(list);
    }
}
