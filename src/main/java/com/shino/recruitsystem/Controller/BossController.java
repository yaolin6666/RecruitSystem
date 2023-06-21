package com.shino.recruitsystem.Controller;

import com.shino.recruitsystem.Pojo.Account;
import com.shino.recruitsystem.Pojo.BossInfo;
import com.shino.recruitsystem.Pojo.Job;
import com.shino.recruitsystem.Service.AccountService;
import com.shino.recruitsystem.Service.BossInfoService;
import com.shino.recruitsystem.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boss")//角色限定boss
public class BossController {
    @Autowired
    AccountService accountService;
    @Autowired
    BossInfoService bossInfoService;
    @Autowired
    JobService jobService;
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public void registerBoss(@RequestParam Account account, @RequestParam BossInfo bossInfo){
        accountService.saveOrUpdate(account);
        bossInfoService.addBoss(account,bossInfo);
    }
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public void alterPassword(@RequestParam Account account){
        accountService.saveOrUpdate(account);
    }
    @RequestMapping(value = "/",method = RequestMethod.PATCH)
    public void updateBossInfo(@RequestParam BossInfo bossInfo){
        bossInfoService.saveOrUpdate(bossInfo);
    }
    @RequestMapping(value = "/job",method = RequestMethod.POST)
    public void addJob(@RequestParam Job job){
        jobService.saveOrUpdate(job);
    }
    @RequestMapping(value = "/job",method = RequestMethod.PUT)
    public void updateJob(@RequestParam Job job){
        jobService.saveOrUpdate(job);
    }
    @RequestMapping(value = "/job",method = RequestMethod.DELETE)
    public void deleteJob(@RequestParam Long UUID){
        jobService.removeById(UUID);
    }
}
