package com.train.web.controller.frontendWeb;

import com.train.cmsCloud.service.INlpAdmissionTeamOverviewTitleService;
import com.train.common.annotation.Log;
import com.train.common.core.controller.BaseController;
import com.train.common.core.domain.AjaxResult;
import com.train.common.core.page.TableDataInfo;
import com.train.common.domain.NlpAdmissionTeamOverviewTitle;
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
@RequestMapping("/show/nlp/admission/teamOverviewTitle")
public class ShowNlpAdmissionTeamOverviewTitleController extends BaseController
{
    @Autowired
    private INlpAdmissionTeamOverviewTitleService nlpAdmissionTeamOverviewTitleService;

    /**
     * 查询团队掠影 标题 (title)列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:teamOverviewTitle:list')")
    @GetMapping("/list")
    public TableDataInfo list(NlpAdmissionTeamOverviewTitle nlpAdmissionTeamOverviewTitle)
    {
        startPage();
        List<NlpAdmissionTeamOverviewTitle> list = nlpAdmissionTeamOverviewTitleService.selectNlpAdmissionTeamOverviewTitleList(nlpAdmissionTeamOverviewTitle);
        return getDataTable(list);
    }

    /**
     * 导出团队掠影 标题 (title)列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:teamOverviewTitle:export')")
    @Log(title = "团队掠影 标题 (title)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NlpAdmissionTeamOverviewTitle nlpAdmissionTeamOverviewTitle)
    {
        List<NlpAdmissionTeamOverviewTitle> list = nlpAdmissionTeamOverviewTitleService.selectNlpAdmissionTeamOverviewTitleList(nlpAdmissionTeamOverviewTitle);
        ExcelUtil<NlpAdmissionTeamOverviewTitle> util = new ExcelUtil<NlpAdmissionTeamOverviewTitle>(NlpAdmissionTeamOverviewTitle.class);
        util.exportExcel(response, list, "团队掠影 标题 (title)数据");
    }

    /**
     * 获取团队掠影 标题 (title)详细信息
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:teamOverviewTitle:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(nlpAdmissionTeamOverviewTitleService.selectNlpAdmissionTeamOverviewTitleById(id));
    }

    /**
     * 新增团队掠影 标题 (title)
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:teamOverviewTitle:add')")
    @Log(title = "团队掠影 标题 (title)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NlpAdmissionTeamOverviewTitle nlpAdmissionTeamOverviewTitle)
    {
        return toAjax(nlpAdmissionTeamOverviewTitleService.insertNlpAdmissionTeamOverviewTitle(nlpAdmissionTeamOverviewTitle));
    }

    /**
     * 修改团队掠影 标题 (title)
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:teamOverviewTitle:edit')")
    @Log(title = "团队掠影 标题 (title)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NlpAdmissionTeamOverviewTitle nlpAdmissionTeamOverviewTitle)
    {
        return toAjax(nlpAdmissionTeamOverviewTitleService.updateNlpAdmissionTeamOverviewTitle(nlpAdmissionTeamOverviewTitle));
    }

    /**
     * 删除团队掠影 标题 (title)
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:teamOverviewTitle:remove')")
    @Log(title = "团队掠影 标题 (title)", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(nlpAdmissionTeamOverviewTitleService.deleteNlpAdmissionTeamOverviewTitleByIds(ids));
    }
}
