package com.egaku.frames.egaku;

import com.egaku.utils.KValues;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static com.egaku.panels.TitlePanel.drawTitle;

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
            g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);

            g.setColor(new Color(141, 141, 141));
            g.fillRect(0,0,getWidth(),getHeight());
            drawTitle(g);
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