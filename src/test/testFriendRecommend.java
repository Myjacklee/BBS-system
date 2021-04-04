import com.nuist.utils.FriendRecommend;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author LiZonggen
 * @date 2021-04-03 15:37
 * @description:好友推荐测试类
 * @version:
 */
public class testFriendRecommend {
    @Test
    public void test(){
        Map<Integer, ArrayList<Integer>> data= FriendRecommend.generateData();
        FriendRecommend.showAll(data);
        System.out.println("最多出现次数算法");
        List<Integer> res1= FriendRecommend.mostAppearList(data,3);
        for(int i=0;i<res1.size();i++){
            System.out.println(res1.get(i));
        }
        System.out.println("common neighbor 算法");
        List<Integer> res2= FriendRecommend.commonNeighbors(data,3);
        for(int i=0;i<res2.size();i++){
            System.out.println(res2.get(i));
        }
    }
}
