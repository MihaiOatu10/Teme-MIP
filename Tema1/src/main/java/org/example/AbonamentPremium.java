package org.example;

public class AbonamentPremium extends Abonament {
    private boolean accesNelimitat = true;
    private boolean suportPrioritar = true;

    public AbonamentPremium(double pretLunar, int durataLuni) {
        super("Premium", pretLunar, durataLuni);
    }

    @Override
    public double calculeazaCostTotal() {
        return pretLunar * durataLuni;
    }

    @Override
    public void afiseazaDetalii() {
        super.afiseazaDetalii();
        System.out.println("Acces Nelimitat: " + (accesNelimitat ? "Da" : "Nu"));
        System.out.println("Suport Prioritar: " + (suportPrioritar ? "Da" : "Nu"));
    }
}
