package com.niit.controller;

import com.niit.biz.IUserBiz;
import com.niit.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by XRog
 * On 2/1/2017.12:36 AM
 */
@Controller
public class LoginController {
    @Autowired
    private IUserBiz userBiz;

    @RequestMapping(value = "Login.mvc", method = RequestMethod.POST)
    public String Login(String phone, String username, String password, HttpServletRequest req, HttpSession session, ModelMap map) {
        System.out.println("密码登录-----------------------------");
        if (phone == null || password == null) {
            map.addAttribute("msg", "手机或密码不能为空");
            map.addAttribute("msgtype", "login");
            return "lrf.jsp";
        }

        Users user = userBiz.findUserByPhone(phone);

        System.out.println("password = " + password);
        System.out.println("userpwd = " + user.getuPwd());


        try {
            if (!phone.equals(user.getuPhone())) {
                map.addAttribute("msg", "该手机号未注册");
                map.addAttribute("msgtype", "login");
                return "lrf.jsp";
            }
        } catch (Exception e) {
            map.addAttribute("msg", "该手机号未注册");
            map.addAttribute("msgtype", "login");
            return "lrf.jsp";
        }

        System.out.println("检查密码");
        if (password.equals(user.getuPwd())) {
            System.out.println("密码正确");
            session.setAttribute("user", user);
            map.addAttribute("msg", "登陆成功");
            if (user.getuType() == 1) {
                map.addAttribute("url", "index.jsp");
            } else {
                map.addAttribute("url", "manger.jsp");
            }
            return "msg.jsp";
        } else {
            map.addAttribute("msg", "密码错误");
            map.addAttribute("msgtype", "login");
            return "lrf.jsp";
        }

    }

    @RequestMapping(value = "LoginBySms.mvc", method = RequestMethod.POST)
    public String LoginBySms(String phone, String username, String sms, HttpServletRequest req, HttpSession session, ModelMap map) {
        System.out.println("验证码登录---------------------------");
        if (phone == null || sms == null) {
            map.addAttribute("msg", "手机或验证码不能为空");
            map.addAttribute("msgtype", "login");
            return "lrf.jsp";
        }

        Users user = userBiz.findUserByPhone(phone);

        try {
            if (!phone.equals(user.getuPhone())) {
                map.addAttribute("msg", "该手机号未注册");
                map.addAttribute("msgtype", "login");
                return "lrf.jsp";
            }
        } catch (Exception e) {
            map.addAttribute("msg", "该手机号未注册");
            map.addAttribute("msgtype", "login");
            return "lrf.jsp";
        }

        System.out.println("sms = " + sms);
        System.out.println("user = " + req.getSession().getAttribute("code"));

        if (sms.equals(req.getSession().getAttribute("code").toString())) {
            System.out.println("验证码正确");
            session.setAttribute("user", user);
            map.addAttribute("msg", "登陆成功");
            if (user.getuType() == 1) {
                map.addAttribute("url", "index.jsp");
            } else {
                map.addAttribute("url", "manger.jsp");
            }
            return "msg.jsp";
        } else {
            map.addAttribute("msg", "验证码错误");
            map.addAttribute("msgtype", "login");
            return "lrf.jsp";
        }

    }

    @RequestMapping(value = "Checkout.mvc", method = RequestMethod.GET)
    public String Checkout(HttpServletRequest req, ModelMap map) {
        req.getSession().invalidate();
        map.addAttribute("msg", "已注销");
        map.addAttribute("url", "lrf.jsp");
        return "msg.jsp";
    }
}