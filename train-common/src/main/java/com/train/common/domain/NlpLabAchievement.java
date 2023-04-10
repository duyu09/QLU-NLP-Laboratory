package com.train.common.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.train.common.annotation.Excel;
import com.train.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 成果管理对象 nlp_lab_achievement
 * 
 * @author relief
 * @date 2023-04-07
 */
public class NlpLabAchievement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 科研平台 */
    @Excel(name = "科研平台")
    private String scientificResearchPlatform;

    /** 科研专利 */
    @Excel(name = "科研专利")
    private String scientificPatent;

    /** 科研论文 */
    @Excel(name = "科研论文")
    private String scientificPaper;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Long postSort;

    /** 状态（0正常 1停用） */
    private String status;

    /** 创建者 */
    private String creatBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updataTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setScientificResearchPlatform(String scientificResearchPlatform) 
    {
        this.scientificResearchPlatform = scientificResearchPlatform;
    }

    public String getScientificResearchPlatform() 
    {
        return scientificResearchPlatform;
    }
    public void setScientificPatent(String scientificPatent) 
    {
        this.scientificPatent = scientificPatent;
    }

    public String getScientificPatent() 
    {
        return scientificPatent;
    }
    public void setScientificPaper(String scientificPaper) 
    {
        this.scientificPaper = scientificPaper;
    }

    public String getScientificPaper() 
    {
        return scientificPaper;
    }
    public void setPostSort(Long postSort) 
    {
        this.postSort = postSort;
    }

    public Long getPostSort() 
    {
        return postSort;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setCreatBy(String creatBy) 
    {
        this.creatBy = creatBy;
    }

    public String getCreatBy() 
    {
        return creatBy;
    }
    public void setUpdataTime(Date updataTime) 
    {
        this.updataTime = updataTime;
    }

    public Date getUpdataTime() 
    {
        return updataTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("scientificResearchPlatform", getScientificResearchPlatform())
            .append("scientificPatent", getScientificPatent())
            .append("scientificPaper", getScientificPaper())
            .append("postSort", getPostSort())
            .append("status", getStatus())
            .append("creatBy", getCreatBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updataTime", getUpdataTime())
            .toString();
    }
}
