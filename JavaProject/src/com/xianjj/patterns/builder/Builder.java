package com.xianjj.patterns.builder;

/**
 * JavaProject
 * Created by xian.juanjuan on 2017-7-17 11:20.
 */

/**
 * 建造者接口
 */
public interface Builder {
    void buildPartA();
    void buildPartB();
    void buildPartC();
    Product getResult();
}

/**
 * 具体建造者
 */
class ConcreteBuilder implements Builder{
    Part partA, partB, partC;

    @Override
    public void buildPartA() {
        //创建partA
    }

    @Override
    public void buildPartB() {
        //创建partB
    }

    @Override
    public void buildPartC() {
        //创建partC
    }

    @Override
    public Product getResult() {
        return null;//返回最后的组装结果
    }
}

/**
 * 指挥者类
 */
class Director{
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct(){
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
    }
}

/**
 * 客户端
 */
class Client{
    public static void main(String[] args){
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();
        Product product = builder.getResult();
    }
}

interface Part{}
interface Product{}
