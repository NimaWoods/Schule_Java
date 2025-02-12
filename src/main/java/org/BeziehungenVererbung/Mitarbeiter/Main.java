package org.BeziehungenVererbung.Mitarbeiter;

import org.BeziehungenVererbung.Mitarbeiter.model.BüroArbeiter;
import org.BeziehungenVererbung.Mitarbeiter.model.Manager;
import org.BeziehungenVererbung.Mitarbeiter.model.SchichtArbeiter;

public class Main {
    public static void main(String[] args) {
        MitarbeiterVerwaltung verwaltung = new MitarbeiterVerwaltung();

        SchichtArbeiter schichtArbeiter = new SchichtArbeiter(3001, "Hans", 20);
        schichtArbeiter.arbeite(40);

        BüroArbeiter büroArbeiter = new BüroArbeiter(5001, "Anna", 3000);

        Manager manager = new Manager(5002, "Lisa", 5000, 10);

        verwaltung.neuenMitarbeiterHinzufügen(schichtArbeiter);
        verwaltung.neuenMitarbeiterHinzufügen(büroArbeiter);
        verwaltung.neuenMitarbeiterHinzufügen(manager);

        verwaltung.gehaltsListeErstellen();
        verwaltung.mitarbeiterEntlassen(5001);
        verwaltung.gehaltsListeErstellen();
    }
}
