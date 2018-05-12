package com.niit.biz.impl;

import com.niit.biz.IUserBiz;
import com.niit.dao.IUsersDao;
import com.niit.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBizImp implements IUserBiz {

    @Autowired
    private IUsersDao usersDao;

    @Override
    public void save(Users u) {

    }

    @Override
    public void update(Users u) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Users> findAll() {
        return null;
    }

    //根据手机号查找用户是否存在
    @Override
    public boolean findByPhone(String phone) {

        Users user = usersDao.findByPhone(phone);

        if (null == user)
            return false;
        try {
            if (user.getuPhone().equals(phone)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }


    }

    @Override
    public Users findUserByPhone(String phone) {
        Users user = usersDao.findByPhone(phone);
        return user;
    }
}