package com.shino.recruitsystem.Controller;

import com.shino.recruitsystem.Pojo.Talk;
import com.shino.recruitsystem.Service.TalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/talk")//boss Seeker限定
public class TalkController {
    @Autowired
    TalkService talkService;
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public void addTalk(@RequestParam Talk talk){
        talkService.saveOrUpdate(talk);
    }
}
