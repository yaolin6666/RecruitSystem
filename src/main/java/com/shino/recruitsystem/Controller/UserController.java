package com.shino.recruitsystem.Controller;

import com.shino.recruitsystem.Pojo.Account;
import com.shino.recruitsystem.Pojo.BossInfo;
import com.shino.recruitsystem.Pojo.SeekerInfo;
import com.shino.recruitsystem.Service.AccountService;
import com.shino.recruitsystem.Service.BossInfoService;
import com.shino.recruitsystem.Service.SeekerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class UserController {
    @Autowired
    SeekerInfoService seekerInfoService;
    @Autowired
    BossInfoService bossInfoService;
    @Autowired
    AccountService accountService;
    @RequestMapping(value = "/register",method = RequestMethod.GET)//注册
    public String regAccount(){
        return "/user/reg";
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String regAccount(@RequestParam String username,@RequestParam String password,@RequestParam String role,@RequestParam String name){
        Account account=new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setRole(role);
        accountService.saveOrUpdate(account);
        if(account.getRole().equals("seeker")){
            SeekerInfo seekerInfo=new SeekerInfo();
            seekerInfo.setName(name);
            seekerInfoService.addSeeker(account,seekerInfo);
        }
        else if(account.getRole().equals("company")){
            BossInfo bossInfo=new BossInfo();
            bossInfo.setName(name);
            bossInfo.setName(name);
        }
        return "redirect:/register";
    }
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public String getUserInfo(Principal principal, Model model){
        String username=principal.getName();
        Account user=accountService.getByUsername(username);
        if(user.getRole().equals("seeker")) {
            model.addAttribute("type", "seeker");
            SeekerInfo seekerInfo=seekerInfoService.getById(user.getUUID());
            model.addAttribute("seeker",seekerInfo);
        }
        else if(user.getRole().equals("company"))
        {
            model.addAttribute("type","company");
            BossInfo bossInfo=bossInfoService.getById(user.getUUID());
            model.addAttribute("company",bossInfo);
        }
        return "/user/information";
    }
    @RequestMapping(value = "/updateseeker",method = RequestMethod.POST)
    public String updateSeeker(@RequestParam SeekerInfo seekerInfo)
    {
        seekerInfoService.saveOrUpdate(seekerInfo);
        return "redirect:/info";
    }
    @RequestMapping(value = "/updatecompany",method = RequestMethod.POST)
    public String updateSeeker(@RequestParam BossInfo bossInfo)
    {
        bossInfoService.saveOrUpdate(bossInfo);
        return "redirect:/info";
    }
}
