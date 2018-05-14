package com.niit.dao;

import com.niit.entity.UsersAddress;

import java.util.List;


public interface IUsersAddressDao {

    List<UsersAddress> findAllAddress(String Phone);

    boolean save(UsersAddress addr);
}
