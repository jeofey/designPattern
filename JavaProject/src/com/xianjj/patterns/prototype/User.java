package com.xianjj.patterns.prototype;

/**
 * JavaProject
 * Created by xian.juanjuan on 2017-7-18 15:55.
 */
public class User implements Cloneable{

    private String userId;
    private String userName;

    @Override
    public User clone(){
        User user = null;
        try {
            user = (User) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return user;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
