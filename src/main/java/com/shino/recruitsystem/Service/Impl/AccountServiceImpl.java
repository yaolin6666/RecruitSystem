package com.shino.recruitsystem.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shino.recruitsystem.Mapper.AccountMapper;
import com.shino.recruitsystem.Pojo.Account;
import com.shino.recruitsystem.Service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService{
    @Override
    public Account getByUsername(Account userInput) {
        QueryWrapper<Account> accountQueryWrapper=new QueryWrapper<>();
        accountQueryWrapper.eq("username",userInput.getUsername()).eq("password",userInput.getPassword()).eq("role",userInput.getRole());
        Account user=this.getOne(accountQueryWrapper);
        return user;
    }

    @Override
    public Account getByUsername(String username) {
        QueryWrapper<Account> accountQueryWrapper=new QueryWrapper<>();
        accountQueryWrapper.eq("username",username);
        Account user=this.getOne(accountQueryWrapper);
        return user;
    }

    @Override
    public Boolean updateByUsername(Account userInput) {
        UpdateWrapper<Account> accountUpdateWrapper=new UpdateWrapper<>();
        accountUpdateWrapper.eq("username",userInput.getUsername()).set("password",userInput.getPassword());
        Boolean valueReturn=this.update(accountUpdateWrapper);
        return valueReturn;
    }
}
