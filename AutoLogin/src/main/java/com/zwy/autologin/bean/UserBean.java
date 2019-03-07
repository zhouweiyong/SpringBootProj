package com.zwy.autologin.bean;

public class UserBean {
    private String userName;
    private String password;
    private String isAuto;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsAuto() {
        return isAuto;
    }

    public void setIsAuto(String isAuto) {
        this.isAuto = isAuto;
    }

    @Override
    public String toString() {
        return "userName=" + userName + " password=" + password + " isAuto=" + isAuto;
    }
}
