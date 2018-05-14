package com.niit.controller;

import com.niit.biz.IProjectBiz;
import com.niit.entity.Project;
import com.niit.entity.ProjectType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

@Controller
public class ProjectController {
    @Autowired
    private IProjectBiz projectBiz;

    @RequestMapping(value = "AddProject", method = RequestMethod.POST)
    public String AddProject(ModelMap map, HttpSession session, String PName, String PDesc, String PED, String PTarget, String
            PMilestone, String PCategoryId, String PRemark, String PMF, String PLimit, String PTeam, String PPlan) throws ParseException {
        Timestamp tss = new Timestamp(new Date().getTime());
        Timestamp tse = Timestamp.valueOf(PED);
        int plimit = Integer.parseInt(PLimit);
        int ppid = Integer.parseInt(PCategoryId);
        int pmf = Integer.parseInt(PMF);
        BigDecimal pt = BigDecimal.valueOf(Long.parseLong(PTarget));
        BigDecimal pnm = BigDecimal.valueOf(0);
        ProjectType projectType = new ProjectType();
        projectType.setProjectTypeId(ppid);
        Project project = new Project(PName, PDesc, tss, tse, pt, pnm, 0, PMilestone, PRemark, pmf, plimit, PTeam, 0, PPlan, projectType);

        System.out.println("project = " + project.toString());


        int isok = projectBiz.save(project);
        if (isok >= 0) {
            session.setAttribute("addprojectid", isok);
            map.addAttribute("msg", "添加地址成功,请上传图片");
            map.addAttribute("url", "upload.jsp");
        } else {
            map.addAttribute("msg", "添加地址失败");
            map.addAttribute("url", "addproject.jsp");
        }

        return "msg.jsp";
    }

}
