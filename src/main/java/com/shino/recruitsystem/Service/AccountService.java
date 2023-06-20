package com.shino.recruitsystem.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shino.recruitsystem.Pojo.Account;

public interface AccountService extends IService<Account>{
    /**
     * 登录getByUsername
     *  注册save
     *  修改密码updateByUsername
     * */
    public Account getByUsername(Account userInput);
    public Boolean updateByUsername(Account userInput);//修改密码
}
