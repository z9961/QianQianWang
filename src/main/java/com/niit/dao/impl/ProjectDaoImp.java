package com.niit.dao.impl;

import com.niit.dao.IProjectDao;
import com.niit.entity.Project;
import com.niit.entity.ProjectComment;
import com.niit.entity.ProjectImg;
import com.niit.entity.Users;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
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
//        query.setMaxResults(5);
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
//        query.setMaxResults(5);
        List<Project> list = query.list();
        for (int i = 0; i < list.size(); i++) {
            Project project = list.get(i);
            System.out.println("dao:newproject = " + project.toString());
        }
        return list;
    }

    @Override
    public List<Project> findMostProject() {
        String hql = "from Project order by pnp desc";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
//        query.setMaxResults(5);
        List<Project> list = query.list();
        for (int i = 0; i < list.size(); i++) {
            Project project = list.get(i);
            System.out.println("dao:findMostProject = " + project.toString());
        }
        return list;
    }

    @Override
    public List<Project> findProjectBySearch(String searchstr) {
        String hql = "from Project where pName like :pname";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("pname", "%" + searchstr + "%");
        List<Project> list = query.list();
        for (int i = 0; i < list.size(); i++) {
            Project project = list.get(i);
            System.out.println("dao:searchstr = " + project.toString());
        }
        return list;
    }

    @Override
    public List<Project> findAllUserProject(String s) {
        String hql = "from Project where usersByUPhone.uPhone =:phone";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("phone", s);
        return query.list();

    }

    @Override
    public List<ProjectComment> findAllUserProjectComment(String s) {
        String hql = "from ProjectComment where usersByUPhone.uPhone=:phone";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("phone", s);
        return query.list();
    }

    @Override
    public boolean update(Project project) {
        try {
            sessionFactory.getCurrentSession().update(project);
            return true;
        } catch (Exception e) {
            System.out.println("更新用户信息失败!");
            return false;
        }
    }

    @Override
    public int countproject() {
        String hql = "select count(*) from Project";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        int numint = 0;
        try {
            long num = (long) query.uniqueResult();
            numint = Integer.parseInt(Long.toString(num));
        } catch (Exception e) {
            numint = 0;
        }
        return numint;
    }

    @Override
    public int supportnum() {
        int numint = 0;
        try {
            String hql = "select count(*) from Orders group by usersByUPhone.uPhone";
            Query query = sessionFactory.getCurrentSession().createQuery(hql);
            long num = (long) query.uniqueResult();
            numint = Integer.parseInt(Long.toString(num));
        } catch (Exception e) {
            numint = 0;
        }

        return numint;
    }

    @Override
    public int countokpro() {
        String hql = "select count(*) from Project where pState=3";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        int numint = 0;
        try {
            long num = (long) query.uniqueResult();
            numint = Integer.parseInt(Long.toString(num));
        } catch (Exception e) {
            numint = 0;
        }
        return numint;
    }

    @Override
    public List<ProjectImg> findimg(int pid) {
        String hql = "from ProjectImg where projectByPid.pId=:pid order by imgId";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("pid", pid);
        return query.list();
    }

    @Override
    public List<ProjectImg> findhotimg() {
        String hql = "from ProjectImg a where a.imgPath = (select min(imgPath) from ProjectImg where projectByPid.pId = a.projectByPid.pId) order by a.projectByPid.pId";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List<Project> findProject1() {
        String hql = "from Project where projectTypeByPCategoryId.projectTypeId = 1";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
//        query.setMaxResults(5);
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
//        query.setMaxResults(5);
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
//        query.setMaxResults(5);

        List<Project> list = query.list();
        for (int i = 0; i < list.size(); i++) {
            Project project = list.get(i);
            System.out.println("dao:p3project = " + project.toString());
        }
        return list;
    }

    @Override
    public int save(Project project) {
        System.out.println("保存项目到数据库========================================");
        int max = 0;
        try {
            max = (int) sessionFactory.getCurrentSession().createQuery("select max(a.pId) from Project a ").uniqueResult();
        } catch (Exception e) {
            System.out.println("pmax=0");
        }
        project.setpId(max + 1);
        System.out.println("max = " + max + 1);
        System.out.println("project = " + project.toString());
        sessionFactory.getCurrentSession().save(project);
        return project.getpId();
    }

    @Override
    public Project findProjectById(int pid) {
        String hql = "from Project where pId = :pid";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("pid", pid);

        Project project = (Project) query.uniqueResult();

        return project;
    }

    @Override
    public boolean saveimg(int pid, List<String> listImagePath) {
        int max = 0;

        for (String s : listImagePath) {
            try {
                max = (int) sessionFactory.getCurrentSession().createQuery("select max(a.imgId) from ProjectImg a ").uniqueResult();

            } catch (Exception e) {
                max = 0;
            }
            ProjectImg projectImg = new ProjectImg();
            Project project = new Project();
            project.setpId(pid);
            projectImg.setProjectByPid(project);
            projectImg.setImgPath(s);
            projectImg.setImgId(max + 1);
            sessionFactory.getCurrentSession().save(projectImg);
        }
        return true;
    }

    @Override
    public boolean savecom(Project p, Users u, String newcom) {

        int max = 0;
        try {
            max = (int) sessionFactory.getCurrentSession().createQuery("select max(a.pcId) from ProjectComment a ").uniqueResult();
        } catch (Exception e) {
            System.out.println("pmax=0");
        }
        max++;
        ProjectComment projectComment = new ProjectComment();
        projectComment.setpComment(newcom);
        projectComment.setPcTime(new Timestamp(new Date().getTime()));
        projectComment.setProjectByCPid(p);
        projectComment.setUsersByUPhone(u);
        projectComment.setPcId(max);
        sessionFactory.getCurrentSession().save(projectComment);
        return true;
    }


}
