package com.train.web.controller.frontendWeb;

import com.train.cmsCloud.service.INlpAdmissionStudentService;
import com.train.common.annotation.Log;
import com.train.common.core.controller.BaseController;
import com.train.common.core.domain.AjaxResult;
import com.train.common.core.page.TableDataInfo;
import com.train.common.domain.NlpAdmissionStudent;
import com.train.common.enums.BusinessType;
import com.train.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 学生 数据Controller
 *
 * @author ICOVETOUS
 * @date 2023-04-05
 */
@RestController
@RequestMapping("/show/nlp/admissionStudent")
public class ShowNlpAdmissionStudentController extends BaseController
{
    @Autowired
    private INlpAdmissionStudentService nlpAdmissionStudentService;

    /**
     * 查询学生 数据列表
     */
    @GetMapping("/list")
    public TableDataInfo list(NlpAdmissionStudent nlpAdmissionStudent)
    {
        startPage();
        List<NlpAdmissionStudent> list = nlpAdmissionStudentService.selectNlpAdmissionStudentList(nlpAdmissionStudent);
        return getDataTable(list);
    }

    /**
     * 查询学生 数据
     *
     * @return 学生数据 根据是否毕业分组
     */
    @GetMapping("/listSeparately")
    public TableDataInfo listSeparately()
    {
        startPage();
        List<List<NlpAdmissionStudent>> list = nlpAdmissionStudentService.selectNlpAdmissionStudentSeparatelyList();
        return getDataTable(list);
    }
}
