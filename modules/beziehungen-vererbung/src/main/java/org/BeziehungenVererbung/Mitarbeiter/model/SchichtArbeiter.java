package org.BeziehungenVererbung.Mitarbeiter.model;

public class SchichtArbeiter extends Mitarbeiter {
    private double stundenSatz;
    private int anzahlStunden;
    private String führerscheinKlasse;

    public SchichtArbeiter(int id, String name, double stundenSatz) {
        super(id, name);
        if (!String.valueOf(id).startsWith("3")) {
            throw new IllegalArgumentException("Schichtarbeiter-IDs müssen mit 3 beginnen.");
        }
        this.stundenSatz = stundenSatz;
        this.anzahlStunden = 0;
    }

    public void arbeite() {
        this.anzahlStunden += 8; // Standard 8 Stunden
    }

    public void arbeite(int stunden) {
        if (stunden < 0) {
            throw new IllegalArgumentException("Gearbeitete Stunden müssen positiv sein.");
        }
        this.anzahlStunden += stunden;
    }

    public double getStundenSatz() {
        return stundenSatz;
    }

    public void setStundenSatz(double stundenSatz) {
        this.stundenSatz = stundenSatz;
    }

    public int getAnzahlStunden() {
        return anzahlStunden;
    }

    public void setAnzahlStunden(int anzahlStunden) {
        this.anzahlStunden = anzahlStunden;
    }

    public String getFührerscheinKlasse() {
        return führerscheinKlasse;
    }

    public void setFührerscheinKlasse(String führerscheinKlasse) {
        this.führerscheinKlasse = führerscheinKlasse;
    }

    @Override
    public double berechneGehalt() {
        return stundenSatz * anzahlStunden;
    }
}
