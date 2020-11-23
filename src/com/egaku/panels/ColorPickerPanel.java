package com.egaku.panels;

import com.egaku.frames.colorpicker.ColorPickerFrame;
import com.egaku.frames.egaku.EgakuFrame;
import com.egaku.utils.BiLinearGradient;
import com.egaku.utils.KValues;

import java.awt.*;

public class ColorPickerPanel {

    int x = KValues.frameWidth - 200, y = KValues.frameHeight - 300, width = 200, height = 300,
    selectedX = x, selectedY = y+20;
    boolean changed = false;

    public ColorPickerPanel() {
    }

    public void draw(Graphics2D g){
        final Color UPPER_LEFT = new Color(1.0f, 0.0f, 0.0f, 1.0f);
        final Color UPPER_RIGHT = new Color(1.0f, 1.0f, 0.0f, 1.0f);
        final Color LOWER_LEFT = new Color(0.0f, 0.0f, 1.0f, 1.0f);
        final Color LOWER_RIGHT = new Color(0.0f, 1.0f, 1.0f, 1.0f);


        BiLinearGradient bilinearpaint = new BiLinearGradient(0, 0, width,height-20, UPPER_LEFT, UPPER_RIGHT, LOWER_LEFT, LOWER_RIGHT);

        g.setPaint(bilinearpaint);
        g.fillRect(0,20,width,height);

        g.setColor(new Color(36, 36, 36));
        g.fillRect(0,0, width, 20);

        this.changed = false;
    }
    public void drawPickerCursor(Graphics2D g){
        g.fillOval(this.selectedX, this.selectedY, 10,10);
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

    public int getSelectedY() {
        return selectedY;
    }

    public void setPickColorLocation(int x, int y, EgakuFrame _ef, ColorPickerFrame _cpf){
        final int lastX = this.x, lastY = this.y;
        if(x < lastX || x > lastX+getWidth()-10){
            if(x < lastX)   x = lastX;
            else x = lastX+getWidth()-10;
        }
        if(y < lastY+20 || y > lastY+getHeight()-10){
            if(y < lastY+20)   y = lastY+20;
            else y = lastY+getHeight()-10;
        }

        int realX = x - _cpf.getColorPickerPanel().getX(), realY = y - _cpf.getColorPickerPanel().getY();
        _ef.getPane().setPaletteColor(new Color(_cpf.getPane().getColorPaletteImage().getRGB(realX, realY)));

        final int oldX = this.selectedX, oldY = this.selectedY;
        this.selectedX = x;
        this.selectedY = y;
        this.changed = true;
        //_ef.getPane().repaint(lastX, lastY, getWidth()+lastX, getHeight()+lastY);
        _ef.getPane().repaint();
    }

    public boolean isOnMe(int x, int y){
        if(x >= this.x && x <= this.x + this.width
        && y >= this.y && y <= this.y+this.height){
            return true;
        }
        return false;
    }

}
