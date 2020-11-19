package com.egaku.input.mouse.events;

import com.egaku.EgakuFrame;
import com.egaku.input.mouse.Mouse;

import java.awt.*;
import java.awt.event.MouseEvent;

public class DragEvent extends Mouse {
    private final EgakuFrame ef;
    public DragEvent(EgakuFrame _ef){
        ef = _ef;
    }

    private boolean dragging = false;
    private Point dragpoint = null;

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getY() >= 0 && e.getY() <= 20){
            dragging = true;
            dragpoint = e.getPoint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(dragging){
            dragging = false;
            dragpoint = null;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(dragging){
            Point cp = e.getLocationOnScreen();
            ef.setLocation(cp.x - dragpoint.x, cp.y - dragpoint.y);
        }
    }
}
