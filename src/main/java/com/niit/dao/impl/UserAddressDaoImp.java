package com.niit.dao.impl;

import com.niit.dao.IUsersAddressDao;
import com.niit.entity.UsersAddress;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Repository
public class UserAddressDaoImp implements IUsersAddressDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<UsersAddress> findAllAddress(String Phone) {
        String hql = "from UsersAddress where usersByAUPhone.uPhone=:phone";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("phone", Phone);

        //这里的user在没有对应的数据时为NULL
        return query.list();
    }

    @Override
    public boolean save(UsersAddress addr) {

        int max = 0;
        try {
            max = (int) sessionFactory.getCurrentSession().createQuery("select max(a.pcId) from ProjectComment a ").uniqueResult();
        } catch (Exception e) {
            System.out.println("pmax=0");
        }
        max++;
        addr.setaId(max);

        try {
            Serializable serializable = sessionFactory.getCurrentSession().save(addr);
            if (serializable != null)
                return true;
            else
                return false;

        } catch (HibernateException e) {
            return false;
        }

    }
}
