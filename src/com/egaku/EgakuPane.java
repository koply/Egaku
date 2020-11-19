package com.egaku;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class EgakuPane extends JPanel {

    public EgakuPane() {
        super();
        setLayout(null);
    }

    private final LinkedList<IPicasso> picassos = new LinkedList<>();

    @Override
    protected void paintComponent(Graphics normalg) {
        super.paintComponent(normalg);
        Graphics2D g = (Graphics2D) normalg;
        for (IPicasso p : picassos) {
            p.paint(g);
        }
        g.dispose();
    }

    // TODO: tüm interface'leri listeye eklemek yerine ekranın son ss'i alınıp onu yazdıracağız. ondan sonra da interface çalıştırılacak

    public void render(IPicasso picasso) {
        picassos.add(picasso);
        this.repaint();
    }
}