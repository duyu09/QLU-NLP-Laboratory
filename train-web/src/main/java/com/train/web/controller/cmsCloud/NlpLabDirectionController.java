package com.train.web.controller.cmsCloud;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.train.cmsCloud.service.INlpLabDirectionService;
import com.train.common.domain.NlpLabDirection;
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
import com.train.common.utils.poi.ExcelUtil;
import com.train.common.core.page.TableDataInfo;

/**
 * 研究方向管理Controller
 * 
 * @author relief
 * @date 2023-04-07
 */
@RestController
@RequestMapping("/nlp/direction")
public class NlpLabDirectionController extends BaseController
{
    @Autowired
    private INlpLabDirectionService nlpLabDirectionService;

    /**
     * 查询研究方向管理列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:direction:list')")
    @GetMapping("/list")
    public TableDataInfo list(NlpLabDirection nlpLabDirection)
    {
        startPage();
        List<NlpLabDirection> list = nlpLabDirectionService.selectNlpLabDirectionList(nlpLabDirection);
        return getDataTable(list);
    }

    /**
     * 导出研究方向管理列表
     */
    @PreAuthorize("@ss.hasPermi('nlp:direction:export')")
    @Log(title = "研究方向管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NlpLabDirection nlpLabDirection)
    {
        List<NlpLabDirection> list = nlpLabDirectionService.selectNlpLabDirectionList(nlpLabDirection);
        ExcelUtil<NlpLabDirection> util = new ExcelUtil<NlpLabDirection>(NlpLabDirection.class);
        util.exportExcel(response, list, "研究方向管理数据");
    }

    /**
     * 获取研究方向管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('nlp:direction:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(nlpLabDirectionService.selectNlpLabDirectionById(id));
    }

    /**
     * 新增研究方向管理
     */
    @PreAuthorize("@ss.hasPermi('nlp:direction:add')")
    @Log(title = "研究方向管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NlpLabDirection nlpLabDirection)
    {
        return toAjax(nlpLabDirectionService.insertNlpLabDirection(nlpLabDirection));
    }

    /**
     * 修改研究方向管理
     */
    @PreAuthorize("@ss.hasPermi('nlp:direction:edit')")
    @Log(title = "研究方向管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NlpLabDirection nlpLabDirection)
    {
        return toAjax(nlpLabDirectionService.updateNlpLabDirection(nlpLabDirection));
    }

    /**
     * 删除研究方向管理
     */
    @PreAuthorize("@ss.hasPermi('nlp:direction:remove')")
    @Log(title = "研究方向管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(nlpLabDirectionService.deleteNlpLabDirectionByIds(ids));
    }
}
