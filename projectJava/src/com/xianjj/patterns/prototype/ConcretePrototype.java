package com.xianjj.patterns.prototype;



/**
 * JavaProject
 * Created by xian.juanjuan on 2017-7-18 14:51.
 */
public class ConcretePrototype{
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 拷贝方法
     * @return
     */
    public ConcretePrototype clone(){
        ConcretePrototype prototype = new ConcretePrototype();//创建新对象
        prototype.setUserName(this.userName);
        return prototype;
    }
}

class Client{
    public static void main(String[] args){
        /*ConcretePrototype obj1 = new ConcretePrototype();
        obj1.setUserName("我是小白");
        ConcretePrototype obj2 = obj1.clone();
        System.out.println(obj1.getUserName()+":"+obj2.getUserName());*/

        Prototype prototype = new Prototype();
        prototype.setUserName("我是小黑");
        Prototype prototype1 = prototype.clone();
        System.out.println(prototype.getUserName()+":"+prototype1.getUserName());
    }
}

class Prototype{
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Prototype clone(){
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return (Prototype)obj;
    }
}


