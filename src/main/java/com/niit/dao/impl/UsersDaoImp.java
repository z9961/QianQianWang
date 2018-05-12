package com.niit.dao.impl;

import com.niit.dao.IUsersDao;
import com.niit.entity.Users;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public Users findByPhone(String phone) {
        System.out.println("Dao");
        System.out.println("phone = " + phone);

        String hql = "from Users where uPhone=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter(0, phone);


        //这里的返回值可能为NULL
        //  return (Users) query.uniqueResult();
        System.out.println("================================================");
        System.out.println(sessionFactory.hashCode());
        System.out.println(sessionFactory.openSession().hashCode());
        System.out.println("================================================");
      /*  System.out.println(hibernateTemplate);
        System.out.println(hibernateTemplate.hashCode());
        System.out.println("================================================");
        Users user = hibernateTemplate.load(Users.class, 1);
        System.out.println("user = " + user.toString());*/

        return new Users();
    }

    @Override
    public Users findById(String Uid) {
        return null;
    }


}
