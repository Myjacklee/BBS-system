package com.nuist.thread;

/**
 * @author LiZonggen
 * @date 2021-03-07 16:32
 * @description:多线程测试
 * @version:
 */
public class ThreadDemo extends Thread {
    private static Integer ticket;
    private String name;
    public ThreadDemo(String name){
        this.name=name;
    }
    public void setTicket(Integer ticket) {
        this.ticket = ticket;
    }
    @Override
    public void run() {
            while(true){
                synchronized (ThreadDemo.class){
                    if(ticket>0){
                        --ticket;
                        System.out.println(name+" : "+"抢到一张票，当前余票 "+ticket);
                    }else{
                        break;
                    }
                }

            }
        System.out.println(name+" : 停止工作...");
    }

    public static void main(String[] args) {
        ThreadDemo th=new ThreadDemo("线程1");
        th.setTicket(1000);
        th.start();
        ThreadDemo th2=new ThreadDemo("线程2");
        th2.start();
        ThreadDemo th3=new ThreadDemo("线程3");
        th3.start();
    }
}
