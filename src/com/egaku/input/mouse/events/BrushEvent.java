package com.egaku.input.mouse.events;

import com.egaku.EgakuFrame;
import com.egaku.EgakuPane;
import com.egaku.input.mouse.Mouse;

import java.awt.*;
import java.awt.event.MouseEvent;

public class BrushEvent extends Mouse {

    private boolean pressed = false;
    private final EgakuPane pane;

    public BrushEvent() {
        pane = EgakuFrame.getInstance().getPane();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getY() > 20){
            pressed = true;
            pane.render((g) -> {

                g.setColor(new Color(90,170,250));
                g.fillOval(e.getX()-9, e.getY()-9, 18,18);
            });
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (pressed) pressed = false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (pressed) {
            pane.render((g) -> {
                g.setColor(new Color(90,170,250));
                g.fillOval(e.getX()-9, e.getY()-9, 18,18);
            });
        }
    }
}