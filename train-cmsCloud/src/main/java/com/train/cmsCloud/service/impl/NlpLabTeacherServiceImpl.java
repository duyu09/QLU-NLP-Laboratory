package com.train.cmsCloud.service.impl;

import java.util.*;

import com.train.cmsCloud.mapper.NlpLabTeacherMapper;
import com.train.cmsCloud.mapper.NlpLabTeacherModuleMapper;
import com.train.cmsCloud.service.INlpLabTeacherService;
import com.train.common.core.domain.entity.SysUser;
import com.train.common.domain.NlpAdmissionTeamOverviewImg;
import com.train.common.domain.NlpAdmissionTeamOverviewTitle;
import com.train.common.domain.NlpLabTeacher;
import com.train.common.domain.NlpLabTeacherModule;
import com.train.common.domain.dto.NlpLabTeacherDto;
import com.train.common.enums.UserStatus;
import com.train.common.utils.DateUtils;
import com.train.common.utils.SecurityUtils;
import com.train.common.utils.StringUtils;
import com.train.system.service.ISysUserService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 职称Service业务层处理
 *
 * @author relief
 * @date 2023-05-16
 */
@Service
@Transactional
public class NlpLabTeacherServiceImpl implements INlpLabTeacherService
{
    @Autowired
    private NlpLabTeacherMapper nlpLabTeacherMapper;
    @Autowired
    private NlpLabTeacherModuleMapper nlpLabTeacherModuleMapper;
    @Autowired
    private NlpLabTeacher nlpLabTeacher;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询老师
     *
     * @param id 老师主键
     * @return 老师
     */
    @Override
    public NlpLabTeacher selectNlpLabTeacherById(Long id)
    {
        SysUser sysUser = userService.selectUserById(id);
        NlpLabTeacher nlpLabTeacher1 = nlpLabTeacherMapper.selectNlpLabTeacherById(id);
        if (nlpLabTeacher1.equals(null)) {
            nlpLabTeacher1 = new NlpLabTeacher();
        }
        setUserInfo(sysUser, nlpLabTeacher1);

        NlpLabTeacherDto nlpLabTeacherDto = new NlpLabTeacherDto();

        BeanUtils.copyProperties(nlpLabTeacher1, nlpLabTeacherDto);


        NlpLabTeacherModule nlpLabTeacherModule=new NlpLabTeacherModule();

        // 设置状态 只查询正常
        nlpLabTeacherModule.setTeacherId(id);
        List<NlpLabTeacherModule> nlpLabTeacherModuleList = nlpLabTeacherModuleMapper.selectNlpLabTeacherModuleList(nlpLabTeacherModule);

        nlpLabTeacherDto.setTeacherModuleList(nlpLabTeacherModuleList);

        return nlpLabTeacherDto;
    }

    /**
     * 查询老师列表
     *
     * @param nlpLabTeacher 老师
     * @return 老师
     */
    @Override
    public List<NlpLabTeacher> selectNlpLabTeacherList(NlpLabTeacher nlpLabTeacher)
    {
        SysUser user = new SysUser();
        user.setStatus(UserStatus.OK.getCode());
        user.getParams().put("roleKey", "teacher");
        List<SysUser> userList = userService.selectUserList(user);

        List<NlpLabTeacher> teacherList = nlpLabTeacherMapper.selectNlpLabTeacherList(nlpLabTeacher);
        List<NlpLabTeacher> list = new ArrayList<>();
        if (userList.size()>0) {
            Map<Long, NlpLabTeacher> teacherMap = new HashMap<>();
            for (NlpLabTeacher labTeacher : teacherList) {
                teacherMap.put(labTeacher.getId(), labTeacher);
            }
            for (SysUser sysUser : userList) {
                NlpLabTeacher labTeacher = new NlpLabTeacher();
                if (teacherMap.containsKey(sysUser.getUserId())) {
                    labTeacher = teacherMap.get(sysUser.getUserId());
                    setUserInfo(sysUser, labTeacher);
                } else {
                    setUserInfo(sysUser, labTeacher);
                }
                list.add(labTeacher);
            }
        }
        list.sort(Comparator.comparing(NlpLabTeacher::getPostSort));

        return list;
    }

