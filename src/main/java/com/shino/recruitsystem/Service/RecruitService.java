package com.shino.recruitsystem.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shino.recruitsystem.Pojo.Recruit;

import java.util.List;

public interface RecruitService extends IService<Recruit> {
    public List<Recruit> getListByJob(Long job_UUID);
    public List<Recruit> getListBySeeker(Long seeker_UUID);
    public Boolean recruitJob(Recruit recruit);
}
