package com.egaku;

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
        DragEvent dragEvent = new DragEvent(){
            @Override
            public int getMinY() {
                return 0;
            }

            @Override
            public int getMaxY() {
                return 20;
            }

            @Override
            public int getMaxX() {
                return _ef.getWidth();
            }

            @Override
            public void event(Point cp, int x, int y) {
                _ef.setLocation(cp.x - x, cp.y - y);
            }
        };
        implementMouseEvents(_ef, dragEvent, ImplementType.All);
        DragEvent dragEventColorPicker = new DragEvent(){
            @Override
            public int getMinY() {
                return _ef.getColorPickerPanel().getY();
            }

            @Override
            public int getMaxY() {
                return _ef.getColorPickerPanel().getY() + 20;
            }

            @Override
            public int getMinX() {
                return _ef.getColorPickerPanel().getX();
            }

            @Override
            public int getMaxX() {
                return _ef.getColorPickerPanel().getX() + _ef.getColorPickerPanel().getWidth();
            }

            @Override
            public void eventOnScreen(int x, int y) {
                _ef.getColorPickerPanel().setLocation(x, y, _ef);
            }
        };
        implementMouseEvents(_ef, dragEventColorPicker, ImplementType.All);
        BrushEvent brushEvent = new BrushEvent();
        implementMouseEvents(_ef, brushEvent, ImplementType.All);
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
