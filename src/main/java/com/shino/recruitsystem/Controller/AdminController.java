package com.shino.recruitsystem.Controller;

import com.shino.recruitsystem.Pojo.Account;
import com.shino.recruitsystem.Pojo.Job;
import com.shino.recruitsystem.Service.AccountService;
import com.shino.recruitsystem.Service.JobService;
import com.shino.recruitsystem.Service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")//角色限定admin
public class AdminController {
    @Autowired
    TypeService typeService;
    @Autowired
    AccountService accountService;
    @Autowired
    JobService jobService;
    @RequestMapping({"/","/index"})
    public String adminIndex(){
        return "/admin/index";
    }
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUserList(Model model){
        List<Account> userList=accountService.list();
        model.addAttribute("userList",userList);
        return "/admin/user";
    }
    @RequestMapping(value = "/user/{user_UUID}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long user_UUID){
        accountService.removeById(user_UUID);
        return "index";
    }
    @RequestMapping(value = "/user/{user_UUID}",method = RequestMethod.PUT)
    public String initPassword(@PathVariable Long user_UUID){
        Account account=accountService.getById(user_UUID);
        account.setPassword("123456");
        accountService.saveOrUpdate(account);
        return "index";
    }
    @RequestMapping(value = "/posts",method = RequestMethod.GET)
    public String getPostList(Model model)
    {
        List<Job> jobList=jobService.list();
        model.addAttribute("postList",jobList);
        return "/admin/post";
    }
    @RequestMapping(value = "/posts",method = RequestMethod.POST)
    public String getPostList(Model model, @RequestParam String name){
        List<Job> jobList=jobService.getByName(name);
        model.addAttribute("postList",jobList);
        return "/admin/post";
    }
    @RequestMapping(value = "/post/{UUID}",method = RequestMethod.GET)
    public String updateJob(@PathVariable Long UUID, Model model){
        Job job=jobService.getById(UUID);
        model.addAttribute("post",job);
        return "/admin/addpost";
    }
    @RequestMapping(value = "/post/{UUID}",method = RequestMethod.DELETE)
    public String deleteJob(@PathVariable Long UUID){
        jobService.removeById(UUID);
        return "index";
    }
    @RequestMapping(value = "/delete/{UUID}",method = RequestMethod.GET)
    public String deleteJobet(@PathVariable Long UUID){
        jobService.removeById(UUID);
        return "redirect:/admin/posts";
    }
}
