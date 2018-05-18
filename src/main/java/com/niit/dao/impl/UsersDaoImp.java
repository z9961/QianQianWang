package com.niit.dao.impl;

import com.niit.dao.IUsersDao;
import com.niit.entity.Users;
import com.niit.entity.UsersInfo;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UsersDaoImp implements IUsersDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean save(Users u) {
        try {
            sessionFactory.getCurrentSession().save(u);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @Override
    public Users findByPhone(String phone) {
        System.out.println("Dao");
        System.out.println("phone = " + phone);

        String hql = "from Users where uPhone=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0, phone);

        //这里的user在没有对应的数据时为NULL
        Users user = (Users) query.uniqueResult();

        return user;
    }

    @Override
    public boolean changepwd(String s, String newpwd) {

        String hql = "update Users u set u.uPwd=:pwd where u.uPhone=:phone";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("pwd", newpwd);
        query.setParameter("phone", s);

        int i = query.executeUpdate();

        if (i > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean update(Users user) {

        try {
            sessionFactory.getCurrentSession().update(user);
            return true;
        } catch (Exception e) {
            System.out.println("更新用户信息失败!");
            return false;
        }

    }

    @Override
    public boolean updateinfo(UsersInfo usersInfo) {
        try {
            sessionFactory.getCurrentSession().update(usersInfo);
            return true;
        } catch (Exception e) {
            System.out.println("更新融资者信息失败!");
            return false;
        }
    }


}
