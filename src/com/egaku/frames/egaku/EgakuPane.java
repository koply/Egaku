package com.egaku.frames.egaku;

import com.egaku.utils.KValues;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class EgakuPane extends JPanel {

    public EgakuPane() {
        super();
        setLayout(null);
        int w = KValues.frameWidth;
        int h = KValues.frameHeight;
        img = new BufferedImage(w, h,BufferedImage.TYPE_INT_ARGB);
        paletteColor = new Color(200, 15, 0);
    }

    private IPicasso picas;
    private final BufferedImage img;
    private Color paletteColor;

    @Override
    protected void paintComponent(Graphics normalg) {
        super.paintComponent(normalg);

        Graphics2D g = (Graphics2D) img.getGraphics();
        picas.paint(g);
        g.dispose();
        normalg.drawImage(img,0,0,null);
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
}