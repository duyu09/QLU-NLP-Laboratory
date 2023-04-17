package com.train.common.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.train.common.annotation.Excel;
import com.train.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 简介管理对象 nlp_lab_brief
 * 
 * @author relief
 * @date 2023-04-06
 */
public class NlpLabBrief extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 实验室简介 */
    @Excel(name = "实验室简介")
    private String recordContent;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Long postSort;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 创建者 */
    @Excel(name = "创建者")
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
    public void setRecordContent(String recordContent) 
    {
        this.recordContent = recordContent;
    }

    public String getRecordContent() 
    {
        return recordContent;
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
            .append("recordContent", getRecordContent())
            .append("postSort", getPostSort())
            .append("status", getStatus())
            .append("creatBy", getCreatBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updataTime", getUpdataTime())
            .toString();
    }
}
