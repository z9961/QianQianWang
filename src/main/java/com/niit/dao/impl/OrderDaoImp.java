package com.niit.dao.impl;

import com.niit.dao.IOrderDao;
import com.niit.entity.Orders;
import com.niit.entity.Project;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class OrderDaoImp implements IOrderDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public boolean saveorder(Orders o) {
        int max = 0;
        try {
            max = (int) sessionFactory.getCurrentSession().createQuery("select max(a.orderId) from Orders a ").uniqueResult();
        } catch (Exception e) {
            System.out.println("pmax=0");
        }
        max++;
        o.setOrderId(max);
        sessionFactory.getCurrentSession().save(o);

        Project p = o.getProjectByPId();
        String hql = "update Project p set p.pnp=p.pnp+1,p.pnm =:pnm where pId=:pid";

        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        BigDecimal pnm = p.getPnm().add(o.getMoney());
        query.setParameter("pnm", pnm);
        query.setParameter("pid", p.getpId());

        query.executeUpdate();


        return true;
    }

    @Override
    public List<Orders> findAllOrder(String s) {
        String hql = "from Orders where usersByUPhone.uPhone=:uphone";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("uphone", s);
        return query.list();
    }

    @Override
    public List<Orders> findOrderByPid(int pid) {
        String hql = "from Orders where projectByPId.pId=:pid";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("pid", pid);
        return query.list();
    }
}
