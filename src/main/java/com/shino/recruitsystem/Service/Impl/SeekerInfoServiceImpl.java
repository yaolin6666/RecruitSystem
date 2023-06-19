package com.shino.recruitsystem.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shino.recruitsystem.Mapper.SeekInfoMapper;
import com.shino.recruitsystem.Pojo.SeekerInfo;
import com.shino.recruitsystem.Service.SeekerInfoService;
import org.springframework.stereotype.Service;

@Service
public class SeekerInfoServiceImpl extends ServiceImpl<SeekInfoMapper, SeekerInfo> implements SeekerInfoService {
}
