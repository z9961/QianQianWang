package com.niit.biz;

import com.niit.entity.Users;

import java.util.List;

public interface IUserBiz {


    void save(Users u);

    void update(Users u);

    void delete(Integer id);

    List<Users> findAll();

    //根据手机号查找用户
    boolean findByPhone(String phone);

    Users findUserByPhone(String phone);
}
