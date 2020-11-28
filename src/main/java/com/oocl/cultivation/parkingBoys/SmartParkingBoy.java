package com.oocl.cultivation.parkingBoys;

import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.pickParkingLotStrategies.SmartStrategy;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot, new SmartStrategy());
    }
}
