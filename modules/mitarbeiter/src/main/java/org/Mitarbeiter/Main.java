package org.Mitarbeiter;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        Mitarbeiter m1 = null;
        Mitarbeiter m2 = null;

        try {
            m1 = new Mitarbeiter(1, "Max Mustermann");
            m2 = new Mitarbeiter(2, "erika Mustermann");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(m1);
        System.out.println(m2);
    }

}
