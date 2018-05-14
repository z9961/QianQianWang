package com.niit.biz.impl;

import com.niit.biz.IProjectBiz;
import com.niit.dao.IProjectDao;
import com.niit.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IProjectBizImp implements IProjectBiz {

    @Autowired
    private IProjectDao projectDao;


    @Override
    public List<Project> findHotProject() {
        return projectDao.findHotProject();
    }

    @Override
    public List<Project> findNewProject() {
        return projectDao.findNewProject();
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

}
