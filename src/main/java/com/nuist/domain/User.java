package com.nuist.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author LiZonggen
 * @date 2021-03-16 23:11
 * @description:用户信息
 * @version:
 */
public class User implements Serializable {
    private String email;
    private String password;
    private String username;
    private String nickname;
    private String school;
    private String college;
    private String studentClass;
    private String uid;
    private Date sign_date;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Date getSign_date() {
        return sign_date;
    }

    public void setSign_date(Date sign_date) {
        this.sign_date = sign_date;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", school='" + school + '\'' +
                ", college='" + college + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", uid='" + uid + '\'' +
                ", sign_date=" + sign_date +
                '}';
    }
    public boolean isEmpty(){
        if(email==null&&password==null&&username==null&&nickname==null&&school==null&&college==null&&studentClass==null&&uid==null&&sign_date==null){
            return true;
        }else{
            return false;
        }
    }
}
