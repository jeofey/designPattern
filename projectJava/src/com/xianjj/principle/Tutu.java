package com.xianjj.principle;

/**
 * JavaProject
 * Created by xian.juanjuan on 2017-7-10 14:36.
 */
public class Tutu {
    public void cook(Ifood ifood){
        ifood.eat();
    }
}

interface Ifood{
    public void eat();
}

class Noodles implements Ifood{
    @Override
    public void eat(){
        System.out.println("涂涂吃面条");
    }
}

class Rice implements Ifood{
    @Override
    public void eat() {
        System.out.println("涂涂吃米饭");
    }
}

class Eat{
    public static void main(String[] args){
        Tutu tutu = new Tutu();
        //涂涂会煮面条
        Ifood noodles = new Noodles();
        tutu.cook(noodles);
        //涂涂学会煮米饭
        Ifood rice = new Rice();
        tutu.cook(rice);
    }
}
