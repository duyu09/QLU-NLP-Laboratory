package com.train.frontendWeb.dto;

import com.train.common.domain.NlpFrontendNews;

/**
 * @author Along
 */
public class NlpFrontendNewsDTO extends NlpFrontendNews {

    /**
     * 上一篇新闻id
     */
    private Long beforeId;
    /**
     * 上一篇新闻标题
     */
    private String beforeTitle;
    /**
     * 下一篇新闻id
     */
    private Long afterId;
    /**
     * 下一篇新闻标题
     */
    private String afterTitle;

    public Long getBeforeId() {
        return beforeId;
    }

    public void setBeforeId(Long beforeId) {
        this.beforeId = beforeId;
    }

    public String getBeforeTitle() {
        return beforeTitle;
    }

    public void setBeforeTitle(String beforeTitle) {
        this.beforeTitle = beforeTitle;
    }

    public Long getAfterId() {
        return afterId;
    }

    public void setAfterId(Long afterId) {
        this.afterId = afterId;
    }

    public String getAfterTitle() {
        return afterTitle;
    }

    public void setAfterTitle(String afterTitle) {
        this.afterTitle = afterTitle;
    }
}
