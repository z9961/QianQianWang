package com.niit.controller;

import com.niit.biz.IUserBiz;
import com.niit.entity.Users;
import com.niit.entity.UsersAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AddressController {
    @Autowired
    private IUserBiz userBiz;

    @RequestMapping(value = "GetAddress.mvc")
    public String GetAddress(HttpServletRequest req, ModelMap map) {
        System.out.println("获取全部地址");
        Users user = (Users) req.getSession().getAttribute("user");
        List<UsersAddress> list = userBiz.findAllAddress(user.getuPhone());
        System.out.println("list = " + list.size());
        map.addAttribute("addr", list);
        map.addAttribute("getaddrok", 1);
        return "address.jsp";
    }


    @RequestMapping(value = "AddAddress.mvc")
    public String AddAdress(HttpSession session, String address, HttpServletRequest req, ModelMap map) {
        System.out.println("添加地址");
        Users user = (Users) req.getSession().getAttribute("user");
        UsersAddress addr = new UsersAddress();
        addr.setAddress(address);
        addr.setUsersByAUPhone(user);

        boolean isok = userBiz.saveAddress(addr);
        if (isok) {
            map.addAttribute("msg", "添加地址成功");
        } else {
            map.addAttribute("msg", "添加地址失败");
        }
        map.addAttribute("url", "address.jsp");

        List<UsersAddress> list = userBiz.findAllAddress(user.getuPhone());
        System.out.println("list = " + list.size());
        session.setAttribute("addr", list);
        return "msg.jsp";
    }

    @RequestMapping(value = "DeleteAddress.mvc")
    public String DeleteAddress(ModelMap map, int aid) {

        boolean isok = userBiz.deleteAddress(aid);
        if (isok) {
            map.addAttribute("existaddrmsg", "false");
        } else {
            map.addAttribute("existaddrmsg", "true");
            map.addAttribute("addrmsg", "地址正在使用,不能删除");
            return "manage_address.jsp";
        }

        return "GetAddress.mvc";
    }
}
