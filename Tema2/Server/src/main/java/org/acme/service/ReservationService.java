package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.entity.Reservation;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ReservationService {
    private static final List<String> ALL_SLOTS = List.of(
            "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00"
    );

    @Transactional
    public String getAvailableSlots() {

        List<Reservation> reservations = Reservation.listAll();
        List<String> occupiedSlots = reservations.stream()
                .map(r -> r.timeSlot)
                .collect(Collectors.toList());

        List<String> available = ALL_SLOTS.stream()
                .filter(slot -> !occupiedSlots.contains(slot))
                .collect(Collectors.toList());

        return available.isEmpty() ? "Nu sunt sloturi libere." : "Disponibil: " + available;
    }

    @Transactional
    public synchronized String makeReservation(String clientName, String slot) {
        if (!ALL_SLOTS.contains(slot)) {
            return "Eroare: Slot invalid. Alege o ora fixa (ex: 10:00).";
        }

        if (Reservation.findBySlot(slot) != null) {
            return "Eroare: Slotul " + slot + " este deja rezervat!";
        }

        Reservation res = new Reservation(clientName, slot);
        res.persist();
        return "Succes: Rezervare confirmata pentru " + slot;
    }

    @Transactional
    public String getMyReservations(String clientName) {
        List<Reservation> myRes = Reservation.find("clientName", clientName).list();
        if (myRes.isEmpty()) return "Nu ai rezervari.";

        return "Rezervarile tale: " + myRes.stream()
                .map(r -> r.timeSlot)
                .collect(Collectors.joining(", "));
    }

    @Transactional
    public String cancelReservation(String clientName, String slot) {
        Reservation res = Reservation.findBySlot(slot);
        if (res != null && res.clientName.equals(clientName)) {
            res.delete();
            return "Succes: Rezervarea de la " + slot + " a fost anulata.";
        }
        return "Eroare: Nu poti anula acest slot (nu exista sau nu e al tau).";
    }
}