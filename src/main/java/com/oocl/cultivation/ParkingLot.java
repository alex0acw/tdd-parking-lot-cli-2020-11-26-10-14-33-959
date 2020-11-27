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

    public Ticket park(Car car) throws NotEnoughParkingSlotException {
        if (capacity - ticketCarMap.size() > 0) {
            Ticket ticket = new Ticket();
            this.ticketCarMap.put(ticket, car);
            return ticket;
        }
        throw new NotEnoughParkingSlotException();
    }

    public Car getCarByTicket(Ticket ticket) throws UnrecognizedParkingTicketException {
        Car car = this.ticketCarMap.remove(ticket);
        if (car == null)
            throw new UnrecognizedParkingTicketException();
        else
            return car;
    }
}
