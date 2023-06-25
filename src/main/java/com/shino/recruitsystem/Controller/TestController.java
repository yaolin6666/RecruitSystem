package com.shino.recruitsystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping({"/company","/company/index"})
    public String test1(){
        return "/company/index";
    }
    @RequestMapping("/company/add")
    public String test2(){
        return "/company/index";
    }
    @RequestMapping("/company/candidate")
    public String test3(){
        return "/company/index";
    }
    @RequestMapping("/company/detail")
    public String test4(){
        return "/company/index";
    }
    @RequestMapping("/company/post")
    public String test5(){
        return "/company/index";
    }
    @RequestMapping("/company/recruit")
    public String test6(){
        return "/company/index";
    }
    @RequestMapping("/company/seeker")
    public String test7(){
        return "/company/index";
    }
    @RequestMapping("/company/update")
    public String test8(){
        return "/company/index";
    }
    @RequestMapping("/reg")
    public String test9(){
        return "/user/login";
    }
}
