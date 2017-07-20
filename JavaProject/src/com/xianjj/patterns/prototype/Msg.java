package com.xianjj.patterns.prototype;

import java.util.Random;

/**
 * JavaProject
 * Created by xian.juanjuan on 2017-7-19 11:44.
 */
public class Msg implements Cloneable{
    private String receiver;//收件人
    private String appellation;//称谓
    private String subject;
    private String context;

    public Msg(MsgTemplete msgTemplete) {
        this.context = msgTemplete.getContext();
        this.subject = msgTemplete.getSubject();
    }

    @Override
    public Msg clone(){
        Msg msg = null;
        try {
            msg = (Msg) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return msg;
    }

    public String getAppellation() {
        return appellation;
    }

    public void setAppellation(String appellation) {
        this.appellation = appellation;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

class MsgTemplete{
    private String subject="XX店铺会员送优惠券活动";
    private String context = "老会员只要下单即送价值1万元的优惠券，可低现金使用。。。";
    public String getSubject(){
        return this.subject;
    }
    public String getContext(){
        return this.context;
    }
}

class MsgClient{
    private static int SEND_MAX = 5;//发送短信的数量

    public static void sendMsg(Msg msg){
        System.out.println("收件人："+msg.getReceiver()+"；短信主题："+msg.getSubject()+"；短信内容："+msg.getAppellation()+msg.getContext());
    }
    public static void main(String[] args){
        int i = 0;
        //定义模板,可以从数据库读取
        Msg msg = new Msg(new MsgTemplete());
        while (i < SEND_MAX){
            //单独设定每条短信的特殊内容
            Msg msgClone = msg.clone();
            msgClone.setAppellation(getRandString(5)+"先生（女士）");
            msgClone.setReceiver(getRandString(5)+"@"+getRandString(3)+".com");
            //发送短信
            sendMsg(msgClone);
            i++;
        }
    }

    //获取指定长度的字符串模式收件人
    public static String getRandString(int maxLength){
        String source = "abcdefghijiklmnopqrstuvwrstABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer sb = new StringBuffer();
        Random rand = new Random();
        for (int i=0; i<maxLength; i++){
            sb.append(source.charAt(rand.nextInt(source.length())));
        }
        return sb.toString();
    }
}
