package org.example;

public class MainHundetest {

    public static void main(String[] args) {
        Hund bob = new Hund();
        bob.setGewicht(40.8);
        bob.setGroesse(80);
        bob.setRasse("Collie");
        bob.ausgabe();

        Mitarbeiter mitarbeiter = new Mitarbeiter();
        mitarbeiter.setId(1);
        mitarbeiter.setName("Max Mustermann");
        System.out.println(mitarbeiter);
    }

}
