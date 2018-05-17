package com.niit.biz.impl;

import com.niit.biz.IProjectBiz;
import com.niit.dao.IOrderDao;
import com.niit.dao.IProjectDao;
import com.niit.entity.Orders;
import com.niit.entity.Project;
import com.niit.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IProjectBizImp implements IProjectBiz {

    @Autowired
    private IProjectDao projectDao;


    @Autowired
    private IOrderDao iOrderDao;


    @Override
    public List<Project> findHotProject() {
        return projectDao.findHotProject();
    }

    @Override
    public List<Project> findNewProject() {
        return projectDao.findNewProject();
    }

    @Override
    public List<Project> findMostProject() {
        return projectDao.findMostProject();
    }

    @Override
    public boolean saveorder(Orders o) {
        return iOrderDao.saveorder(o);
    }

    @Override
    public List<Project> findProjectBySearch(String searchstr) {
        return projectDao.findProjectBySearch(searchstr);
    }

    @Override
    public List<Project> findProject1() {
        return projectDao.findProject1();
    }

    @Override
    public List<Project> findProject2() {
        return projectDao.findProject2();
    }

    @Override
    public List<Project> findProject3() {
        return projectDao.findProject3();
    }

    @Override
    public int save(Project project) {
        return projectDao.save(project);
    }

    @Override
    public Project findProjectById(int pid) {
        return projectDao.findProjectById(pid);
    }

    @Override
    public boolean saveimg(int pid, List<String> listImagePath) {
        return projectDao.saveimg(pid, listImagePath);
    }

    @Override
    public boolean savecom(Project p, Users u, String newcom) {
        return projectDao.savecom(p, u, newcom);
    }


}
