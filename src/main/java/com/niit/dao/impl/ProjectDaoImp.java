package com.niit.dao.impl;

import com.niit.dao.IProjectDao;
import com.niit.entity.Project;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ProjectDaoImp implements IProjectDao {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Project> findHotProject() {
        String hql = "from Project order by pnm desc";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setMaxResults(5);
        //这里的user在没有对应的数据时为NULL
        return query.list();
    }

    @Override
    public List<Project> findNewProject() {
        String hql = "from Project order by psd desc";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setMaxResults(5);
        //这里的user在没有对应的数据时为NULL
        return query.list();
    }

    @Override
    public List<Project> findProject1() {
        String hql = "from Project where projectTypeByPCategoryId.projectTypeId = 1";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setMaxResults(5);
        //这里的user在没有对应的数据时为NULL
        return query.list();
    }

    @Override
    public List<Project> findProject2() {
        String hql = "from Project where projectTypeByPCategoryId.projectTypeId = 2";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setMaxResults(5);
        //这里的user在没有对应的数据时为NULL
        return query.list();
    }

    @Override
    public List<Project> findProject3() {
        String hql = "from Project where projectTypeByPCategoryId.projectTypeId = 3";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setMaxResults(5);
        //这里的user在没有对应的数据时为NULL
        return query.list();
    }
}
