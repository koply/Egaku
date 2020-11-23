package com.egaku.frames.colorpicker;

import com.egaku.frames.egaku.EgakuPane;
import com.egaku.ui.EgakuFrameTitle;
import com.egaku.utils.KValues;

import javax.swing.*;
import java.awt.*;

public class ColorPickerFrame extends JFrame {

    private static ColorPickerFrame instance;

    public static ColorPickerFrame getInstance() {
        if (instance == null) instance = new ColorPickerFrame();
        return instance;
    }

    private ColorPickerPane colorPickerPane;
    public final ColorPickerPane getPane() { return colorPickerPane; }

    private ColorPickerFrame() {
        setSize(KValues.colorPickerFrameWidth, KValues.colorPickerFrameHeight);
        setLayout(null);
    }


    public void prepareUI() {
        colorPickerPane = new ColorPickerPane(this);
        colorPickerPane.setBounds(0,0, KValues.colorPickerFrameWidth, KValues.colorPickerFrameHeight);
        add(colorPickerPane);
    }


}