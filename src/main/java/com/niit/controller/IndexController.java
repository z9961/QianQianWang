package com.niit.controller;

import com.niit.biz.IProjectBiz;
import com.niit.entity.Project;
import com.niit.entity.ProjectImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


/**
 * Created by XRog
 * On 2/1/2017.12:36 AM
 */
@Controller
public class IndexController {
    @Autowired
    private IProjectBiz projectBiz;

    @RequestMapping(value = "Index.mvc")
    public String findproject(ModelMap map, HttpSession session) {
        List<Project> hot = projectBiz.findHotProject();
        List<Project> newp = projectBiz.findNewProject();
        List<Project> p1 = projectBiz.findProject1();
        List<Project> p2 = projectBiz.findProject2();
        List<Project> p3 = projectBiz.findProject3();

        map.addAttribute("ihot", hot);
        map.addAttribute("inewp", newp);
        map.addAttribute("ip1", p1);
        map.addAttribute("ip2", p2);
        map.addAttribute("ip3", p3);

        List<ProjectImg> hotimglist = new ArrayList<>();
        List<ProjectImg> hotimglisttemp = null;
        for (int i = 0; i < hot.size(); i++) {
            Project project = hot.get(i);
            Collection<ProjectImg> projectImgsByPId = project.getProjectImgsByPId();
            for (Iterator<ProjectImg> iterator = projectImgsByPId.iterator(); iterator.hasNext(); ) {
                ProjectImg next = iterator.next();
                hotimglisttemp = new ArrayList<>();
                hotimglisttemp.add(next);
            }
            hotimglist.add(hotimglisttemp.get(0));

        }
        session.setAttribute("hotimglist", hotimglist);
        for (int i = 0; i < hotimglist.size(); i++) {
            ProjectImg projectImg = hotimglist.get(i);
            System.out.println("projectImg = " + projectImg.getImgPath());
        }

        session.setAttribute("hot", hot);

        return "index.jsp";
    }


}