    private void setUserInfo(SysUser sysUser, NlpLabTeacher labTeacher){
        if (ObjectUtils.isEmpty(labTeacher.getId()) && ObjectUtils.isNotEmpty(sysUser.getUserId())) {
            labTeacher.setId(sysUser.getUserId());
        }
        if (StringUtils.isEmpty(labTeacher.getName()) && StringUtils.isNotEmpty(sysUser.getNickName())) {
            labTeacher.setName(sysUser.getNickName());
        }
        if (StringUtils.isEmpty(labTeacher.getSex()) && StringUtils.isNotEmpty(sysUser.getSex())) {
            labTeacher.setSex(sysUser.getSex());
        }
        if (StringUtils.isEmpty(labTeacher.getPhone()) && StringUtils.isNotEmpty(sysUser.getPhonenumber())) {
            labTeacher.setPhone(sysUser.getPhonenumber());
        }
        if (StringUtils.isEmpty(labTeacher.getEmail()) && StringUtils.isNotEmpty(sysUser.getEmail())) {
            labTeacher.setEmail(sysUser.getEmail());
        }
    }

    /**
     * 新增老师
     *
     * @param
     * @return 结果
     */
    @Override
    public int insertNlpLabTeacher(NlpLabTeacherDto nlpLabTeacherDto)
    {
        BeanUtils.copyProperties(nlpLabTeacherDto,nlpLabTeacher);
        nlpLabTeacherMapper.insertNlpLabTeacher(nlpLabTeacher);
        Long id=nlpLabTeacherMapper.selectNlpLabTeacherByName(nlpLabTeacherDto.getName()).getId();
        for (int i = 0; i < nlpLabTeacherDto.getTeacherModuleList().size(); i++) {
            NlpLabTeacherModule nlpLabTeacherModule = nlpLabTeacherDto.getTeacherModuleList().get(i);
            nlpLabTeacherModule.setTeacherId(id);
            nlpLabTeacherModule.setPostSort(i);
            nlpLabTeacherModuleMapper.insertNlpLabTeacherModule(nlpLabTeacherModule);
        }
        return 1;
    }

    /**
     * 修改老师
     *
     * @param
     * @return 结果
     */
    @Override
    @Transactional
    public int updateNlpLabTeacher(NlpLabTeacherDto nlpLabTeacherDto)
    {
        NlpLabTeacher nlpLabTeacher1 = nlpLabTeacherMapper.selectNlpLabTeacherById(nlpLabTeacherDto.getId());
        if (nlpLabTeacher1.equals(null)) {
            return this.insertNlpLabTeacher(nlpLabTeacherDto);
        }
        nlpLabTeacherDto.setUpdateTime(DateUtils.getNowDate());
        BeanUtils.copyProperties(nlpLabTeacherDto,nlpLabTeacher);
        nlpLabTeacherMapper.updateNlpLabTeacher(nlpLabTeacher);
        nlpLabTeacherModuleMapper.deleteNlpLabTeacherModuleByTeacherId(nlpLabTeacherDto.getId());
        for(NlpLabTeacherModule nlpLabTeacherModule:nlpLabTeacherDto.getTeacherModuleList()){
            nlpLabTeacherModuleMapper.insertNlpLabTeacherModule(nlpLabTeacherModule);
        }
        return 1;
    }

    /**
     * 修改老师
     *
     * @param
     * @return 结果
     */
    @Override
    public int save(NlpLabTeacherDto nlpLabTeacherDto)
    {
        NlpLabTeacher nlpLabTeacher1 = nlpLabTeacherMapper.selectNlpLabTeacherById(nlpLabTeacherDto.getId());
        if (nlpLabTeacher1.equals(null)) {
            nlpLabTeacherDto.setCreateBy(SecurityUtils.getUsername());
            return nlpLabTeacherMapper.insertNlpLabTeacher(nlpLabTeacherDto);
        }else {
            nlpLabTeacherDto.setUpdateBy(SecurityUtils.getUsername());
            return nlpLabTeacherMapper.updateNlpLabTeacher(nlpLabTeacher);
        }
    }

