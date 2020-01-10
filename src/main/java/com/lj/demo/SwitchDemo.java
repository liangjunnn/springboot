package com.lj.demo;

/**
 * @author : liangjun
 * @ClassName : SwitchDemo
 * @Description :
 * @Date : 2019/12/06 15:09
 */
public class SwitchDemo {

    public String getSwitch(Integer i) {
        String s = null;
        switch (i) {
            case 1:
                s = getHello();
                break;
            case 2:
                s = getHi();
                break;
            case 3:
                s = getStr();
                break;
        }
        return s;
    }

    public String getHello() {
        return "Hello";
    }

    public String getHi() {
        return "Hi";
    }

    public String getStr() {
        return "你好";
    }

    public static void main(String[] args) {
        SwitchDemo s = new SwitchDemo();
        String aSwitch = s.getSwitch(3);
        System.out.println(aSwitch);
    }
}
