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
import com.train.cmsCloud.domain.QluCourse;
import com.train.cmsCloud.service.IQluCourseService;
import com.train.common.utils.poi.ExcelUtil;
import com.train.common.core.page.TableDataInfo;

/**
 * 视频资源管理Controller
 * 
 * @author qluoj
 * @date 2022-01-02
 */
@RestController
@RequestMapping("/addqluoj/course")
public class QluCourseController extends BaseController
{
    @Autowired
    private IQluCourseService qluCourseService;

    /**
     * 查询视频资源管理列表
     */
    @PreAuthorize("@ss.hasPermi('addqluoj:course:list')")
    @GetMapping("/list")
    public TableDataInfo list(QluCourse qluCourse)
    {
        startPage();
        List<QluCourse> list = qluCourseService.selectQluCourseList(qluCourse);
        return getDataTable(list);
    }

    /**
     * 导出视频资源管理列表
     */
    @PreAuthorize("@ss.hasPermi('addqluoj:course:export')")
    @Log(title = "视频资源管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, QluCourse qluCourse)
    {
        List<QluCourse> list = qluCourseService.selectQluCourseList(qluCourse);
        ExcelUtil<QluCourse> util = new ExcelUtil<QluCourse>(QluCourse.class);
        util.exportExcel(response, list, "视频资源管理数据");
    }

    /**
     * 获取视频资源管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('addqluoj:course:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(qluCourseService.selectQluCourseById(id));
    }

    /**
     * 新增视频资源管理
     */
    @PreAuthorize("@ss.hasPermi('addqluoj:course:add')")
    @Log(title = "视频资源管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody QluCourse qluCourse)
    {
        return toAjax(qluCourseService.insertQluCourse(qluCourse));
    }

    /**
     * 修改视频资源管理
     */
    @PreAuthorize("@ss.hasPermi('addqluoj:course:edit')")
    @Log(title = "视频资源管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody QluCourse qluCourse)
    {
        return toAjax(qluCourseService.updateQluCourse(qluCourse));
    }

    /**
     * 删除视频资源管理
     */
    @PreAuthorize("@ss.hasPermi('addqluoj:course:remove')")
    @Log(title = "视频资源管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(qluCourseService.deleteQluCourseByIds(ids));
    }
}
