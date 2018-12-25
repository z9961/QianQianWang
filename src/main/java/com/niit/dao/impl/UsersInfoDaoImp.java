package com.niit.dao.impl;

import com.niit.dao.IUsersInfoDao;
import com.niit.entity.Users;
import com.niit.entity.UsersInfo;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UsersInfoDaoImp implements IUsersInfoDao {


    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public boolean save(Users user, UsersInfo usersInfo) {
        try {
            sessionFactory.getCurrentSession().save(user);
            sessionFactory.getCurrentSession().save(usersInfo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
