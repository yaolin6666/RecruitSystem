package com.shino.recruitsystem.Component.Security;

import com.shino.recruitsystem.Pojo.Account;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerUserDetailsService extends Account implements UserDetailsService {
    @Resource
    AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account= accountRepository.findAccountByUserName(username);
        if(account==null){
            log.warn("查找不存在账号");
        }
        return new CustomUserDetail(account);
    }
}
