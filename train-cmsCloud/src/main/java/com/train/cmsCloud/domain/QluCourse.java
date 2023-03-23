package com.train.cmsCloud.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.train.common.annotation.Excel;
import com.train.common.annotation.Excel.ColumnType;
import com.train.common.core.domain.BaseEntity;
/**
 * 视频资源管理对象 qlu_course
 * 
 * @author qluoj
 * @date 2022-01-02
 */
public class QluCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 视频主键 */
    private String id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** title标题 */
    @Excel(name = "title标题")
    private String title;

    /** 视频链接 */
    @Excel(name = "视频链接")
    private String videoLink;

    /** 视频介绍 */
    @Excel(name = "视频介绍")
    private String recordContent;

    /** 课程PPT */
    @Excel(name = "课程PPT")
    private String downPdfLink;

    /** 课程视频 */
    @Excel(name = "课程视频")
    private String downVideoLink;

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
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setVideoLink(String videoLink) 
    {
        this.videoLink = videoLink;
    }

    public String getVideoLink() 
    {
        return videoLink;
    }
    public void setRecordContent(String recordContent) 
    {
        this.recordContent = recordContent;
    }

    public String getRecordContent() 
    {
        return recordContent;
    }
    public void setDownPdfLink(String downPdfLink) 
    {
        this.downPdfLink = downPdfLink;
    }

    public String getDownPdfLink() 
    {
        return downPdfLink;
    }
    public void setDownVideoLink(String downVideoLink) 
    {
        this.downVideoLink = downVideoLink;
    }

    public String getDownVideoLink() 
    {
        return downVideoLink;
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
            .append("name", getName())
            .append("title", getTitle())
            .append("videoLink", getVideoLink())
            .append("recordContent", getRecordContent())
            .append("downPdfLink", getDownPdfLink())
            .append("downVideoLink", getDownVideoLink())
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
