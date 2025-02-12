package org.BeziehungenVererbung.kfz;

import org.BeziehungenVererbung.Mitarbeiter.model.SchichtArbeiter;

public abstract class Kfz {
    protected int maxTank;
    protected int aktuellerTank;
    protected SchichtArbeiter fahrer;

    public Kfz(int maxTank) {
        this.maxTank = maxTank;
        this.aktuellerTank = 0;
    }

    public int tanken(int liter) {
        int überschuss = 0;
        if (aktuellerTank + liter > maxTank) {
            überschuss = (aktuellerTank + liter) - maxTank;
            aktuellerTank = maxTank;
        } else {
            aktuellerTank += liter;
        }
        return überschuss;
    }

    public boolean setFahrer(SchichtArbeiter fahrer) {
        if (fahrer.getFührerscheinKlasse() == benötigteFührerscheinKlasse()) {
            this.fahrer = fahrer;
            return true;
        }
        return false;
    }

    protected abstract String benötigteFührerscheinKlasse();

    public abstract void fahren();
}
