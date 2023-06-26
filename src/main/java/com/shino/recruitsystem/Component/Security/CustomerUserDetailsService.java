package com.shino.recruitsystem.Component.Security;

import com.shino.recruitsystem.Pojo.Account;
import com.shino.recruitsystem.Service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CustomerUserDetailsService extends Account implements UserDetailsService {
    @Autowired
    AccountService accountService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account= accountService.getByUsername(username);
        if(account==null){
            log.warn("查找不存在账号");
            throw new UsernameNotFoundException("用户名不存在");
        }
        return new CustomUserDetail(account);
    }
}
