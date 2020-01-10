package com.lj.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author : liangjun
 * @ClassName : JavaStreamDemo
 * @Description :
 * @Date : 2019/12/04 14:24
 */
public class JavaStreamDemo {

    public static void main(String[] args) {
        List<Integer> str = new ArrayList<Integer>();
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 4;
        Integer e = 5;
        str.add(a);
        str.add(b);
        str.add(c);
        str.add(d);
        str.add(e);
//        str.forEach(item -> {
//            if ("c".equals(item)) {
//                System.out.println(item);
//            }
//        });

        //最大值
        Integer reduceMax = Stream.of(a, b, c, d).reduce(Integer.MIN_VALUE, Integer::max);
        //最小值
        Integer reduceMin = Stream.of(a, b, c, d).reduce(Integer.MAX_VALUE, Integer::min);
        System.out.println(reduceMin);

    }

}
