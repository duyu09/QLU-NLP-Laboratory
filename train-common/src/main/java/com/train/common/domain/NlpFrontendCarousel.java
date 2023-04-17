package com.train.common.domain;

import com.train.common.annotation.Excel;
import com.train.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 轮播图对象 nlp_frontend_carousel
 *
 * @author relief
 * @date 2023-04-03
 */
public class NlpFrontendCarousel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 轮播图ID */
    private Long id;

    /** 轮播图 */
    @Excel(name = "轮播图")
    private String carouselImg;

    /** 轮播图名称 */
    @Excel(name = "轮播图名称")
    private String carouselName;

    /** 路由地址 */
    @Excel(name = "路由地址")
    private String urlPath;

    /** 详细信息 */
    @Excel(name = "详细信息")
    private String recordContent;

    /** 轮播图顺序 */
    @Excel(name = "轮播图顺序")
    private Long postSort;

    /** 是否为外链  */
    @Excel(name = "是否为外链 ")
    private String isFrame;

    /** 轮播图状态（0正常 1停用） */
    @Excel(name = "轮播图状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCarouselImg(String carouselImg)
    {
        this.carouselImg = carouselImg;
    }

    public String getCarouselImg()
    {
        return carouselImg;
    }
    public void setCarouselName(String carouselName)
    {
        this.carouselName = carouselName;
    }

    public String getCarouselName()
    {
        return carouselName;
    }
    public void setUrlPath(String urlPath)
    {
        this.urlPath = urlPath;
    }

    public String getUrlPath()
    {
        return urlPath;
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
    public void setIsFrame(String isFrame)
    {
        this.isFrame = isFrame;
    }

    public String getIsFrame()
    {
        return isFrame;
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
                .append("carouselImg", getCarouselImg())
                .append("carouselName", getCarouselName())
                .append("urlPath", getUrlPath())
                .append("recordContent", getRecordContent())
                .append("postSort", getPostSort())
                .append("isFrame", getIsFrame())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
