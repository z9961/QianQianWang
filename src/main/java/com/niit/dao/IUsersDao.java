package com.niit.dao;

import com.niit.entity.Users;


public interface IUsersDao {

    boolean save(Users u);


    Users findByPhone(String phone);

}
