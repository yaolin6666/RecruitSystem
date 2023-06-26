package com.shino.recruitsystem.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/seeker")
public class SeekerController {
    @Autowired
    AccountService accountService;
    @Autowired
    BossInfoService bossInfoService;
    @Autowired
    SeekerInfoService seekerInfoService;
    @Autowired
    ResumeService resumeService;
    @Autowired
    RecruitService recruitService;
    @Autowired
    JobService jobService;
    @RequestMapping("/posts")
    public String getPosts(Model model){
        List<Job> recruitList=jobService.list();
        model.addAttribute("postList",recruitList);
        return "/seeker/post";
    }
    @RequestMapping(value = "/posts",method = RequestMethod.POST)
    public String selectPosts(Model model,@RequestParam String name){
        List<Job> recruitList=jobService.getByName(name);
        model.addAttribute("postList",recruitList);
        return "/seeker/post";
    }
    @RequestMapping("/post")
    public String getPost(Model model){
        return "/seeker/post";
    }
    @RequestMapping("/post/{uuid}")
    public String getPost(Model model,@PathVariable Long uuid){
        Job job=jobService.getById(uuid);
        BossInfo bossInfo=bossInfoService.getById(job.getBoss_UUID());
        model.addAttribute("post",job);
        model.addAttribute("company",bossInfo);
        return "/seeker/postdetails";
    }
    @RequestMapping(value = "/recruit/{uuid}",method = RequestMethod.PUT)
    public String recruitJob(@PathVariable Long uuid, Principal principal){
        String username=principal.getName();
        Account user=accountService.getByUsername(username);
        Recruit recruit=new Recruit();
        recruit.setStatus("未查看");
        recruit.setJob_UUID(uuid);
        recruit.setSeeker_UUID(user.getUUID());
        List<Resume> resumeList=resumeService.getResumeBySeeker(user.getUUID());
        if(resumeList.size()!=0){
           recruit.setResume_UUID(resumeList.get(0).getUUID());
        }
        recruitService.recruitJob(recruit);
        return "index";
    }
    @RequestMapping(value = "/candidate",method = RequestMethod.GET)
    public String getCandidateList(Model model,Principal principal){
        String username=principal.getName();
        Account user=accountService.getByUsername(username);
        List<Recruit> recruitList=recruitService.getListBySeeker(user.getUUID());
        HashMap<Long,Job> jobMap=jobService.getJobMapByRecruit(recruitList);
        model.addAttribute("candidateList",recruitList);
        model.addAttribute("jobMap",jobMap);
        return "/seeker/candidate";
    }
}
