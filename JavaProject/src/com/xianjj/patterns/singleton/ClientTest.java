package com.xianjj.patterns.singleton;

/**
 * 工厂方法模式示例
 * Created by xian.juanjuan on 2017-7-14 09:30.
 */
public class ClientTest {
    public static void main(String[] args){
        //实例化水果工厂
        FruitFactory fruitFactory = new AppleFactoryImpl();
        FruitFactory fruitFactory1 = new GrapeFactoryImpl();
        //从水果工厂生产水果
        Fruit fruit = fruitFactory.factory();
        Fruit fruit1 = fruitFactory1.factory();
        //不同水果的生长过程
        fruit.plant();
        fruit1.harvest();
    }
}

/**
 * 水果接口
 */
interface Fruit{
    void plant();//种植
    void harvest();//收获
}

/**
 * 水果工厂的产品：苹果
 */
class Apple implements Fruit{
    private int treeAget;//树龄

    @Override
    public void harvest() {
        System.out.println("苹果已经收获。。。");
    }

    @Override
    public void plant() {
        System.out.println("苹果已经种植。。。");
    }

    public int getTreeAget() {
        return treeAget;
    }

    public void setTreeAget(int treeAget) {
        this.treeAget = treeAget;
    }
}

/**
 * 水果工厂的产品：葡萄
 */
class Grape implements Fruit{
    private boolean seedless;//是否有籽

    @Override
    public void harvest() {
        System.out.println("葡萄已经收获。。。");
    }

    @Override
    public void plant() {
        System.out.println("葡萄已经种植。。。");
    }

    public boolean isSeedless() {
        return seedless;
    }

    public void setSeedless(boolean seedless) {
        this.seedless = seedless;
    }
}

/**
 * 水果工厂接口
 */
interface FruitFactory{
    Fruit factory();
}

/**
 * 苹果工厂实现
 */
class AppleFactoryImpl implements FruitFactory{
    @Override
    public Fruit factory() {
        Fruit fruit = new Apple();
        System.out.println("水工工厂成功创建一个水果：苹果");
        return fruit;
    }
}

/**
 * 葡萄工厂实现
 */
class GrapeFactoryImpl implements FruitFactory{
    @Override
    public Fruit factory() {
        Fruit fruit = new Grape();
        System.out.println("水工工厂成功创建一个水果：葡萄");
        return fruit;
    }
}
