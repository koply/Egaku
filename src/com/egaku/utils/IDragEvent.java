package com.egaku.utils;

import com.egaku.EgakuFrame;

import java.awt.*;

public interface IDragEvent {
    int getMinY();
    int getMaxY();
    int getMinX();
    int getMaxX();
    void event(Point cp, int x, int y);
    void eventOnScreen(int x, int y);
}
