package com.shino.recruitsystem.Controller;

import com.shino.recruitsystem.Pojo.Type;
import com.shino.recruitsystem.Service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")//角色限定admin
public class AdminController {
    @Autowired
    TypeService typeService;
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
