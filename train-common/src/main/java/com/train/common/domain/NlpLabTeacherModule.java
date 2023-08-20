package com.train.common.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.train.common.annotation.Excel;
import com.train.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 成员编辑器对象 nlp_lab_teacher_module
 *
 * @author relief
 * @date 2023-05-18
 */
public class NlpLabTeacherModule extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 老师个人简介模块主键 */
    private Long id;

    /** 对应teacher表的id */
    @Excel(name = "对应teacher表的id")
    private Long teacherId;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 内容 */
    @Excel(name = "内容")
    private String recordContent;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 顺序 */
    private Integer postSort;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setTeacherId(Long teacherId)
    {
        this.teacherId = teacherId;
    }

    public Long getTeacherId()
    {
        return teacherId;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setRecordContent(String recordContent)
    {
        this.recordContent = recordContent;
    }

    public String getRecordContent()
    {
        return recordContent;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    public Integer getPostSort() {return postSort;}

    public void setPostSort(Integer postSort) {this.postSort = postSort;}

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("teacherId", getTeacherId())
            .append("title", getTitle())
            .append("recordContent", getRecordContent())
            .append("status", getStatus())
            .append("postSort",getPostSort())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
