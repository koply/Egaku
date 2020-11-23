package com.egaku.input.mouse;

import com.egaku.input.mouse.Mouse;
import com.egaku.input.mouse.MouseRegister;
import com.egaku.utils.IDragEvent;

import java.awt.*;
import java.awt.event.MouseEvent;

public class EgakuMouseListener extends Mouse implements IDragEvent {
    protected EgakuMouseListener(){
    }

    public static MouseRegister.MouseEventType eventType = null;
    private boolean dragging = false;
    private Point dragpoint = null;

    @Override
    public void mousePressed(MouseEvent e) {
        if(eventType != null) return;
        if(e.getY() >= getMinY() && e.getY() <= getMaxY() &&
        e.getX() >= getMinX() && e.getX() <= getMaxX()){
            eventType = getEventType();
            dragging = true;
            dragpoint = e.getPoint();
            pressEvent(e.getX(), e.getY());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        eventType = null;
        if(dragging){
            dragging = false;
            dragpoint = null;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(getEventType() != eventType){
            return;
        }
        if(dragging){
            Point cp = e.getLocationOnScreen();
            dragEventWindow(cp, dragpoint.x, dragpoint.y);
            dragEventPanel(e.getX(), e.getY());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(eventType != null) return;
        if(e.getY() >= getMinY() && e.getY() <= getMaxY() &&
                e.getX() >= getMinX() && e.getX() <= getMaxX()) {
            clickEvent(e.getX(), e.getY());
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
    public MouseRegister.MouseEventType getEventType() {
        return null;
    }

    @Override
    public void dragEventWindow(Point cp, int x, int y) {
    }

    @Override
    public void dragEventPanel(int x, int y) {
    }

    @Override
    public void pressEvent(int x, int y) {

    }

    @Override
    public void clickEvent(int x, int y) {

    }

}
