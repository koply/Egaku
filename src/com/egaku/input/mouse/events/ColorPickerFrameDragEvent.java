package com.egaku.input.mouse.events;

import com.egaku.frames.colorpicker.ColorPickerFrame;
import com.egaku.input.mouse.EgakuMouseListener;
import com.egaku.utils.KValues;

import java.awt.*;

import static com.egaku.input.mouse.MouseRegister.MouseEventType;

public class ColorPickerFrameDragEvent extends EgakuMouseListener {
    private final ColorPickerFrame _cpf;

    public ColorPickerFrameDragEvent(ColorPickerFrame _cpf){
        this._cpf = _cpf;
    }

    @Override
    public int getMinY() {
        return 0;
    }

    @Override
    public int getMaxY() {
        return KValues.colorPickerFrameDragHeight;
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
    public void dragEventWindow(Point cp, int x, int y) {
        _cpf.setLocation(cp.x - x, cp.y - y);
    }

    @Override
    public MouseEventType getEventType() {
        return MouseEventType.ColorPickerFrameDragEvent;
    }

}
