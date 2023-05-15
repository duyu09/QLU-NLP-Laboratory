package com.train.common.domain.dto;

import com.train.common.domain.NlpAdmissionTeamOverviewImg;
import com.train.common.domain.NlpAdmissionTeamOverviewTitle;

import java.util.ArrayList;
import java.util.List;

public class NlpAdmissionTeamOverviewTitleDTO extends NlpAdmissionTeamOverviewTitle {
    List<NlpAdmissionTeamOverviewImg> imgList = new ArrayList<>();

    public List<NlpAdmissionTeamOverviewImg> getImgList() {
        return imgList;
    }

    public void setImgList(List<NlpAdmissionTeamOverviewImg> imgList) {
        this.imgList = imgList;
    }

}
