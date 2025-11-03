package org.example;

public abstract class Antrenor {
    protected String nume;
    protected String tipClasaPredata;

    public Antrenor(String nume, String tipClasaPredata) {
        this.nume = nume;
        this.tipClasaPredata = tipClasaPredata;
    }

    public String getNume() {
        return nume;
    }

    public String getTipClasaPredata() {
        return tipClasaPredata;
    }

    public abstract String getStatusAngajare();

    public void afiseazaDetalii() {
        System.out.println("Nume Antrenor: " + nume);
        System.out.println("Tip Clasa Predata: " + tipClasaPredata);
    }
}
