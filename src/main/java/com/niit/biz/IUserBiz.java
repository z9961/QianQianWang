package com.niit.biz;

import com.niit.entity.*;

import java.util.List;

public interface IUserBiz {




    String RegisterUser(Users user);

    Users findUserByPhone(String phone);

    //融资者注册
    String RegisterUser(Users user, UsersInfo userinfo);

    List<UsersAddress> findAllAddress(String Phone);


    boolean saveAddress(UsersAddress addr);

    boolean changepwd(String s, String newpwd);

    boolean update(Users user);

    boolean updateinfo(UsersInfo usersInfo);

    List<Orders> findAllOrder(String s);

    List<Project> findAllUserProject(String s);

    List<ProjectComment> findAllUserProjectComment(String s);
}
