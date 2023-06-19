package com.shino.recruitsystem.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shino.recruitsystem.Mapper.BossInfoMapper;
import com.shino.recruitsystem.Pojo.BossInfo;
import com.shino.recruitsystem.Service.BossInfoService;
import org.springframework.stereotype.Service;

@Service
public class BossInfoServiceImpl extends ServiceImpl<BossInfoMapper, BossInfo> implements BossInfoService {
}
