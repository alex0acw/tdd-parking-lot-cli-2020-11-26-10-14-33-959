package com.oocl.cultivation;

import com.oocl.cultivation.PickParkingLotStrategies.SuperSmartStrategy;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot, new SuperSmartStrategy());
    }

}
