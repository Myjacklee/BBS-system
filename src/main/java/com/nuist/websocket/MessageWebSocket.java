package com.nuist.websocket;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author LiZonggen
 * @date 2021-04-02 15:01
 * @description:消息推送
 * @version:
 */
@Component
@ServerEndpoint(value = "/connection")
public class MessageWebSocket {
    private Integer uid;
    private Session session;
    private static Map<Integer,MessageWebSocket> clients=new ConcurrentHashMap<>();
    @OnOpen
    public void onOpen(Session session,HttpSession httpSession){
        Integer uid=(Integer) httpSession.getAttribute("uid");
        this.uid=uid;
        this.session=session;
        clients.put(uid,this);
        System.out.println("开启连接，uid为 "+uid);
    }

    @OnClose
    public void onClose(){
        System.out.println("关闭了链接，uid为 "+uid);
    }
    @OnMessage
    public void OnMessage(String message,Session session){
        System.out.println("收到了用户 "+this.uid+ " 发来的消息："+message);
        session.getAsyncRemote().sendText("收到了消息："+this.uid+" "+message);
    }
    @OnError
    public void onError(Session session,Throwable error){
        System.out.println("用户的连接出现了错误，uid "+this.uid);
    }
    public void sendMessageToUser(Integer clientId,String message){
        MessageWebSocket receiver=clients.get(clientId);
        if(receiver!=null){
            if(receiver.session.isOpen()){
                receiver.session.getAsyncRemote().sendText("收到了来自"+this.uid+"的消息："+message);
            }else{
                System.out.println("用户连接关闭了");
            }
        }else{
            System.out.println("用户不存在了");

        }
    }

}
