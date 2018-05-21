package com.niit.controller;

import com.niit.biz.IProjectBiz;
import com.niit.biz.IUserBiz;
import com.niit.entity.Project;
import com.niit.entity.ProjectImg;
import com.niit.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by XRog
 * On 2/1/2017.12:36 AM
 */
@Controller
public class IndexController {
    @Autowired
    private IProjectBiz projectBiz;
    @Autowired
    private IUserBiz userBiz;

    @RequestMapping(value = "Index.mvc")
    public String findproject(HttpServletRequest request, ModelMap map, HttpSession session) {

        //检查用户是否记住登录状态
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
        }

        List<Project> hot = projectBiz.findHotProject();
        List<Project> newp = projectBiz.findNewProject();
        List<Project> p1 = projectBiz.findProject1();
        List<Project> p2 = projectBiz.findProject2();
        List<Project> p3 = projectBiz.findProject3();

        int counproject = projectBiz.countproject();
        int supportnum = projectBiz.supportnum();
        int countokpro = projectBiz.countokpro();

        map.addAttribute("counproject", counproject);
        map.addAttribute("supportnum", supportnum);
        map.addAttribute("countokpro", countokpro);

        map.addAttribute("ihot", hot);
        map.addAttribute("inewp", newp);
        map.addAttribute("ip1", p1);
        map.addAttribute("ip2", p2);
        map.addAttribute("ip3", p3);

        List<ProjectImg> hotimglist = new ArrayList<>();
        hotimglist = projectBiz.findhotimg();
//        List<ProjectImg> hotimglisttemp = null;
//        for (int i = 0; i < hot.size(); i++) {
//            Project project = hot.get(i);
//            Collection<ProjectImg> projectImgsByPId = project.getProjectImgsByPId();
//            for (Iterator<ProjectImg> iterator = projectImgsByPId.iterator(); iterator.hasNext(); ) {
//                ProjectImg next = iterator.next();
//                hotimglisttemp = new ArrayList<>();
//                hotimglisttemp.add(next);
//            }
//            hotimglist.add(hotimglisttemp.get(0));
//
//        }
        session.setAttribute("hotimglist", hotimglist);
        for (int i = 0; i < hotimglist.size(); i++) {
            ProjectImg projectImg = hotimglist.get(i);
            System.out.println("projectImg = " + projectImg.getImgPath());
        }

        session.setAttribute("hot", hot);

        return "index.jsp";
    }


}