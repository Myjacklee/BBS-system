import com.nuist.dao.AdminDao;
import com.nuist.dao.MessageDao;
import com.nuist.domain.Admin;
import com.nuist.service.AdminService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LiZonggen
 * @date 2021-04-05 16:56
 * @description:测试事务
 * @version:
 */
public class testAOP {
    @Test
    public void test(){
        ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminService service=ac.getBean("adminService", AdminService.class);
        Admin admin=new Admin();
        admin.setName("lufeng");
        admin.setPassword("lufeng");
        service.addAdmin(admin);
    }
}
