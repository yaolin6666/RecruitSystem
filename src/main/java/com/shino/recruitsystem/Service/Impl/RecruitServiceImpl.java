package com.shino.recruitsystem.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shino.recruitsystem.Mapper.RecruitMapper;
import com.shino.recruitsystem.Pojo.BossInfo;
import com.shino.recruitsystem.Pojo.Job;
import com.shino.recruitsystem.Pojo.Recruit;
import com.shino.recruitsystem.Service.RecruitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitServiceImpl extends ServiceImpl<RecruitMapper, Recruit> implements RecruitService{
    @Override
    public List<Recruit> getListByJob(Long job_UUID) {
        QueryWrapper<Recruit> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("job_uuid",job_UUID);
        List<Recruit> valueReturn=this.list(queryWrapper);
        return valueReturn;
    }

    @Override
    public List<Recruit> getListBySeeker(Long seeker_UUID) {
        QueryWrapper<Recruit> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("seeker_uuid",seeker_UUID);
        List<Recruit> valueReturn=this.list(queryWrapper);
        return valueReturn;
    }

    @Override
    public List<Recruit> getListByJobList(List<Job> jobList) {
        List<Long> longList=jobList.stream().map(e->e.getUUID()).toList();
        QueryWrapper<Recruit> queryWrapper=new QueryWrapper<>();
        queryWrapper.in("job_uuid",longList);
        List<Recruit> valueReturn=this.list(queryWrapper);
        return valueReturn;
    }

    @Override
    public Boolean recruitJob(Recruit recruit) {
        recruit.setStatus("未查看");
        Boolean valueReturn=this.saveOrUpdate(recruit);
        return valueReturn;
    }
}
