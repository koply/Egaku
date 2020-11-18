package com.egaku.panels;

import com.egaku.EgakuFrame;
import com.egaku.utils.kValues;

import java.awt.*;

public class TitlePanel {

    public static void drawTitle(Graphics2D g){
        final Color lastColor = g.getColor();

        g.setColor(new Color(0,0,0));
        g.fillRect(0,0,kValues.frameWidth, kValues.kDraggableHeight);

        g.setColor(new Color(105,50,70));
        g.fillRect(kValues.frameWidth - kValues.title_button_width,0,kValues.title_button_width,kValues.kDraggableHeight);

        g.setColor(new Color(60, 170, 37));
        g.fillRect(kValues.frameWidth - kValues.title_button_width - (int)(kValues.title_button_margin*1.25),0,kValues.title_button_width, kValues.kDraggableHeight);

        EgakuFrame.getInstance().oswaldfont = EgakuFrame.getInstance().oswaldfont.deriveFont(Font.PLAIN, 20f);
        g.setColor(Color.white);
        g.setFont(EgakuFrame.getInstance().oswaldfont);
        g.drawString("Egaku Art", 10, 18);

        g.setColor(lastColor);
    }

}
