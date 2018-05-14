package com.niit.controller;

import com.niit.biz.IProjectBiz;
import com.niit.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * Created by XRog
 * On 2/1/2017.12:36 AM
 */
@Controller
public class IndexController {
    @Autowired
    private IProjectBiz projectBiz;

    @RequestMapping(value = "Index.mvc", method = RequestMethod.GET)
    public String findproject(ModelMap map) {
        List<Project> hot = projectBiz.findHotProject();
        List<Project> newp = projectBiz.findNewProject();
        List<Project> p1 = projectBiz.findProject1();
        List<Project> p2 = projectBiz.findProject2();
        List<Project> p3 = projectBiz.findProject3();

        map.addAttribute("hot", hot);
        map.addAttribute("new", newp);
        map.addAttribute("p1", hot);
        map.addAttribute("p2", hot);
        map.addAttribute("p3", hot);
        System.out.println("getIndexData======================================");
        System.out.println("hot = " + hot.size());
        System.out.println("hot = " + hot.toString());
        for (int i = 0; i < hot.size(); i++) {
            Project project = hot.get(i);
            System.out.println("project = " + project.toString());
        }

        hot.get(0).getProjectImgsByPId()

        return "index.jsp";
    }


}