package com.niit.controller;

import com.niit.biz.IProjectBiz;
import com.niit.entity.ProjectType;
import com.niit.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ProjectController {
    @Autowired
    private IProjectBiz projectBiz;

    @RequestMapping(value = "AddProject", method = RequestMethod.POST)
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

        /*Project project = new Project(PName, PDesc, tss, tse, pt,
                pnm, 0, PMilestone, PRemark, pmf, plimit, PTeam, 0, PPlan, u, projectType);

        System.out.println("project = " + project.toString());


        int isok = projectBiz.save(project);
        if (isok >= 0) {
            session.setAttribute("addprojectid", isok);
            map.addAttribute("msg", "添加地址成功,请上传图片");
            map.addAttribute("url", "upload.jsp");
        } else {
            map.addAttribute("msg", "添加地址失败");
            map.addAttribute("url", "addproject.jsp");
        }
*/
        return "msg.jsp";
    }

    @RequestMapping(value = "Upload.mvc", method = RequestMethod.POST)
    private String fildUpload(@RequestParam(value = "file", required = false) MultipartFile[] file,
                              HttpServletRequest request, ModelMap map) throws Exception {

        int pid = (int) request.getSession().getAttribute("addprojectid");
        String pathRoot = request.getSession().getServletContext().getRealPath("");
        String path = "";

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
        for (MultipartFile mf : file) {
            if (!mf.isEmpty()) {

                //得到文件名
                File countfile = new File(savePath);
                String[] files = countfile.list();
                int i = files.length;

                //获得文件类型
                String contentType = mf.getContentType();
                System.out.println("contentType = " + contentType);
                if (contentType == "jpg" || contentType == "png") {
                    //获得文件后缀名称
                    String imageName = contentType.substring(contentType.indexOf("/") + 1);
                    path = "/images/" + pid + "/" + i + "." + imageName;
                    mf.transferTo(new File(pathRoot + path));
                    listImagePath.add(path);
                    map.addAttribute("msg", "图片上传成功");
                    map.addAttribute("url", "manger.jsp");
                } else {
                    map.addAttribute("msg", "图片类型不正确");
                    map.addAttribute("url", "upload.jsp");
                }
            }
        }
        System.out.println(path);
        request.setAttribute("imagesPathList", listImagePath);
        return "msg.jsp";
    }

}
