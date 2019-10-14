package com.example.shiro.service.impl;

import com.example.shiro.entity.Authority;
import com.example.shiro.entity.Role;
import com.example.shiro.entity.RoleVo;
import com.example.shiro.entity.User;
import com.example.shiro.mapper.RoleMapper;
import com.example.shiro.mapper.UserMapper;
import com.example.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User findUserByName(String name) {
        return userMapper.findUserByName(name);
    }

    @Override
    public List<Authority> findAuthorities(String name) {
        return userMapper.gerAuthoritiesByUserName(name);
    }

    /**
     * 添加用户和用户角色
     *
     * @param user
     * @param roleId
     * @return
     */
    @Override
    public int addUser(User user, String[] roleId) {
        userMapper.addUser(user);
        return userMapper.addUserRole(user.getUserName(), roleId);
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public int delUser(String userName) {
        return userMapper.delUser(userName);
    }

    @Override
    public List<Role> findRoleByName(String userName) {
        return userMapper.findRoleByName(userName);
    }

    @Override
    public int updateUser(User user, int[] id) {
        int count = 0;
        userMapper.updateUser(user);
        roleMapper.delRoleByUser(user.getUserName());
        for (int k : id) {
            RoleVo roleVo = new RoleVo();
            roleVo.setRoleId(k);
            roleVo.setUserId(user.getUserName());
            roleMapper.addRoleByUser(roleVo);
        }
        count = 1;
        return count;
    }
}
