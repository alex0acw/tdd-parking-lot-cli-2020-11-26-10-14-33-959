package com.oocl.cultivation.PickParkingLotStrategies;

import com.oocl.cultivation.ParkingLot;

import java.util.List;

public class SequentialStrategy implements PickParkingLotStrategyInterface {
    @Override
    public ParkingLot pickParkingLot(List<ParkingLot> parkingLotList) {
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.getRemainingSpaces() > 0)
                return parkingLot;
        }
        return null;
    }
}
