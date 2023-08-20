package com.train.common.domain.dto;

import com.train.common.domain.NlpLabTeacher;
import com.train.common.domain.NlpLabTeacherModule;

import java.util.ArrayList;
import java.util.List;

public class NlpLabTeacherDto extends NlpLabTeacher {
    List<NlpLabTeacherModule>  teacherModuleList=new ArrayList<>();
    public List<NlpLabTeacherModule> getTeacherModuleList(){
        return teacherModuleList;
    }
    public void setTeacherModuleList(List<NlpLabTeacherModule> nlpLabTeacherModuleList){
        this.teacherModuleList=nlpLabTeacherModuleList;
    }
    public void addTeacherModuleList (NlpLabTeacherModule nlpLabTeacherModule){
        teacherModuleList.add(nlpLabTeacherModule);
    }

}
