package com.oocl.cultivation.parkingBoys;

import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.pickParkingLotStrategies.SuperSmartStrategy;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot, new SuperSmartStrategy());
    }

}
