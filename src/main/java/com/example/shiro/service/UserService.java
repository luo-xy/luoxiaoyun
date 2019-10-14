package com.example.shiro.service;

import com.example.shiro.entity.Authority;
import com.example.shiro.entity.Role;
import com.example.shiro.entity.User;

import java.util.List;

public interface UserService {

    User findUserByName(String name);
    List<Authority> findAuthorities(String name);
    int addUser(User user,String[] roleId);

    List<User> findAllUser();

    int delUser(String userName);

    List<Role> findRoleByName(String userName);

    int updateUser(User user, int[] id);
}
