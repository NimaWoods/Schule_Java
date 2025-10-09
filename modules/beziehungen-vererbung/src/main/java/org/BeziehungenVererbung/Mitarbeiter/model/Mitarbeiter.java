package org.BeziehungenVererbung.Mitarbeiter.model;

public abstract class Mitarbeiter {
    protected int id;
    protected String name;

    public Mitarbeiter(int id, String name) {
        setId(id);
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0 || id < 1000 || id > 9999) {
            throw new IllegalArgumentException("ID muss positiv und vierstellig sein.");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public abstract double berechneGehalt();

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Gehalt: " + berechneGehalt();
    }
}
