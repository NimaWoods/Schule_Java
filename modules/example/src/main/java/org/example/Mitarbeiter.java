package org.example;


/**
 * Mitarbeiter Klasse mit den Attributen id und name und den dazugehörigen Getter und Setter Methoden
 *
 * @Author Niklas Fabritzius
 */
public class Mitarbeiter {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Mitarbeiter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
