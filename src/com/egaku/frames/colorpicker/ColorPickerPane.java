package com.egaku.frames.colorpicker;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ColorPickerPane extends JPanel {

    public ColorPickerPane(ColorPickerFrame _cpf) {
        setLayout(null);
        colorPaletteImage = new BufferedImage(_cpf.getWidth(), _cpf.getHeight(), BufferedImage.TYPE_INT_ARGB);
    }

    private final BufferedImage colorPaletteImage;

    @Override
    protected void paintComponent(Graphics normalg) {
        super.paintComponent(normalg);

        Graphics2D g = (Graphics2D) colorPaletteImage.getGraphics();
        ColorPickerFrame.getInstance().getColorPickerPanel().draw(g);
        g.dispose();
        normalg.drawImage(colorPaletteImage, ColorPickerFrame.getInstance().getColorPickerPanel().getX(), ColorPickerFrame.getInstance().getColorPickerPanel().getY(),null);

        g = (Graphics2D) normalg;
        ColorPickerFrame.getInstance().getColorPickerPanel().drawPickerCursor(g);
        g.dispose();
    }

    public final BufferedImage getColorPaletteImage() {
        return colorPaletteImage;
    }
}