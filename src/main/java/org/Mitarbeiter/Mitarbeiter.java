package org.Mitarbeiter;

public class Mitarbeiter {

    public int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String name;

    public Mitarbeiter(int id, String name) throws IllegalArgumentException {
        this.id = id;

        String[] nameParts = name.split(" ");

        String vorname = nameParts[0];
        String nachname = nameParts[1];

        if (vorname.equals(vorname.toLowerCase())) {
            char firstLetter = vorname.charAt(0);
            char capitalFirstLetter = Character.toUpperCase(firstLetter);

            vorname = capitalFirstLetter + vorname.substring(1);
        } else if (nachname.equals(nachname.toLowerCase())) {
            char firstLetter = nachname.charAt(0);
            char capitalFirstLetter = Character.toUpperCase(firstLetter);

            nachname = capitalFirstLetter + nachname.substring(1);
        }

        this.name = vorname + " " + nachname;
    }

    public String toString() {
        return "Mitarbeiter ID: " + id + " Mitarbeite Name:" + name;
    }
}
