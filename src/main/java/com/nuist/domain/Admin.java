package com.nuist.domain;

/**
 * @author LiZonggen
 * @date 2021-03-29 11:08
 * @description:管理员
 * @version:
 */
public class Admin {
    private Integer id;
    private String name;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isEmpty(){
        if(id==null&&name==null&&password==null){
            return true;
        }else{
            return false;
        }
    }
}
