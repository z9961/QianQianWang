package com.niit.dao.impl;

import com.niit.dao.IUsersAddressDao;
import com.niit.entity.UsersAddress;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
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
        String hql = "from UsersAddress where UPhone=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0, Phone);

        //这里的user在没有对应的数据时为NULL
        return query.list();
    }
}
