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
import com.train.cmsCloud.domain.QluAnnouncement;
import com.train.cmsCloud.service.IQluAnnouncementService;
import com.train.common.utils.poi.ExcelUtil;
import com.train.common.core.page.TableDataInfo;

/**
 * 公告通知管理Controller
 * 
 * @author qluoj
 * @date 2022-01-02
 */
////
@RestController
@RequestMapping("/addqluoj/announcement")
public class QluAnnouncementController extends BaseController
{
    @Autowired
    private IQluAnnouncementService qluAnnouncementService;

    /**
     * 查询公告通知管理列表
     */
    @PreAuthorize("@ss.hasPermi('addqluoj:announcement:list')")
    @GetMapping("/list")
    public TableDataInfo list(QluAnnouncement qluAnnouncement)
    {
        startPage();
        List<QluAnnouncement> list = qluAnnouncementService.selectQluAnnouncementList(qluAnnouncement);
        return getDataTable(list);
    }

    /**
     * 导出公告通知管理列表
     */
    @PreAuthorize("@ss.hasPermi('addqluoj:announcement:export')")
    @Log(title = "公告通知管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, QluAnnouncement qluAnnouncement)
    {
        List<QluAnnouncement> list = qluAnnouncementService.selectQluAnnouncementList(qluAnnouncement);
        ExcelUtil<QluAnnouncement> util = new ExcelUtil<QluAnnouncement>(QluAnnouncement.class);
        util.exportExcel(response, list, "公告通知管理数据");
    }

    /**
     * 获取公告通知管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('addqluoj:announcement:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(qluAnnouncementService.selectQluAnnouncementById(id));
    }

    /**
     * 新增公告通知管理
     */
    @PreAuthorize("@ss.hasPermi('addqluoj:announcement:add')")
    @Log(title = "公告通知管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody QluAnnouncement qluAnnouncement)
    {
        return toAjax(qluAnnouncementService.insertQluAnnouncement(qluAnnouncement));
    }

    /**
     * 修改公告通知管理
     */
    @PreAuthorize("@ss.hasPermi('addqluoj:announcement:edit')")
    @Log(title = "公告通知管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody QluAnnouncement qluAnnouncement)
    {
        return toAjax(qluAnnouncementService.updateQluAnnouncement(qluAnnouncement));
    }

    /**
     * 删除公告通知管理
     */
    @PreAuthorize("@ss.hasPermi('addqluoj:announcement:remove')")
    @Log(title = "公告通知管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(qluAnnouncementService.deleteQluAnnouncementByIds(ids));
    }
}
