package com.train.common.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.train.common.annotation.Excel;
import com.train.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 项目管理对象 nlp_lab_project
 *
 * @author relief
 * @date 2023-04-07
 */
public class NlpLabProject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 项目名 */
    @Excel(name = "项目名")
    private String name;

    /** 项目的介绍 */
    @Excel(name = "项目的介绍")
    private String recordContent;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Long postSort;

    /** 0为进行中，1为已完成 */
    @Excel(name = "0为进行中，1为已完成")
    private String projectStatus;

    /** 0为正常，1为停用 */
    @Excel(name = "0为正常，1为停用")
    private String status;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
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
    public void setProjectStatus(String projectStatus)
    {
        this.projectStatus = projectStatus;
    }

    public String getProjectStatus()
    {
        return projectStatus;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("recordContent", getRecordContent())
            .append("postSort", getPostSort())
            .append("projectStatus", getProjectStatus())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
