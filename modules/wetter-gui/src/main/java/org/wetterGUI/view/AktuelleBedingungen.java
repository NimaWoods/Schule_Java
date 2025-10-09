package org.wetterGUI.view;

import org.wetterGUI.interfaces.WetterDatenObserver;

import javax.swing.*;

public class AktuelleBedingungen extends JPanel implements WetterDatenObserver {

    public AktuelleBedingungen() {
        setup();
    }

    private void setup() {

    }

    @Override
    public void update(double temperatur, double feuchtigkeit, double luftdruck) {

    }
}
