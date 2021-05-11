package com.nuist.utils;


import java.util.*;

/**
 * @author LiZonggen
 * @date 2021-04-03 14:54
 * @description:好友推荐
 * @version:
 */
public class FriendRecommend {
    //用户数量
    private static Integer allNumber=100;
    //用户的最大好友数
    private static Integer maxFriendNum=8;
    //用户的最小好友数
    private static Integer minFriendNum=3;
    //推荐的好友的个数
    private static Integer recommendNum=5;
    //生成测试数据
    public static Map<Integer, ArrayList<Integer>> generateData(){
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<allNumber;i++){
            Integer friendNum=getRandomRange(minFriendNum,maxFriendNum);
            if(map.get(i)==null){
                ArrayList<Integer> list=new ArrayList<>();
                for(int j=0;j<friendNum;){
                    Integer target=(int) (Math.random()*100);
                    if(i!=target&&!isContain(list,target)){
                        list.add(target);
                        if(map.get(target)==null){
                            ArrayList<Integer> newList=new ArrayList<>();
                            newList.add(i);
                            map.put(target,newList);
                        }else{
                            map.get(target).add(i);
                        }
                        j++;
                    }
                }
                Integer person=i;
                map.put(person,list);
            }else{
                for(int j=0;j<friendNum;){
                    Integer target=(int) (Math.random()*100);
                    if(i!=target&&!isContain(map.get(i),target)){
                        map.get(i).add(target);
                        if(map.get(target)==null){
                            ArrayList<Integer> newList=new ArrayList<>();
                            newList.add(i);
                            map.put(target,newList);
                        }else{
                            map.get(target).add(i);
                        }
                        j++;
                    }
                }
            }

        }
        return map;
    }
    // max min 随机数生成
    public static int getRandomRange(int min,int max) {
        Random random=new Random();
        int i=random.nextInt(max-min+1)+min;
        return i;
    }
    public static boolean isContain(List<Integer> list,Integer a){
        for(int i=0;i<list.size();i++){
            if(!list.get(i).equals(a)){
                continue;
            }else{
                return true;
            }
        }
        return false;
    }
    public static void showAll(Map<Integer, ArrayList<Integer>> data){
        for(Map.Entry<Integer,ArrayList<Integer>> entry:data.entrySet()){
            System.out.print("编号为 "+entry.getKey() +" 的用户的好友：");
            for(int i=0;i<entry.getValue().size();i++){
                System.out.print(entry.getValue().get(i)+" ");
            }
            System.out.println("");
        }
        System.out.println("暂停看结果");
    }
    private static int exchange(List<Integer> value,List<Integer> key,int left,int right){
        int l=left,r=right;
        Integer valueX=value.get(l);
        Integer keyX=key.get(l);
        while(l<r){
            while(l<r&&value.get(r)>=valueX){
                r--;
            }
            if(l<r){
                value.set(l,value.get(r));
                key.set(l,key.get(r));
                l++;
            }
            while(l<r&&value.get(l)<valueX){
                l++;
            }
            if(l<r){
                value.set(r,value.get(l));
                key.set(r,key.get(l));
                r--;
            }
        }
        value.set(l,valueX);
        key.set(l,keyX);
        return l;
    }
    //按map的值对map进行快速排序
    private static void quickSort(List<Integer> value,List<Integer> key,int left,int right){
        if(left<right){
            int center=exchange(value,key,left,right);
            quickSort(value,key,left,center-1);
            quickSort(value,key,center+1,right);
        }
    }
    /**
    * @Author: LiZonggen
    * @Date: 2021/4/3        
    * @Description: 计算目标推荐用户的好友的好友出现的次数，并返回出现次数较多的用户作为推荐列表
    * @param data: 数据源
    * @param user: 推荐用户的uid
    * @return: java.util.List<java.lang.Integer>
    */
    public static List<Integer> mostAppearList(Map<Integer, ArrayList<Integer>> data,Integer user){
        //使用hash表进行好友是否已添加判断,加快判断的速度
        Map<Integer,Boolean> userFriendMap=new HashMap<>();
//        出现次数统计
        Map<Integer,Integer> appearTime=new HashMap<>();
        for(int i=0;i<data.get(user).size();i++){
            userFriendMap.put(data.get(user).get(i),true);
        }
        userFriendMap.put(user,true);
        for(int i=0;i<data.get(user).size();i++){
            for(int j=0;j<data.get(data.get(user).get(i)).size();j++){
                //如果被添加的用户已经有了该好友则不进行添加
                if(userFriendMap.get(data.get(data.get(user).get(i)).get(j))!=null){
                    continue;
                }
                if(  appearTime.get(data.get(data.get(user).get(i)).get(j))==null){
                    appearTime.put(data.get(data.get(user).get(i)).get(j),1);
                }else{
                    appearTime.put(data.get(data.get(user).get(i)).get(j), appearTime.get(data.get(data.get(user).get(i)).get(j))+1);
                }
            }
        }
        //输出出现的次数
        System.out.println("\n每个用户出现的次数为");
        for(Map.Entry<Integer, Integer> entry:appearTime.entrySet()){
            System.out.println("用户 "+entry.getKey()+ " 出现的次数为："+entry.getValue());
        }
        List<Integer> keyList=new ArrayList<>();
        List<Integer> valueList=new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry:appearTime.entrySet()){
            keyList.add(entry.getKey());
            valueList.add(entry.getValue());
        }
        quickSort(valueList,keyList,0,valueList.size()-1);
        for(int i=0;i<valueList.size();i++){
            System.out.println("出现的次数 "+valueList.get(i)+" 用户："+keyList.get(i));
        }
        List<Integer> recommendList=new ArrayList<>();
        if(keyList.size()<recommendNum){
            for(int i=keyList.size()-1;i>=0;i--){
                recommendList.add(keyList.get(i));
            }
        }else{
            for(int i=keyList.size()-1;i>=keyList.size()-recommendNum;i--){
                recommendList.add(keyList.get(i));
            }
        }
        return recommendList;
    }
    /**
    * @Author: LiZonggen
    * @Date: 2021/4/3
    * @Description: 进行好友推荐，推荐算法的思想为如果A和B两个用户的共同好友越多，他们就越可能成为好友
    * @param data: 数据源
    * @param user: 推荐用户的uid
    * @return: java.util.List<java.lang.Integer>
    */
    public static List<Integer> commonNeighbors(Map<Integer,ArrayList<Integer>> data,Integer user){
        //初始化不是目标用户好友的集合
        ArrayList<Integer> notFriendsList=new ArrayList<>();
        //遍历好友集合，如果不是目标用户的好友则放入notFriendsList集合中
        for(Map.Entry<Integer,ArrayList<Integer>> entry:data.entrySet()){
            //判断条件为目标用户不在某一用户的好友聊表当中
            if(data.get(user).indexOf(entry.getKey())==-1&&entry.getKey()!=user){
                //加入非好友集合
                notFriendsList.add(entry.getKey());
            }
        }
        //该集合用于储存目标用户与目标用户的非好友的共同好友的数量
        HashMap<Integer,Integer> commonNeighbor=new HashMap<>();
        //依次遍历非好友列表
        for(int i=0;i<notFriendsList.size();i++){
            //内层循环为目标用户的好友列表遍历
            for(int j=0;j<data.get(user).size();j++)
            //判断目标用户的好友是否在其它用户的好友列表中
            if(data.get(notFriendsList.get(i)).indexOf(data.get(user).get(j))!=-1){
                //如果在列表当中则表示存在共同好友

                //判断在共同好友集合中是否是第一次出现
                if(commonNeighbor.get(notFriendsList.get(i))==null){
                    //第一次出现，将hashmap的初始值赋值为1
                    commonNeighbor.put(notFriendsList.get(i),1);
                }else{
                    //不是第一次出现，在原来的基础上做+1的操作
                    commonNeighbor.put(notFriendsList.get(i),commonNeighbor.get(notFriendsList.get(i))+1);
                }
            }
        }
        //输出共同好友的出现的次数
        System.out.println("\n每个用户出现的重复的邻居数为");
        for(Map.Entry<Integer, Integer> entry:commonNeighbor.entrySet()){
            System.out.println("用户 "+entry.getKey()+ " 重复的邻居数为："+entry.getValue());
        }
        //使用快速排序排序对结果按用户出现的次数从小到大排序

        //共同好友的uid
        List<Integer> NeighborUidList=new ArrayList<>();
        //每个共同好友出现的次数
        List<Integer> NumList=new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry:commonNeighbor.entrySet()){
            NeighborUidList.add(entry.getKey());
            NumList.add(entry.getValue());
        }
        /*
        * 使用快速排序对结果进行排序，排序时判断依据为出现的次数，用户的uid需要同时进行重新排序
        * */
        quickSort(NumList,NeighborUidList,0,NumList.size()-1);
        System.out.println("排序后");
        for(int i=0;i<NumList.size();i++){
            System.out.println("重复的邻居数为 "+NumList.get(i)+" 用户："+NeighborUidList.get(i));
        }
        //目标用户的推荐列表
        List<Integer> recommendList=new ArrayList<>();
        if(NeighborUidList.size()<recommendNum){
            //如果生成的列表的大小小于推荐数量，则将结果全部输出
            for(int i=NeighborUidList.size()-1;i>=0;i--){
                recommendList.add(NeighborUidList.get(i));
            }
        }else{
            //如果生成的列表的大小大于等于推荐数量，则按推荐数量选择出现次数较多的前N个用户进行推荐
            for(int i=NeighborUidList.size()-1;i>=NeighborUidList.size()-recommendNum;i--){
                recommendList.add(NeighborUidList.get(i));
            }
        }
        //对处理后的结果做出判断，如果结果集的大小为0，则在不是好友中的用户中随机推荐好友
        if(recommendList.size()==0){
            if(notFriendsList.size()<recommendNum){
                recommendList=notFriendsList;
            }else{
                for(int i=notFriendsList.size()-1;i>=notFriendsList.size()-recommendNum;i--){
                    recommendList.add(notFriendsList.get(i));
                }
            }
        }
        return recommendList;
    }



}
