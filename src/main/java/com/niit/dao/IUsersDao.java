package com.niit.dao;

import com.niit.entity.Users;

import java.util.List;


public interface IUsersDao {

    void save(Users u);

    void update(Users u);

    void delete(Integer id);

    List<Users> findAll();

    Users findByPhone(String phone);

    Users findById(String Uid);
}
