package com.xianjj.patterns.adapter;

/**
 * JavaProject
 * Created by xian.juanjuan on 2017-7-19 16:52.
 */

/**
 * 客户端
 */
public class AdpterClient {
    public static void main(String[] args){
        AppleCharger target = new Adapter1(new AndroidCharger());
        target.chargeForApple();
        target.chargeForAndroid();
    }
}

/**
 * 源-Adaptee
 */
class AndroidCharger{
    public void chargeForAndroid(){
        System.out.println("为Android手机充电");
    }
}

/**
 * 目标-Target
 */
interface AppleCharger{
    void chargeForAndroid();
    void chargeForApple();
}

/**
 * 适配器-Adapter
 */
class Adapter extends AndroidCharger implements AppleCharger{
    @Override
    public void chargeForApple() {
        System.out.println("为Apple手机充电");
    }
}

class Adapter1 implements AppleCharger{
    AndroidCharger androidCharger = new AndroidCharger();

    public Adapter1(AndroidCharger androidCharger) {
        this.androidCharger = androidCharger;
    }

    @Override
    public void chargeForAndroid() {
        androidCharger.chargeForAndroid();
    }

    @Override
    public void chargeForApple() {//新增方法
        System.out.println("为Apple手机充电");
    }

    //如果技术能实现我还以为电脑充电，即实现了为多个源进行适配的功能
}

interface Code{
    void codeJava();
    void codeC();
    void codePhp();
}
abstract class CodeDefault implements Code{
    public void codeC() {
    }
    public void codeJava() {
    }
    public void codePhp() {
    }
}

class CodeImpl extends CodeDefault{
    @Override
    public void codeJava() {
        System.out.println("我只会用Java语言写代码");
    }
}