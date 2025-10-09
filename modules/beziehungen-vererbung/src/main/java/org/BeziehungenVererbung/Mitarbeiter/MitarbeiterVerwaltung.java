package org.BeziehungenVererbung.Mitarbeiter;

import org.BeziehungenVererbung.Mitarbeiter.model.Mitarbeiter;

import java.util.ArrayList;
import java.util.List;

public class MitarbeiterVerwaltung {
    private List<Mitarbeiter> mitarbeiterListe;

    public MitarbeiterVerwaltung() {
        this.mitarbeiterListe = new ArrayList<>();
    }

    public void neuenMitarbeiterHinzufügen(Mitarbeiter mitarbeiter) {
        mitarbeiterListe.add(mitarbeiter);
    }

    public void mitarbeiterEntlassen(int id) {
        mitarbeiterListe.removeIf(m -> m.getId() == id);
    }

    public void gehaltsListeErstellen() {
        double gesamtGehalt = 0;
        for (Mitarbeiter m : mitarbeiterListe) {
            System.out.println(m);
            gesamtGehalt += m.berechneGehalt();
        }
        System.out.println("Gesamtes Gehalt: " + gesamtGehalt);
    }
}

