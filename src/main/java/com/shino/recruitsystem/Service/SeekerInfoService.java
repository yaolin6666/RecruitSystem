package com.shino.recruitsystem.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shino.recruitsystem.Pojo.Account;
import com.shino.recruitsystem.Pojo.Job;
import com.shino.recruitsystem.Pojo.Recruit;
import com.shino.recruitsystem.Pojo.SeekerInfo;

import java.util.HashMap;
import java.util.List;

public interface SeekerInfoService extends IService<SeekerInfo> {
    public Boolean addSeeker(Account account, SeekerInfo seekerInfo);
    public List<SeekerInfo> getListByRecruitList(List<Recruit> recruitList);
    public HashMap<Long,SeekerInfo> getMapByRecruitList(List<Recruit> recruitList);
}
