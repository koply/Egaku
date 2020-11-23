package com.egaku.frames.colorpicker;

import com.egaku.utils.BiLinearGradient;
import com.egaku.utils.KValues;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static com.egaku.utils.GraphicUtil.addAntialias;
import static com.egaku.utils.KValues.*;

public class ColorPickerPane extends JPanel {

    public ColorPickerPane(ColorPickerFrame _cpf) {
        setLayout(null);
        colorPaletteImage = new BufferedImage(_cpf.getWidth(), _cpf.getHeight(), BufferedImage.TYPE_INT_ARGB);
    }

    private final BufferedImage colorPaletteImage;
    private final Color UPPER_LEFT = new Color(1.0f, 0.0f, 0.0f, 1.0f);
    private final Color UPPER_RIGHT = new Color(1.0f, 1.0f, 0.0f, 1.0f);
    private final Color LOWER_LEFT = new Color(0.0f, 0.0f, 1.0f, 1.0f);
    private final Color LOWER_RIGHT = new Color(0.0f, 1.0f, 1.0f, 1.0f);
    int colorPickerCursorX = 0, colorPickerCursorY = colorPickerFrameDragHeight;

    @Override
    protected void paintComponent(Graphics normalg) {
        super.paintComponent(normalg);

        BiLinearGradient bilinearpaint = new BiLinearGradient(0, 0, getWidth(),getHeight()- colorPickerFrameDragHeight, UPPER_LEFT, UPPER_RIGHT, LOWER_LEFT, LOWER_RIGHT);

        Graphics2D g = (Graphics2D) colorPaletteImage.getGraphics();

        addAntialias(g);

        g.setPaint(bilinearpaint);
        g.fillRect(0, colorPickerFrameDragHeight, getWidth(), getHeight());

        System.out.println("Sa my x "+getColorPickerCursorX());

        g.dispose();
        normalg.drawImage(colorPaletteImage, 0, 0,null);

        Graphics2D g2d = (Graphics2D) normalg;
        g2d.fillOval(getColorPickerCursorX(), getColorPickerCursorY(), colorPickerCursorSize, colorPickerCursorSize);
        g2d.dispose();
    }

    public final BufferedImage getColorPaletteImage() {
        return colorPaletteImage;
    }

    public int getColorPickerCursorX() {
        return colorPickerCursorX;
    }

    public int getColorPickerCursorY() {
        return colorPickerCursorY;
    }

    public void setColorPickerCursorX(int colorPickerCursorX) {
        this.colorPickerCursorX = colorPickerCursorX;
    }

    public void setColorPickerCursorY(int colorPickerCursorY) {
        this.colorPickerCursorY = colorPickerCursorY;
    }
}