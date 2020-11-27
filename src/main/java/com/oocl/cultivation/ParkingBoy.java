package com.oocl.cultivation;

public class ParkingBoy {
    private final ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car) throws NotEnoughParkingSlotException {
        return parkingLot.park(car);
    }

    public Car getCarByTicket(Ticket ticket) throws UnrecognizedParkingTicketException {
        return parkingLot.getCarByTicket(ticket);
    }
}
