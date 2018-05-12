package com.niit.controller;

import com.niit.biz.IUserBiz;
import com.niit.entity.Users;
import com.niit.entity.UsersAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

public class AddressController {
    @Autowired
    private IUserBiz userBiz;

    @RequestMapping(value = "GetAddress.mvc", method = RequestMethod.GET)
    public String Login(HttpServletRequest req, ModelMap map) {
        System.out.println("获取全部地址");
        Users user = (Users) req.getSession().getAttribute("user");
        Collection<UsersAddress> addr = user.getUsersAddressesByUPhone();
        map.addAttribute("addr", addr);
        return "address.jsp";
    }
}
