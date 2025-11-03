package org.example;

import java.util.ArrayList;
import java.util.List;

public class FitZoneManager {
    private List<Antrenor> listaAntrenori;
    private List<Abonament> listaAbonamente;
    private List<ClasaAntrenament> listaClaseAntrenament;

    public FitZoneManager() {
        listaAntrenori = new ArrayList<>();
        listaAbonamente = new ArrayList<>();
        listaClaseAntrenament = new ArrayList<>();
    }

    public void adaugaAntrenor(Antrenor antrenor) {
        listaAntrenori.add(antrenor);
    }
    public void adaugaAbonament(Abonament abonament) {
        listaAbonamente.add(abonament);
    }
    public void adaugaClasaAntrenament(ClasaAntrenament clasaAntrenament) {
        listaClaseAntrenament.add(clasaAntrenament);
    }

    public void afiseazaToateDetaliile() {
        System.out.println("---- Antrenori ----");
        for (Antrenor antrenor : listaAntrenori) {
            antrenor.afiseazaDetalii();
            System.out.println("Status Angajare: " + antrenor.getStatusAngajare());
            System.out.println();
        }

        System.out.println("---- Abonamente ----");
        for (Abonament abonament : listaAbonamente) {
            abonament.afiseazaDetalii();
            System.out.println("Cost Total: " + abonament.calculeazaCostTotal());
            System.out.println();
        }

        System.out.println("---- Clase de Antrenament ----");
        for (ClasaAntrenament clasa : listaClaseAntrenament) {
            clasa.afiseazaDetaliiClasa();
            System.out.println();
        }
    }

    public void genereazaRaportSumar() {
        System.out.println("---- Raport Sumar FitZone ----");
        if(listaClaseAntrenament.size()==0)
        {
            System.out.println("Nu exista clase de antrenament disponibile.");
            return;
        }
        for(ClasaAntrenament clasa : listaClaseAntrenament) {
            System.out.println("Clasa: " + clasa.getNumeClasa() + "Intensitate: " + clasa.getNivelIntensitate());
            System.out.println("Antrenorii care predau aceasta clasa:");
            boolean gasitAntrenor = false;
            for(Antrenor antrenor : listaAntrenori) {
                if (antrenor.getTipClasaPredata().equalsIgnoreCase(clasa.getNumeClasa())) {
                    System.out.println("- " + antrenor.getNume() + " (" + antrenor.getStatusAngajare() + ")");
                    gasitAntrenor = true;
                }
            }
            if(!gasitAntrenor) {
                System.out.println("Niciun antrenor nu preda aceasta clasa.");
            }
        }
    }

}
