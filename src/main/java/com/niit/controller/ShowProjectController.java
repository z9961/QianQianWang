package com.niit.controller;

import com.niit.biz.IProjectBiz;
import com.niit.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * Created by XRog
 * On 2/1/2017.12:36 AM
 */
@Controller
public class ShowProjectController {
    @Autowired
    private IProjectBiz projectBiz;

    @RequestMapping(value = "ShowProject.mvc/{pid}", method = RequestMethod.GET)
    public String project(ModelMap map, @PathVariable("pid") int pid) {
        Project project = projectBiz.findProjectById(pid);
        String pname = project.getpName();
        BigDecimal pnm = project.getPnm();
        int pnp = project.getPnp();
        Timestamp deadline = project.getPed();
        BigDecimal ptarget = project.getpTarget();
        String percentage = ((pnm.intValue() / ptarget.intValue()) * 100) + "%";
        Timestamp time = new Timestamp(System.currentTimeMillis());
        int last;

        return "project.jsp";
    }


}