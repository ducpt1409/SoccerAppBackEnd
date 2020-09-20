package com.ptd.service;

import com.ptd.model.AccountDTO;

public interface AccountService {
    public int getCountAccount(String user);
    public void updatePassword(AccountDTO accountDTO);
}
