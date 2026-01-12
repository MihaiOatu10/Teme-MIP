package org.acme.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Reservation extends PanacheEntity {

    public String clientName;
    public String timeSlot;

    public Reservation() {}

    public Reservation(String clientName, String timeSlot) {
        this.clientName = clientName;
        this.timeSlot = timeSlot;
    }

    public static Reservation findBySlot(String slot) {
        return find("timeSlot", slot).firstResult();
    }
}