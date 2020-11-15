package com.egaku;

import javax.swing.*;
import java.awt.*;

public class EgakuFrame extends JFrame {

    private static EgakuFrame instance;
    public static EgakuFrame getInstance() {
        if (instance == null) instance = new EgakuFrame();
        return instance;
    }

    private final EgakuPane pane;

    public EgakuFrame() {
        setTitle("描く");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        pane = new EgakuPane();
        pane.setBounds(0,0,800,600);
        add(pane);

    }

    public void test() {
        pane.render((g) -> {
            g.setColor(new Color(50,150,50));
            g.fillRect(100,100,600,400);
        });
    }
}