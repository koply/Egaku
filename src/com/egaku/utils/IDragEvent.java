package com.egaku.utils;

import com.egaku.EgakuFrame;

import java.awt.*;

public interface IDragEvent {
    int getMinY();
    int getMaxY();
    int getMinX();
    int getMaxX();
    void dragEventWindow(Point cp, int x, int y);
    void dragEventPanel(int x, int y);
    void clickEvent(int x, int y);
}
