package com.niit.biz;

import com.niit.entity.*;

import java.util.List;

public interface IUserBiz {

    //注册用户
    String RegisterUser(Users user);

    //根据手机号查找用户
    Users findUserByPhone(String phone);

    //融资者注册
    String RegisterUser(Users user, UsersInfo userinfo);

    //当前用户的所有地址
    List<UsersAddress> findAllAddress(String Phone);

    //添加地址
    boolean saveAddress(UsersAddress addr);

    //修改密码
    boolean changepwd(String s, String newpwd);

    //更新用户
    boolean update(Users user);

    //修改融资者信息
    boolean updateinfo(UsersInfo usersInfo);

    //当前用户的所有订单
    List<Orders> findAllOrder(String s);

    //当前用户的所有项目
    List<Project> findAllUserProject(String s);

    //当前用户的所有评论
    List<ProjectComment> findAllUserProjectComment(String s);

    //查找pid对应的所有订单
    List<Orders> findOrderByPid(int i);

    boolean deleteAddress(int aid);
}
