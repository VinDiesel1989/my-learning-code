package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class TestCode1 {

    public static void main(String[] args) {
        int a = 9;
        int b = a++; //先赋值给b, a再自己+1
        System.out.println(a);
        System.out.println(b);
        int c = ++a; //a先自己+1，再赋值给c
        System.out.println(a);
        System.out.println(c);


        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "1");
        map.put("3", "1");
        int hashCode = hash(map);
        System.out.println(hashCode);

    }


    static final int hash(Object key) {
        int h;
        // key.hashCode()：返回散列值也就是hashcode
        // ^：按位异或
        // >>>:无符号右移，忽略符号位，空位都以0补齐
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
