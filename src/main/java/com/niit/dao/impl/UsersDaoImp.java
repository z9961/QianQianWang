package com.niit.dao.impl;

import com.niit.dao.IUsersDao;
import com.niit.entity.Users;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UsersDaoImp implements IUsersDao {

   /* @Resource
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }*/

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


}