package com.shino.recruitsystem.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shino.recruitsystem.Mapper.ResumeMapper;
import com.shino.recruitsystem.Pojo.Resume;
import com.shino.recruitsystem.Service.ResumeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl extends ServiceImpl<ResumeMapper, Resume> implements ResumeService {
    @Override
    public List<Resume> getResumeBySeeker(Long seeker_UUID) {
        QueryWrapper<Resume> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("seeker_uuid",seeker_UUID);
        List<Resume> valueReturn=this.list(queryWrapper);
        return valueReturn;
    }
}
