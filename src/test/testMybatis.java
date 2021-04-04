import com.nuist.dao.FriendDao;
import com.nuist.domain.Friend;
import com.nuist.domain.FriendAddRequest;
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
        FriendDao dao=ac.getBean("friendDao",FriendDao.class);
        //进行更新操作
        FriendAddRequest friendAddRequest=new FriendAddRequest();
        friendAddRequest.setReceiver_uid(2);
        friendAddRequest.setStates(1);
        friendAddRequest.setMd5_code("full");
        friendAddRequest.setRequest_id(1);
        dao.dealWithRequest(friendAddRequest);
        System.out.println(friendAddRequest);
    }

}
