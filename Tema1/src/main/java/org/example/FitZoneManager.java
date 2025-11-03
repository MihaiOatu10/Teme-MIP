package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FitZoneManager {
    private List<Antrenor> listaAntrenori;
    private List<Abonament> listaAbonamente;
    private List<ClasaAntrenament> listaClaseAntrenament;

    public FitZoneManager() {
        listaAntrenori = new ArrayList<>();
        listaAbonamente = new ArrayList<>();
        listaClaseAntrenament = new ArrayList<>();
    }

    public void adaugaAntrenor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti numele antrenorului: ");
        String nume = scanner.nextLine();
        System.out.print("Introduceti tipul clasei predate: ");
        String tipClasa = scanner.nextLine();
        System.out.print("Este antrenor angajat full-time? (da/nu): ");
        String status = scanner.nextLine();

        Antrenor antrenor;
        if (status.equals("da")) {
            System.out.print("Introduceti salariul lunar al antrenorului: ");
            double salariuLunar = scanner.nextDouble();
            System.out.print("Introduceti vechimea in ani a antrenorului: ");
            int vechimeAni = scanner.nextInt();
            antrenor = new AntrenorPermanent(nume, tipClasa, salariuLunar, vechimeAni);
        } else {
            System.out.print("Introduceti tariful pe ora al antrenorului: ");
            double tarifPeOra = scanner.nextDouble();
            System.out.print("Introduceti numarul de ore contractate lunar: ");
            int nrOreContractateLunar = scanner.nextInt();
            antrenor = new ColaboratorExtern(nume, tipClasa, tarifPeOra, nrOreContractateLunar);
        }
        listaAntrenori.add(antrenor);
    }
    public void adaugaAbonament() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti tipul abonamentului (Standard/Premium): ");
        String tipAbonament = scanner.nextLine();
        System.out.println("Introduceti durata abonamentului(Luni): ");
        int durataLuni = scanner.nextInt();
        System.out.print("Introduceti pretul de baza al abonamentului: ");
        double pretBaza = scanner.nextDouble();

        Abonament abonament;
        if (tipAbonament.equals("Standard")) {
            abonament = new AbonamentStandard(pretBaza, durataLuni);
        } else {
            abonament = new AbonamentPremium(pretBaza, durataLuni);
        }
        listaAbonamente.add(abonament);

    }
    public void adaugaClasaAntrenament() {
        System.out.println("Introduceti numele clasei: ");
        Scanner scanner = new Scanner(System.in);
        String numeClasa = scanner.nextLine();
        System.out.println("Introduceti nivelul de intensitate (Incepator/Intermediar/Avansat): ");
        String nivelIntensitate = scanner.nextLine();
        System.out.println("Introduceti pretul de baza al clasei: ");
        double pretDeBaza = scanner.nextDouble();
        ClasaAntrenament clasa = new ClasaAntrenament(numeClasa, nivelIntensitate, pretDeBaza);
        listaClaseAntrenament.add(clasa);
    }

    public void afisareAntrenori() {
        System.out.println("---- Antrenori ----");
        for (Antrenor antrenor : listaAntrenori) {
            antrenor.afiseazaDetalii();
            System.out.println("Status Angajare: " + antrenor.getStatusAngajare());
            System.out.println();
        }
    }
    public void afisareAbonamente() {
        System.out.println("---- Abonamente ----");
        for (Abonament abonament : listaAbonamente) {
            abonament.afiseazaDetalii();
            System.out.println("Cost Total: " + abonament.calculeazaCostTotal());
            System.out.println();
        }
    }

    public void afisareClaseAntrenament() {
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
