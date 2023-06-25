package com.shino.recruitsystem.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shino.recruitsystem.Pojo.Job;
import com.shino.recruitsystem.Pojo.Recruit;
import jakarta.annotation.Nullable;

import java.util.HashMap;
import java.util.List;

public interface JobService extends IService<Job> {
    public List<Job> getByType(Long type_UUID, @Nullable String jobType);
    public List<Job> getByBoss(Long boss_UUID, @Nullable String jobType);
    public List<Job> getByName(String name);
    public HashMap<Long,Job> getJobMapByRecruit(List<Recruit> recruitList);
}
