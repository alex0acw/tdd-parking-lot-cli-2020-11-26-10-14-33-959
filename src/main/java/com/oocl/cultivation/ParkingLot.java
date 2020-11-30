package com.oocl.cultivation;

import com.oocl.cultivation.exceptions.NotEnoughParkingSlotException;
import com.oocl.cultivation.exceptions.UnrecognizedParkingTicketException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot implements ParkingEntity {
    private final int CAPACITY;
    private final Map<Ticket, Car> ticketCarMap;

    public ParkingLot(int CAPACITY) {
        this.CAPACITY = CAPACITY;
        ticketCarMap = new HashMap<>();
    }

    public ParkingLot() {
        this.CAPACITY = 10;
        ticketCarMap = new HashMap<>();
    }

    public Ticket park(Car car) throws NotEnoughParkingSlotException {
        if (CAPACITY - ticketCarMap.size() > 0) {
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

    public Integer getRemainingSpaces() {
        return this.CAPACITY - this.ticketCarMap.size();
    }

    public float getAvailableProportion() {
        return (float) (CAPACITY - this.ticketCarMap.size()) / CAPACITY;
    }
}
