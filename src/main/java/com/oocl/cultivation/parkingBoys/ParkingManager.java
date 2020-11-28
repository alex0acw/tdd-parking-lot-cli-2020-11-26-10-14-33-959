package com.oocl.cultivation.parkingBoys;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import com.oocl.cultivation.exceptions.NotEnoughParkingSlotException;
import com.oocl.cultivation.exceptions.UnrecognizedParkingTicketException;

import java.util.HashSet;
import java.util.Set;

public class ParkingManager extends ParkingBoy {
    private final Set<ParkingBoy> parkingBoys;

    public ParkingManager(ParkingLot parkingLot) {
        super(parkingLot);
        parkingBoys = new HashSet<>();
    }

    public void manage(ParkingBoy parkingBoy) {
        this.parkingBoys.add(parkingBoy);
    }

    public Ticket park(ParkingBoy parkingBoy, Car car) throws NotEnoughParkingSlotException {
        if (this.parkingBoys.contains(parkingBoy)) {
            return parkingBoy.park(car);
        }
        return null;
    }

    public Car getCarByTicket(ParkingBoy parkingBoy, Ticket ticket) throws UnrecognizedParkingTicketException {
        if (this.parkingBoys.contains(parkingBoy)) {
            return parkingBoy.getCarByTicket(ticket);
        }
        return null;
    }

}
