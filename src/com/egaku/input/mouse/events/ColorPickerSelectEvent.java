package com.egaku.input.mouse.events;

import com.egaku.frames.colorpicker.ColorPickerFrame;
import com.egaku.frames.egaku.EgakuFrame;
import com.egaku.input.mouse.EgakuMouseListener;
import com.egaku.utils.KValues;

import java.awt.*;

import static com.egaku.input.mouse.MouseRegister.MouseEventType;

public class ColorPickerSelectEvent extends EgakuMouseListener {
    private final ColorPickerFrame _cpf;

    public ColorPickerSelectEvent(ColorPickerFrame _cpf){
        this._cpf = _cpf;
    }

    private void updateColor(int x, int y){
        if(x < getMinX())   x = getMinX();
        else if(x > getMaxX()-KValues.colorPickerCursorSize) x = getMaxX()-KValues.colorPickerCursorSize;
        if(y < getMinY())   y = getMinY();
        else if(y > getMaxY()-KValues.colorPickerCursorSize) y = getMaxY()-KValues.colorPickerCursorSize;

        EgakuFrame.getInstance().getPane().setPaletteColor(new Color(_cpf.getPane().getColorPaletteImage().getRGB(x, y)));
        _cpf.getPane().setColorPickerCursorX(x);
        _cpf.getPane().setColorPickerCursorY(y);
        System.out.println("Color picker x: "+_cpf.getPane().getColorPickerCursorX()+" Y: "+_cpf.getPane().getColorPickerCursorY());
        _cpf.getPane().repaint();
    }

    @Override
    public int getMinY() {
        return KValues.colorPickerFrameDragHeight;
    }

    @Override
    public int getMaxY() {
        return KValues.colorPickerFrameHeight;
    }

    @Override
    public int getMinX() {
        return 0;
    }

    @Override
    public int getMaxX() {
        return KValues.colorPickerFrameWidth;
    }

    @Override
    public void dragEventPanel(int x, int y) {
        updateColor(x, y);
    }

    @Override
    public void pressEvent(int x, int y) {
        updateColor(x, y);
    }

    @Override
    public MouseEventType getEventType() {
        return MouseEventType.ColorPickerSelectEvent;
    }

}
