package com.shino.recruitsystem.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shino.recruitsystem.Pojo.Talk;

import java.util.List;

public interface TalkService extends IService<Talk> {
    public List<Talk> getTalkList(Long seeker_UUID, Long boss_UUID);
}
