package org.example;

public class ClasaAntrenament {

    private String numeClasa;
    private String nivelIntensitate;
    private double pretDeBaza;

    public ClasaAntrenament(String numeClasa, String nivelIntensitate, double pretDeBaza) {
        this.numeClasa = numeClasa;
        this.nivelIntensitate = nivelIntensitate;
        this.pretDeBaza = pretDeBaza;
    }

    public String getNumeClasa() {
        return numeClasa;
    }

    public String getNivelIntensitate() {
        return nivelIntensitate;
    }

    public double getPretDeBaza() {
        return pretDeBaza;
    }

    public void afiseazaDetaliiClasa() {
        System.out.println("Clasa: " + numeClasa);
        System.out.println("Nivel Intensitate: " + nivelIntensitate);
        System.out.println("Pret de Baza: " + pretDeBaza + " RON");
    }
}