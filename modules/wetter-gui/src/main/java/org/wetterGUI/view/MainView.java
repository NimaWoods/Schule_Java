package org.wetterGUI.view;

import lombok.Getter;
import org.wetterGUI.interfaces.WetterDatenObserver;

import javax.swing.*;
import java.awt.*;

@Getter
public class MainView extends JFrame {

    private JLabel temperaturLabel;
    private JLabel feuchtigkeitLabel;
    private JLabel luftdruckLabel;

    public MainView() {
        setupWindow();
        addComponents();
    }

    private void setupWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setSize(400, 300);

        setVisible(true);
    }

    private void addComponents() {
        AktuelleBedingungen aktuelleBedingungen = new AktuelleBedingungen();
        WetterVorhersage wetterVorhersage = new WetterVorhersage();

        add(aktuelleBedingungen);
        add(wetterVorhersage);
    }
}