package com.xianjj.patterns.singleton;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 简单工厂模式
 * Created by xian.juanjuan on 2017-7-13 14:07.
 */
public class SimpleFactory {

    private SimpleFactory() {
    }

    public static MessageApi createMessageApi(){
        Properties properties = new Properties();
        InputStream inputStream;
        try {
            inputStream = SimpleFactory.class.getResourceAsStream("FactoryTest.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("加载工厂配置文件异常");
            e.printStackTrace();
        }
        //用反射创建对象
        MessageApi messageApi = null;
        try {
            messageApi = (MessageApi)Class.forName(properties.getProperty("ImplClass")).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return messageApi;
    }
}

class Client{
    public static void main(String[] args){
        //通过简单工厂获取接口对象
        MessageApi messageApi = SimpleFactory.createMessageApi();
        messageApi.sendMessage("测试简单工厂模式");
    }
}

/**
 * 通信接口可以通过简单工厂来创建
 */
interface MessageApi{
    //具体的功能方法
    void sendMessage(String msg);
}

/**
 * 接口的具体实现--QQ通信
 */
class QQMessageImpl implements MessageApi{
    @Override
    public void sendMessage(String msg) {
        System.out.println("通过QQ聊天工具发送消息："+msg);
    }
}

/**
 * 接口的具体实现--微信通信
 */
class WeChatMessageImpl implements MessageApi{
    @Override
    public void sendMessage(String msg) {
        System.out.println("通过微信聊天工具发送消息"+msg);
    }
}


