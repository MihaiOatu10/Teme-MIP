package org.example;

public class ColaboratorExtern extends Antrenor{
    private double tarifPeOra;
    private int nrOreContractateLunar;

    public ColaboratorExtern(String nume, String tipClasaPredata, double tarifPeOra, int nrOreContractateLunar) {
        super(nume, tipClasaPredata);
        this.tarifPeOra = tarifPeOra;
        this.nrOreContractateLunar = nrOreContractateLunar;
    }

    @Override
    public String getStatusAngajare() {
        return "Colaborator Extern";
    }

    @Override
    public void afiseazaDetalii() {
        super.afiseazaDetalii();
        System.out.println("Status Angajare: " + getStatusAngajare());
        System.out.println("Tarif pe Ora: " + tarifPeOra);
        System.out.println("Numar Ore Contractate Lunar: " + nrOreContractateLunar);
    }

    public double calculeazaVenitLunar() {
        return tarifPeOra * nrOreContractateLunar;
    }
}
