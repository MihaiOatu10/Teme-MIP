package org.example;

public class AntrenorPermanent extends Antrenor{
    private double salariuLunar;
    private int vechimeAni;

    public AntrenorPermanent(String nume, String tipClasaPredata, double salariuLunar, int vechimeAni) {
        super(nume, tipClasaPredata);
        this.salariuLunar = salariuLunar;
        this.vechimeAni = vechimeAni;
    }

    @Override
    public String getStatusAngajare() {
        return "Permanent";
    }

    @Override
    public void afiseazaDetalii() {
        super.afiseazaDetalii();
        System.out.println("Status Angajare: " + getStatusAngajare());
        System.out.println("Salariu Lunar: " + salariuLunar);
        System.out.println("Vechime (ani): " + vechimeAni);
    }

    public double calculeazaBonusVechime() {
        final double bonusVechimePerAn = 0.01;
        return vechimeAni * salariuLunar * bonusVechimePerAn;
    }

}
