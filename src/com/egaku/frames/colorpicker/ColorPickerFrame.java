package com.egaku.frames.colorpicker;

import com.egaku.panels.ColorPickerPanel;
import com.egaku.utils.KValues;

import javax.swing.*;

public class ColorPickerFrame extends JFrame {

    private static ColorPickerFrame instance;

    public static ColorPickerFrame getInstance() {
        if (instance == null) instance = new ColorPickerFrame();
        return instance;
    }

    private final ColorPickerPane colorPickerPane;
    public ColorPickerPane getPane() { return colorPickerPane; }

    private final ColorPickerPanel colorPickerPanel;
    public final ColorPickerPanel getColorPickerPanel() { return colorPickerPanel; }

    public ColorPickerFrame() {
        setSize(KValues.colorPickerFrameWidth, KValues.colorPickerFrameHeight);
        setLayout(null);
        setUndecorated(true);
        colorPickerPane = new ColorPickerPane(this);
        colorPickerPanel = new ColorPickerPanel();
    }


    public void prepareUI() {

    }


}