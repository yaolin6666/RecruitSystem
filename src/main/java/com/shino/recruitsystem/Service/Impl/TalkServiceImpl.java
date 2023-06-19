package com.shino.recruitsystem.Service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shino.recruitsystem.Mapper.TalkMapper;
import com.shino.recruitsystem.Pojo.Talk;
import com.shino.recruitsystem.Service.TalkService;
import org.springframework.stereotype.Service;

@Service
public class TalkServiceImpl extends ServiceImpl<TalkMapper, Talk> implements TalkService {
}
