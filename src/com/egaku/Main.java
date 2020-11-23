package com.egaku;

import com.egaku.input.mouse.MouseRegister;
import com.egaku.input.mouse.events.BrushEvent;
import com.egaku.input.mouse.events.DragEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.EventListener;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    private Main(){
        new EgakuFrame();
        SwingUtilities.invokeLater(() -> {
            EgakuFrame.getInstance().setUndecorated(true);
            EgakuFrame.getInstance().setLocationRelativeTo(null);
            EgakuFrame.getInstance().setVisible(true);
            EgakuFrame.getInstance().prepareUI();
            EgakuFrame.getInstance().prepareFonts();
            new MouseRegister().implementEvents(EgakuFrame.getInstance());
        });
    }
}
