package com.egaku.input.mouse;

import com.egaku.frames.colorpicker.ColorPickerFrame;
import com.egaku.frames.egaku.EgakuFrame;
import com.egaku.input.mouse.events.BrushEvent;
import com.egaku.input.mouse.events.ColorPickerFrameDragEvent;
import com.egaku.input.mouse.events.ColorPickerSelectEvent;
import com.egaku.input.mouse.events.EgakuFrameDragEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.EventListener;

public class MouseRegister {
    public enum MouseEventType {
        EgakuFrameDragEvent,
        ColorPickerFrameDragEvent,
        ColorPickerSelectEvent,
        Brush,
    }
    enum ImplementType {
        First,
        Second,
        All,
    }

    private final EgakuFrame _ef;
    private final ColorPickerFrame _cpf;
    private static MouseRegister instance;

    public static MouseRegister getInstance() {
        if (instance == null) instance = new MouseRegister();
        return instance;
    }

    private MouseRegister(){
        this._ef = EgakuFrame.getInstance();
        this._cpf = ColorPickerFrame.getInstance();
    }

    public void implementEvents(){
        implementMouseEvents(_ef, new EgakuFrameDragEvent(_ef), ImplementType.All);
        implementMouseEvents(_cpf, new ColorPickerFrameDragEvent(_cpf), ImplementType.All);
        implementMouseEvents(_cpf, new ColorPickerSelectEvent(_cpf), ImplementType.All);
        BrushEvent brushEvent = new BrushEvent();
        implementMouseEvents(_ef, brushEvent, ImplementType.All);
    }

    private void implementMouseEvents(Object _class, EventListener eventListener, ImplementType implementType){
        if (implementType == ImplementType.First)
            ((JFrame)_class).addMouseListener((MouseListener) eventListener);
        else if (implementType == ImplementType.Second)
            ((JFrame)_class).addMouseMotionListener((MouseMotionListener) eventListener);
        else{
            ((JFrame)_class).addMouseListener((MouseListener) eventListener);
            ((JFrame)_class).addMouseMotionListener((MouseMotionListener) eventListener);
        }
    }
}
