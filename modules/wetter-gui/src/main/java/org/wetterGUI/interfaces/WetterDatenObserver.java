package org.wetterGUI.interfaces;

public interface WetterDatenObserver {
    void update(double temperatur, double feuchtigkeit, double luftdruck);
}