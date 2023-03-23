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
import com.train.cmsCloud.domain.QluCharacter;
import com.train.cmsCloud.service.IQluCharacterService;
import com.train.common.utils.poi.ExcelUtil;
import com.train.common.core.page.TableDataInfo;

/**
 * 人物志管理Controller
 * 
 * @author qluoj
 * @date 2022-01-02
 */
@RestController
@RequestMapping("/addqluoj/character")
public class QluCharacterController extends BaseController
{
    @Autowired
    private IQluCharacterService qluCharacterService;

    /**
     * 查询人物志管理列表
     */
    @PreAuthorize("@ss.hasPermi('addqluoj:character:list')")
    @GetMapping("/list")
    public TableDataInfo list(QluCharacter qluCharacter)
    {
        startPage();
        List<QluCharacter> list = qluCharacterService.selectQluCharacterList(qluCharacter);
        return getDataTable(list);
    }

    /**
     * 导出人物志管理列表
     */
    @PreAuthorize("@ss.hasPermi('addqluoj:character:export')")
    @Log(title = "人物志管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, QluCharacter qluCharacter)
    {
        List<QluCharacter> list = qluCharacterService.selectQluCharacterList(qluCharacter);
        ExcelUtil<QluCharacter> util = new ExcelUtil<QluCharacter>(QluCharacter.class);
        util.exportExcel(response, list, "人物志管理数据");
    }

    /**
     * 获取人物志管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('addqluoj:character:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(qluCharacterService.selectQluCharacterById(id));
    }

    /**
     * 新增人物志管理
     */
    @PreAuthorize("@ss.hasPermi('addqluoj:character:add')")
    @Log(title = "人物志管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody QluCharacter qluCharacter)
    {
        return toAjax(qluCharacterService.insertQluCharacter(qluCharacter));
    }

    /**
     * 修改人物志管理
     */
    @PreAuthorize("@ss.hasPermi('addqluoj:character:edit')")
    @Log(title = "人物志管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody QluCharacter qluCharacter)
    {
        return toAjax(qluCharacterService.updateQluCharacter(qluCharacter));
    }

    /**
     * 删除人物志管理
     */
    @PreAuthorize("@ss.hasPermi('addqluoj:character:remove')")
    @Log(title = "人物志管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(qluCharacterService.deleteQluCharacterByIds(ids));
    }
}
