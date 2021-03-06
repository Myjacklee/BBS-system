import com.nuist.dao.*;
import com.nuist.domain.*;
import com.nuist.service.FriendService;
import com.sun.javaws.IconUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.io.InputStream;
import java.util.List;

/**
 * @author LiZonggen
 * @date 2021-02-26 23:34
 * @description:测试整合后的ssm框架
 * @version:
 */
public class testMybatis {
    @Test
    public void run1() throws Exception {
//        //加载配置文件
//        InputStream in = Resources.getResourceAsStream("applicationContext.xml");
//        //创建SqlSessionFactory对象
//        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
//        //创建SqlSession对象
//        SqlSession session=factory.openSession();
//        //获取到代理对象
//        FriendDao dao=session.getMapper(FriendDao.class);
        ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext.xml");
        ReplyDao service=ac.getBean("replyDao", ReplyDao.class);
        //进行更新操作

        System.out.println( service.findUidByBoardIdAndFloor(8,-1));
//        System.out.println(list);
//        for(Reply message: list){
//            System.out.println(message);
//        }
    }

    @Test
    public void run2() throws Exception {
//        //加载配置文件
//        InputStream in = Resources.getResourceAsStream("applicationContext.xml");
//        //创建SqlSessionFactory对象
//        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
//        //创建SqlSession对象
//        SqlSession session=factory.openSession();
//        //获取到代理对象
//        FriendDao dao=session.getMapper(FriendDao.class);
        ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext.xml");
        ReplyDao service=ac.getBean("replyDao", ReplyDao.class);
        //进行更新操作

        List<Reply> list=service.findAllReply(8);
//        System.out.println(list);
        for(Reply message: list){
            System.out.println(message);
        }
    }
    @Test
    public void run3() throws Exception {
//        //加载配置文件
//        InputStream in = Resources.getResourceAsStream("applicationContext.xml");
//        //创建SqlSessionFactory对象
//        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
//        //创建SqlSession对象
//        SqlSession session=factory.openSession();
//        //获取到代理对象
//        FriendDao dao=session.getMapper(FriendDao.class);
        ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext.xml");
        ReplyDao service=ac.getBean("replyDao", ReplyDao.class);
        //进行更新操作

        List<Reply> list=service.findAllReply(19);
//        System.out.println(list);
        for(Reply message: list){
            System.out.println(message);
        }
    }

}
