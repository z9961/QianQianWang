package com.niit.controller;

import com.niit.biz.IProjectBiz;
import com.niit.entity.Orders;
import com.niit.entity.Project;
import com.niit.entity.ProjectComment;
import com.niit.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Controller
public class ManageController {
    @Autowired
    private IProjectBiz projectBiz;

    @RequestMapping(value = "manage.mvc", method = RequestMethod.POST)
    public String manage(ModelMap map, HttpSession session) {
        Users user = (Users) session.getAttribute("user");

        Collection<Orders> ordersByUPhone = user.getOrdersByUPhone();
        List<Project> myprojects = new ArrayList<Project>();
        for (Iterator<Project> iterator = myprojects.iterator(); iterator.hasNext(); ) {
            Project next = iterator.next();
            myprojects.add(next);
        }

        List<Project> mynewprojects = new ArrayList<Project>();
        Collection<Project> projectsByUPhone = user.getProjectsByUPhone();
        for (Iterator<Project> iterator = projectsByUPhone.iterator(); iterator.hasNext(); ) {
            Project next = iterator.next();
            mynewprojects.add(next);
        }

        List<ProjectComment> mycomments = new ArrayList<>();
        Collection<ProjectComment> projectCommentsByUPhone = user.getProjectCommentsByUPhone();
        for (Iterator<ProjectComment> iterator = projectCommentsByUPhone.iterator(); iterator.hasNext(); ) {
            ProjectComment next = iterator.next();
            mycomments.add(next);
        }

        map.addAttribute("myprojects", myprojects);
        map.addAttribute("mynewprojects", myprojects);
        map.addAttribute("mycomments", myprojects);


        return "manage.jsp";
    }


}
