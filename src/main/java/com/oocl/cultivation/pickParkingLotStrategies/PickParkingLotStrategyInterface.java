package com.oocl.cultivation.pickParkingLotStrategies;

import com.oocl.cultivation.ParkingLot;

import java.util.List;

public interface PickParkingLotStrategyInterface {
    ParkingLot pickParkingLot(List<ParkingLot> parkingLotList);
}
