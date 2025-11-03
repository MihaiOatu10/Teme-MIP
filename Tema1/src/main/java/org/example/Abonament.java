package org.example;

public abstract class Abonament {
    protected String tipAbonament;
    protected double pretLunar;
    protected int durataLuni;

    public Abonament(String tipAbonament, double pretLunar, int durataLuni) {
        this.tipAbonament = tipAbonament;
        this.pretLunar = pretLunar;
        this.durataLuni = durataLuni;
    }

    public String getTipAbonament() {
        return tipAbonament;
    }

    public double getPretLunar() {
        return pretLunar;
    }

    public int getDurataLuni() {
        return durataLuni;
    }

    public abstract double calculeazaCostTotal();

    public void afiseazaDetalii() {
        System.out.println("Tip Abonament: " + tipAbonament);
        System.out.println("Pret Lunar: " + pretLunar);
        System.out.println("Durata (luni): " + durataLuni);
        System.out.println("Cost Total: " + calculeazaCostTotal());
    }
}
