package com.xianjj.patterns.bridge;

/**
 * JavaProject
 * Created by xian.juanjuan on 2017-7-20 09:50.
 */

/**
 * 抽象化角色:声明了operation方法，并给出了它的实现，该实现是通过向实现化对象的委派（调用operationImpl()方法）实现
 */
public abstract class Abstraction {
    protected Implementor impl;

    public Abstraction(Implementor impl) {
        this.impl = impl;
    }

    public void operation(){
        impl.operationImpl();
    }
    // 其他的操作方法
    public void otherOperation(){
    }
}

/**
 * 修正抽象化角色
 */
class RefinedAbstraction extends Abstraction{

    public RefinedAbstraction(Implementor impl) {
        super(impl);
    }
}

/**
 * 实现化角色：实现抽象部分需要的某些具体功能
 */
abstract class Implementor{
    public abstract void operationImpl();
}

/**
 * 具体实现化A
 */
class ConcreteImplementorA extends Implementor{
    @Override
    public void operationImpl() {
        System.out.println("具体实现化A");
    }
}

/**
 * 具体实现化B
 */
class ConcreteImplementorB extends Implementor{
    @Override
    public void operationImpl() {
        System.out.println("具体实现化B");
    }
}

class BridgeClient{
    public static void main(String[] args){
        Implementor impl = new ConcreteImplementorA();
        Abstraction abstraction = new RefinedAbstraction(impl);
        abstraction.operation();

        //把实现方式切换为B调用
        impl = new ConcreteImplementorB();
        abstraction = new RefinedAbstraction(impl);
        abstraction.operation();
    }
}

