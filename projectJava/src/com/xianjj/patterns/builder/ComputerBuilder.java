package com.xianjj.patterns.builder;

/**
 * JavaProject
 * Created by xian.juanjuan on 2017-7-17 14:07.
 */

/**
 * 电脑类：不管是联想还是方正电脑，都包含这些部件
 */
class Computer{
    private String board;//主板
    private String cpu;//CPU
    private String monitor;//显示器

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }
}

/**
 * 建造电脑的抽象类
 */
public abstract class ComputerBuilder {
    public abstract void buildBoard();
    public abstract void buildCPU();
    public abstract void buildMonitor();
    public abstract Computer getCompuer();
}

/**
 * ThinkPad建造类
 */
class ThinkPadBuilder extends ComputerBuilder{
    Computer computer = new Computer();
    @Override
    public void buildBoard() {
        computer.setBoard("ThinkPad主板");
    }

    @Override
    public void buildCPU() {
        computer.setCpu("ThinkPadCPU");
    }

    @Override
    public void buildMonitor() {
        computer.setMonitor("ThinkPad显示器");
    }

    @Override
    public Computer getCompuer() {
        return computer;
    }
}

/**
 * 电脑组装操作的封装类
 */
class ComputerDirector{
    public void constructComputer(ComputerBuilder builder){
        builder.buildBoard();
        builder.buildCPU();
        builder.buildMonitor();
    }
}

/**
 * 客户端
 */
class UserClient{
    public static void main(String[] args){
        ComputerDirector computerDirector = new ComputerDirector();
        // 创建ThinkPad生成器（工厂）
        ComputerBuilder builder = new ThinkPadBuilder();
        //调用ComputerDirector组装电脑
        computerDirector.constructComputer(builder);
        //得到组装好的电脑
        Computer computer = builder.getCompuer();
        System.out.println(computer.getBoard());
        System.out.println(computer.getCpu());
        System.out.println(computer.getMonitor());
    }
}

