package com.niit.controller;

import com.niit.biz.IProjectBiz;
import com.niit.entity.Project;
import com.niit.entity.ProjectImg;
import com.niit.entity.ProjectType;
import com.niit.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.*;

@Controller
public class ProjectController {
    @Autowired
    private IProjectBiz projectBiz;

    @RequestMapping(value = "AddProject.mvc", method = RequestMethod.POST)
    public String AddProject(ModelMap map, HttpSession session, String PName, String PDesc, String PED, String PTarget, String
            PMilestone, String PCategoryId, String PRemark, String PMF, String PLimit, String PTeam, String PPlan) throws ParseException {
        Timestamp tss = new Timestamp(new Date().getTime());
        Timestamp tse = Timestamp.valueOf(PED);
        int plimit = Integer.parseInt(PLimit);
        int ppid = Integer.parseInt(PCategoryId);
        int pmf = Integer.parseInt(PMF);
        BigDecimal pt = BigDecimal.valueOf(Long.parseLong(PTarget));
        BigDecimal pnm = BigDecimal.valueOf(0);
        ProjectType projectType = new ProjectType();
        projectType.setProjectTypeId(ppid);
        Users u = (Users) session.getAttribute("user");
        String phone = u.getuPhone();


        Project project = new Project(PName, PDesc, tss, tse, pt,
                pnm, 0, PMilestone, PRemark, pmf, plimit, PTeam, 0, PPlan, u, projectType);

        System.out.println("project = " + project.toString());


        int isok = projectBiz.save(project);
        if (isok >= 0) {
            session.setAttribute("addprojectid", isok);
            map.addAttribute("msg", "添加项目成功,请上传图片");
            map.addAttribute("url", "upload.jsp");
        } else {
            map.addAttribute("msg", "添加项目失败");
            map.addAttribute("url", "addproject.jsp");
        }

        return "msg.jsp";
    }

    @RequestMapping(value = "Upload.mvc", method = RequestMethod.POST)
    private String fildUpload(@RequestParam(value = "file", required = false) MultipartFile[] file,
                              HttpSession session, ModelMap map) throws Exception {

        int pid = (int) session.getAttribute("addprojectid");
        String pathRoot = session.getServletContext().getRealPath("");
        String path = "";
        String imgpath = "";

        String savePath = pathRoot + "/images/" + pid + "/";

        //若果不存在文件夹则创建
        File dirFile;
        File tempFile;
        boolean bFile;
        String sFileName;
        bFile = false;
        try {
            dirFile = new File(savePath);
            bFile = dirFile.exists();
            if (bFile == true) {
            } else {
                bFile = dirFile.mkdir();
            }
        } catch (Exception e) {
            System.out.println("创建文件夹失败!");
        }

        //保存图片
        List<String> listImagePath = new ArrayList<String>();
        boolean upload = true;
        for (MultipartFile mf : file) {
            if (!mf.isEmpty()) {

                //得到文件名
                File countfile = new File(savePath);
                String[] files = countfile.list();
                int i = files.length + 1;

                //获得文件类型
                String contentType = mf.getContentType();
                System.out.println("contentType = " + contentType);
                if (contentType.equals("image/jpeg") || contentType.equals("image/png")) {
                    //获得文件后缀名称
                    String imageName = contentType.substring(contentType.indexOf("/") + 1);
                    System.out.println("imageName = " + imageName);
                    path = "/images/" + pid + "/" + i + "." + imageName;
                    imgpath = "images/" + pid + "/" + i + "." + imageName;
                    mf.transferTo(new File(pathRoot + path));
                    listImagePath.add(imgpath);
                    System.out.println(imgpath);
                } else {
                    map.addAttribute("msg", "图片类型不正确");
                    map.addAttribute("url", "upload.jsp");
                    //失败清空list
                    upload = false;
                    listImagePath = new ArrayList<String>();
                }
            }
        }
        boolean isok = projectBiz.saveimg(pid, listImagePath);
        if (upload && isok) {
            map.addAttribute("msg", "添加图片成功");
            map.addAttribute("url", "manage.jsp");
        }


        return "msg.jsp";
    }


    @RequestMapping(value = "ShowProject.mvc", method = RequestMethod.GET)
    public String project(HttpSession session, ModelMap map, String pid) {
        Project project = projectBiz.findProjectById(Integer.parseInt(pid));
        String pname = project.getpName();
        BigDecimal pnm = project.getPnm();
        int pnp = project.getPnp();
        Timestamp deadline = project.getPed();
        BigDecimal ptarget = project.getpTarget();
        String percentage = ((pnm.intValue() / ptarget.intValue()) * 100) + "%";
        map.addAttribute("showproject", project);

        map.addAttribute("percentage", percentage);

        //计算剩余时间
        Timestamp time = new Timestamp(System.currentTimeMillis());
        long difftime = deadline.getTime() - time.getTime();
        String timestr = "";
        if (difftime <= 0) {
            timestr = "已超过结束时间";
        } else {
            double dayDiff = Math.floor(difftime / (24 * 3600 * 1000));
            double leave1 = dayDiff % (24 * 3600 * 1000);
            double hours = Math.floor(leave1 / (3600 * 1000));//计算出小时数
            //计算相差分钟数
            double leave2 = leave1 % (3600 * 1000);    //计算小时数后剩余的毫秒数
            double minutes = Math.floor(leave2 / (60 * 1000));//计算相差分钟数
            //计算相差秒数
            double leave3 = leave2 % (60 * 1000);      //计算分钟数后剩余的毫秒数
            double seconds = Math.round(leave3 / 1000);
            timestr = "剩余" + dayDiff + "天 " + hours + "小时 " + minutes + " 分钟" + seconds + " 秒";
        }
        map.addAttribute("timestr", timestr);

        //将所有图片转为list


        List imglist = new ArrayList();
        Collection<ProjectImg> c = project.getProjectImgsByPId();
        for (Iterator<ProjectImg> iterator = c.iterator(); iterator.hasNext(); ) {
            ProjectImg next = iterator.next();
            imglist.add(next);
        }
        System.out.println("imglist = " + imglist.size());

        map.addAttribute("imglist", imglist);
        String pathRoot = session.getServletContext().getRealPath("");
        String savePath = pathRoot + "/images/" + pid + "/";
        File countfile = new File(savePath);
        String[] files = countfile.list();
        int i = files.length;


        return "project.jsp";
    }


}
