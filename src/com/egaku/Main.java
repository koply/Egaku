package com.egaku;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EgakuFrame.getInstance().setVisible(true);
            EgakuFrame.getInstance().test();
        });
    }
}