    /**
     * 批量删除老师
     *
     * @param ids 需要删除的老师主键
     * @return 结果
     */
    @Override
    public int deleteNlpLabTeacherByIds(Long[] ids)
    {
        for(Long id:ids){
            deleteNlpLabTeacherById(id);
        }
        return 1;
    }

    /**
     * 删除老师信息
     *
     * @param id 老师主键
     * @return 结果
     */
    @Override
    public int deleteNlpLabTeacherById(Long id)
    {
        nlpLabTeacherModuleMapper.deleteNlpLabTeacherModuleByTeacherId(id);
        nlpLabTeacherMapper.deleteNlpLabTeacherById(id);
        return 1;
    }

    /**
     *查询老师详情页Dto
     * @return 结果
     */
    @Override
    public List<NlpLabTeacherDto> selectNlpLabTeacherDtoList() {
            NlpLabTeacherModule nlpLabTeacherModule=new NlpLabTeacherModule();
            NlpLabTeacher nlpLabTeacher=new NlpLabTeacher();

            // 设置状态 只查询正常
            nlpLabTeacherModule.setStatus(UserStatus.OK.getCode());
            nlpLabTeacher.setStatus(UserStatus.OK.getCode());

            List<NlpLabTeacherModule> nlpLabTeacherModuleList=nlpLabTeacherModuleMapper.selectNlpLabTeacherModuleList(nlpLabTeacherModule);

            List<NlpLabTeacher> nlpLabTeacherList=nlpLabTeacherMapper.selectNlpLabTeacherList(nlpLabTeacher);

            List<NlpLabTeacherDto> nlpLabTeacherDtoResult = new ArrayList<>(nlpLabTeacherList.size());

            Map<Integer, Integer> titleIdToIndex = new HashMap<>();
            int index = 0;
            for (NlpLabTeacher teacher:nlpLabTeacherList) {
                NlpLabTeacherDto nlpLabTeacherDtoNew=new NlpLabTeacherDto();

                // 赋值
                BeanUtils.copyProperties(teacher,nlpLabTeacherDtoNew);

                // 添加到结果集
                nlpLabTeacherDtoResult.add(nlpLabTeacherDtoNew);

                // titleId -> index
                titleIdToIndex.put(Math.toIntExact(teacher.getId()), index ++);
            }

            for (NlpLabTeacherModule nlpLabTeacherModuleNew:nlpLabTeacherModuleList) {
                Integer TeacherId = Math.toIntExact(nlpLabTeacherModuleNew.getTeacherId());
                Integer titleIndex = titleIdToIndex.get(TeacherId);
                if (titleIdToIndex.containsKey(TeacherId)) {
                    nlpLabTeacherDtoResult.get(titleIndex).addTeacherModuleList(nlpLabTeacherModuleNew);
                }
            }
            return nlpLabTeacherDtoResult;

    }

    /**
     * 查询老师
     *
     * @param id 老师主键
     * @return 老师
     */
    @Override
    public NlpLabTeacherDto selectNlpLabTeacherDtoById(Long id)
    {
        SysUser sysUser = userService.selectUserById(id);
        NlpLabTeacher nlpLabTeacher1 = nlpLabTeacherMapper.selectNlpLabTeacherById(id);
        if (nlpLabTeacher1.equals(null)) {
            nlpLabTeacher1 = new NlpLabTeacher();
        }
        setUserInfo(sysUser, nlpLabTeacher1);

        NlpLabTeacherDto nlpLabTeacherDto = new NlpLabTeacherDto();

        BeanUtils.copyProperties(nlpLabTeacher1, nlpLabTeacherDto);


        NlpLabTeacherModule nlpLabTeacherModule=new NlpLabTeacherModule();

        // 设置状态 只查询正常
        nlpLabTeacherModule.setTeacherId(id);
        nlpLabTeacherModule.setStatus(UserStatus.OK.getCode());
        List<NlpLabTeacherModule> nlpLabTeacherModuleList = nlpLabTeacherModuleMapper.selectNlpLabTeacherModuleList(nlpLabTeacherModule);

        nlpLabTeacherDto.setTeacherModuleList(nlpLabTeacherModuleList);

        return nlpLabTeacherDto;
    }

}
