package com.egaku.panels;

import com.egaku.EgakuFrame;
import com.egaku.utils.BiLinearGradient;
import com.egaku.utils.kValues;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class ColorPickerPanel {

    int x = kValues.frameWidth - 200, y = kValues.frameHeight - 300, width = 200, height = 300;
    boolean changed = false;

    public ColorPickerPanel() {
    }

    public void draw(Graphics2D g){
        final Color lastColor = g.getColor();
        final Paint _lastPaint = g.getPaint();

        final Color UPPER_LEFT = new Color(1.0f, 0.0f, 0.0f, 1.0f);
        final Color UPPER_RIGHT = new Color(1.0f, 1.0f, 0.0f, 1.0f);
        final Color LOWER_LEFT = new Color(0.0f, 0.0f, 1.0f, 1.0f);
        final Color LOWER_RIGHT = new Color(0.0f, 1.0f, 1.0f, 1.0f);


        BiLinearGradient bilinearpaint = new BiLinearGradient(this.changed ? 0 : x, 0, width,height-20, UPPER_LEFT, UPPER_RIGHT, LOWER_LEFT, LOWER_RIGHT);

        g.setPaint(bilinearpaint);
        g.fillRect(x,y+20,width,height);

        g.setColor(new Color(36, 36, 36));
        g.fillRect(x,y, width, 20);

        g.setColor(lastColor);
        g.setPaint(_lastPaint);
        this.changed = false;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setLocation(int x, int y, EgakuFrame _ef){
        if(x < 0 || x > _ef.getPane().getWidth()-_ef.getColorPickerPanel().getWidth()){
            if(x < 0)   x = 0;
            else x = _ef.getPane().getWidth()-_ef.getColorPickerPanel().getWidth();
        }
        if(y < 20 || y > _ef.getPane().getHeight()-_ef.getColorPickerPanel().getHeight()){
            if(y < 20)   y = 20;
            else y = _ef.getPane().getHeight()-_ef.getColorPickerPanel().getHeight();
        }

        final int oldX = this.x, oldY = this.y;
        this.x = x;
        this.y = y;
        this.changed = true;
        _ef.getPane().repaint(oldX, oldY, _ef.getColorPickerPanel().getWidth()+x, _ef.getColorPickerPanel().getHeight()+y);
        //_ef.getPane().render(this::draw);
    }

    public boolean isOnMe(int x, int y){
        if(x >= this.x && x <= this.x + this.width
        && y >= this.y && y <= this.y+this.height){
            return true;
        }
        return false;
    }

}
