package com.oocl.cultivation;

public class ParkingBoy {
    private final ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket requestParking(Car car) {
        return null;
    }

    public Ticket park(Car car) {
        this.parkingLot.park(car);
        return null;
    }
}
