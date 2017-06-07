package com.fileCopy;

import com.mylogger.Mylogger;

/**
 * Created by 尹恒 on 2017/6/7.
 */
public class Launcher {

    public static void main(String[] args) {
        FileCopy fileCopy = new FileCopy();
        fileCopy.start();
        Mylogger.log("start");
    }


}
