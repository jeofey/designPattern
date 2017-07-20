package com.xianjj.patterns.singleton;

/**
 * 抽象工厂模式
 * Created by xian.juanjuan on 2017-7-14 10:52.
 */
public class AbstractFactoryTest {

    public static void main(String[] args){
        //客户选择并创建需要的产品对象
        AbstractFactory factory = new AppleFactory();
        //让店员配套起来即可
        phoneCharging(factory);
    }

    public static void phoneCharging(AbstractFactory factory){
        //店员找相应的工厂获取产品
        Phone phone = factory.createPhone();
        Charger charger = factory.createCharger();
        phone.buyPhone();
        charger.configureCharger();
    }
}

/**
 * 手机接口
 */
interface Phone{
    void buyPhone();//买手机
}

class AndroidPhone implements Phone{
    @Override
    public void buyPhone() {
        System.out.println("我买了一部Android手机");
    }
}

class ApplePhone implements Phone{
    @Override
    public void buyPhone() {
        System.out.println("我买了一部Apple手机");
    }
}

/**
 * 充电器接口
 */
interface Charger{
    void configureCharger();//配置充电器
}

class AndroidCharger implements Charger{
    @Override
    public void configureCharger() {
        System.out.println("给我配置了Android手机充电器");
    }
}

class AppleCharger implements Charger{
    @Override
    public void configureCharger() {
        System.out.println("给我配置了Apple手机充电器");
    }
}

/**
 * 手机工厂类
 */
class PhoneFactory{

    public static Phone createPhone(int type){
        Phone phone = null;
        if (1 == type){
            phone =  new AndroidPhone();
        } else if (2 == type){
            phone =  new ApplePhone();
        }
        return phone;
    }
}

/**
 * 充电器工厂类
 */
class ChargerFactory{
    public static Charger createCharger(int type){
        Charger charger = null;
        if (1 == type){
            charger = new AndroidCharger();
        } else if(2 == type){
            charger = new AppleCharger();
        }
        return charger;
    }
}

interface AbstractFactory{
    Phone createPhone();
    Charger createCharger();
}

class AndroidFactory implements AbstractFactory{
    @Override
    public Charger createCharger() {
        return new AndroidCharger();
    }

    @Override
    public Phone createPhone() {
        return new ApplePhone();
    }
}

class AppleFactory implements AbstractFactory{
    @Override
    public Charger createCharger() {
        return new AppleCharger();
    }

    @Override
    public Phone createPhone() {
        return new ApplePhone();
    }
}