package com.xianjj.patterns.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例模式示例代码
 * Created by xian.juanjuan on 2017-7-14 15:57.
 */
public class SingletonPattern {
    /**
     * 类级内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
     * 没有绑定关系，而且只有被调用的时候才会被装载，从而实现了延迟健在
     */
    private static class SingletonHolder{
        //静态初始化器，由JVM保证线程安全
        private static SingletonPattern instance = new SingletonPattern();
    }
    private SingletonPattern(){}

    public static SingletonPattern getInstance(){
        return SingletonHolder.instance;
    }
}

/**
 * 懒汉式单例模式示例
 */
class LazySingleton{
    //私有静态对象，类加载的时候不做初始化
    private static LazySingleton instance = null;
    //私有构造方法，避免外部创建实例
    private LazySingleton(){}
    //静态工厂方法，返回此类的唯一实例，实例没有初始化时才初始化
    synchronized public static LazySingleton getInstance(){
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

/**
 * 饿汉式单例模式示例
 */
class Singleton{
    //私有静态变量存储创建好的实例
    private static Singleton instance = new Singleton();
    //private static final Singleton instance = new Singleton();可以定义为static final成员
    //私有构造方法，避免外部创建实例
    private Singleton(){}
    //微客户端提供类实例
    public static Singleton getInstance(){
        return instance;
    }
}

class RegistrySingleton{
    //登记簿，用来存放所有登记的实例
    private static Map<String, RegistrySingleton> mapRegistry = new HashMap();
    //在类加载的时候添加一个实例到登记簿
    static {
        RegistrySingleton x = new RegistrySingleton();
        mapRegistry.put(x.getClass().getName(), x);
    }
    //受保护的默认构造方法
    protected RegistrySingleton(){}
    //静态工厂方法返回等级对象的唯一实例
    public static RegistrySingleton getInstance(String name){
        if (name == null){
            name = "RegistrySingleton";
        }
        if (mapRegistry.get(name) == null){
            try {
                mapRegistry.put(name, (RegistrySingleton) Class.forName(name).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return mapRegistry.get(name);
    }
}


