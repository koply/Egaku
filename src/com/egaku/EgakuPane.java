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
    }

    private IPicasso picas;
    private final BufferedImage img;

    @Override
    protected void paintComponent(Graphics normalg) {
        super.paintComponent(normalg);

        Graphics2D g = (Graphics2D) img.getGraphics();
        picas.paint(g);
        g.dispose();

        normalg.drawImage(img,0,0,null);

        Graphics2D g2 = (Graphics2D) normalg;
        EgakuFrame.getInstance().getColorPickerPanel().draw(g2);
        g2.dispose();

        normalg.dispose();
    }

    public void render(IPicasso picasso) {
        picas = picasso;
        this.repaint();
    }
}