package com.train.common.domain;

import com.train.common.annotation.Excel;
import com.train.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 团队掠影 图片 (img)对象 nlp_admission_team_overview_img
 *
 * @author ICOVETOUS
 * @date 2023-04-21
 */
public class NlpAdmissionTeamOverviewImg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer id;

    /** 分类标题id */
    @Excel(name = "分类标题id")
    private Integer titleId;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String imgUrl;

    /** 图片名称 */
    @Excel(name = "图片名称")
    private String imgName;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Long postSort;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getId()
    {
        return id;
    }
    public void setTitleId(Integer titleId)
    {
        this.titleId = titleId;
    }

    public Integer getTitleId()
    {
        return titleId;
    }
    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl()
    {
        return imgUrl;
    }
    public void setImgName(String imgName)
    {
        this.imgName = imgName;
    }

    public String getImgName()
    {
        return imgName;
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
                .append("titleId", getTitleId())
                .append("imgUrl", getImgUrl())
                .append("imgName", getImgName())
                .append("postSort", getPostSort())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
