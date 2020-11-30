package com.oocl.cultivation.pickParkingLotStrategies;

import com.oocl.cultivation.ParkingLot;

import java.util.List;

public class SequentialStrategy implements PickParkingLotStrategy {
    @Override
    public ParkingLot pickParkingLot(List<ParkingLot> parkingLotList) {
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.getRemainingSpaces() > 0)
                return parkingLot;
        }
        return null;
    }
}
