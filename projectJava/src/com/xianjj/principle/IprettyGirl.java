package com.xianjj.principle;

/**
 * JavaProject
 * Created by xian.juanjuan on 2017-7-10 15:10.
 */
//定义美女接口
public interface IprettyGirl {
    void greatLooks();//长相好
    void greatFigure();//身材好
    void greatTemperament();//气质佳
}

interface IgreatGril{
    void greatLooks();//长相好
    void greatFigure();//身材好
}

class PrettyGirl implements IgreatGril{
    private String name;
    public PrettyGirl(String name) {
        this.name = name;
    }

    @Override
    public void greatFigure() {
        System.out.println(name+"：身材非常好");
    }

    @Override
    public void greatLooks() {
        System.out.println(name+"：长相非常好");
    }

}

//抽象一个帅哥
abstract class IMan{
    protected IgreatGril prettyGirl;

    public IMan(IgreatGril prettyGirl) {
        this.prettyGirl = prettyGirl;
    }
    //帅哥开始找美女了
    public abstract void findGirl();
}

class Man extends IMan{

    public Man(IgreatGril prettyGirl) {
        super(prettyGirl);
    }

    @Override
    public void findGirl() {
        System.out.println("找到美女了。。。");
        super.prettyGirl.greatFigure();
        super.prettyGirl.greatLooks();
    }
}

class Beijing{//在北京找美女
    public static void main(String[] args){
        IgreatGril jiajai = new PrettyGirl("佳佳");
        IMan man = new Man(jiajai);
        man.findGirl();
    }
}