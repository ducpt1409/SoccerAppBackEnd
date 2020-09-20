package com.ptd.dao.impl;

import com.ptd.dao.UserDAO;
import com.ptd.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<User> getUserByLogin(String abc, String password) {
        String jql = "select a from User a where a.account.username = '" + abc + "' and a.account.password = '" + password + "'";
        return entityManager.createQuery(jql, User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class,id);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override

    public List<User> getUserByNameLike(String name) {
        String jql = "select e from User e where e.name like '%" + name+"%'";
        return entityManager.createQuery(jql, User.class).getResultList();
    }
}
