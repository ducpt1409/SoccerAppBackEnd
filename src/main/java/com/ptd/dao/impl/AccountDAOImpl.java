package com.ptd.dao.impl;

import com.ptd.dao.AccountDAO;
import com.ptd.entity.Account;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class AccountDAOImpl implements AccountDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Account> getAccountByUsername(String username) {
        String jql = "select e from Account e where e.username = '" + username+"'";
        return entityManager.createQuery(jql,Account.class).getResultList();
    }

    @Override
    public void updatePassword(Account account) {
        entityManager.merge(account);
    }
}
