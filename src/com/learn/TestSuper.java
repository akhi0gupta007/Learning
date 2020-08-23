package com.learn;

import java.util.ArrayList;
import java.util.List;

public class TestSuper extends SuperClass {
    public static void main(String[] args) throws Exception {
		TestSuper obj = new TestSuper();
        obj.method(3);
    }
//    String method(int i) throws RuntimeException, ArrayIndexOutOfBoundsException {
//        System.out.println("TestSuper");
//        return null;
//    }
    String method(Integer i) {
        System.out.println("base Integer wrapper ");
        return null;
    }
    Integer method(Object i) {
        System.out.println("base Object wrapper ");
        return null;
    }
    static void m1() throws Exception {
        try {
            throw new Exception();

        } catch (Exception ex) {
            System.out.println("caught");
            return;
        } finally {
            System.out.println("finally");
        }
    }
}

class SuperClass {
//    Object method(int i) throws NullPointerException {
//        System.out.println("SuperClass");
//        return null;
//    }


    Object method(Integer i, int x) {
        System.out.println("SuperClass wrapper Integer i,int x");
        return null;
    }

    Object method(int i, int x) {
        System.out.println("SuperClass wrapper int i,int x");
        return null;
    }

    Number method(Object i) {
        System.out.println("SuperClass Object wrapper");
        return null;
    }

    void method(String str) {
        System.out.println("String ");
    }

}