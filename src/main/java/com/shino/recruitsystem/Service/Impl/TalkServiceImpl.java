package com.shino.recruitsystem.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shino.recruitsystem.Mapper.TalkMapper;
import com.shino.recruitsystem.Pojo.Talk;
import com.shino.recruitsystem.Service.TalkService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalkServiceImpl extends ServiceImpl<TalkMapper, Talk> implements TalkService {
    @Override
    public List<Talk> getTalkList(Long seeker_UUID, Long boss_UUID) {
        QueryWrapper<Talk> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("seeker_uuid",seeker_UUID).eq("boss_uuid",boss_UUID);
        List<Talk> valueReturn=this.list(queryWrapper);
        return valueReturn;
    }
}
