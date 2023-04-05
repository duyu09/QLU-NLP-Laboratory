package com.train.common.domain;

import com.train.common.annotation.Excel;
import com.train.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 新闻动态管理对象 nlp_frontend_news
 *
 * @author relief
 * @date 2023-04-05
 */
public class NlpFrontendNews extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 新闻ID */
    private Long id;

    /** 新闻插图 */
    @Excel(name = "新闻插图")
    private String newsImg;

    /** title标题 */
    @Excel(name = "title标题")
    private String title;

    /** 简介内容 */
    @Excel(name = "简介内容")
    private String synopsisContent;

    /** 详细内容 */
    @Excel(name = "详细内容")
    private String recordContent;

    /** 是否置顶(0置顶 1不置顶) */
    @Excel(name = "是否置顶(0置顶 1不置顶)")
    private String isStick;

    /** 展示顺序 */
    @Excel(name = "展示顺序")
    private Long postSort;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setNewsImg(String newsImg)
    {
        this.newsImg = newsImg;
    }

    public String getNewsImg()
    {
        return newsImg;
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
    public void setIsStick(String isStick)
    {
        this.isStick = isStick;
    }

    public String getIsStick()
    {
        return isStick;
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
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("newsImg", getNewsImg())
                .append("title", getTitle())
                .append("synopsisContent", getSynopsisContent())
                .append("recordContent", getRecordContent())
                .append("isStick", getIsStick())
                .append("postSort", getPostSort())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
