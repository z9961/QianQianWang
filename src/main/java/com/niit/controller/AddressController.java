package com.niit.controller;

import com.niit.biz.IUserBiz;
import com.niit.entity.Users;
import com.niit.entity.UsersAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AddressController {
    @Autowired
    private IUserBiz userBiz;

    @RequestMapping(value = "GetAddress.mvc", method = RequestMethod.GET)
    public String GetAddress(HttpServletRequest req, ModelMap map) {
        System.out.println("获取全部地址");
        Users user = (Users) req.getSession().getAttribute("user");
        List<UsersAddress> list = userBiz.findAllAddress(user.getuPhone());
        System.out.println("list = " + list.size());
        System.out.println("list = " + list.get(0).toString());
        map.addAttribute("addr", list);
        return "address.jsp";
    }


    @RequestMapping(value = "AddAddress.mvc", method = RequestMethod.POST)
    public String AddAdress(String address, HttpServletRequest req, ModelMap map) {
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
        return "msg.jsp";
    }

}
