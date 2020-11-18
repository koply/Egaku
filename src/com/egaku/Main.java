package com.egaku;

import com.egaku.input.mouse.events.DragEvent;

import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.EventListener;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    private Main(){
        SwingUtilities.invokeLater(() -> {
            EgakuFrame.getInstance().setUndecorated(true);
            EgakuFrame.getInstance().setLocationRelativeTo(null);
            EgakuFrame.getInstance().setVisible(true);
            EgakuFrame.getInstance().prepareUI();
            EgakuFrame.getInstance().prepareFonts();
            implementEvents(EgakuFrame.getInstance());
        });
    }

    enum ImplementType {
        First,
        Second,
        All,
    }

    private void implementEvents(EgakuFrame _ef){
        DragEvent dragEvent = new DragEvent(_ef);
        implementMouseEvents(_ef, dragEvent, ImplementType.All);
    }

    private void implementMouseEvents(EgakuFrame _ef, EventListener eventListener, ImplementType implementType){
        if (implementType == ImplementType.First)
            _ef.addMouseListener((MouseListener) eventListener);
        else if (implementType == ImplementType.Second)
            _ef.addMouseMotionListener((MouseMotionListener) eventListener);
        else{
            _ef.addMouseListener((MouseListener) eventListener);
            _ef.addMouseMotionListener((MouseMotionListener) eventListener);
        }
    }
}