package com.niit.dao;

import com.niit.entity.Users;
import com.niit.entity.UsersInfo;


public interface IUsersDao {

    boolean save(Users u);


    Users findByPhone(String phone);

    boolean changepwd(String s, String newpwd);

    boolean update(Users user);

    boolean updateinfo(UsersInfo usersInfo);
}
