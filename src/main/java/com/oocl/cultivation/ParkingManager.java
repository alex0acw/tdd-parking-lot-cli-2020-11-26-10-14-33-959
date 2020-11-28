package com.oocl.cultivation;

import java.util.HashSet;
import java.util.Set;

public class ParkingManager {
    private final Set<ParkingBoy> parkingBoys;

    public ParkingManager() {
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
