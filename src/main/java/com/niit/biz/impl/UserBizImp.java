package com.niit.biz.impl;

import com.niit.biz.IUserBiz;
import com.niit.dao.*;
import com.niit.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBizImp implements IUserBiz {

    @Autowired
    private IUsersDao usersDao;
    @Autowired
    private IUsersInfoDao usersInfoDao;
    @Autowired
    private IUsersAddressDao usersAddressDao;
    @Autowired
    private IOrderDao OrderDao;
    @Autowired
    private IProjectDao projectDao;


    //注册业务
    @Override
    public String RegisterUser(Users u) {

        //根据手机号查询用户
        Users user = usersDao.findByPhone(u.getuPhone());

        //判断用户是否存在
        boolean PhoneExistFlag = true;
        try {
            if (null == user)
                PhoneExistFlag = false;
            if (user.getuPhone().equals(u.getuPhone())) {
                PhoneExistFlag = true;
            } else {
                PhoneExistFlag = false;
            }
        } catch (Exception e) {
            PhoneExistFlag = false;
        }

        if (PhoneExistFlag) {
            System.out.println("biz:手机号已存在!");
            return "UserExisted";
        } else {
            System.out.println("biz:手机号不存在");

            if (u.getuType() == 1) {
                if (usersDao.save(u)) {
                    System.out.println("biz:注册成功");
                    return "ok";
                } else {
                    System.out.println("biz:注册失败");
                    return "error";
                }
            } else {
                System.out.println("biz:用户类型为2");
                return "Type2";
            }
        }
    }

    @Override
    public String RegisterUser(Users user, UsersInfo userinfo) {
        if (usersInfoDao.save(user, userinfo)) {
            System.out.println("biz:注册成功");
            return "ok";
        } else {
            System.out.println("biz:注册失败");
            return "error";
        }
    }

    @Override
    public List<UsersAddress> findAllAddress(String Phone) {
        return usersAddressDao.findAllAddress(Phone);
    }


    @Override
    public boolean saveAddress(UsersAddress addr) {
        return usersAddressDao.save(addr);
    }

    @Override
    public boolean changepwd(String s, String newpwd) {
        return usersDao.changepwd(s, newpwd);
    }

    @Override
    public boolean update(Users user) {
        return usersDao.update(user);
    }

    @Override
    public boolean updateinfo(UsersInfo usersInfo) {
        return usersDao.updateinfo(usersInfo);
    }

    @Override
    public List<Orders> findAllOrder(String s) {
        return OrderDao.findAllOrder(s);
    }

    @Override
    public List<Project> findAllUserProject(String s) {
        return projectDao.findAllUserProject(s);
    }

    @Override
    public List<ProjectComment> findAllUserProjectComment(String s) {
        return projectDao.findAllUserProjectComment(s);
    }

    @Override
    public List<Orders> findOrderByPid(int pid) {
        return OrderDao.findOrderByPid(pid);
    }

    @Override
    public boolean deleteAddress(int aid) {
        return usersAddressDao.delete(aid);
    }

    @Override
    public Users findUserByPhone(String phone) {
        Users user = usersDao.findByPhone(phone);
        return user;
    }


}