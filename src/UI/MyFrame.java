package UI;

import com.fileCopy.FileCopy;
import com.mylogger.Mylogger;
import listener.ListenerAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by 尹恒 on 2017/6/7.
 */
public class MyFrame {

    String path, dest;

    public void show() {
        JFrame jFrame = new JFrame("FileCopy");
        jFrame.setResizable(true);
        jFrame.setSize(800, 600);
        JButton chooseFile = new JButton("choose");
        JButton destFile = new JButton("dest");
        JButton ok = new JButton("ok");
        JProgressBar jProgressBar = new JProgressBar();
        JTextArea jTextArea = new JTextArea();
        chooseFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mylogger.log("chooseBtn clicked.");

                JFileChooser jfc = new JFileChooser();
                jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                jfc.showDialog(new JLabel(), "选择");
                File file = jfc.getSelectedFile();
                Mylogger.log(file);
                path = file.getPath();
                jTextArea.append(path);
                Mylogger.log("from:" + path);

            }
        });

        destFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mylogger.log("destbtn clicked.");

                JFileChooser jfc = new JFileChooser();
                jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                jfc.showDialog(new JLabel(), "选择");
                File file = jfc.getSelectedFile();
                Mylogger.log(file);
                dest = file.getPath();
                jTextArea.append(dest);
                Mylogger.log("to:" + dest);
            }
        });

        ok.addActionListener(new ActionListener() {
            String name = new File(path).getName();
            String  newDest = dest + File.separator + name;
            @Override
            public void actionPerformed(ActionEvent e) {
                new FileCopy().fileCopy(path, dest, new ListenerAdapter() {
                    @Override
                    public void onClick(float p) {
                        super.onClick(p);
                        jProgressBar.setValue((int)p);
                    }

                    @Override
                    public void onComplate() {
                        super.onComplate();
                        Mylogger.log("done");
                    }
                });

            }
        });

        jFrame.add(chooseFile, BorderLayout.WEST);
        jFrame.add(destFile, BorderLayout.EAST);
        jFrame.add(ok, BorderLayout.SOUTH);
        jFrame.add(jProgressBar, BorderLayout.NORTH);

        jFrame.setVisible(true);
    }
}
