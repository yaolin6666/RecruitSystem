package com.shino.recruitsystem.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shino.recruitsystem.Mapper.BossInfoMapper;
import com.shino.recruitsystem.Pojo.Account;
import com.shino.recruitsystem.Pojo.BossInfo;
import com.shino.recruitsystem.Pojo.Job;
import com.shino.recruitsystem.Service.BossInfoService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BossInfoServiceImpl extends ServiceImpl<BossInfoMapper, BossInfo> implements BossInfoService {
    @Override
    public Boolean addBoss(Account account, BossInfo bossInfo) {
        bossInfo.setUUID(account.getUUID());
        Boolean valueReturn=this.saveOrUpdate(bossInfo);
        return valueReturn;
    }

    @Override
    public List<BossInfo> getListByJobList(List<Job> jobList) {
        List<Long> integerList=jobList.stream().map(e->e.getBoss_UUID()).toList();
        List<BossInfo> valueReturn=this.listByIds(integerList);
        return valueReturn;
    }

    @Override
    public HashMap<Long, BossInfo> getMapByJobList(List<Job> jobList) {
        List<Long> integerList=jobList.stream().map(e->e.getBoss_UUID()).toList();
        List<BossInfo> bossInfoList=this.listByIds(integerList);
        HashMap<Long,BossInfo> valueReturn=new HashMap<>();
        bossInfoList.forEach(e->valueReturn.put(e.getUUID(),e));
        return valueReturn;
    }
}
