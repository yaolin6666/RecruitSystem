package com.shino.recruitsystem.Controller;

import com.shino.recruitsystem.Pojo.Account;
import com.shino.recruitsystem.Pojo.Type;
import com.shino.recruitsystem.Service.AccountService;
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
    @RequestMapping(value = "/type",method = RequestMethod.POST)
    public void addType(@RequestParam Type type){
        typeService.saveOrUpdate(type);
    }
    @RequestMapping(value = "/type",method = RequestMethod.PUT)
    public void updateType(@RequestParam Type type){
        typeService.saveOrUpdate(type);
    }
    @RequestMapping(value = "/type",method = RequestMethod.DELETE)
    public void deleteType(@RequestParam Long UUID){
        typeService.removeById(UUID);
    }
}
