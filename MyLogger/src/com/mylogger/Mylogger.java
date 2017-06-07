package com.mylogger;

/**
 * Created by 尹恒 on 2017/6/7.
 */
public class Mylogger {

    public static  void log(String message) {
        System.out.println(message);
    }

    public static void log(Object o) {
        System.out.println(o);
    }

    public static void log(String format, Object o) {
        System.out.println(String.format(format, o));
    }
}
