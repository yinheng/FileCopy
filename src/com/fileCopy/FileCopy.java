package com.fileCopy;

import UI.MyFrame;
import com.mylogger.Mylogger;
import listener.ListenerAdapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by 尹恒 on 2017/6/7.
 */
public class FileCopy {

    public void start() {
        MyFrame myFrame = new MyFrame();
        myFrame.show();
    }

    public void fileCopy(String path, String dest, ListenerAdapter listenerAdapter) {
        File file = new File(path);
        if(file.exists() && file.isFile()) {
            try {
                FileInputStream fis = new FileInputStream(file.getPath());
                FileOutputStream fos = new FileOutputStream(dest);
                int num = fis.available();
                int n = 0;
                int total = 0;
                byte[] buffer = new byte[4094];
                while ((n =fis.read(buffer)) != -1) {
                    fos.write(buffer, 0, n);
                    fos.flush();
                    total += n;
                    Mylogger.log("total is %s", total);
                    float per = (float) (total/num) * 100;
                    listenerAdapter.onClick(per);
                }

            }
            catch(Exception e) {

            }
        }
        else {
            Mylogger.log("file not found");

        }

    }
}
