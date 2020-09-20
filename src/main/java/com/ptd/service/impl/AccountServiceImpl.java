package com.ptd.service.impl;

import com.ptd.dao.AccountDAO;
import com.ptd.entity.Account;
import com.ptd.model.AccountDTO;
import com.ptd.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDAO accountDAO;

    @Override
    public int getCountAccount(String user) {
        return  accountDAO.getAccountByUsername(user).size();
    }

    @Override
    public void updatePassword(AccountDTO accountDTO) {
        Account account = new Account();
        account.setId(accountDTO.getId());
        account.setUsername(accountDTO.getUsername());
        account.setPassword(accountDTO.getPassword());

        accountDAO.updatePassword(account);
    }
}
