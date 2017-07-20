package com.xianjj.patterns.prototype;

import java.io.*;
import java.util.ArrayList;

/**
 * JavaProject
 * Created by xian.juanjuan on 2017-7-18 15:55.
 */
public class CloneTest implements Cloneable{
    private User user = new User();
    private int status;

    @Override
    public CloneTest clone(){
        CloneTest object = null;
        try {
            object = (CloneTest) super.clone();
            object.user = this.user.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return object;
    }

    public void getValue() {
        System.out.println("原始类型int："+status+"；引用类型User的属性userName："+user.getUserName());
    }

    public void setValue(int status, String userId, String userName) {
        this.status = status;
        this.user.setUserId(userId);
        this.user.setUserName(userName);
    }

}

class CloneClient{
    public static void main(String[] args){
        CloneTest obj1 = new CloneTest();
        obj1.setValue(1, "1", "小黑");

        CloneTest obj2 = obj1.clone();
        obj2.setValue(2, "2", "小白");

        obj1.getValue();
        obj2.getValue();
    }
}

class Thing implements Cloneable{
    private ArrayList<String> arrayList = new ArrayList<>();

    @Override
    public Thing clone(){
        Thing thing = null;
        try {
            thing = (Thing) super.clone();
            thing.arrayList = (ArrayList<String>) this.arrayList.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return thing;
    }

    public void setValue(String value){
        this.arrayList.add(value);
    }

    public ArrayList<String> getValue(){
        return this.arrayList;
    }

}
class ThingTest{
    public static void main(String[] args){
        Thing thing = new Thing();
        thing.setValue("小黑");
        Thing cloneThing = thing.clone();
        cloneThing.setValue("小白");

        System.out.println(thing.getValue());
        System.out.println(cloneThing.getValue());
    }
}


class UserPojo implements Serializable{

    private static final long serialVersionUID = -2659011435026358451L;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
class DeepCopy implements Serializable{

    private static final long serialVersionUID = -4252107879230837204L;
    private String id;
    private UserPojo user;

    //利用序列化实现深度拷贝方法，不需要重写clone()
    public DeepCopy deepClone() throws IOException, ClassNotFoundException {
        //将对象写入流中
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(this);
        //将对象从流中读出
        ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (DeepCopy) ois.readObject();
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserPojo getUser() {
        return user;
    }

    public void setUser(UserPojo user) {
        this.user = user;
    }
}

class DeepClient{
    public static void main(String[] args){
        DeepCopy obj1, obj2 = null;
        obj1 = new DeepCopy();
        UserPojo user = new UserPojo();
        obj1.setUser(user);
        try {
            obj2 = obj1.deepClone();
        } catch (IOException e) {
            System.out.println("深度拷贝失败");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("DeepCopy两个对象是否相同?  "+(obj1 == obj2));
        System.out.println("两个对象的引用UserPojo是否相同?  "+(obj1.getUser() == obj2.getUser()));
    }
}