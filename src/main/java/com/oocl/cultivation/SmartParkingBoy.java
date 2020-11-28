package com.oocl.cultivation;

import com.oocl.cultivation.PickParkingLotStrategies.SmartStrategy;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot, new SmartStrategy());
    }
}
