package com.train.common.domain;

import com.train.common.annotation.Excel;
import com.train.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 友情链接对象 nlp_frontend_link
 *
 * @author relief
 * @date 2023-04-07
 */
public class NlpFrontendLink extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 是否使用(0是 1否) */
    @Excel(name = "是否使用(0是 1否)")
    private String status;

    /** 链接名称 */
    @Excel(name = "链接名称")
    private String linkName;

    /** 链接地址 */
    @Excel(name = "链接地址")
    private String linkUrl;

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
    public void setLinkName(String linkName)
    {
        this.linkName = linkName;
    }

    public String getLinkName()
    {
        return linkName;
    }
    public void setLinkUrl(String linkUrl)
    {
        this.linkUrl = linkUrl;
    }

    public String getLinkUrl()
    {
        return linkUrl;
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
                .append("linkName", getLinkName())
                .append("linkUrl", getLinkUrl())
                .append("postSort", getPostSort())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
