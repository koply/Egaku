package com.egaku.frames.egaku;

import com.egaku.ui.EgakuFrameTitle;
import com.egaku.utils.KValues;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static com.egaku.utils.GraphicUtil.addAntialias;

public class EgakuFrame extends JFrame {

    private static EgakuFrame instance;
    public static EgakuFrame getInstance() {
        if (instance == null) instance = new EgakuFrame();
        return instance;
    }

    private EgakuPane pane;
    public final EgakuPane getPane() {return pane;}

    private EgakuFrame() {
        //描く
        setTitle("Egaku Art");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(KValues.frameWidth, KValues.frameHeight);
    }

    // calls at main
    public void prepareUI() {
        pane = new EgakuPane();
        pane.setBounds(0,0, KValues.frameWidth, KValues.frameHeight);
        add(pane);
        pane.render((g) -> {
            addAntialias(g);

            g.setColor(new Color(141, 141, 141));
            g.fillRect(0,0,getWidth(),getHeight());
            EgakuFrameTitle.draw(g);
        });
    }

    public Font oswaldfont = null;
    public void prepareFonts() {
        try {
            oswaldfont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/oswaldlight.ttf"));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }
}