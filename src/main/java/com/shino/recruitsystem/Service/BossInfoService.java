package com.shino.recruitsystem.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shino.recruitsystem.Pojo.Account;
import com.shino.recruitsystem.Pojo.BossInfo;
import com.shino.recruitsystem.Pojo.Job;

import java.util.HashMap;
import java.util.List;

public interface BossInfoService extends IService<BossInfo> {
    public Boolean addBoss(Account account,BossInfo bossInfo);
    public List<BossInfo> getListByJobList(List<Job> jobList);
    public HashMap<Long,BossInfo> getMapByJobList(List<Job> jobList);
}
