//package com.shino.recruitsystem.Service.Impl;
//
//import com.shino.recruitsystem.Service.AccountService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@Service
//public class UserDetailServiceImpl implements UserDetailsService {
//    @Autowired
//    AccountService accountService;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserDetails userDetails=null;
//        Collection<GrantedAuthority> authList = getAuthorities();;
//        username="admin";
//        userDetails=new User(username,"123456",true,true,true,true,authList);
//        return userDetails;
//    }
//    private Collection<GrantedAuthority> getAuthorities(){
//        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
//        authList.add(new SimpleGrantedAuthority("ROLE_USER"));
//        authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        return authList;
//    }
//}
