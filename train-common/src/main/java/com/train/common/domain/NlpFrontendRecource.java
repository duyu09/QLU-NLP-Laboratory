package com.train.common.domain;

import com.train.common.annotation.Excel;
import com.train.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 学术资源对象 nlp_frontend_recource
 *
 * @author relief
 * @date 2023-05-21
 */
public class NlpFrontendRecource extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 是否使用(0是 1否) */
    @Excel(name = "是否使用(0是 1否)")
    private String status;

    /** 链接名称 */
    @Excel(name = "链接名称")
    private String recourceName;

    /** 详细内容 */
    @Excel(name = "详细内容")
    private String recordContent;

    /** 链接地址 */
    @Excel(name = "链接地址")
    private String recourceUrl;

    /** 展示顺序 */
    @Excel(name = "展示顺序")
    private Long postSort;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setRecourceName(String recourceName)
    {
        this.recourceName = recourceName;
    }

    public String getRecourceName()
    {
        return recourceName;
    }
    public void setRecordContent(String recordContent)
    {
        this.recordContent = recordContent;
    }

    public String getRecordContent()
    {
        return recordContent;
    }
    public void setRecourceUrl(String recourceUrl)
    {
        this.recourceUrl = recourceUrl;
    }

    public String getRecourceUrl()
    {
        return recourceUrl;
    }
    public void setPostSort(Long postSort)
    {
        this.postSort = postSort;
    }

    public Long getPostSort()
    {
        return postSort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("status", getStatus())
                .append("recourceName", getRecourceName())
                .append("recordContent", getRecordContent())
                .append("recourceUrl", getRecourceUrl())
                .append("postSort", getPostSort())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
