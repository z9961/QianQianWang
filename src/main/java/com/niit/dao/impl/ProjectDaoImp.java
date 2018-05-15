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
        List<Project> list = query.list();
        for (int i = 0; i < list.size(); i++) {
            Project project = list.get(i);
            System.out.println("dao:hotproject = " + project.toString());
        }
        return list;
    }

    @Override
    public List<Project> findNewProject() {
        String hql = "from Project order by psd desc";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setMaxResults(5);
        List<Project> list = query.list();
        for (int i = 0; i < list.size(); i++) {
            Project project = list.get(i);
            System.out.println("dao:newproject = " + project.toString());
        }
        return list;
    }

    @Override
    public List<Project> findProject1() {
        String hql = "from Project where projectTypeByPCategoryId.projectTypeId = 1";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setMaxResults(5);
        List<Project> list = query.list();
        for (int i = 0; i < list.size(); i++) {
            Project project = list.get(i);
            System.out.println("dao:p1project = " + project.toString());
        }
        return list;
    }

    @Override
    public List<Project> findProject2() {
        String hql = "from Project where projectTypeByPCategoryId.projectTypeId = 2";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setMaxResults(5);
        List<Project> list = query.list();
        for (int i = 0; i < list.size(); i++) {
            Project project = list.get(i);
            System.out.println("dao:p2project = " + project.toString());
        }
        return list;
    }

    @Override
    public List<Project> findProject3() {
        String hql = "from Project where projectTypeByPCategoryId.projectTypeId = 3";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setMaxResults(5);

        List<Project> list = query.list();
        for (int i = 0; i < list.size(); i++) {
            Project project = list.get(i);
            System.out.println("dao:p3project = " + project.toString());
        }
        return list;
    }

    @Override
    public int save(Project project) {
        try {
            System.out.println("project = " + project.toString());
            sessionFactory.getCurrentSession().save(project);
            return project.getpId();
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public Project findProjectById(int pid) {
        String hql = "from Project where pId = :pid";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("pid", pid);

        Project project = (Project) query.uniqueResult();

        return project;
    }
}
