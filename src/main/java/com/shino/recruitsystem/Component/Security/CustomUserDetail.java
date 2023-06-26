package com.shino.recruitsystem.Component.Security;

import com.shino.recruitsystem.Pojo.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetail extends Account implements UserDetails {
    public CustomUserDetail(Account account){
        super(account.getUUID(), account.getUsername(), account.getPassword(), account.getRole(), account.getVersion());
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
