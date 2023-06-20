package com.shino.recruitsystem.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shino.recruitsystem.Mapper.SeekInfoMapper;
import com.shino.recruitsystem.Pojo.*;
import com.shino.recruitsystem.Service.SeekerInfoService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class SeekerInfoServiceImpl extends ServiceImpl<SeekInfoMapper, SeekerInfo> implements SeekerInfoService {
    @Override
    public Boolean addSeeker(Account account, SeekerInfo seekerInfo) {
        seekerInfo.setUUID(account.getUUID());
        Boolean valueReturn=this.saveOrUpdate(seekerInfo);
        return valueReturn;
    }

    @Override
    public List<SeekerInfo> getListByRecruitList(List<Recruit> recruitList) {
        List<Long> integerList=recruitList.stream().map(e->e.getSeeker_UUID()).toList();
        List<SeekerInfo> valueReturn=this.listByIds(integerList);
        return valueReturn;
    }

    @Override
    public HashMap<Long, SeekerInfo> getMapByRecruitList(List<Recruit> recruitList) {
        List<Long> integerList=recruitList.stream().map(e->e.getSeeker_UUID()).toList();
        List<SeekerInfo> seekerInfoList=this.listByIds(integerList);
        HashMap<Long,SeekerInfo> valueReturn=new HashMap<>();
        seekerInfoList.forEach(e->valueReturn.put(e.getUUID(),e));
        return valueReturn;
    }
}
