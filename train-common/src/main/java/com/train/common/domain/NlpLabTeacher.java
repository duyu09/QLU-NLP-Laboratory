package com.train.common.domain;

import com.train.common.annotation.Excel;
import com.train.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

/**
 * 职称对象 nlp_lab_teacher
 *
 * @author relief
 * @date 2023-05-16
 */
@Component
public class NlpLabTeacher extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 老师介绍主键 */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 照片 */
    @Excel(name = "照片")
    private String imgUrl;

    /** 所在学科 */
    @Excel(name = "所在学科")
    private String subject;

    /** 所在学校 */
    @Excel(name = "所在学校")
    private String school;

    /** 性别 */
    @Excel(name = "性别")
    private String sex;

    /** 学位 */
    @Excel(name = "学位")
    private String degree;

    /** 职称 */
    @Excel(name = "职称")
    private String professionalTitle;

    /** 邮箱 */
    @Excel(name = "邮箱")
    @Email(message = "邮箱格式不正确")
    @Size(min = 0, max = 50, message = "邮箱长度不能超过50个字符")
    private String email;

    /** 联系电话 */
    @Excel(name = "联系电话")
    @Size(min = 0, max = 11, message = "手机号码长度不能超过11个字符")
    private String phone;

    /** 成员身份 */
    @Excel(name = "成员身份")
    private Long identity;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 显示顺序 */
    @Excel(name = "显示顺序")
    private Long postSort;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
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
    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl()
    {
        return imgUrl;
    }
    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public String getSubject()
    {
        return subject;
    }
    public void setSchool(String school)
    {
        this.school = school;
    }

    public String getSchool()
    {
        return school;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }
    public void setDegree(String degree)
    {
        this.degree = degree;
    }

    public String getDegree()
    {
        return degree;
    }
    public void setProfessionalTitle(String professionalTitle)
    {
        this.professionalTitle = professionalTitle;
    }

    public String getProfessionalTitle()
    {
        return professionalTitle;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setIdentity(Long identity)
    {
        this.identity = identity;
    }

    public Long getIdentity()
    {
        return identity;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setPostSort(Long postSort)
    {
        this.postSort = postSort;
    }

    public Long getPostSort()
    {
        return postSort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("imgUrl", getImgUrl())
            .append("subject", getSubject())
            .append("school", getSchool())
            .append("sex", getSex())
            .append("degree", getDegree())
            .append("professionalTitle", getProfessionalTitle())
            .append("email", getEmail())
            .append("phone", getPhone())
            .append("identity", getIdentity())
            .append("status", getStatus())
            .append("postSort", getPostSort())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
