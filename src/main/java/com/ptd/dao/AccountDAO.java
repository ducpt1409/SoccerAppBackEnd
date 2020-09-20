package com.ptd.dao;

import com.ptd.entity.Account;

import java.util.List;

public interface AccountDAO {
    public List<Account> getAccountByUsername(String Username);
    public void updatePassword(Account account);
}
