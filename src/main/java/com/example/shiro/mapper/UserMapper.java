package com.example.shiro.mapper;

import com.example.shiro.entity.Authority;
import com.example.shiro.entity.Role;
import com.example.shiro.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
    User findUserByName(String userName);

    /**
     * 获得该用户的所有权限
     *
     * @param userName
     * @return
     */
    List<Authority> gerAuthoritiesByUserName(String userName);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 添加用户角色
     *
     * @return
     */
    int addUserRole(@Param("userName") String userName, @Param("roles") String[] roles);

    List<User> findAllUser();

    int delUser(@Param("userName") String userName);

    List<Role> findRoleByName(String userName);

    int updateUser(User user);
}
