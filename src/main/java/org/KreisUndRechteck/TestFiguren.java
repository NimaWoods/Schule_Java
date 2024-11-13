package org.KreisUndRechteck;

public class TestFiguren {

    public static void main(String[] args) {

        Form kreis = new Form("Kreis", 5, 0, 0);
        System.out.println("Kreis Fläche: " + kreis.getFlaeche());
        System.out.println("Umfang Fläche: " + kreis.getUmfang());

        Form rechteck = new Form("Rechteck", 0, 5, 10);
        System.out.println("Rechteck Fläche: " + rechteck.getFlaeche());
        System.out.println("Rechteck Umfang: " + rechteck.getUmfang());

    }

}
