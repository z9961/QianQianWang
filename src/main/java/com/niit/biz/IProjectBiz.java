package com.niit.biz;

import com.niit.entity.Project;

import java.util.List;

public interface IProjectBiz {

    List<Project> findHotProject();

    List<Project> findNewProject();

    List<Project> findProject1();

    List<Project> findProject2();

    List<Project> findProject3();

}
