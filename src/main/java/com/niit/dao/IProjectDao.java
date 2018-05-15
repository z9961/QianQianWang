package com.niit.dao;

import com.niit.entity.Project;
import com.niit.entity.Users;

import java.util.List;

public interface IProjectDao {
    List<Project> findHotProject();

    List<Project> findNewProject();

    List<Project> findProject1();

    List<Project> findProject2();

    List<Project> findProject3();

    int save(Project project);

    Project findProjectById(int pid);

    boolean saveimg(int pid, List<String> listImagePath);

    boolean savecom(Project p, Users u, String newcom);
}
