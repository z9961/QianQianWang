package com.niit.biz;

import com.niit.entity.Orders;
import com.niit.entity.Project;
import com.niit.entity.ProjectImg;
import com.niit.entity.Users;

import java.util.List;

public interface IProjectBiz {

    //最热的项目
    List<Project> findHotProject();

    //最新的项目
    List<Project> findNewProject();

    //数码
    List<Project> findProject1();

    //生活
    List<Project> findProject2();

    //艺术
    List<Project> findProject3();

    //添加项目
    int save(Project project);

    //根据id找项目
    Project findProjectById(int pid);

    //保存图片
    boolean saveimg(int pid, List<String> listImagePath);

    //添加评论
    boolean savecom(Project p, Users u, String newcom);

    //最多人支持的项目
    List<Project> findMostProject();

    //添加订单
    boolean saveorder(Orders o);

    //自定义搜索
    List<Project> findProjectBySearch(String searchstr);

    //更新项目
    boolean update(Project project);

    //项目总数
    int countproject();

    //总支持人数
    int supportnum();

    //完成的项目数
    int countokpro();

    List<ProjectImg> findimg(int pid);

    List<ProjectImg> findhotimg();
}
