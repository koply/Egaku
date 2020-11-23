package com.egaku.input.mouse.events;

import com.egaku.frames.egaku.EgakuFrame;
import com.egaku.input.mouse.EgakuMouseListener;
import com.egaku.utils.KValues;

import java.awt.*;

import static com.egaku.input.mouse.MouseRegister.MouseEventType;

public class EgakuFrameDragEvent extends EgakuMouseListener {
    private final EgakuFrame _ef;

    public EgakuFrameDragEvent(EgakuFrame _ef){
        this._ef = _ef;
    }

    @Override
    public int getMinY() {
        return 0;
    }

    @Override
    public int getMaxY() {
        return KValues.egakuFrameDragHeight;
    }

    @Override
    public int getMinX() {
        return 0;
    }

    @Override
    public int getMaxX() {
        return KValues.frameWidth;
    }

    @Override
    public void dragEventWindow(Point cp, int x, int y) {
        _ef.setLocation(cp.x - x, cp.y - y);
    }

    @Override
    public MouseEventType getEventType() {
        return MouseEventType.EgakuFrameDragEvent;
    }

}
