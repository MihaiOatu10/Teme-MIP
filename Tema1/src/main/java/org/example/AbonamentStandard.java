package org.example;

public class AbonamentStandard extends Abonament {

    private boolean accesLimitat = true;

    public AbonamentStandard(double pretLunar, int durataLuni) {
        super("Standard", pretLunar, durataLuni);
    }

    @Override
    public double calculeazaCostTotal() {
        return pretLunar * durataLuni;
    }

    @Override
    public void afiseazaDetalii() {
        super.afiseazaDetalii();
        System.out.println("Acces Limitat: " + (accesLimitat ? "Da" : "Nu"));
    }
}
