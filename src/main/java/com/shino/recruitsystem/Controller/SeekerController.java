package com.shino.recruitsystem.Controller;

import com.shino.recruitsystem.Pojo.Account;
import com.shino.recruitsystem.Pojo.Resume;
import com.shino.recruitsystem.Pojo.SeekerInfo;
import com.shino.recruitsystem.Service.AccountService;
import com.shino.recruitsystem.Service.ResumeService;
import com.shino.recruitsystem.Service.SeekerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seeker")
public class SeekerController {
    @Autowired
    AccountService accountService;
    @Autowired
    SeekerInfoService seekerInfoService;
    @Autowired
    ResumeService resumeService;
     @RequestMapping(value="/",method = RequestMethod.PUT)
    public void alterPassword(@RequestParam Account account){
         accountService.updateByUsername(account);
     }
     @RequestMapping(value = "/",method = RequestMethod.PATCH)
    public void updateInfo(@RequestParam SeekerInfo seekerInfo){
         seekerInfoService.saveOrUpdate(seekerInfo);
     }
     @RequestMapping(value = "/resume",method = RequestMethod.POST)
    public void addResume(@RequestParam Resume resume){
        resumeService.saveOrUpdate(resume);
     }
     @RequestMapping(value = "/resume",method = RequestMethod.PUT)
    public void updateResume(@RequestParam Resume resume){
         resumeService.saveOrUpdate(resume);
     }
     @RequestMapping(value = "/resume",method = RequestMethod.DELETE)
    public void deleteResume(@RequestParam Long UUID){
         resumeService.removeById(UUID);
     }
}
