import com.nuist.dao.AccountDao;
import com.nuist.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resource;
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
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session=factory.openSession();
        //获取到代理对象
        AccountDao dao=session.getMapper(AccountDao.class);
        //查询所有数据
        List<Account> list= dao.findAll();
        for(Account item:list){
            System.out.println(item);
        }
        in.close();;
    }

}
