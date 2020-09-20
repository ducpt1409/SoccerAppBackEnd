package com.ptd.service.impl;

import com.ptd.dao.UserDAO;
import com.ptd.entity.Account;
import com.ptd.entity.User;
import com.ptd.model.UserDTO;
import com.ptd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;

    @Override
    public List<UserDTO> getUserByLogin(String username, String password) {
        List<User> users = userDAO.getUserByLogin(username, password);
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User i : users) {
            userDTOS.add(i.toDTO());
        }
        return userDTOS;
    }

    @Override
    public void addUser(String username, String password, String name) {
        User user = new User();
        Account account = new Account();
        user.setId(0);
        user.setName(name);
        user.setAchievement(0);

        account.setId(0);
        account.setUsername(username);
        account.setPassword(password);

        user.setAccount(account);
        userDAO.addUser(user);

    }

    @Override
    public UserDTO getUserById(int id) {
        User user = userDAO.getUserById(id);
        return user.toDTO();
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        User user = userDAO.getUserById(userDTO.getId());
        user.setName(userDTO.getName());
        user.setDoB(userDTO.getDoB());
        user.setLocation(userDTO.getLocation());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setAvatarUrl(userDTO.getAvatarUrl());
        user.setIntroduce(userDTO.getIntroduce());
        userDAO.updateUser(user);
    }

    @Override
    public List<UserDTO> getUserByNameLike(String name) {
        List<User> users = userDAO.getUserByNameLike(name);
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User i : users) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(i.getId());
            userDTO.setName(i.getName());
            userDTO.setDoB(i.getDoB());
            userDTO.setLocation(i.getLocation());
            userDTO.setPhone(i.getPhone());
            userDTO.setEmail(i.getEmail());
            userDTO.setIntroduce(i.getIntroduce());
            userDTO.setAchievement(i.getAchievement());
            userDTO.setAvatarUrl(i.getAvatarUrl());

            userDTOS.add(userDTO);
        }
        return userDTOS;
    }
}
