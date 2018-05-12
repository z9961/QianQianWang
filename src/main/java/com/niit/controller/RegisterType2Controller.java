package com.niit.controller;

import com.niit.biz.IUserBiz;
import com.niit.entity.Users;
import com.niit.entity.UsersInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by XRog
 * On 2/1/2017.12:36 AM
 */
@Controller
public class RegisterType2Controller {

    @Autowired
    private IUserBiz userBiz;

    @RequestMapping(value = "RegisterType2.mvc", method = RequestMethod.POST)
    public String Register(HttpServletRequest req, ModelMap map, String UName, String UZipCode, String UEmail, String UCardNumber) {
        System.out.println("-------------------------------------------------------");
        System.out.println("RegisterType2");
        Users user = (Users) req.getSession().getAttribute("registeruser");
        String UPhone = null;
        try {
            UPhone = user.getuPhone();
        } catch (Exception e) {
            map.addAttribute("url", "lrf.jsp");
            map.addAttribute("msg", "注册失败!");
            return "msg.jsp";
        }

        UsersInfo userinfo = new UsersInfo();
        userinfo.setuZipCode(UZipCode);
        userinfo.setuCardNumber(UCardNumber);
        userinfo.setuEmail(UEmail);
        userinfo.setuName(UName);
        userinfo.setuPhone(UPhone);

        //尝试保存用户到数据库
        String result = userBiz.RegisterUser(user, userinfo);

        if (result == "ok") {
            System.out.println("注册成功");
            map.addAttribute("url", "lrf.jsp");
            map.addAttribute("msg", "注册成功!");
            return "msg.jsp";
        } else if (result == "error") {
            map.addAttribute("url", "lrf.jsp");
            map.addAttribute("msg", "注册失败!");
            return "msg.jsp";
        } else {
            map.addAttribute("url", "lrf.jsp");
            map.addAttribute("msg", "注册失败!");
            return "msg.jsp";
        }

    }
}