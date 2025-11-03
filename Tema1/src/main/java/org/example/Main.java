package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FitZoneManager manager = new FitZoneManager();
        Scanner scanner = new Scanner(System.in);
        int optiune;

        do{
            afiseazaMeniu();
            System.out.print("Alege o optiune: ");
            optiune = scanner.nextInt();
            scanner.nextLine();
            proceseazaOptiune(optiune, manager, scanner);
        }while(optiune != 0);
        scanner.close();
        System.out.println("Aplicatia s-a inchis.");
    }
    private static void afiseazaMeniu() {
        System.out.println("\n--- Meniu FitZone ---");
        System.out.println("1. Adauga Antrenor");
        System.out.println("2. Adauga Abonament");
        System.out.println("3. Adauga Clasa de Antrenament");
        System.out.println("4. Genereaza Raport Sumar");
        System.out.println("5. Afisare Abonamente");
        System.out.println("6. Afisare Antrenori");
        System.out.println("7. Afisare Clase de Antrenament");
        System.out.println("0. Iesire");
    }

    private static void proceseazaOptiune(int optiune, FitZoneManager manager, Scanner scanner) {
        switch (optiune) {
            case 1:
                manager.adaugaAntrenor();
                break;
            case 2:
                manager.adaugaAbonament();
                break;
            case 3:
                manager.adaugaClasaAntrenament();
                break;
            case 4:
                manager.genereazaRaportSumar();
                break;
            case 5:
                manager.afisareAbonamente();
                break;
            case 6:
                manager.afisareAntrenori();
                break;
            case 7:
                manager.afisareClaseAntrenament();
                break;
            case 0:
                break;
            default:
                System.out.println("Optiune invalida. Te rog incearca din nou.");
        }
    }
}