package com.egaku.panels;

import com.egaku.frames.egaku.EgakuFrame;
import com.egaku.utils.KValues;

import java.awt.*;

public class TitlePanel {

    public static void drawTitle(Graphics2D g){
        final Color lastColor = g.getColor();

        g.setColor(new Color(0,0,0));
        g.fillRect(0,0, KValues.frameWidth, KValues.kDraggableHeight);

        g.setColor(new Color(105,50,70));
        g.fillRect(KValues.frameWidth - KValues.title_button_width,0, KValues.title_button_width, KValues.kDraggableHeight);

        g.setColor(new Color(60, 170, 37));
        g.fillRect(KValues.frameWidth - KValues.title_button_width - (int)(KValues.title_button_margin*1.25),0, KValues.title_button_width, KValues.kDraggableHeight);

        EgakuFrame.getInstance().oswaldfont = EgakuFrame.getInstance().oswaldfont.deriveFont(Font.PLAIN, 20f);
        g.setColor(Color.white);
        g.setFont(EgakuFrame.getInstance().oswaldfont);
        g.drawString("Egaku Art", 10, 18);

        g.setColor(lastColor);
    }

}
