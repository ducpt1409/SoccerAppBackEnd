package com.ptd.service;

import com.ptd.model.UserDTO;

import java.util.List;

public interface UserService {
    public List<UserDTO> getUserByLogin(String username, String password);
    public void addUser (String username, String password, String name);
    public UserDTO getUserById(int id);
    public void updateUser(UserDTO userDTO);
    public List<UserDTO> getUserByNameLike(String name);
}
