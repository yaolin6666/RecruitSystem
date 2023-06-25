package com.shino.recruitsystem;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shino.recruitsystem.Pojo.Account;
import com.shino.recruitsystem.Service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisplusTest {
    @Autowired
    AccountService accountService;
    @Test
    public void addAccount(){
        Account account=new Account();
        account.setRole("test");
        account.setUsername("test");
        accountService.saveOrUpdate(account);
    }
}
