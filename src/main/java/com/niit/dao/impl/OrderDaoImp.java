package com.niit.dao.impl;

import com.niit.dao.IOrderDao;
import com.niit.entity.Orders;
import com.niit.entity.Project;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
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


        BigDecimal pnm = p.getPnm().add(o.getMoney());
        p.setPnm(pnm);
        p.setPnp(p.getPnp() + 1);
        Timestamp tnow = new Timestamp(new Date().getTime());

        if (p.getPed().after(tnow)) {
            p.setpState(0);
        } else {
            p.setpState(1);
        }
        if (tnow.after(p.getPed())) {
            if (pnm == p.getpTarget())
                p.setpState(2);
            else
                p.setpState(3);
        }

        try {
            sessionFactory.getCurrentSession().update(p);
            return true;
        } catch (Exception e) {
            return false;
        }
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
