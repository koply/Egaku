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
                lastx = e.getX();
                lasty = e.getY();
                g.setColor(new Color(220,90,90));
                g.fillOval(e.getX()-5, e.getY()-5, 10,10);
            });
        }
    }

    private int lastx;
    private int lasty;

    @Override
    public void mouseReleased(MouseEvent e) {
        if (pressed) pressed = false;

        lastx = Integer.MIN_VALUE;
        lasty = Integer.MIN_VALUE;

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (pressed) {
            pane.render((g) -> {
                g.setColor(new Color(220,90,90));
                g.fillOval(e.getX()-5, e.getY()-5, 10,10);

                if ((lastx != Integer.MIN_VALUE && lasty != Integer.MIN_VALUE) && (Math.abs(e.getX()-lastx) != 1 || Math.abs(e.getY()-lasty) != 1)) {
                    g.setStroke(new BasicStroke(10f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
                    g.drawLine(lastx,lasty,e.getX(),e.getY());
                    lastx=e.getX();
                    lasty=e.getY();
                }
            });
        }
    }
}