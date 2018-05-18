package com.niit.controller;

import com.niit.biz.IProjectBiz;
import com.niit.biz.IUserBiz;
import com.niit.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Controller
public class ManageController {
    @Autowired
    private IUserBiz userBiz;

    @Autowired
    private IProjectBiz projectBiz;


    @RequestMapping(value = "/Manage.mvc")
    public String manage(ModelMap map, HttpSession session) {
        System.out.println("Manage.mvc");
        Users user = (Users) session.getAttribute("user");

        String uphone = user.getuPhone();
        System.out.println("uphone = " + uphone);


        Collection<Orders> ordersByUPhone = user.getOrdersByUPhone();
        List<Orders> myorders = new ArrayList<Orders>();
        for (Iterator<Orders> iterator = ordersByUPhone.iterator(); iterator.hasNext(); ) {
            Orders next = iterator.next();
            myorders.add(next);
        }


        Collection<Project> projectsByUPhone = user.getProjectsByUPhone();
        List<Project> mynewprojects = new ArrayList<Project>();
        for (Iterator<Project> iterator = projectsByUPhone.iterator(); iterator.hasNext(); ) {
            Project next = iterator.next();
            System.out.println("next = " + next);
            mynewprojects.add(next);
        }


        Collection<ProjectComment> projectCommentsByUPhone = user.getProjectCommentsByUPhone();
        List<ProjectComment> mycomments = new ArrayList<>();
        for (Iterator<ProjectComment> iterator = projectCommentsByUPhone.iterator(); iterator.hasNext(); ) {
            ProjectComment next = iterator.next();
            mycomments.add(next);
        }

        map.addAttribute("myprojects", myorders);
        map.addAttribute("mynewprojects", mynewprojects);
        map.addAttribute("mycomments", mycomments);


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


        if (isok) {
            map.addAttribute("msg", "修改信息成功");
            map.addAttribute("url", "Checkout.mvc");
        } else {
            map.addAttribute("msg", "修改信息失败");
            map.addAttribute("url", "manage_person.jsp");
        }

        return "msg.jsp";
    }
}
