package com.egaku.input.mouse.events;

import com.egaku.EgakuFrame;
import com.egaku.input.mouse.Mouse;
import com.egaku.utils.IDragEvent;

import java.awt.*;
import java.awt.event.MouseEvent;

public class DragEvent extends Mouse implements IDragEvent {
    public DragEvent(){
    }

    private boolean dragging = false;
    private Point dragpoint = null;

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getY() >= getMinY() && e.getY() <= getMaxY() &&
        e.getX() >= getMinX() && e.getX() <= getMaxX()){
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
            event(cp, dragpoint.x, dragpoint.y);
            eventOnScreen(e.getX(), e.getY());
        }
    }

    @Override
    public int getMinY() {
        return 0;
    }

    @Override
    public int getMaxY() {
        return 0;
    }
    @Override
    public int getMinX() {
        return 0;
    }

    @Override
    public int getMaxX() {
        return 0;
    }

    @Override
    public void event(Point cp, int x, int y) {
    }

    @Override
    public void eventOnScreen(int x, int y) {
    }
}
