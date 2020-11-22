package com.egaku.input.mouse.events;

import com.egaku.EgakuFrame;
import com.egaku.EgakuPane;
import com.egaku.input.mouse.Mouse;

import java.awt.*;
import java.awt.event.MouseEvent;

import static com.egaku.utils.kValues.kDraggableHeight;

public class BrushEvent extends Mouse {

    private boolean pressed = false;
    private final EgakuPane pane;

    public BrushEvent() {
        pane = EgakuFrame.getInstance().getPane();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        final int size = 10;
        if(e.getY() > kDraggableHeight && !EgakuFrame.getInstance().getColorPickerPanel().isOnMe(e.getX(), e.getY())){
            pressed = true;
            pane.render((g) -> {
                lastx = e.getX();
                lasty = e.getY();
                g.setColor(pane.getPaletteColor());
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
        final int size = 10;
        if (pressed) {
            if(!(e.getY() > kDraggableHeight)){
                return;
            }
            pane.render((g) -> {
                g.setColor(pane.getPaletteColor());
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