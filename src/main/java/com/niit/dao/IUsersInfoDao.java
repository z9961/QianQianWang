package com.niit.dao;

import com.niit.entity.Users;
import com.niit.entity.UsersInfo;


public interface IUsersInfoDao {

    boolean save(Users user, UsersInfo usersInfo);

}
