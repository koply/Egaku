package com.egaku.input.mouse;

import com.egaku.frames.colorpicker.ColorPickerFrame;
import com.egaku.frames.egaku.EgakuFrame;
import com.egaku.input.mouse.events.BrushEvent;
import com.egaku.input.mouse.events.DragEvent;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.EventListener;

public class MouseRegister {
    public enum MouseEventType {
        FrameDrag,
        ColorPickerDrag,
        ColorPickerColorPick,
        Brush,
    }
    enum ImplementType {
        First,
        Second,
        All,
    }

    private final EgakuFrame _ef;
    private final ColorPickerFrame _cpf;

    public MouseRegister(EgakuFrame _ef, ColorPickerFrame _cpf) {
        this._ef = _ef;
        this._cpf = _cpf;
    }

    public void implementEvents(){
        DragEvent dragEvent = new DragEvent(MouseEventType.FrameDrag){
            @Override
            public int getMinY() {
                return 0;
            }

            @Override
            public int getMaxY() {
                return 20;
            }

            @Override
            public int getMaxX() {
                return _ef.getWidth();
            }

            @Override
            public void dragEventWindow(Point cp, int x, int y) {
                _ef.setLocation(cp.x - x, cp.y - y);
            }
        };
        implementMouseEvents(_ef, dragEvent, ImplementType.All);
        DragEvent dragEventColorPicker = new DragEvent(MouseEventType.ColorPickerDrag){
            @Override
            public int getMinY() {
                return _cpf.getColorPickerPanel().getY();
            }

            @Override
            public int getMaxY() {
                return _cpf.getColorPickerPanel().getY() + 20;
            }

            @Override
            public int getMinX() {
                return _cpf.getColorPickerPanel().getX();
            }

            @Override
            public int getMaxX() {
                return _cpf.getColorPickerPanel().getX() + _cpf.getColorPickerPanel().getWidth();
            }

            @Override
            public void dragEventPanel(int x, int y) {
                //_cpf.getColorPickerPanel().setLocation(x, y, _ef);
            }
        };
        implementMouseEvents(_ef, dragEventColorPicker, ImplementType.All);
        DragEvent colorPickEvent = new DragEvent(MouseEventType.ColorPickerColorPick){
            @Override
            public int getMinY() {
                return _cpf.getColorPickerPanel().getY() + 20;
            }

            @Override
            public int getMaxY() {
                return _cpf.getColorPickerPanel().getY() + _cpf.getColorPickerPanel().getHeight();
            }

            @Override
            public int getMinX() {
                return _cpf.getColorPickerPanel().getX();
            }

            @Override
            public int getMaxX() {
                return _cpf.getColorPickerPanel().getX() + _cpf.getColorPickerPanel().getWidth();
            }

            @Override
            public void dragEventPanel(int x, int y) {
                _cpf.getColorPickerPanel().setPickColorLocation(x, y, _ef, _cpf);
            }

            @Override
            public void pressEvent(int x, int y) {
                _cpf.getColorPickerPanel().setPickColorLocation(x, y, _ef, _cpf);
            }
        };
        implementMouseEvents(_ef, colorPickEvent, ImplementType.All);
        BrushEvent brushEvent = new BrushEvent();
        implementMouseEvents(_ef, brushEvent, ImplementType.All);
    }

    private void implementMouseEvents(EgakuFrame _ef, EventListener eventListener, ImplementType implementType){
        if (implementType == ImplementType.First)
            _ef.addMouseListener((MouseListener) eventListener);
        else if (implementType == ImplementType.Second)
            _ef.addMouseMotionListener((MouseMotionListener) eventListener);
        else{
            _ef.addMouseListener((MouseListener) eventListener);
            _ef.addMouseMotionListener((MouseMotionListener) eventListener);
        }
    }
}
