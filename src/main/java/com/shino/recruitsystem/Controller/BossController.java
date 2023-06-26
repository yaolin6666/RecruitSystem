package com.shino.recruitsystem.Controller;

import com.shino.recruitsystem.Pojo.*;
import com.shino.recruitsystem.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/boss")//角色限定boss
public class BossController {
    @Autowired
    AccountService accountService;
    @Autowired
    BossInfoService bossInfoService;
    @Autowired
    JobService jobService;
    @Autowired
    RecruitService recruitService;
    @Autowired
    SeekerInfoService seekerInfoService;
    @Autowired
    ResumeService resumeService;
    @RequestMapping({"/","/index"})
    public String bossIndex(){
        return "/company/index";
    }
    @RequestMapping("/post/detail")
    public String getPostDetail(@RequestParam(required = false) Long UUID, Model model){
        if(UUID!=null){
            Job job=jobService.getById(UUID);
            model.addAttribute("post",job);
        }
        return "/company/addpost";
    }
    @RequestMapping(value = "/post/detail",method = RequestMethod.POST)
    public String addUpdateDetail(@RequestParam(required = false) Long UUID,
                                  @RequestParam String name,
                                  @RequestParam String type,
                                  @RequestParam Double salary_Num,
                                  @RequestParam String salary_Unit,
                                  @RequestParam String requirement,
                                  @RequestParam String description ,
                                  Principal principal){
        Job job=new Job();
        if(UUID!=null)
            job.setUUID(UUID);
        job.setType(type);
        job.setName(name);
        job.setSalary_Unit(salary_Unit);
        job.setSalary_Num(salary_Num);
        job.setRequirement(requirement);
        job.setDescription(description);
        if(job.getBoss_UUID()==null)
        {
            String username=principal.getName();
            Account user=accountService.getByUsername(username);
            job.setBoss_UUID(user.getUUID());
        }
        jobService.saveOrUpdate(job);
        return "redirect:/boss/posts";
    }
    @RequestMapping(value = "/posts",method = RequestMethod.GET)
    public String postList(Principal principal,Model model){
        String username=principal.getName();
        Account user=accountService.getByUsername(username);
        List<Job> jobList=jobService.getByBoss(user.getUUID(), null);
        model.addAttribute("postList",jobList);
        return "/company/post";
    }
    @RequestMapping(value = "/posts",method = RequestMethod.POST)
    public String postList(Principal principal,Model model,@RequestParam String name){
        String username=principal.getName();
        Account user=accountService.getByUsername(username);

        user=new Account();
        user.setUUID(1234L);

        List<Job> jobList=jobService.getByName(name);
        model.addAttribute("postList",jobList);
        return "/company/post";
    }
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public void alterPassword(@RequestParam Account account){
        accountService.saveOrUpdate(account);
    }
    @RequestMapping(value = "/post/{UUID}",method = RequestMethod.GET)
    public String updateJob(@PathVariable Long UUID, Model model){
        Job job=jobService.getById(UUID);
        model.addAttribute("post",job);
        return "/company/addpost";
    }
    @RequestMapping(value = "/post/{UUID}",method = RequestMethod.DELETE)
    public String deleteJob(@PathVariable Long UUID){
        jobService.removeById(UUID);
        return "index";
    }
    @RequestMapping(value = "/candidate",method = RequestMethod.GET)
    public String getCandidate(Principal principal,Model model,@RequestParam(required = false) Long UUID){
        String username=principal.getName();
        Account user=accountService.getByUsername(username);
        List<Recruit> recruitList = new ArrayList<>();
        List<Job> jobList=new ArrayList<>();
        HashMap<Long,Job> jobHashMap=new HashMap<>();
        if(UUID==null)
        {
            jobList=jobService.getByBoss(user.getUUID(), null);
            if(jobList.size()!=0)
                recruitList=recruitService.getListByJobList(jobList);
        }
        else {
            jobList.add(jobService.getById(UUID));
            recruitList=recruitService.getListByJob(UUID);
        }
        HashMap<Long,SeekerInfo> seekerInfoHashMap=new HashMap<>();
        if(jobList.size()!=0&&recruitList.size()!=0) {
            jobList.forEach(e -> {
                jobHashMap.put(e.getUUID(), e);
            });
            seekerInfoHashMap = seekerInfoService.getMapByRecruitList(recruitList);
        }
        model.addAttribute("seekerMap",seekerInfoHashMap);
        model.addAttribute("jobMap",jobHashMap);
        model.addAttribute("candidateList",recruitList);
        return "/company/candidate";
    }
    @RequestMapping(value="/candidate/{recruit_UUID}",method = RequestMethod.PUT)//同意请求
    public String agreeRecruit(@PathVariable Long recruit_UUID,@RequestParam String type){
        Recruit recruit=recruitService.getById(recruit_UUID);
        recruit.setStatus(type);
        recruitService.saveOrUpdate(recruit);
        return "index";
    }
    @RequestMapping(value = "/candidate/{recruit_UUID}",method = RequestMethod.GET)
    public String seekerDetail(Model model,@PathVariable Long recruit_UUID){
        Recruit recruit=recruitService.getById(recruit_UUID);
        SeekerInfo seekerInfo=seekerInfoService.getById(recruit.getSeeker_UUID());
        Resume resume=resumeService.getById(recruit.getResume_UUID());
        model.addAttribute("candidate",recruit);
        model.addAttribute("seeker",seekerInfo);
        model.addAttribute("resume",resume);
        return "/company/details";
    }
    @RequestMapping(value = "/recruits",method = RequestMethod.GET)
    public String recruitList(Model model, Principal principal){
        String username=principal.getName();
        Account user=accountService.getByUsername(username);
        List<Job> jobList=jobService.getByBoss(user.getUUID(), null);
        List<Recruit> recruitList=new ArrayList<>();
        if(jobList.size()!=0) {
            recruitList = recruitService.getListByJobList(jobList);
        }
        recruitList=recruitList.stream().filter(e->e.getStatus().equals("同意")).toList();
        HashMap<Long,SeekerInfo> seekerInfoList=new HashMap<>();
        HashMap<Long,Job> jobHashMap=new HashMap<>();
        if(recruitList.size()!=0) {
            seekerInfoList = seekerInfoService.getMapByRecruitList(recruitList);
            jobHashMap = jobService.getJobMapByRecruit(recruitList);
        }
        model.addAttribute("recruitList",recruitList);
        model.addAttribute("seekerMap",seekerInfoList);
        model.addAttribute("jobMap",jobHashMap);
        return "/company/recruit";
    }
}
