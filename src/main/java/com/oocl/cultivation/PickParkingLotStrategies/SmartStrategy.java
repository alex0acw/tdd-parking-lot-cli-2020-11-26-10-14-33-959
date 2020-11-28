package com.oocl.cultivation.PickParkingLotStrategies;

import com.oocl.cultivation.ParkingLot;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SmartStrategy implements PickParkingLotStrategyInterface {
    @Override
    public ParkingLot pickParkingLot(List<ParkingLot> parkingLotList) {
        Optional<ParkingLot> parkingLot = parkingLotList.stream().max(Comparator.comparingInt(ParkingLot::getRemainingSpaces));
        return parkingLot.orElse(null);
    }
}
