package com.shino.recruitsystem.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shino.recruitsystem.Mapper.JobMapper;
import com.shino.recruitsystem.Pojo.Job;
import com.shino.recruitsystem.Service.JobService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements JobService {
    @Override
    public List<Job> getByType(Long type_UUID, String jobType) {
        QueryWrapper<Job> queryWrapper=new QueryWrapper<>();
        if(jobType==null)
        {
            queryWrapper.eq("type_uuid",type_UUID);
        }
        else {
            queryWrapper.eq("type_uuid",type_UUID).eq("type",jobType);
        }
        List<Job> valueReturn=this.list(queryWrapper);
        return valueReturn;
    }

    @Override
    public List<Job> getByBoss(Long boss_UUID, String jobType) {
        QueryWrapper<Job> queryWrapper=new QueryWrapper<>();
        if(jobType==null)
        {
            queryWrapper.eq("boss_uuid",boss_UUID);
        }
        else {
            queryWrapper.eq("boss_uuid",boss_UUID).eq("type",jobType);
        }
        List<Job> valueReturn=this.list(queryWrapper);
        return valueReturn;
    }

    @Override
    public List<Job> getByName(String name) {
        QueryWrapper<Job> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("name",name);
        List<Job> valueReturn=this.list(queryWrapper);
        return valueReturn;
    }
}
