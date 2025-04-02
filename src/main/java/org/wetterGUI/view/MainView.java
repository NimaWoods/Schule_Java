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
    }

    private void addComponents() {
        AktuelleBedingungen aktuelleBedingungen = new AktuelleBedingungen();
        WetterVorhersage wetterVorhersage = new WetterVorhersage();

        add(aktuelleBedingungen);
        add(wetterVorhersage);
    }

    @Override
    public void update(double temperatur, double feuchtigkeit, double luftdruck) {
        // Update the labels with the new weather data
        temperaturLabel.setText("Temperatur: " + temperatur + " °C");
        feuchtigkeitLabel.setText("Feuchtigkeit: " + feuchtigkeit + " %");
        luftdruckLabel.setText("Luftdruck: " + luftdruck + " hPa");
    }
}