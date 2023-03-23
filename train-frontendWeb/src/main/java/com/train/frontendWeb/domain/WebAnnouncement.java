package com.train.frontendWeb.domain;


import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.train.common.annotation.Excel;
import com.train.common.core.domain.BaseEntity;

/**
 * 公告通知管理对象 qlu_announcement
 * 
 * @author qluoj
 * @date 2022-01-02
 */
public class WebAnnouncement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** title标题 */
    @Excel(name = "title标题")
    private String title;

    /** 简介md内容 */
    @Excel(name = "简介md内容")
    private String synopsisContent;

    /** 详细md内容 */
    private String recordContent;

    /** 所属类别 */
    @Excel(name = "所属类别")
    private String configId;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Long postSort;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setSynopsisContent(String synopsisContent) 
    {
        this.synopsisContent = synopsisContent;
    }

    public String getSynopsisContent() 
    {
        return synopsisContent;
    }
    public void setRecordContent(String recordContent) 
    {
        this.recordContent = recordContent;
    }

    public String getRecordContent() 
    {
        return recordContent;
    }
    public void setConfigId(String configId)
    {
        this.configId = configId;
    }

    public String getConfigId()
    {
        return configId;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("synopsisContent", getSynopsisContent())
            .append("recordContent", getRecordContent())
            .append("configId", getConfigId())
            .append("postSort", getPostSort())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
