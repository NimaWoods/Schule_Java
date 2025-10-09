package org.wetterGUI.testlauf;

import lombok.Getter;
import org.wetterGUI.interfaces.WetterDatenObserver;

import java.util.ArrayList;
import java.util.List;

@Getter
public class WetterDaten {

    private double temperatur;
    private double feuchtigkeit;
    private double luftdruck;
    private List<WetterDatenObserver> observers;

    public WetterDaten(double t, double f, double l) {
        this.observers = new ArrayList<>();
        this.setTemperatur(t);
        this.setFeuchtigkeit(f);
        this.setLuftdruck(l);
    }

    public void setTemperatur(double temperatur) {
        if (temperatur >= -90 && temperatur <= 60) {
            this.temperatur = temperatur;
            notifyObservers();
        }
    }

    public void setFeuchtigkeit(double feuchtigkeit) {
        if (feuchtigkeit >= 0 && feuchtigkeit <= 100) {
            this.feuchtigkeit = feuchtigkeit;
            notifyObservers();
        }
    }

    public void setLuftdruck(double luftdruck) {
        if (luftdruck >= 100 && luftdruck <= 1050) {
            this.luftdruck = luftdruck;
            notifyObservers();
        }
    }

    public void addObserver(WetterDatenObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WetterDatenObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (WetterDatenObserver observer : observers) {
            observer.update(temperatur, feuchtigkeit, luftdruck);
        }
    }
}