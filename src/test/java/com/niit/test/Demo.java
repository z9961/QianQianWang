package com.niit.test;

import com.niit.biz.IUserBiz;
import com.niit.dao.IUsersDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class Demo {

    @Resource(name = "usersDaoImp")
    private IUsersDao userDao;

    @Resource(name = "userBizImp")
    private IUserBiz userBiz;

    // 添加(事务切入到了业务层)
    @Test
    public void test() throws SQLException {
        /*Users u = new Users();
        u.setuName("jack");
        u.setuPwd("1");
        u.setuType(1);
        u.setuPhone("12346578912");
        u.setuFlag(0);

        userBiz.save(u);*/
/*        System.out.println(
                userBiz.findByPhone("11111111111")
        );*/
        // 1.注册驱动
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//推荐方式

        // 2.建立连接
        String url = "jdbc:mysql://localhost:3306/jdbc";
        String user = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, user, password);

        // 3.创建语句
        Statement st = conn.createStatement();

        // 4.执行语句
        ResultSet rs = st.executeQuery("select * from user");

        // 5.处理结果（依次打印出 user 表中的4列基本数据项的值）
        while (rs.next()) {
            System.out.println(rs.getObject(1) + "\t" + rs.getObject(2) + "\t"
                    + rs.getObject(3) + "\t" + rs.getObject(4));
        }

        // 6.释放资源
        rs.close();
        st.close();
        conn.close();
    }


}
