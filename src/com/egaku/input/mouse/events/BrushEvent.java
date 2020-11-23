package com.egaku.input.mouse.events;

import com.egaku.frames.egaku.EgakuFrame;
import com.egaku.frames.egaku.EgakuPane;
import com.egaku.input.mouse.EgakuMouseListener;
import com.egaku.input.mouse.Mouse;
import com.egaku.input.mouse.MouseRegister;

import java.awt.*;
import java.awt.event.MouseEvent;

import static com.egaku.utils.KValues.egakuFrameDragHeight;

public class BrushEvent extends Mouse {

    private boolean pressed = false;
    private final MouseRegister.MouseEventType myType = MouseRegister.MouseEventType.Brush;
    private final EgakuPane pane;

    public BrushEvent() {
        pane = EgakuFrame.getInstance().getPane();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if( EgakuMouseListener.eventType != null) return;
        if(e.getY() > egakuFrameDragHeight){
            EgakuMouseListener.eventType = myType;
            final int size = 10;
            pressed = true;
            final Color lastColor = pane.getPaletteColor();
            pane.render((g) -> {
                lastx = e.getX();
                lasty = e.getY();
                g.setColor(lastColor);
                g.fillOval(e.getX()-(size/2), e.getY()-(size/2), size,size);
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
        if(myType != EgakuMouseListener.eventType){
            return;
        }
        final int size = 10;
        if (pressed) {
            if(!(e.getY() > egakuFrameDragHeight)){
                return;
            }
            final Color lastColor = pane.getPaletteColor();
            pane.render((g) -> {
                g.setColor(lastColor);
                g.fillOval(e.getX()-(size/2), e.getY()-(size/2), size,size);

                if ((lastx != Integer.MIN_VALUE && lasty != Integer.MIN_VALUE) && (Math.abs(e.getX()-lastx) != 1 || Math.abs(e.getY()-lasty) != 1)) {
                    g.setStroke(new BasicStroke(size, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
                    g.drawLine(lastx,lasty,e.getX(),e.getY());
                    lastx=e.getX();
                    lasty=e.getY();
                }
            });
        }
    }
}