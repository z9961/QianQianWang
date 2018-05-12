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
        System.out.println("++++++++++++++++++++++++++");
        System.out.println("Register");
        System.out.println("UName = " + UName);
        System.out.println("newpassword = " + newpassword);
        System.out.println("phone = " + phone);
        System.out.println("sms = " + sms);
        System.out.println("UType = " + UType);
        System.out.println("++++++++++++++++++++++++++");

        Users user = new Users();
        user.setuPhone(phone + "");
        user.setuName(UName);
        user.setuType(Integer.parseInt(UType));
        user.setuPwd(newpassword);

        //临时保存用户信息
        req.getSession().setAttribute("registeruser", user);

        if ((Integer.parseInt(sms)) != (int) (req.getSession().getAttribute("code"))) {
            System.out.println("验证码错误:" + (Integer.valueOf(sms) + "|" + (req.getSession().getAttribute("code"))));
            map.addAttribute("msg", "验证码错误");
            map.addAttribute("msgtype", "register");
            return "lrf.jsp";
        }

        //尝试保存用户到数据库
        String result = userBiz.RegisterUser(user);

        if (result == "UserExisted") {
            System.out.println("手机号已经存在");
            map.addAttribute("msg", "手机号已经存在");
            map.addAttribute("msgtype", "register");
            return "lrf.jsp";
        } else if (result == "ok") {
            System.out.println("注册成功");
            map.addAttribute("url", "lrf.jsp");
            map.addAttribute("msg", "注册成功!");
            return "msg.jsp";
        } else if (result == "error") {
            map.addAttribute("url", "lrf.jsp");
            map.addAttribute("msg", "注册失败!");
            return "msg.jsp";
        } else if (result == "Type2") {
            System.out.println("con:Type2");
            //注册类型为融资者,需要进一步填写信息
            return "userinfo.jsp";
        } else {
            map.addAttribute("url", "lrf.jsp");
            map.addAttribute("msg", "注册失败!");
            return "msg.jsp";
        }


    }
}