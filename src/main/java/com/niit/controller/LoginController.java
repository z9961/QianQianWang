package com.niit.controller;

import com.niit.biz.IUserBiz;
import com.niit.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String login(String phone, String username, String password, HttpServletRequest req, HttpSession session, Model model) {

        if (phone == null || password == null) {
            model.addAttribute("msg", "手机或密码不能为空");
            return "/login.jsp";
        }

        Users user = userBiz.findUserByPhone(phone);
        String pw = user.getuPwd();
        if (pw == password) {
            session.setAttribute("user", user);
            return "/index.jsp";
        } else {
            model.addAttribute("msg", "手机或密码错误");
            return "/login.jsp";
        }
    }
}