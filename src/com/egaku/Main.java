package com.egaku;

import com.egaku.frames.colorpicker.ColorPickerFrame;
import com.egaku.frames.egaku.EgakuFrame;
import com.egaku.input.mouse.MouseRegister;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    private Main(){
        SwingUtilities.invokeLater(() -> {
            EgakuFrame.getInstance().setUndecorated(true);
            EgakuFrame.getInstance().setLocationRelativeTo(null);
            EgakuFrame.getInstance().prepareUI();
            EgakuFrame.getInstance().setVisible(true);
            EgakuFrame.getInstance().prepareFonts();
            new MouseRegister(EgakuFrame.getInstance(), ColorPickerFrame.getInstance()).implementEvents();
            ColorPickerFrame.getInstance().setVisible(true);
        });
    }
}
