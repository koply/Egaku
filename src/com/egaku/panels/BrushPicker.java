package com.egaku.panels;

import com.egaku.EgakuFrame;
import com.egaku.utils.BiLinearGradient;
import com.egaku.utils.kValues;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class BrushPicker {

    int x = kValues.frameWidth - 200, y = kValues.frameHeight - 300, width = 200, height = 300,
            selectedX = x;

    public BrushPicker() {
    }

    public void draw(Graphics2D g){
        g.setColor(new Color(36, 36, 36));
        g.fillRoundRect(0,0,width, height, 20, 20);
    }
    public void drawPickerSlider(Graphics2D g){
        g.fillOval(this.selectedX, 0, 10,10);
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

    public int getSelectedX() {
        return selectedX;
    }

    public void setPickColorLocation(int x, int y, EgakuFrame _ef){
        final int lastX = this.x, lastY = this.y;
        if(x < lastX || x > lastX+getWidth()-10){
            if(x < lastX)   x = lastX;
            else x = lastX+getWidth()-10;
        }
        if(y < lastY+20 || y > lastY+getHeight()-10){
            if(y < lastY+20)   y = lastY+20;
            else y = lastY+getHeight()-10;
        }

        int realX = x - _ef.getColorPickerPanel().getX(), realY = y - _ef.getColorPickerPanel().getY();
        _ef.getPane().setPaletteColor(new Color(_ef.getPane().getColorPickerImage().getRGB(realX, realY)));

        final int oldX = this.selectedX;
        this.selectedX = x;
        _ef.getPane().repaint(lastX, lastY, getWidth()+lastX, getHeight()+lastY);
    }

    public void setLocation(int x, int y, EgakuFrame _ef){
        if(x < 0 || x > _ef.getPane().getWidth()-getWidth()){
            if(x < 0)   x = 0;
            else x = _ef.getPane().getWidth()-getWidth();
        }
        if(y < 20 || y > _ef.getPane().getHeight()-getHeight()){
            if(y < 20)   y = 20;
            else y = _ef.getPane().getHeight()-getHeight();
        }

        final int oldX = this.x, oldY = this.y;
        this.x = x;
        this.y = y;
        _ef.getPane().repaint(oldX, oldY, getWidth()+x, getHeight()+y);
        setPickColorLocation(this.selectedX+(x-oldX), (y-oldY), _ef);
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
