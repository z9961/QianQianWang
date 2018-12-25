package com.niit.utils;

import com.niit.entity.Orders;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class SaveToWord {

    private Configuration configuration = null;

    public SaveToWord() {
        configuration = new Configuration();
        configuration.setDefaultEncoding("UTF-8");
    }

    public String createWord(List<Orders> list) throws IOException {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        getData(dataMap, list);
        String temppath = this.getClass().getResource("").getPath();
        System.out.println("temppath = " + temppath);
        String basepath = temppath + "\\..\\..\\..\\..\\..\\file\\";
        System.out.println("basepath = " + basepath);
        File baseFile = new File(basepath);
        System.out.println("baseFile = " + baseFile.getAbsolutePath());
        System.out.println("baseFile = " + baseFile);
        configuration.setDirectoryForTemplateLoading(baseFile);//模板文件所在路径
        Template t = null;
        try {
            t = configuration.getTemplate("test.ftl"); //获取模板文件
            System.out.println("========== getT");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String uuid = UUID.randomUUID().toString().replace("-", "") + ".doc";
        System.out.println("uuid = " + uuid);
        String filename = basepath + "\\" + uuid;

        File outFile = new File(filename); //导出文件
        System.out.println("outFile = " + outFile.getCanonicalPath());

        Writer out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        try {
            t.process(dataMap, out); //将填充数据填入模板文件并输出到目标文件
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return uuid;
    }

    private void getData(Map<String, Object> dataMap, List<Orders> l) {

        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String timestr = dateFormat.format(date);

        dataMap.put("timestr", timestr);

        List<Map<String, Object>> newList = new ArrayList<Map<String, Object>>();
        int cout = l.size();
        for (int i = 0; i < cout; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            Orders order = l.get(i);
            String pid = order.getProjectByPId().getpId() + " 订单编号:" + order.getOrderId();
            map.put("pid", pid);
            map.put("pname", order.getProjectByPId().getpName());
            map.put("pstate", order.getProjectByPId().getpState());
            map.put("pmoney", order.getMoney());
            map.put("ptime", order.getOrderDate());

            String exp = "是";
            if (order.getExpect() == 0)
                exp = "否";
            map.put("pr", exp);

            String exptype = "";
            switch (order.getExpectType()) {
                case -1:
                    exptype = "-";
                    break;
                case 1:
                    exptype = "投资产品享受折扣";
                    break;
                case 2:
                    exptype = "购买产品享有更高折扣或附加服务";
                    break;
                case 3:
                    exptype = "免费获得投资产品";
                    break;
                case 4:
                    exptype = "其他";
                    break;

            }
            map.put("pt", exptype);

            String address = null;
            String remark = null;
            try {
                address = order.getUsersAddressByAId().getAddress();
                remark = order.getExceptOther();
            } catch (Exception e) {
                address = "-";
                remark = "-";
            }
            if (address == null)
                address = "-";
            if (remark == null)
                remark = "-";


            map.put("pa", address);

            map.put("premark", remark);

            newList.add(map);
        }
        dataMap.put("newList", newList);
    }
}