package com.niit.interceptor;

import com.niit.biz.IUserBiz;
import com.niit.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private IUserBiz userBiz;


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        request.setCharacterEncoding("UTF-8");

        String uri = request.getRequestURI();

        //设置不拦截的对象
        String[] noFilters = new String[]{"lrf.jsp", "images", "js", "css", "Index.mvc", "index.jsp", "css"};  //对登录本身的页面以及业务不拦截
        boolean beFilter = true;
        for (String s : noFilters) {
            if (uri.indexOf(s) != -1) {
                beFilter = false;
                break;
            }
        }

        if (beFilter == true) {

            Users loginUser = (Users) request.getSession().getAttribute("user");
            if (loginUser == null || loginUser.getuPhone() == null || loginUser.getuPhone() == "") {

                String loginCookieUserName = "";
                String loginCookiePassword = "";

                Cookie[] cookies = request.getCookies();
                if (null != cookies) {
                    for (Cookie cookie : cookies) {
                        if ("loginUserName".equals(cookie.getName())) {
                            loginCookieUserName = cookie.getValue();
                        } else if ("loginPassword".equals(cookie.getName())) {
                            loginCookiePassword = cookie.getValue();
                        }
                    }
                    if (!"".equals(loginCookieUserName) && !"".equals(loginCookiePassword)) {
                        Users user = userBiz.findUserByPhone(loginCookieUserName);
                        if (loginCookiePassword.equals(user.getuPwd())) {
                            request.getSession().setAttribute("user", user);
                        }
                    }
                    return true;
                }


                response.sendRedirect("lrf.jsp");
                return false;
            }

        }
        return true;
    }
}