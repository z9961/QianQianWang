package com.niit.controller;

import com.niit.biz.IProjectBiz;
import com.niit.biz.IUserBiz;
import com.niit.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ManageController {
    @Autowired
    private IUserBiz userBiz;

    @Autowired
    private IProjectBiz projectBiz;


    @RequestMapping(value = "Manage.mvc")
    public String manage(ModelMap map, HttpSession session) {
        System.out.println("Manage.mvc");
        Users user = (Users) session.getAttribute("user");

        String uphone = user.getuPhone();
        System.out.println("uphone = " + uphone);


        List<Orders> myorders = userBiz.findAllOrder(user.getuPhone());
        System.out.println("myorders = " + myorders.size());
        List<Project> mynewprojects = userBiz.findAllUserProject(user.getuPhone());
        System.out.println("myorders = " + myorders.size());
        List<ProjectComment> mycomments = userBiz.findAllUserProjectComment(user.getuPhone());
        System.out.println("myorders = " + myorders.size());


        session.setAttribute("myorders", myorders);
        session.setAttribute("mynewprojects", mynewprojects);
        session.setAttribute("mycomments", mycomments);


        return "manage.jsp";
    }

    @RequestMapping(value = "Changepwd.mvc")
    public String manage(ModelMap map, HttpSession session, String nowpwd, String newpwd, String newpwd2) {
        if (nowpwd == null || nowpwd == "" || newpwd == null || newpwd == "" || newpwd2 == null || newpwd2 == "") {
            map.addAttribute("msg", "请输入密码");
            map.addAttribute("url", "manage_person.jsp");
            return "msg.jsp";
        }
        Users user = (Users) session.getAttribute("user");
        String pwd = user.getuPwd();
        if (newpwd.equals(newpwd2) && pwd.equals(nowpwd)) {
            boolean isok = userBiz.changepwd(user.getuPhone(), newpwd);
            if (isok) {
                map.addAttribute("msg", "修改密码成功");
                map.addAttribute("url", "Checkout.mvc");
            } else {
                map.addAttribute("msg", "修改密码失败");
                map.addAttribute("url", "manage_person.jsp");
            }
        } else {
            map.addAttribute("msg", "密码不一致");
            map.addAttribute("url", "manage_person.jsp");
        }
        return "msg.jsp";
    }

    @RequestMapping(value = "Changeinfo.mvc")
    public String Changeinfo(ModelMap map, HttpSession session, String uName,
                             String uZipCode, String uEmail) {

        Users user = (Users) session.getAttribute("user");
        int type = user.getuType();
        user.setuName(uName);
        boolean isok = userBiz.update(user);
        if (isok && (type == 2)) {
            UsersInfo usersInfo = user.getUsersInfoByUPhone();
            usersInfo.setuEmail(uEmail);
            usersInfo.setuZipCode(uZipCode);
            isok = userBiz.updateinfo(usersInfo);
        }

        map.addAttribute("url", "manage_person.jsp");
        if (isok) {
            map.addAttribute("msg", "修改信息成功");
        } else {
            map.addAttribute("msg", "修改信息失败");

        }

        return "msg.jsp";
    }

    @RequestMapping(value = "ProjectDetails.mvc")
    public String ProjectDetails(ModelMap map, HttpSession session, String pid) {

        Project p = projectBiz.findProjectById(Integer.parseInt(pid));
        List<Orders> ordersList = userBiz.findOrderByPid(Integer.parseInt(pid));

        session.setAttribute("ProjectDetails", p);
        session.setAttribute("ProjectDetailsOrders", ordersList);


        return "manage_myprojectdetails.jsp";
    }

}
