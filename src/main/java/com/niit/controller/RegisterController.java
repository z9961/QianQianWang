package com.niit.controller;

import com.niit.biz.IUserBiz;
import com.niit.entity.Users;
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
public class RegisterController {

    @Autowired
    private IUserBiz userBiz;

    @RequestMapping(value = "Register.mvc", method = RequestMethod.POST)
    public String Register(HttpServletRequest req, ModelMap map, String UName, String newpassword, String phone, String sms, String UType) {
        System.out.println("Register");
        System.out.println("UName = " + UName);
        System.out.println("newpassword = " + newpassword);
        System.out.println("phone = " + phone);
        System.out.println("sms = " + sms);
        System.out.println("UType = " + UType);

        if (userBiz.findByPhone(phone)) {
            map.addAttribute("registermsg", "手机号已存在!");
            System.out.println("手机号已存在!");
            return "lrf.jsp";
        } else {
            System.out.println("手机号不存在");
            Users user = new Users();
            user.setuPhone(phone + "");
            user.setuName(UName);
            System.out.println("UType = " + UType);
            user.setuType(Integer.parseInt(UType));
            user.setuPwd(newpassword);
            if (UType == "1") {

            }

            req.getSession().setAttribute("user", user);


        }


        return "/msg.jsp";
    }
}