package com.train.cmsCloud.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.train.common.annotation.Excel;
import com.train.common.annotation.Excel.ColumnType;
import com.train.common.core.domain.BaseEntity;

/**
 * 人物志管理对象 qlu_character
 * 
 * @author qluoj
 * @date 2022-01-02
 */
public class QluCharacter extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 人物志主键 */
    private String id;

    /** 名称 */
    @Excel(name = "名称")
    private String nameTitle;

    /** 人物照片 */
    @Excel(name = "人物照片")
    private String imgUrl;

    /** 详细信息 */
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
    public void setNameTitle(String nameTitle) 
    {
        this.nameTitle = nameTitle;
    }

    public String getNameTitle() 
    {
        return nameTitle;
    }
    public void setImgUrl(String imgUrl) 
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() 
    {
        return imgUrl;
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
            .append("nameTitle", getNameTitle())
            .append("imgUrl", getImgUrl())
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
