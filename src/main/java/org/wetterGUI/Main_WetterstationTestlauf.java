package org.wetterGUI;

import org.wetterGUI.testlauf.WetterDaten;
import org.wetterGUI.view.AktuelleBedingungen;
import org.wetterGUI.view.MainView;
import org.wetterGUI.view.WetterVorhersage;

import java.util.Random;

public class Main_WetterstationTestlauf {
    static Random zM = new Random();

    public static void main(String[] args) {
        System.out.println("--------------WETTERSTATION PULL ohne Dauerreferenz--------------");
        WetterDaten wetterDaten = new WetterDaten(26, 50, 1000);

        AktuelleBedingungen aktuelleBedingungen = new AktuelleBedingungen();
        WetterVorhersage wetterVorhersage = new WetterVorhersage();

        // Adding the MainView as an observer
        wetterDaten.addObserver(aktuelleBedingungen);
        wetterDaten.addObserver(wetterVorhersage);

        // TESTLAUF
        try {
            // Simulation von 50 Änderungen der Wetterdaten
            for (int i = 0; i < 50; i++) {
                int welcher = zM.nextInt(3);
                double wert = 0;
                switch (welcher) {
                    case 0:
                        wetterDaten.setTemperatur(wetterDaten.getTemperatur() + zM.nextInt(8) - 4);
                        break;
                    case 1:
                        wert = wetterDaten.getFeuchtigkeit() + zM.nextInt(40) - 20;
                        if (wert >= 0)
                            wetterDaten.setFeuchtigkeit(wert);
                        break;
                    case 2:
                        wert = wetterDaten.getLuftdruck() + zM.nextInt(30) - 15;
                        if (wert >= 650)
                            wetterDaten.setLuftdruck(wert);
                        break;
                }
                Thread.sleep(1000);
            }

            // Observer wird entfernt
            wetterDaten.removeObserver(aktuelleBedingungen);
            wetterDaten.removeObserver(wetterVorhersage);
            Thread.sleep(500);
            wetterDaten.setLuftdruck(900);
            wetterDaten.setTemperatur(36);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}