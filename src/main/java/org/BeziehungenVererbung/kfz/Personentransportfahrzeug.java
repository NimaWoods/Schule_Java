package org.BeziehungenVererbung.kfz;

import org.BeziehungenVererbung.Mitarbeiter.model.SchichtArbeiter;

public class Personentransportfahrzeug extends Kfz {
    protected int maxPassagiere;
    protected int aktuellePassagiere;

    public Personentransportfahrzeug(int maxTank, int maxPassagiere) {
        super(maxTank);
        this.maxPassagiere = maxPassagiere;
        this.aktuellePassagiere = 0;
    }

    public boolean einsteigen(int passagiere, boolean istMitarbeiter) {
        if (!istMitarbeiter || aktuellePassagiere + passagiere > maxPassagiere) {
            return false;
        }
        aktuellePassagiere += passagiere;
        return true;
    }

    public boolean aussteigen(int passagiere) {
        if (aktuellePassagiere - passagiere < 0) return false;
        aktuellePassagiere -= passagiere;
        return true;
    }

    @Override
    protected String benötigteFührerscheinKlasse() {
        return "B";
    }

    @Override
    public void fahren() {
        if (aktuellerTank > 0 && fahrer != null) {
            aktuellerTank--;
            System.out.println("Fährt zur nächsten GPS-Position...");
        } else {
            System.out.println("Tank leer oder kein Fahrer!");
        }
    }
}
