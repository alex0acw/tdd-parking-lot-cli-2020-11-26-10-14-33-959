package com.oocl.cultivation;

public class ParkingLot {
    private final int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
        this.capacity = 10;
    }

    public Ticket park(Car car) {
        return new Ticket();
    }
}
