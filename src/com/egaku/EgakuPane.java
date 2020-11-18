package com.egaku;

import javax.swing.*;
import java.awt.*;

public class EgakuPane extends JPanel {

    public EgakuPane() {
        super();
        setLayout(null);
    }

    private IPicasso picasso;

    @Override
    protected void paintComponent(Graphics normalg) {
        super.paintComponent(normalg);
        Graphics2D g = (Graphics2D) normalg;

        picasso.paint(g);
        g.dispose();
    }

    public void render(IPicasso picasso) {
        this.picasso = picasso;
        this.repaint();
    }
}