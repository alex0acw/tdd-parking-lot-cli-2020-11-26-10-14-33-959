package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final int capacity;
    private final List<Car> carList;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        carList = new ArrayList<>();
    }

    public ParkingLot() {
        this.capacity = 10;
        carList = new ArrayList<>();
    }

    public Ticket park(Car car) {
        if (capacity - carList.size() > 0) {
            this.carList.add(car);
            return new Ticket();
        } else
            return null;
    }
}
