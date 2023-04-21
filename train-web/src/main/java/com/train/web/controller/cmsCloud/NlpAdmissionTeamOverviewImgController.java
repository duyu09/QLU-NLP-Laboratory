package com.train.web.controller.cmsCloud;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.train.common.annotation.Log;
import com.train.common.core.controller.BaseController;
import com.train.common.core.domain.AjaxResult;
import com.train.common.enums.BusinessType;
import com.train.common.domain.NlpAdmissionTeamOverviewImg;
import com.train.cmsCloud.service.INlpAdmissionTeamOverviewImgService;
import com.train.common.utils.poi.ExcelUtil;
import com.train.common.core.page.TableDataInfo;

/**
 * 团队掠影 图片 (img)Controller
 *
 * @author ICOVETOUS
 * @date 2023-04-21
 */
@RestController
@RequestMapping("/nlp/admission/teamOverviewImg")
public class NlpAdmissionTeamOverviewImgController extends BaseController
{
    @Autowired
    private INlpAdmissionTeamOverviewImgService nlpAdmissionTeamOverviewImgService;

    /**
     * 查询团队掠影 图片 (img)列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:teamOverviewImg:list')")
    @GetMapping("/list")
    public TableDataInfo list(NlpAdmissionTeamOverviewImg nlpAdmissionTeamOverviewImg)
    {
        startPage();
        List<NlpAdmissionTeamOverviewImg> list = nlpAdmissionTeamOverviewImgService.selectNlpAdmissionTeamOverviewImgList(nlpAdmissionTeamOverviewImg);
        return getDataTable(list);
    }

    /**
     * 导出团队掠影 图片 (img)列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:teamOverviewImg:export')")
    @Log(title = "团队掠影 图片 (img)", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NlpAdmissionTeamOverviewImg nlpAdmissionTeamOverviewImg)
    {
        List<NlpAdmissionTeamOverviewImg> list = nlpAdmissionTeamOverviewImgService.selectNlpAdmissionTeamOverviewImgList(nlpAdmissionTeamOverviewImg);
        ExcelUtil<NlpAdmissionTeamOverviewImg> util = new ExcelUtil<NlpAdmissionTeamOverviewImg>(NlpAdmissionTeamOverviewImg.class);
        util.exportExcel(response, list, "团队掠影 图片 (img)数据");
    }

    /**
     * 获取团队掠影 图片 (img)详细信息
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:teamOverviewImg:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(nlpAdmissionTeamOverviewImgService.selectNlpAdmissionTeamOverviewImgById(id));
    }

    /**
     * 新增团队掠影 图片 (img)
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:teamOverviewImg:add')")
    @Log(title = "团队掠影 图片 (img)", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NlpAdmissionTeamOverviewImg nlpAdmissionTeamOverviewImg)
    {
        return toAjax(nlpAdmissionTeamOverviewImgService.insertNlpAdmissionTeamOverviewImg(nlpAdmissionTeamOverviewImg));
    }

    /**
     * 修改团队掠影 图片 (img)
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:teamOverviewImg:edit')")
    @Log(title = "团队掠影 图片 (img)", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NlpAdmissionTeamOverviewImg nlpAdmissionTeamOverviewImg)
    {
        return toAjax(nlpAdmissionTeamOverviewImgService.updateNlpAdmissionTeamOverviewImg(nlpAdmissionTeamOverviewImg));
    }

    /**
     * 删除团队掠影 图片 (img)
     */
    @PreAuthorize("@ss.hasPermi('nlp:admission:teamOverviewImg:remove')")
    @Log(title = "团队掠影 图片 (img)", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(nlpAdmissionTeamOverviewImgService.deleteNlpAdmissionTeamOverviewImgByIds(ids));
    }
}
