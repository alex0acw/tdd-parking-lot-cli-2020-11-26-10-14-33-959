package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final int capacity;
    private final Map<Ticket, Car> ticketCarMap;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        ticketCarMap = new HashMap<>();
    }

    public ParkingLot() {
        this.capacity = 10;
        ticketCarMap = new HashMap<>();
    }

    public Ticket park(Car car) {
        if (capacity - ticketCarMap.size() > 0) {
            Ticket ticket = new Ticket();
            this.ticketCarMap.put(ticket, car);
            return ticket;
        }
        return null;
    }

    public Car getCarByTicket(Ticket ticket) {
        return this.ticketCarMap.get(ticket);
    }
}
