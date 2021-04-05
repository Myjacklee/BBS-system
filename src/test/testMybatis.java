import com.nuist.dao.FriendDao;
import com.nuist.dao.MessageDao;
import com.nuist.dao.PostDao;
import com.nuist.dao.ReplyDao;
import com.nuist.domain.Friend;
import com.nuist.domain.FriendAddRequest;
import com.nuist.domain.Message;
import com.nuist.domain.Reply;
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
        MessageDao dao=ac.getBean("messageDao", MessageDao.class);
        //进行更新操作

        Integer list=dao.getMessageNum(6);
        System.out.println(list);
//        for(Message message: list){
//            System.out.println(message);
//        }
    }

}
