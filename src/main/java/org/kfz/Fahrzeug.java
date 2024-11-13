package org.kfz;

public class Fahrzeug {

    private double tankGroeße;
    private double tankInhalt;
    private double maximaleGeschwindigkeit;
    private double aktuelleGeschwindigkeit;
    private boolean motorLaeuft;

    public Fahrzeug(double tankGroeße, double maximaleGeschwindigkeit) {
        this.tankGroeße = tankGroeße;
        this.maximaleGeschwindigkeit = maximaleGeschwindigkeit;
        this.aktuelleGeschwindigkeit = 0;
        this.motorLaeuft = false;
        this.tankInhalt = 0;
    }

    public boolean isMotorLaeuft() {
        return motorLaeuft;
    }

    public void setMotorLaeuft(boolean motorLaeuft) {
        this.motorLaeuft = motorLaeuft;
    }

    public double getAktuelleGeschwindigkeit() {
        return aktuelleGeschwindigkeit;
    }

    public void setAktuelleGeschwindigkeit(double aktuelleGeschwindigkeit) {
        this.aktuelleGeschwindigkeit = aktuelleGeschwindigkeit;
    }

    public double getMaximaleGeschwindigkeit() {
        return maximaleGeschwindigkeit;
    }

    public void setMaximaleGeschwindigkeit(double maximaleGeschwindigkeit) {
        this.maximaleGeschwindigkeit = maximaleGeschwindigkeit;
    }

    public double getTankInhalt() {
        return tankInhalt;
    }

    public void setTankInhalt(double tankInhalt) {
        this.tankInhalt = tankInhalt;
    }

    public double getTankGroeße() {
        return tankGroeße;
    }

    public void setTankGroeße(double tankGroeße) {
        this.tankGroeße = tankGroeße;
    }

    public void beschleunigen(double geschwindigkeit) {
        if (motorLaeuft) {
            if (aktuelleGeschwindigkeit + geschwindigkeit <= maximaleGeschwindigkeit) {
                aktuelleGeschwindigkeit += geschwindigkeit;
            } else {
                aktuelleGeschwindigkeit = maximaleGeschwindigkeit;
            }
        }
    }

    public void bremsen(double geschwindigkeit) {
        if (motorLaeuft) {
            if (aktuelleGeschwindigkeit - geschwindigkeit >= 0) {
                aktuelleGeschwindigkeit -= geschwindigkeit;
            } else {
                aktuelleGeschwindigkeit = 0;
            }
        }
    }

    public void tanken(double liter) {
        if (tankInhalt + liter <= tankGroeße) {
            tankInhalt += liter;
        } else {
            tankInhalt = tankGroeße;
        }
    }

    public void starteMotor() {
        motorLaeuft = true;
    }

    public void stoppeMotor() {
        motorLaeuft = false;
    }

    public void fahren(double kilometer) {
        if (motorLaeuft && aktuelleGeschwindigkeit > 0) {
            double benoetigterKraftstoff = kilometer * 0.1;
            if (tankInhalt >= benoetigterKraftstoff) {
                tankInhalt -= benoetigterKraftstoff;
            } else {
                System.out.println("Nicht genug Kraftstoff für die Fahrt!");
            }
        } else {
            System.out.println("Motor ist aus oder das Fahrzeug steht.");
        }
    }

    @Override
    public String toString() {
        return "Tankgröße: " + tankGroeße +
                ", Maximale Geschwindigkeit: " + maximaleGeschwindigkeit +
                ", Aktuelle Geschwindigkeit: " + aktuelleGeschwindigkeit +
                ", Motor läuft: " + motorLaeuft;
    }
}
