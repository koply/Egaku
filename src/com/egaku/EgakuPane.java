package com.egaku;

import com.egaku.utils.kValues;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class EgakuPane extends JPanel {

    public EgakuPane() {
        super();
        setLayout(null);
        int w = kValues.frameWidth;
        int h = kValues.frameHeight;
        img = new BufferedImage(w, h,BufferedImage.TYPE_INT_ARGB);
        colorPickerImage = new BufferedImage(EgakuFrame.getInstance().getColorPickerPanel().getWidth(), EgakuFrame.getInstance().getColorPickerPanel().getHeight(), BufferedImage.TYPE_INT_ARGB);
        paletteColor = new Color(200, 15, 0);
    }

    private IPicasso picas;
    private final BufferedImage img;
    private final BufferedImage colorPickerImage;
    private Color paletteColor;

    @Override
    protected void paintComponent(Graphics normalg) {
        super.paintComponent(normalg);

        Graphics2D g = (Graphics2D) img.getGraphics();
        picas.paint(g);
        g.dispose();
        normalg.drawImage(img,0,0,null);

        g = (Graphics2D) colorPickerImage.getGraphics();
        EgakuFrame.getInstance().getColorPickerPanel().draw(g);
        g.dispose();
        normalg.drawImage(colorPickerImage, EgakuFrame.getInstance().getColorPickerPanel().getX(), EgakuFrame.getInstance().getColorPickerPanel().getY(),null);

        g = (Graphics2D) normalg;
        EgakuFrame.getInstance().getColorPickerPanel().drawPickerCursor(g);
        g.dispose();

        normalg.dispose();
    }

    public void render(IPicasso picasso) {
        picas = picasso;
        this.repaint();
    }

    public Color getPaletteColor(){
        return paletteColor;
    }

    public void setPaletteColor(Color paletteColor) {
        this.paletteColor = paletteColor;
    }

    public BufferedImage getColorPickerImage() {
        return colorPickerImage;
    }
}