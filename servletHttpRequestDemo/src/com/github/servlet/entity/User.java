package com.github.servlet.entity;

import java.util.Arrays;

public class User {
    private String userName;
    private String passwd;
    private String[] hobby;
    private String sex;
    private String province;
    private String jianjie;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getJianjie() {
        return jianjie;
    }

    public void setJianjie(String jianjie) {
        this.jianjie = jianjie;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passwd='" + passwd + '\'' +
                ", hobby=" + Arrays.toString(hobby) +
                ", sex='" + sex + '\'' +
                ", province='" + province + '\'' +
                ", jianjie='" + jianjie + '\'' +
                '}';
    }
}
