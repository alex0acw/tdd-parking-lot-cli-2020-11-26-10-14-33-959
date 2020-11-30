package com.oocl.cultivation.pickParkingLotStrategies;

import com.oocl.cultivation.ParkingLot;

import java.util.List;

public interface PickParkingLotStrategy {
    ParkingLot pickParkingLot(List<ParkingLot> parkingLotList);
}
