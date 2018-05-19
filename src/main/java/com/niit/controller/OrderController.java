package com.niit.controller;

import com.niit.biz.IProjectBiz;
import com.niit.entity.Orders;
import com.niit.entity.Project;
import com.niit.entity.Users;
import com.niit.entity.UsersAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Controller
public class OrderController {

    @Autowired
    private IProjectBiz projectBiz;

    @RequestMapping(value = "AddOrder.mvc", method = RequestMethod.POST)
    public String AddOrder(ModelMap map, HttpSession session,
                           String ordernum, String oexpect, String oexpectType,
                           String oexpectOther, String oaid) {

        Project p = (Project) session.getAttribute("showproject");

        Users u = (Users) session.getAttribute("user");
        Orders o = new Orders();
        o.setUsersByUPhone(u);
        o.setProjectByPId(p);
        o.setOrderDate(new Timestamp(System.currentTimeMillis()));
        BigDecimal money = BigDecimal.valueOf(Long.parseLong(ordernum));
        o.setMoney(money);
        int type = Integer.parseInt(oexpect);
        o.setExpect(type);
        boolean isok;

        //判断是否限额
        if (p.getpLimit() == 1) {
            BigDecimal now = p.getPnm();
            BigDecimal target = p.getpTarget();
            if ((now.add(money)).compareTo(target) > 0) {
                map.addAttribute("msg", "支持的金额大于剩余金额");
                map.addAttribute("url", "ShowProject.mvc?pid=" + p.getpId());
                return "msg.jsp";
            }
        }


        if (type == 1) {
            UsersAddress ua = new UsersAddress();
            ua.setaId(Integer.parseInt(oaid));
            o.setUsersAddressByAId(ua);
            int oexpectTypeint = Integer.parseInt(oexpectType);
            o.setExpectType(oexpectTypeint);
            if (oexpectTypeint == 4) {
                o.setExceptOther(oexpectOther);
            }
            isok = projectBiz.saveorder(o);
        } else {
            //不需要回报
            o.setExpectType(-1);
            isok = projectBiz.saveorder(o);
        }

        if (isok) {
            map.addAttribute("msg", "支持成功");
            map.addAttribute("url", "Manage.mvc");
        } else {
            map.addAttribute("msg", "支持失败");
            map.addAttribute("url", "ShowProject.mvc?pid=" + p.getpId());
        }
        return "msg.jsp";
    }
}