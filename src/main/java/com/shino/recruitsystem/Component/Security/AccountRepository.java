package com.shino.recruitsystem.Component.Security;

import com.shino.recruitsystem.Pojo.Account;

public interface AccountRepository {
    Account findAccountByUserName(String username);
}
