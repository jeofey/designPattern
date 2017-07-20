package com.xianjj.principle;

/**
 * JavaProject
 * Created by xian.juanjuan on 2017-7-10 10:59.
 */
public interface Ijuanjuan {
    //身高
    double getShengao();
    void setShengao(double height);
    //体重
    double getTizhong();
    void setTizhong(double weight);
    //吃完上班
    boolean chiFan(boolean hungry);
    boolean shangBan(boolean flag);
}

/**
 * BO:Bussiness Object
 */
interface IjuanjuanBO{
    //身高
    double getShengao();
    void setShengao(double height);
    //体重
    double getTizhong();
    void setTizhong(double weight);
}

/**
 * BL:Business Logic
 */
interface IjuanjuanBL{
    //吃完上班
    boolean chiFan(boolean hungry);
    boolean shangBan(boolean flag);
}

class JuanjuanBO implements IjuanjuanBO{

    private double height;
    private double weight;

    @Override
    public double getShengao() {
        return height;
    }

    @Override
    public double getTizhong() {
        return weight;
    }

    @Override
    public void setShengao(double height) {
        this.height = height;
    }

    @Override
    public void setTizhong(double weight) {
        this.weight = weight;
    }
}

class JuanjuanBL implements IjuanjuanBL{
    @Override
    public boolean chiFan(boolean hungry) {
        if(hungry){
            System.out.println("吃大餐。。。");
            return true;
        }
        return false;
    }

    @Override
    public boolean shangBan(boolean flag) {
        if (flag){
            System.out.println("上班中。。。");
            return true;
        }
        return false;
    }
}

