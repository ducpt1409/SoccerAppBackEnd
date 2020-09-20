package com.ptd.dao;

import com.ptd.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getUserByLogin(String username, String password);
    public void addUser(User user);
    public User getUserById(int id);
    public void updateUser(User user);
    public List<User> getUserByNameLike(String name);
}
