package com.shino.recruitsystem.Controller;

import com.shino.recruitsystem.Pojo.Recruit;
import com.shino.recruitsystem.Service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    RecruitService recruitService;
    @RequestMapping(value = "/recruit",method = RequestMethod.POST)
    public void seekerRecruit(@RequestParam Recruit recruit){
        recruitService.recruitJob(recruit);
    }
}
