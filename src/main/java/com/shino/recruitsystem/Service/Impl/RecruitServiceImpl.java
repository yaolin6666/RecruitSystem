package com.shino.recruitsystem.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shino.recruitsystem.Mapper.RecruitMapper;
import com.shino.recruitsystem.Pojo.Recruit;
import com.shino.recruitsystem.Service.RecruitService;
import org.springframework.stereotype.Service;

@Service
public class RecruitServiceImpl extends ServiceImpl<RecruitMapper, Recruit> implements RecruitService{
}
