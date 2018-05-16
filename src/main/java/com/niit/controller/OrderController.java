package com.niit.controller;

import com.niit.biz.IProjectBiz;
import com.niit.entity.Orders;
import com.niit.entity.Project;
import com.niit.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class OrderController {

    @Autowired
    private IProjectBiz projectBiz;

    @RequestMapping(value = "AddOrder.mvc", method = RequestMethod.POST)
    public String AddOrder(ModelMap map, HttpSession session,
                           String ordernum, String oexpect, String oexpectType,
                           String oexpectOther) {

        Project p = (Project) session.getAttribute("showproject");
        Users u = (Users) session.getAttribute("user");
        Orders o = new Orders();
        o.setUsersByUPhone(u);
        o.setpId(p.getpId());


        return "msg.jsp";
    }
}