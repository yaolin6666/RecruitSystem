package com.shino.recruitsystem.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shino.recruitsystem.Pojo.Resume;

import java.util.List;

public interface ResumeService extends IService<Resume> {
    public List<Resume> getResumeBySeeker(Long seeker_UUID);
}
