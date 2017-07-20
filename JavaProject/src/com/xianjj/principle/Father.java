package com.xianjj.principle;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * JavaProject
 * Created by xian.juanjuan on 2017-7-10 14:01.
 */
public class Father {
    public Collection say(HashMap hashMap){
        System.out.println("father 被执行");
        return hashMap.values();
    }
}

class Son extends Father{
    public Collection say(Map map) {
        System.out.println("son 被执行");
        return map.values();
    }
}

class Home{
    public static void main(String[] args){
        invoke();
    }

    public static void invoke(){
        Son son = new Son();
        HashMap hashMap = new HashMap();
        son.say(hashMap);
        Map map = new HashMap<>();
        son.say(map);

        Father father = new Father();
        HashMap hashMap1 = new HashMap();
        father.say(hashMap1);
    }
}
